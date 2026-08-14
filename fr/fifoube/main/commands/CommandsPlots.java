package fr.fifoube.main.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.fifoube.main.config.ConfigFile;
import fr.fifoube.world.saveddata.ChunksWorldSavedData;
import fr.fifoube.world.saveddata.PlotsChunkData;
import fr.fifoube.world.saveddata.PlotsData;
import fr.fifoube.world.saveddata.PlotsWorldSavedData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.BlockPosArgument;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraftforge.registries.ForgeRegistries;

public class CommandsPlots {
   public static void register(CommandDispatcher<CommandSource> dispatcher) {
      dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)LiteralArgumentBuilder.literal("plot").requires((src) -> src.func_197034_c(3))).then(Commands.func_197057_a("create").then(Commands.func_197056_a("from", BlockPosArgument.func_197276_a()).then(Commands.func_197056_a("to", BlockPosArgument.func_197276_a()).then(Commands.func_197056_a("name", StringArgumentType.string()).then(Commands.func_197056_a("price", DoubleArgumentType.doubleArg((double)1.0F)).executes((ctx) -> createPlot((CommandSource)ctx.getSource(), BlockPosArgument.func_197273_a(ctx, "from"), BlockPosArgument.func_197273_a(ctx, "to"), StringArgumentType.getString(ctx, "name"), DoubleArgumentType.getDouble(ctx, "price"))))))))).then(Commands.func_197057_a("remove").then(Commands.func_197056_a("name", StringArgumentType.string()).executes((ctx) -> removePlot((CommandSource)ctx.getSource(), StringArgumentType.getString(ctx, "name")))))).then(Commands.func_197057_a("list").executes((ctx) -> listPlot((CommandSource)ctx.getSource())))).then(Commands.func_197057_a("assign").then(Commands.func_197056_a("player", EntityArgument.func_197096_c()).then(Commands.func_197056_a("name", StringArgumentType.string()).executes((ctx) -> assignPlotTo((CommandSource)ctx.getSource(), EntityArgument.func_197089_d(ctx, "player"), StringArgumentType.getString(ctx, "name"))))))).then(Commands.func_197057_a("teleport").then(((RequiredArgumentBuilder)Commands.func_197056_a("name", StringArgumentType.string()).executes((ctx) -> teleportToPlot((CommandSource)ctx.getSource(), (Collection)null, StringArgumentType.getString(ctx, "name"), false))).then(Commands.func_197056_a("players", EntityArgument.func_197094_d()).executes((ctx) -> teleportToPlot((CommandSource)ctx.getSource(), EntityArgument.func_197087_c(ctx, "players"), StringArgumentType.getString(ctx, "name"), true))))));
   }

   private static int teleportToPlot(CommandSource src, Collection<? extends Entity> targets, String plotsName, boolean tpOther) {
      int indexToProceedBuy = -1;
      ServerPlayerEntity player = null;

      try {
         player = src.func_197035_h();
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

      if (player != null) {
         ServerWorld worldIn = player.func_71121_q();
         DimensionSavedDataManager storage = worldIn.func_217481_x();
         PlotsWorldSavedData dataWorld = (PlotsWorldSavedData)storage.func_215752_a(PlotsWorldSavedData::new, "economyinc_PlotsData");
         if (dataWorld != null) {
            for(int i = 0; i < dataWorld.getListContainer().size(); ++i) {
               PlotsData plotsData = (PlotsData)dataWorld.getListContainer().get(i);
               if (plotsData != null && ((String)plotsData.getList().get(0)).equals(plotsName)) {
                  indexToProceedBuy = i;
               }
            }

            if (indexToProceedBuy != -1) {
               PlotsData plotsData = (PlotsData)dataWorld.getListContainer().get(indexToProceedBuy);
               Vector3d center = getCenter((double)plotsData.xPosFirst, (double)plotsData.yPos, (double)plotsData.zPosFirst, (double)plotsData.xPosSecond, (double)plotsData.yPos, (double)plotsData.zPosSecond);
               if (!tpOther) {
                  player.func_200619_a(player.func_71121_q(), center.field_72450_a, center.field_72448_b, center.field_72449_c, player.field_70177_z, player.field_70125_A);
                  src.func_197030_a(new TranslationTextComponent("commands.plot.teleport.success", new Object[]{player.func_145748_c_().getString(), plotsData.name}), false);
               } else {
                  targets.forEach((ex) -> {
                     if (ex instanceof ServerPlayerEntity) {
                        ServerPlayerEntity playerMP = (ServerPlayerEntity)ex;
                        playerMP.func_200619_a(player.func_71121_q(), center.field_72450_a, center.field_72448_b, center.field_72449_c, playerMP.field_70177_z, playerMP.field_70125_A);
                        src.func_197030_a(new TranslationTextComponent("commands.plot.teleport.success", new Object[]{playerMP.func_145748_c_().getString(), plotsData.name}), false);
                     }

                  });
               }
            } else {
               src.func_197030_a(new TranslationTextComponent("commands.plot.teleport.fail"), false);
            }
         }
      }

      return 0;
   }

   private static int assignPlotTo(CommandSource src, ServerPlayerEntity assignedPlayer, String plotsName) {
      boolean canProceedBuy = false;
      int indexToProceedBuy = -1;
      ServerPlayerEntity player = null;

      try {
         player = src.func_197035_h();
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

      if (player != null) {
         ServerWorld worldIn = player.func_71121_q();
         DimensionSavedDataManager storage = worldIn.func_217481_x();
         PlotsWorldSavedData dataWorld = (PlotsWorldSavedData)storage.func_215752_a(PlotsWorldSavedData::new, "economyinc_PlotsData");
         if (dataWorld != null) {
            for(int i = 0; i < dataWorld.getListContainer().size(); ++i) {
               PlotsData plotsData = (PlotsData)dataWorld.getListContainer().get(i);
               if (plotsData != null && ((String)plotsData.getList().get(0)).equals(plotsName)) {
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
            plotsData.bought = true;
            plotsData.owner = assignedPlayer.func_110124_au().toString();
            dataWorld.func_76185_a();
            CommandsPlotsBuy.replaceSign(worldIn, plotsData.xPosFirst, plotsData.yPos, plotsData.zPosFirst, plotsData.xPosSecond, plotsData.zPosSecond, plotsData.name, plotsData.owner);
            saveAll(src, false);
            src.func_197030_a(new TranslationTextComponent("commands.plot.assigned.success", new Object[]{player, assignedPlayer.func_145748_c_().getString()}), false);
         }
      }

      return 0;
   }

   public static int listPlot(CommandSource src) {
      ServerPlayerEntity player = null;

      try {
         player = src.func_197035_h();
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

      if (player != null) {
         DimensionSavedDataManager storage = player.func_71121_q().func_217481_x();
         PlotsWorldSavedData data = (PlotsWorldSavedData)storage.func_215752_a(PlotsWorldSavedData::new, "economyinc_PlotsData");
         List<String> namePlot = new ArrayList();
         if (data != null) {
            for(int i = 0; i < data.getListContainer().size(); ++i) {
               PlotsData plotsData = (PlotsData)data.getListContainer().get(i);
               if (plotsData != null) {
                  namePlot.add(plotsData.getList().get(0));
               }
            }

            Collections.sort(namePlot);
            String name = "Plots name : ";

            for(int i = 0; i < namePlot.size(); ++i) {
               String seperator = ",";
               if (i + 1 == namePlot.size()) {
                  seperator = ".";
               }

               name = name + (String)namePlot.get(i) + seperator;
            }

            src.func_197030_a(new TranslationTextComponent(name), false);
         }
      }

      return 0;
   }

   public static int createPlot(CommandSource src, BlockPos from, BlockPos to, String name, double price) {
      boolean canProceed = true;
      ServerPlayerEntity player = null;

      try {
         player = src.func_197035_h();
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

      if (player != null) {
         if (Math.abs(to.func_177958_n() - from.func_177958_n()) < 26 && Math.abs(to.func_177952_p() - from.func_177952_p()) < 26) {
            DimensionSavedDataManager storage = player.func_71121_q().func_217481_x();
            ServerWorld worldIn = player.func_71121_q();
            PlotsWorldSavedData data = (PlotsWorldSavedData)storage.func_215752_a(PlotsWorldSavedData::new, "economyinc_PlotsData");
            if (data != null) {
               for(int i = 0; i < data.getListContainer().size(); ++i) {
                  PlotsData plotsData = (PlotsData)data.getListContainer().get(i);
                  if (plotsData != null && ((String)plotsData.getList().get(0)).equals(name)) {
                     canProceed = false;
                     src.func_197030_a(new TranslationTextComponent("commands.plot.samename"), false);
                  }
               }
            }

            if (canProceed) {
               createData(src, worldIn, name, player, from.func_177958_n(), from.func_177952_p(), to.func_177958_n(), to.func_177952_p(), from.func_177956_o(), price);
               src.func_197030_a(new TranslationTextComponent("commands.plot.success"), false);
               saveAll(src, false);
            }
         } else {
            src.func_197030_a(new TranslationTextComponent("commands.plot.sizeexceed"), false);
         }
      } else {
         src.func_197030_a(new TranslationTextComponent("commands.plot.noplayer"), false);
      }

      return 0;
   }

   public static int removePlot(CommandSource src, String namePlot) {
      boolean canProceedRemove = false;
      int indexToProceed = -1;
      ServerPlayerEntity player = null;

      try {
         player = src.func_197035_h();
      } catch (CommandSyntaxException e) {
         e.printStackTrace();
      }

      DimensionSavedDataManager storage = player.func_71121_q().func_217481_x();
      PlotsWorldSavedData data = (PlotsWorldSavedData)storage.func_215752_a(PlotsWorldSavedData::new, "economyinc_PlotsData");
      if (player != null && data != null) {
         for(int i = 0; i < data.getListContainer().size(); ++i) {
            PlotsData plotsData = (PlotsData)data.getListContainer().get(i);
            if (plotsData != null) {
               if (((String)plotsData.getList().get(0)).equals(namePlot)) {
                  indexToProceed = i;
                  canProceedRemove = true;
                  src.func_197030_a(new TranslationTextComponent("commands.plot.removed"), false);
                  saveAll(src, false);
               } else {
                  src.func_197030_a(new TranslationTextComponent("commands.plot.nomatch"), false);
               }
            }
         }
      }

      if (canProceedRemove && indexToProceed != -1) {
         data.getListContainer().remove(indexToProceed);
         data.func_76185_a();
      }

      return 0;
   }

   private static void createData(CommandSource src, ServerWorld worldIn, String name, ServerPlayerEntity playerIn, int xPosFirst, int zPosFirst, int xPosSecond, int zPosSecond, int yPos, double priceIn) throws CommandException {
      List<ChunkPos> listChunk = calculatingChunks(worldIn, xPosFirst, zPosFirst, xPosSecond, zPosSecond, yPos);
      PlotsData plotsData = new PlotsData(name, playerIn.func_110124_au().toString(), xPosFirst, zPosFirst, xPosSecond, zPosSecond, yPos, priceIn, false);
      PlotsChunkData chunkData = new PlotsChunkData(listChunk);
      PlotsWorldSavedData storagePlots = (PlotsWorldSavedData)worldIn.func_217481_x().func_215752_a(PlotsWorldSavedData::new, "economyinc_PlotsData");
      storagePlots.getListContainer().add(plotsData);
      storagePlots.func_76185_a();
      ChunksWorldSavedData storageChunk = (ChunksWorldSavedData)worldIn.func_217481_x().func_215752_a(ChunksWorldSavedData::new, "economyinc_PlotsChunkData");
      storageChunk.getListContainer().add(chunkData);
      storageChunk.func_76185_a();
      createBorders(src, worldIn, name, playerIn.func_145748_c_().getString(), xPosFirst, zPosFirst, xPosSecond, zPosSecond, yPos, priceIn);
   }

   private static List<ChunkPos> calculatingChunks(World worldIn, int xPosFirst, int zPosFirst, int xPosSecond, int zPosSecond, int yPos) {
      List<ChunkPos> listChunk = new ArrayList();
      int minusXToTake;
      int maxXToTake;
      if (xPosFirst < xPosSecond) {
         minusXToTake = Math.floorDiv(xPosFirst, 16);
         maxXToTake = Math.floorDiv(xPosSecond, 16);
      } else {
         minusXToTake = Math.floorDiv(xPosSecond, 16);
         maxXToTake = Math.floorDiv(xPosFirst, 16);
      }

      int minusZToTake;
      int maxZToTake;
      if (zPosFirst < zPosSecond) {
         minusZToTake = Math.floorDiv(zPosFirst, 16);
         maxZToTake = Math.floorDiv(zPosSecond, 16);
      } else {
         minusZToTake = Math.floorDiv(zPosSecond, 16);
         maxZToTake = Math.floorDiv(zPosFirst, 16);
      }

      for(int x = minusXToTake; x <= maxXToTake; ++x) {
         for(int z = minusZToTake; z <= maxZToTake; ++z) {
            Chunk chunkIn = worldIn.func_212866_a_(x, z);
            listChunk.add(chunkIn.func_76632_l());
         }
      }

      return listChunk;
   }

   private static void createBorders(CommandSource src, ServerWorld worldIn, String name, String senderName, int xPosFirst, int zPosFirst, int xPosSecond, int zPosSecond, int yPos, double priceIn) {
      AxisAlignedBB area = new AxisAlignedBB(new BlockPos(xPosFirst, yPos, zPosFirst), new BlockPos(xPosSecond, yPos, zPosSecond));
      AxisAlignedBB areaGrown = area.func_72314_b((double)1.0F, (double)0.0F, (double)1.0F);
      Vector3d vec = getCenter((double)xPosFirst, (double)yPos, (double)zPosFirst, (double)xPosSecond, (double)yPos, (double)zPosSecond);
      BlockPos posSign = new BlockPos(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c);
      Block block = Blocks.field_222401_hJ;
      String rl = ConfigFile.plotBorderBlock;
      ResourceLocation location = new ResourceLocation(rl.substring(0, rl.indexOf(":")), rl.substring(rl.indexOf(":") + 1));
      if (ForgeRegistries.BLOCKS.getValue(location) != Blocks.field_150350_a) {
         block = (Block)ForgeRegistries.BLOCKS.getValue(location);
      } else {
         block = Blocks.field_222401_hJ;
         src.func_197030_a(new TranslationTextComponent("commands.plot.wrongPlotBorder"), false);
      }

      worldIn.func_175656_a(posSign, Blocks.field_150350_a.func_176223_P());
      Iterable<BlockPos> posToPlace = BlockPos.func_218278_a(new BlockPos(areaGrown.field_72340_a, (double)yPos, areaGrown.field_72339_c), new BlockPos(areaGrown.field_72336_d, (double)yPos, areaGrown.field_72334_f));
      Iterable<BlockPos> posToRemove = BlockPos.func_218278_a(new BlockPos(area.field_72340_a, (double)yPos, area.field_72339_c), new BlockPos(area.field_72336_d, (double)yPos, area.field_72334_f));

      for(BlockPos posNew : posToPlace) {
         worldIn.func_175656_a(posNew, block.func_176223_P());
      }

      for(BlockPos posNew : posToRemove) {
         worldIn.func_175656_a(posNew, Blocks.field_150350_a.func_176223_P());
      }

      worldIn.func_180501_a(posSign, Blocks.field_222384_bX.func_176223_P(), 2);
      TileEntity tileEntityIn = new SignTileEntity();
      tileEntityIn.func_145829_t();
      worldIn.func_175690_a(posSign, tileEntityIn);
      SignTileEntity signTe = (SignTileEntity)worldIn.func_175625_s(posSign);
      if (signTe != null) {
         signTe.func_212365_a(0, (new StringTextComponent("[" + name + "]")).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.BLUE));
         signTe.func_212365_a(1, (new StringTextComponent(senderName)).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.BLACK));
         signTe.func_212365_a(2, (new StringTextComponent(priceIn + "$")).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.BLACK));
         signTe.func_212365_a(3, (new StringTextComponent("[BUY]")).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.GREEN));
         signTe.func_70296_d();
      }

   }

   public static Vector3d getCenter(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
      return new Vector3d(minX + (maxX - minX) * (double)0.5F, minY + (maxY - minY) * (double)0.5F, minZ + (maxZ - minZ) * (double)0.5F);
   }

   private static int saveAll(CommandSource source, boolean flush) {
      MinecraftServer minecraftserver = source.func_197028_i();
      minecraftserver.func_184103_al().func_72389_g();
      boolean flag = minecraftserver.func_213211_a(true, flush, true);
      if (flag) {
         source.func_197030_a(new TranslationTextComponent("commands.plot.saved"), false);
         return 1;
      } else {
         source.func_197030_a(new TranslationTextComponent("commands.plot.errorsaved"), false);
         return 0;
      }
   }
}
