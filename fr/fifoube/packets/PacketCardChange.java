package fr.fifoube.packets;

import fr.fifoube.items.ItemsRegistery;
import fr.fifoube.main.ModEconomyInc;
import fr.fifoube.main.capabilities.CapabilityMoney;
import java.util.function.Supplier;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketCardChange {
   private double funds;

   public PacketCardChange() {
   }

   public PacketCardChange(double funds) {
      this.funds = funds;
   }

   public static PacketCardChange decode(PacketBuffer buf) {
      double funds = buf.readDouble();
      return new PacketCardChange(funds);
   }

   public static void encode(PacketCardChange packet, PacketBuffer buf) {
      buf.writeDouble(packet.funds);
   }

   public static void handle(PacketCardChange packet, Supplier<NetworkEvent.Context> ctx) {
      ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
         PlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
         player.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
            double funds = packet.funds;
            if (funds == (double)1.0F) {
               if (data.getMoney() >= (double)1.0F) {
                  boolean flag = player.func_191521_c(new ItemStack(ItemsRegistery.ITEM_ONEB));
                  if (flag) {
                     double previous_money = data.getMoney();
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has withdrawn " + 1 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() - (double)1.0F) + ".[UUID: " + player.func_110124_au() + "]");
                     data.setMoney(previous_money - (double)1.0F);
                  } else {
                     player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                  }
               }
            } else if (funds == (double)5.0F) {
               if (data.getMoney() >= (double)5.0F) {
                  boolean flag = player.func_191521_c(new ItemStack(ItemsRegistery.ITEM_FIVEB));
                  if (flag) {
                     double previous_money = data.getMoney();
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has withdrawn " + 5 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() - (double)5.0F) + ".[UUID: " + player.func_110124_au() + "]");
                     data.setMoney(previous_money - (double)5.0F);
                  } else {
                     player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                  }
               }
            } else if (funds == (double)10.0F) {
               if (data.getMoney() >= (double)10.0F) {
                  boolean flag = player.func_191521_c(new ItemStack(ItemsRegistery.ITEM_TENB));
                  if (flag) {
                     double previous_money = data.getMoney();
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has withdrawn " + 10 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() - (double)10.0F) + ".[UUID: " + player.func_110124_au() + "]");
                     data.setMoney(previous_money - (double)10.0F);
                  } else {
                     player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                  }
               }
            } else if (funds == (double)20.0F) {
               if (data.getMoney() >= (double)20.0F) {
                  boolean flag = player.func_191521_c(new ItemStack(ItemsRegistery.ITEM_TWENTYB));
                  if (flag) {
                     double previous_money = data.getMoney();
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has withdrawn " + 20 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() - (double)20.0F) + ".[UUID: " + player.func_110124_au() + "]");
                     data.setMoney(previous_money - (double)20.0F);
                  } else {
                     player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                  }
               }
            } else if (funds == (double)50.0F) {
               if (data.getMoney() >= (double)50.0F) {
                  boolean flag = player.func_191521_c(new ItemStack(ItemsRegistery.ITEM_FIFTYB));
                  if (flag) {
                     double previous_money = data.getMoney();
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has withdrawn " + 50 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() - (double)50.0F) + ".[UUID: " + player.func_110124_au() + "]");
                     data.setMoney(previous_money - (double)50.0F);
                  } else {
                     player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                  }
               }
            } else if (funds == (double)100.0F) {
               if (data.getMoney() >= (double)100.0F) {
                  boolean flag = player.func_191521_c(new ItemStack(ItemsRegistery.ITEM_HUNDREEDB));
                  if (flag) {
                     double previous_money = data.getMoney();
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has withdrawn " + 100 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() - (double)100.0F) + ".[UUID: " + player.func_110124_au() + "]");
                     data.setMoney(previous_money - (double)100.0F);
                  } else {
                     player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                  }
               }
            } else if (funds == (double)200.0F) {
               if (data.getMoney() >= (double)200.0F) {
                  boolean flag = player.func_191521_c(new ItemStack(ItemsRegistery.ITEM_TWOHUNDREEDB));
                  if (flag) {
                     double previous_money = data.getMoney();
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has withdrawn " + 200 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() - (double)200.0F) + ".[UUID: " + player.func_110124_au() + "]");
                     data.setMoney(previous_money - (double)200.0F);
                  } else {
                     player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                  }
               }
            } else if (funds == (double)500.0F) {
               if (data.getMoney() >= (double)500.0F) {
                  boolean flag = player.func_191521_c(new ItemStack(ItemsRegistery.ITEM_FIVEHUNDREEDB));
                  if (flag) {
                     double previous_money = data.getMoney();
                     ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has withdrawn " + 500 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() - (double)500.0F) + ".[UUID: " + player.func_110124_au() + "]");
                     data.setMoney(previous_money - (double)500.0F);
                  } else {
                     player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noInventoryPlace", new Object[0])), player.func_110124_au());
                  }
               }
            } else if (funds == (double)-1.0F) {
               if (player.field_71071_by.func_70431_c(new ItemStack(ItemsRegistery.ITEM_ONEB))) {
                  double previous_money = data.getMoney();
                  ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has added " + 1 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() + (double)1.0F) + ".[UUID: " + player.func_110124_au() + "]");
                  data.setMoney(previous_money + (double)1.0F);
                  clearMatchingItems(player, new ItemStack(ItemsRegistery.ITEM_ONEB), 1);
               }
            } else if (funds == (double)-5.0F) {
               if (player.field_71071_by.func_70431_c(new ItemStack(ItemsRegistery.ITEM_FIVEB))) {
                  double previous_money = data.getMoney();
                  ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has added " + 5 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() + (double)5.0F) + ".[UUID: " + player.func_110124_au() + "]");
                  data.setMoney(previous_money + (double)5.0F);
                  clearMatchingItems(player, new ItemStack(ItemsRegistery.ITEM_FIVEB), 1);
               }
            } else if (funds == (double)-10.0F) {
               if (player.field_71071_by.func_70431_c(new ItemStack(ItemsRegistery.ITEM_TENB))) {
                  double previous_money = data.getMoney();
                  ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has added " + 10 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() + (double)10.0F) + ".[UUID: " + player.func_110124_au() + "]");
                  data.setMoney(previous_money + (double)10.0F);
                  clearMatchingItems(player, new ItemStack(ItemsRegistery.ITEM_TENB), 1);
               }
            } else if (funds == (double)-20.0F) {
               if (player.field_71071_by.func_70431_c(new ItemStack(ItemsRegistery.ITEM_TWENTYB))) {
                  double previous_money = data.getMoney();
                  ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has added " + 20 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() + (double)20.0F) + ".[UUID: " + player.func_110124_au() + "]");
                  data.setMoney(previous_money + (double)20.0F);
                  clearMatchingItems(player, new ItemStack(ItemsRegistery.ITEM_TWENTYB), 1);
               }
            } else if (funds == (double)-50.0F) {
               if (player.field_71071_by.func_70431_c(new ItemStack(ItemsRegistery.ITEM_FIFTYB))) {
                  double previous_money = data.getMoney();
                  ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has added " + 50 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() + (double)50.0F) + ".[UUID: " + player.func_110124_au() + "]");
                  data.setMoney(previous_money + (double)50.0F);
                  clearMatchingItems(player, new ItemStack(ItemsRegistery.ITEM_FIFTYB), 1);
               }
            } else if (funds == (double)-100.0F) {
               if (player.field_71071_by.func_70431_c(new ItemStack(ItemsRegistery.ITEM_HUNDREEDB))) {
                  double previous_money = data.getMoney();
                  ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has added " + 100 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() + (double)100.0F) + ".[UUID: " + player.func_110124_au() + "]");
                  data.setMoney(previous_money + (double)100.0F);
                  clearMatchingItems(player, new ItemStack(ItemsRegistery.ITEM_HUNDREEDB), 1);
               }
            } else if (funds == (double)-200.0F) {
               if (player.field_71071_by.func_70431_c(new ItemStack(ItemsRegistery.ITEM_TWOHUNDREEDB))) {
                  double previous_money = data.getMoney();
                  ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has added " + 200 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() + (double)200.0F) + ".[UUID: " + player.func_110124_au() + "]");
                  data.setMoney(previous_money + (double)200.0F);
                  clearMatchingItems(player, new ItemStack(ItemsRegistery.ITEM_TWOHUNDREEDB), 1);
               }
            } else if (funds == (double)-500.0F && player.field_71071_by.func_70431_c(new ItemStack(ItemsRegistery.ITEM_FIVEHUNDREEDB))) {
               double previous_money = data.getMoney();
               ModEconomyInc.LOGGER.info(player.func_145748_c_().getString() + " has added " + 500 + ". Balance was " + previous_money + ", balance is now " + (data.getMoney() + (double)500.0F) + ".[UUID: " + player.func_110124_au() + "]");
               data.setMoney(previous_money + (double)500.0F);
               clearMatchingItems(player, new ItemStack(ItemsRegistery.ITEM_FIVEHUNDREEDB), 1);
            }

         });
      });
      ((NetworkEvent.Context)ctx.get()).setPacketHandled(true);
   }

   public static void clearMatchingItems(PlayerEntity player, ItemStack stack, int count) {
      for(int j = 0; j < player.field_71071_by.func_70302_i_(); ++j) {
         ItemStack itemstack = player.field_71071_by.func_70301_a(j);
         if (itemstack.func_77969_a(stack)) {
            itemstack.func_190920_e(itemstack.func_190916_E() - count);
         }
      }

   }
}
