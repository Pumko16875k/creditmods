package fr.fifoube.gui.container;

import fr.fifoube.blocks.tileentity.TileEntityBlockChanger;
import fr.fifoube.gui.container.type.ContainerTypeRegistery;
import fr.fifoube.items.ItemsRegistery;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerChanger extends Container {
   public TileEntityBlockChanger te;

   public ContainerChanger(int windowId, PlayerInventory playerInv, PacketBuffer extraData) {
      this(windowId, playerInv, extraData.func_179259_c());
   }

   public ContainerChanger(int windowId, PlayerInventory playerInv, BlockPos pos) {
      super(ContainerTypeRegistery.CHANGER_TYPE, windowId);
      TileEntity te = playerInv.field_70458_d.field_70170_p.func_175625_s(pos);
      if (te instanceof TileEntityBlockChanger) {
         TileEntityBlockChanger tile = (TileEntityBlockChanger)te;
         IItemHandler inventory = tile.getHandler();
         this.func_75146_a(new SlotItemHandler(inventory, 0, 56, 16));
         this.func_75146_a(new SlotItemHandler(inventory, 1, 56, 52));
         this.func_75146_a(new SlotItemHandler(inventory, 2, 116, 34));
         this.bindPlayerInventory(playerInv);
         this.te = tile;
      }

   }

   private void bindPlayerInventory(PlayerInventory inventoryPlayer) {
      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 9; ++j) {
            this.func_75146_a(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 48 + i * 18 + 35));
         }
      }

      for(int var4 = 0; var4 < 9; ++var4) {
         this.func_75146_a(new Slot(inventoryPlayer, var4, 8 + var4 * 18, 141));
      }

   }

   public boolean func_75145_c(PlayerEntity playerIn) {
      return true;
   }

   public ItemStack func_82846_b(PlayerEntity playerIn, int index) {
      ItemStack itemstack = ItemStack.field_190927_a;
      Slot slot = (Slot)this.field_75151_b.get(index);
      if (slot != null && slot.func_75216_d()) {
         ItemStack itemstack1 = slot.func_75211_c();
         itemstack = itemstack1.func_77946_l();
         if (index == 2) {
            if (!this.func_75135_a(itemstack1, 3, 39, true)) {
               return ItemStack.field_190927_a;
            }

            slot.func_75220_a(itemstack1, itemstack);
         } else if (index != 1 && index != 0) {
            if (itemstack1.func_77973_b() == ItemsRegistery.ITEM_GOLDNUGGET) {
               if (!this.func_75135_a(itemstack1, 0, 1, false)) {
                  return ItemStack.field_190927_a;
               }
            } else if (itemstack1.func_77973_b() == ItemsRegistery.ITEM_CREDITCARD) {
               if (!this.func_75135_a(itemstack1, 1, 2, false)) {
                  return ItemStack.field_190927_a;
               }
            } else if (index >= 3 && index < 30) {
               if (!this.func_75135_a(itemstack1, 30, 39, false)) {
                  return ItemStack.field_190927_a;
               }
            } else if (index >= 30 && index < 39 && !this.func_75135_a(itemstack1, 3, 30, false)) {
               return ItemStack.field_190927_a;
            }
         } else if (!this.func_75135_a(itemstack1, 3, 39, false)) {
            return ItemStack.field_190927_a;
         }

         if (itemstack1.func_190926_b()) {
            slot.func_75215_d(ItemStack.field_190927_a);
         } else {
            slot.func_75218_e();
         }

         if (itemstack1.func_190916_E() == itemstack.func_190916_E()) {
            return ItemStack.field_190927_a;
         }

         slot.func_190901_a(playerIn, itemstack1);
      }

      return itemstack;
   }

   public void func_75134_a(PlayerEntity playerIn) {
      super.func_75134_a(playerIn);
      World worldIn = playerIn.field_70170_p;
      if (!worldIn.field_72995_K) {
         TileEntityBlockChanger te = this.te;
         int x = te.func_174877_v().func_177958_n();
         int y = te.func_174877_v().func_177956_o();
         int z = te.func_174877_v().func_177952_p();
         if (te.getNumbUse() > 0) {
            te.setNumbUse(0);
            te.setEntityPlayer((PlayerEntity)null);
            te.func_70296_d();
         }

         ItemStack itemstack = te.getStackInSlot(0).func_77979_a(1);
         if (!itemstack.func_190926_b()) {
            worldIn.func_217376_c(new ItemEntity(worldIn, (double)x, (double)y, (double)z, itemstack));
         }

         itemstack = te.getStackInSlot(1).func_77979_a(1);
         if (!itemstack.func_190926_b()) {
            worldIn.func_217376_c(new ItemEntity(worldIn, (double)x, (double)y, (double)z, itemstack));
         }

         itemstack = te.getStackInSlot(2).func_77979_a(1);
         if (!itemstack.func_190926_b()) {
            worldIn.func_217376_c(new ItemEntity(worldIn, (double)x, (double)y, (double)z, itemstack));
         }
      }

   }

   public TileEntityBlockChanger getTile() {
      return this.te;
   }
}
