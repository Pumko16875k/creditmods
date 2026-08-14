package fr.fifoube.items;

import java.util.List;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemWireless extends Item {
   public ItemWireless(Item.Properties properties) {
      super(properties);
   }

   public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity player, Hand handIn) {
      ItemStack itemStackIn = player.func_184592_cb();
      ItemStack itemStackInC = player.func_184614_ca();
      int totalcount = 0;
      if (!worldIn.field_72995_K && !player.field_71071_by.func_70431_c(itemStackIn) && player.field_71071_by.func_70431_c(itemStackInC)) {
         for(int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
            if (player.field_71071_by.func_70301_a(i) == null) {
               if (worldIn.field_72995_K) {
                  player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.cardTooMuch", new Object[0])), player.func_110124_au());
               }

               return new ActionResult(ActionResultType.FAIL, itemStackIn);
            }

            if (player.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemCreditCard) {
               ++totalcount;
               ItemStack hasCardIS = player.field_71071_by.func_70301_a(i);
               if (totalcount <= 1) {
                  if (hasCardIS.func_77942_o() && hasCardIS.func_77978_p().func_74764_b("Owner")) {
                     String nameCard = hasCardIS.func_77978_p().func_74779_i("OwnerUUID");
                     String nameGame = player.func_110124_au().toString();
                     if (nameCard.equals(nameGame)) {
                        boolean linked = hasCardIS.func_77978_p().func_74767_n("Linked");
                        if (!linked) {
                           if (worldIn.field_72995_K) {
                              player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.cardUpdated", new Object[0])), player.func_110124_au());
                           }

                           hasCardIS.func_77978_p().func_74757_a("Linked", true);
                        } else {
                           if (worldIn.field_72995_K) {
                              player.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.cardAlreadyLinked", new Object[0])), player.func_110124_au());
                           }

                           player.func_191521_c(itemStackInC);
                        }
                     }
                  } else {
                     player.func_191521_c(itemStackInC);
                  }
               }

               return new ActionResult(ActionResultType.SUCCESS, itemStackIn);
            }
         }
      }

      return new ActionResult(ActionResultType.FAIL, itemStackIn);
   }

   public void func_77624_a(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
      tooltip.add(new StringTextComponent(I18n.func_135052_a("title.wireless", new Object[0])));
   }
}
