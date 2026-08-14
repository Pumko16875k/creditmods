package fr.fifoube.items;

import java.util.List;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemGoldNuggetSubs extends Item {
   public ItemGoldNuggetSubs(Item.Properties properties) {
      super(properties);
   }

   public void func_77624_a(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
      if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("weight")) {
         String weight = stack.func_77978_p().func_74779_i("weight");
         tooltip.add(new StringTextComponent(I18n.func_135052_a("title.weight", new Object[0]) + weight));
      }

   }
}
