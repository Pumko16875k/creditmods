package fr.fifoube.main.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.fifoube.main.ModEconomyInc;
import fr.fifoube.main.capabilities.CapabilityMoney;
import fr.fifoube.world.saveddata.PlotsData;
import fr.fifoube.world.saveddata.PlotsWorldSavedData;
import java.util.UUID;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;

public class CommandsPlotsBuy {
   public static void register(CommandDispatcher<CommandSource> dispatcher) {
      dispatcher.register((LiteralArgumentBuilder)LiteralArgumentBuilder.literal("plotbuy").then(((LiteralArgumentBuilder)Commands.func_197057_a("buy").requires((src) -> src.func_197034_c(0))).then(Commands.func_197056_a("plotname", StringArgumentType.string()).executes((ctx) -> requireBuy((CommandSource)ctx.getSource(), StringArgumentType.getString(ctx, "plotname"))))));
   }

   public static int requireBuy(CommandSource src, String plotName) {
      boolean canProceedBuy = false;
      int indexToProceedBuy = -1;
      ServerPlayerEntity player = null;

      try {
         player = src.func_197035_h();
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

      if (player != null) {
         String uuid = player.func_110124_au().toString();
         ServerWorld worldIn = player.func_71121_q();
         DimensionSavedDataManager storage = worldIn.func_217481_x();
         PlotsWorldSavedData dataWorld = (PlotsWorldSavedData)storage.func_215752_a(PlotsWorldSavedData::new, "economyinc_PlotsData");
         if (dataWorld != null) {
            for(int i = 0; i < dataWorld.getListContainer().size(); ++i) {
               PlotsData plotsData = (PlotsData)dataWorld.getListContainer().get(i);
               if (plotsData != null && ((String)plotsData.getList().get(0)).equals(plotName)) {
                  boolean bought = plotsData.getBought();
                  if (!bought) {
                     indexToProceedBuy = i;
                     canProceedBuy = true;
                  } else {
                     src.func_197030_a(new TranslationTextComponent("commands.plotbuy.alreadybought"), false);
                  }
               }
            }
         }

         if (canProceedBuy && indexToProceedBuy != -1) {
            PlotsData plotsData = (PlotsData)dataWorld.getListContainer().get(indexToProceedBuy);
            player.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
               double playerMoney = data.getMoney();
               ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has bought plot " + plotsData.name + ". Balance was at " + data.getMoney() + ", balance is now " + (data.getMoney() - plotsData.price) + ".[UUID: " + player.func_110124_au() + ",PlotID: " + plotsData.name + "]");
               if (playerMoney >= plotsData.price) {
                  plotsData.bought = true;
                  plotsData.owner = uuid;
                  dataWorld.func_76185_a();
                  double newMoney = playerMoney - plotsData.price;
                  data.setMoney(newMoney);
                  replaceSign(worldIn, plotsData.xPosFirst, plotsData.yPos, plotsData.zPosFirst, plotsData.xPosSecond, plotsData.zPosSecond, plotsData.name, plotsData.owner);
               }

            });
            src.func_197030_a(new TranslationTextComponent("commands.plotbuy.success"), false);
         }
      } else {
         src.func_197030_a(new TranslationTextComponent("commands.plot.noplayer"), false);
      }

      return 0;
   }

   public static Vector3d getCenter(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
      return new Vector3d(minX + (maxX - minX) * (double)0.5F, minY + (maxY - minY) * (double)0.5F, minZ + (maxZ - minZ) * (double)0.5F);
   }

   public static void replaceSign(ServerWorld worldIn, int xPosFirst, int yPos, int zPosFirst, int xPosSecond, int zPosSecond, String name, String owner) {
      PlayerEntity playerIn = worldIn.func_217371_b(UUID.fromString(owner));
      if (playerIn != null) {
         Vector3d vec = getCenter((double)xPosFirst, (double)yPos, (double)zPosFirst, (double)xPosSecond, (double)yPos, (double)zPosSecond);
         BlockPos posSign = new BlockPos(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c);
         worldIn.func_175655_b(posSign, false);
         worldIn.func_180501_a(posSign, Blocks.field_222384_bX.func_176223_P(), 2);
         TileEntity tileEntityIn = new SignTileEntity();
         tileEntityIn.func_145829_t();
         worldIn.func_175690_a(posSign, tileEntityIn);
         SignTileEntity signTe = (SignTileEntity)worldIn.func_175625_s(posSign);
         if (signTe != null) {
            signTe.func_212365_a(0, (new StringTextComponent("[" + name + "]")).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.BLUE));
            signTe.func_212365_a(1, (new StringTextComponent("Owned by")).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.BLACK));
            signTe.func_212365_a(2, (new StringTextComponent(playerIn.func_145748_c_().getString())).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.BLACK));
            signTe.func_212365_a(3, (new StringTextComponent("[SOLD]")).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.RED));
            signTe.func_70296_d();
         }
      }

   }
}
