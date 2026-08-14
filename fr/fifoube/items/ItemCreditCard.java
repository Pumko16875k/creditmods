package fr.fifoube.items;

import fr.fifoube.gui.ClientGuiScreen;
import fr.fifoube.main.capabilities.CapabilityMoney;
import fr.fifoube.main.config.ConfigFile;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemCreditCard extends Item {
   public ItemCreditCard(Item.Properties properties) {
      super(properties);
   }

   public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity playerIn, Hand handIn) {
      ItemStack itemStackIn = playerIn.func_184614_ca();
      if (!playerIn.func_184592_cb().func_77969_a(new ItemStack(ItemsRegistery.ITEM_CREDITCARD))) {
         if (!playerIn.func_213453_ef()) {
            if (itemStackIn.func_77942_o()) {
               String nameCard = playerIn.func_184614_ca().func_77978_p().func_74779_i("OwnerUUID");
               String nameGame = playerIn.func_110124_au().toString();
               if (nameCard.equals(nameGame) && worldIn.field_72995_K && ConfigFile.canAccessCardWithoutWT) {
                  if (itemStackIn.func_77978_p().func_74767_n("Linked")) {
                     ClientGuiScreen.openGui(0, (TileEntity)null);
                  } else {
                     playerIn.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.notLinked", new Object[0])), playerIn.func_110124_au());
                  }
               }
            }

            return new ActionResult(ActionResultType.SUCCESS, itemStackIn);
         }

         if (!worldIn.field_72995_K) {
            if (!itemStackIn.func_77942_o()) {
               itemStackIn.func_77982_d(new CompoundNBT());
            }

            if (!itemStackIn.func_77978_p().func_74764_b("Owner")) {
               playerIn.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
                  UUID ownerUUID = playerIn.func_110124_au();
                  itemStackIn.func_77978_p().func_74778_a("OwnerUUID", ownerUUID.toString());
                  itemStackIn.func_77978_p().func_74778_a("Owner", playerIn.func_145748_c_().getString());
                  itemStackIn.func_77978_p().func_74757_a("Owned", true);
                  itemStackIn.func_77978_p().func_74757_a("Linked", false);
                  worldIn.func_184133_a((PlayerEntity)null, playerIn.func_233580_cy_(), SoundEvents.field_187604_bf, SoundCategory.PLAYERS, 0.5F, 0.0F);
               });
            }
         }
      }

      return new ActionResult(ActionResultType.FAIL, itemStackIn);
   }

   @OnlyIn(Dist.CLIENT)
   public void func_77624_a(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
      PlayerEntity playerIn = Minecraft.func_71410_x().field_71439_g;
      if (stack.func_77942_o()) {
         playerIn.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
            double funds = data.getMoney();
            boolean linked = stack.func_77978_p().func_74767_n("Linked");
            String linkedValue = "";
            if (linked) {
               linkedValue = I18n.func_135052_a("title.yes", new Object[0]);
            } else {
               linkedValue = I18n.func_135052_a("title.no", new Object[0]);
            }

            String ownerName = stack.func_77978_p().func_74779_i("Owner");
            tooltip.add(new StringTextComponent(I18n.func_135052_a("title.ownerCard", new Object[0]) + " : " + ownerName));
            tooltip.add(new StringTextComponent(I18n.func_135052_a("title.fundsCard", new Object[0]) + " : " + funds));
            tooltip.add(new StringTextComponent(I18n.func_135052_a("title.linkdCard", new Object[0]) + " : " + linkedValue));
         });
      }
   }

   public boolean func_77636_d(ItemStack stack) {
      return stack.func_77942_o();
   }
}
