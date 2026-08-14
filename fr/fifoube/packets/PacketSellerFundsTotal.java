package fr.fifoube.packets;

import fr.fifoube.blocks.BlockSeller;
import fr.fifoube.blocks.tileentity.TileEntityBlockSeller;
import fr.fifoube.main.ModEconomyInc;
import fr.fifoube.main.capabilities.CapabilityMoney;
import fr.fifoube.main.config.ConfigFile;
import java.util.function.Supplier;
import net.minecraft.block.BlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketSellerFundsTotal {
   private double funds;
   private double cost;
   private double fundstotal;
   private int x;
   private int y;
   private int z;
   private int amount;
   private boolean recovery;

   public PacketSellerFundsTotal() {
   }

   public PacketSellerFundsTotal(double funds, double cost, int xS, int yS, int zS, int amountS, boolean recoveryS) {
      this.funds = funds;
      this.cost = cost;
      this.x = xS;
      this.y = yS;
      this.z = zS;
      this.amount = amountS;
      this.recovery = recoveryS;
      this.fundstotal = funds + cost;
   }

   public static PacketSellerFundsTotal decode(PacketBuffer buf) {
      double funds = buf.readDouble();
      double cost = buf.readDouble();
      int x = buf.readInt();
      int y = buf.readInt();
      int z = buf.readInt();
      int amount = buf.readInt();
      boolean recovery = buf.readBoolean();
      return new PacketSellerFundsTotal(funds, cost, x, y, z, amount, recovery);
   }

   public static void encode(PacketSellerFundsTotal packet, PacketBuffer buf) {
      buf.writeDouble(packet.funds);
      buf.writeDouble(packet.cost);
      buf.writeInt(packet.x);
      buf.writeInt(packet.y);
      buf.writeInt(packet.z);
      buf.writeInt(packet.amount);
      buf.writeBoolean(packet.recovery);
   }

   public static void handle(PacketSellerFundsTotal packet, Supplier<NetworkEvent.Context> ctx) {
      ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
         ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
         World worldIn = player.field_70170_p;
         BlockPos pos = new BlockPos(packet.x, packet.y, packet.z);
         TileEntity tileentity = worldIn.func_175625_s(pos);
         if (!worldIn.field_72995_K && tileentity instanceof TileEntityBlockSeller) {
            TileEntityBlockSeller te = (TileEntityBlockSeller)tileentity;
            if (te != null) {
               if (!packet.recovery) {
                  if (!te.getStackInSlot(0).func_190926_b()) {
                     boolean admin = te.getAdmin();
                     if (!admin) {
                        CompoundNBT nbt = te.getStackInSlot(0).func_77978_p();
                        ItemStack stack = new ItemStack(te.getStackInSlot(0).func_77973_b(), 1);
                        if (nbt != null) {
                           stack.func_196082_o().func_197643_a(nbt);
                        }

                        boolean flag = player.field_71071_by.func_70441_a(stack);
                        if (flag) {
                           te.getStackInSlot(0).func_77979_a(1);
                           te.setFundsTotal(packet.fundstotal);
                           te.func_70296_d();
                           player.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
                              ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has bought " + te.getItem() + " for " + packet.cost + ". Balance was " + data.getMoney() + ", balance is now " + (data.getMoney() - packet.cost) + ".[UUID: " + player.func_110124_au() + "," + te.func_174877_v() + "]");
                              data.setMoney(data.getMoney() - packet.cost);
                           });
                           te.setTime(ConfigFile.cooldownSeller);
                           BlockState state = worldIn.func_180495_p(pos);
                           if (state.func_177230_c() instanceof BlockSeller) {
                              BlockSeller seller = (BlockSeller)state.func_177230_c();
                              seller.scheduleTick(state, worldIn, pos);
                           }
                        } else {
                           player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                        }
                     } else if (admin) {
                        CompoundNBT nbt = te.getStackInSlot(0).func_77978_p();
                        ItemStack stack = new ItemStack(te.getStackInSlot(0).func_77973_b(), 1);
                        if (nbt != null) {
                           stack.func_196082_o().func_197643_a(nbt);
                        }

                        boolean flag = player.field_71071_by.func_70441_a(stack);
                        if (flag) {
                           te.setFundsTotal(packet.fundstotal);
                           te.func_70296_d();
                           player.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
                              ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has bought " + te.getItem() + " for " + packet.cost + ". Balance was " + data.getMoney() + ", balance is now " + (data.getMoney() - packet.cost) + ".[UUID: " + player.func_110124_au() + "," + te.func_174877_v() + "]");
                              data.setMoney(data.getMoney() - packet.cost);
                           });
                           te.setTime(ConfigFile.cooldownSeller);
                           BlockState state = worldIn.func_180495_p(pos);
                           if (state.func_177230_c() instanceof BlockSeller) {
                              BlockSeller seller = (BlockSeller)state.func_177230_c();
                              seller.scheduleTick(state, worldIn, pos);
                           }
                        } else {
                           player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                        }
                     }
                  }
               } else if (packet.recovery) {
                  player.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has recovered funds for a total of " + packet.fundstotal + ". Balance was at " + data.getMoney() + ", balance is now " + (data.getMoney() + packet.fundstotal) + ".[UUID: " + player.func_110124_au() + "," + te.func_174877_v() + "]");
                     data.setMoney(data.getMoney() + packet.fundstotal);
                     te.setFundsTotal((double)0.0F);
                     te.func_70296_d();
                  });
               }
            }
         }

      });
      ((NetworkEvent.Context)ctx.get()).setPacketHandled(true);
   }
}
