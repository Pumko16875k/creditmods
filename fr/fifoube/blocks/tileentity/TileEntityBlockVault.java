package fr.fifoube.blocks.tileentity;

import fr.fifoube.gui.container.ContainerVault;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent.Serializer;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBlockVault extends TileEntity implements INamedContainerProvider {
   private static final TranslationTextComponent NAME = new TranslationTextComponent("container.vault");
   ItemStackHandler inventory;
   private String ownerS;
   private byte direction;
   private boolean isOpen;
   private ITextComponent customName;

   public TileEntityBlockVault() {
      this(TileEntityRegistery.TILE_BLOCKVAULT);
   }

   public TileEntityBlockVault(TileEntityType<?> tileEntityTypeIn) {
      super(tileEntityTypeIn);
      this.inventory = new ItemStackHandler(27);
      this.ownerS = "";
   }

   public ItemStackHandler getHandler() {
      return this.inventory;
   }

   public SUpdateTileEntityPacket func_189518_D_() {
      return new SUpdateTileEntityPacket(this.field_174879_c, 1, this.func_189517_E_());
   }

   public CompoundNBT func_189517_E_() {
      return this.func_189515_b(new CompoundNBT());
   }

   public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
      this.func_230337_a_((BlockState)null, pkt.func_148857_g());
   }

   public boolean getIsOpen() {
      return this.isOpen;
   }

   public void setIsOpen(boolean isOpenIn) {
      this.isOpen = isOpenIn;
   }

   public void setOwner(String string) {
      this.ownerS = string;
   }

   public String getOwnerS() {
      return this.ownerS;
   }

   public Boolean hasItems() {
      for(int i = 0; i < 27; ++i) {
         if (this.inventory.getStackInSlot(i) != ItemStack.field_190927_a) {
            return true;
         }
      }

      return false;
   }

   public byte getDirection() {
      return this.direction;
   }

   public void setDirection(byte direction) {
      this.direction = direction;
   }

   public CompoundNBT func_189515_b(CompoundNBT compound) {
      compound.func_218657_a("inventory", this.inventory.serializeNBT());
      compound.func_74778_a("ownerS", this.ownerS);
      compound.func_74774_a("direction", this.direction);
      if (this.func_145748_c_() != null) {
         compound.func_74778_a("CustomName", Serializer.func_150696_a(this.func_145748_c_()));
      }

      return super.func_189515_b(compound);
   }

   public void func_230337_a_(BlockState state, CompoundNBT compound) {
      super.func_230337_a_(state, compound);
      this.inventory.deserializeNBT(compound.func_74775_l("inventory"));
      this.ownerS = compound.func_74779_i("ownerS");
      this.direction = compound.func_74771_c("direction");
      if (compound.func_150297_b("CustomName", 8)) {
         this.customName = Serializer.func_240643_a_(compound.func_74779_i("CustomName"));
      }

   }

   public void func_70296_d() {
      BlockState state = this.field_145850_b.func_180495_p(this.func_174877_v());
      this.field_145850_b.func_184138_a(this.func_174877_v(), state, state, 3);
   }

   public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
      return new ContainerVault(id, playerInventory, this.func_174877_v());
   }

   public ITextComponent func_145748_c_() {
      return NAME;
   }
}
