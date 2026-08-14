package fr.fifoube.gui.container;

import fr.fifoube.blocks.tileentity.TileEntityBlockVault;
import fr.fifoube.gui.container.type.ContainerTypeRegistery;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerVault extends Container {
   public int X;
   public int Y;
   public int Z;
   private TileEntityBlockVault tile;

   public ContainerVault(int windowId, PlayerInventory playerInv, PacketBuffer extraData) {
      this(windowId, playerInv, extraData.func_179259_c());
   }

   public ContainerVault(int windowId, PlayerInventory playerInv, BlockPos pos) {
      super(ContainerTypeRegistery.VAULT_TYPE, windowId);
      TileEntity entity = playerInv.field_70458_d.field_70170_p.func_175625_s(pos);
      if (entity instanceof TileEntityBlockVault) {
         TileEntityBlockVault te = (TileEntityBlockVault)entity;
         this.tile = te;
         IItemHandler inventory = te.getHandler();

         for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
               this.func_75146_a(new SlotItemHandler(inventory, j + i * 9, 8 + j * 18, 17 + i * 18));
            }
         }
      }

      this.bindPlayerInventory(playerInv);
   }

   private void bindPlayerInventory(PlayerInventory inventoryPlayer) {
      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 9; ++j) {
            this.func_75146_a(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 48 + i * 18 + 37));
         }
      }

      for(int var4 = 0; var4 < 9; ++var4) {
         this.func_75146_a(new Slot(inventoryPlayer, var4, 8 + var4 * 18, 143));
      }

   }

   public boolean func_75145_c(PlayerEntity playerIn) {
      return true;
   }

   public ItemStack func_82846_b(PlayerEntity playerIn, int index) {
      ItemStack stack = ItemStack.field_190927_a;
      Slot slot = (Slot)this.field_75151_b.get(index);
      if (slot != null && slot.func_75216_d()) {
         ItemStack stackInSlot = slot.func_75211_c();
         stack = stackInSlot.func_77946_l();
         int containerSlots = this.field_75151_b.size() - playerIn.field_71071_by.field_70462_a.size();
         if (index < containerSlots) {
            if (!this.func_75135_a(stackInSlot, containerSlots, this.field_75151_b.size(), true)) {
               return ItemStack.field_190927_a;
            }
         } else if (!this.func_75135_a(stackInSlot, 0, containerSlots, false)) {
            return ItemStack.field_190927_a;
         }

         if (stackInSlot.func_190916_E() == 0) {
            slot.func_75215_d(ItemStack.field_190927_a);
         } else {
            slot.func_75218_e();
         }

         slot.func_190901_a(playerIn, stackInSlot);
      }

      return stack;
   }

   public TileEntityBlockVault getTile() {
      return this.tile;
   }
}
