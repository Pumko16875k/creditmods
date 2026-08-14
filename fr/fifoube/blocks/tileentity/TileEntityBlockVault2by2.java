package fr.fifoube.blocks.tileentity;

import fr.fifoube.gui.container.ContainerVault2by2;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent.Serializer;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBlockVault2by2 extends TileEntity implements INamedContainerProvider {
   public static final TranslationTextComponent NAME = new TranslationTextComponent("container.vault2by2");
   ItemStackHandler inventory;
   public String ownerS;
   private byte direction;
   private List<String> allowedPlayers;
   private int maxAllowedPlayers;
   private ITextComponent customName;

   public TileEntityBlockVault2by2() {
      this(TileEntityRegistery.TILE_BLOCKVAULT_2BY2);
   }

   public TileEntityBlockVault2by2(TileEntityType<?> tileEntityTypeIn) {
      super(tileEntityTypeIn);
      this.inventory = new ItemStackHandler(54);
      this.ownerS = "";
      this.allowedPlayers = new ArrayList();
      this.maxAllowedPlayers = 0;
   }

   public ItemStackHandler getHandler() {
      return this.inventory;
   }

   public Boolean hasItems() {
      for(int i = 0; i < 27; ++i) {
         if (this.inventory.getStackInSlot(i) != ItemStack.field_190927_a) {
            return true;
         }
      }

      return false;
   }

   public void setString(String string) {
      this.ownerS = string;
   }

   public String getOwnerS() {
      return this.ownerS;
   }

   public void addAllowedPlayers(String allowed) {
      this.allowedPlayers.add(allowed);
   }

   public List<String> getAllowedPlayers() {
      return this.allowedPlayers;
   }

   public int getMax() {
      return this.maxAllowedPlayers;
   }

   public void addToMax() {
      ++this.maxAllowedPlayers;
   }

   public void removeToMax() {
      --this.maxAllowedPlayers;
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
      compound.func_74768_a("maxallowed", this.maxAllowedPlayers);
      ListNBT tagList = new ListNBT();

      for(int i = 0; i < this.allowedPlayers.size(); ++i) {
         String s = (String)this.allowedPlayers.get(i);
         if (s != null) {
            tagList.add(StringNBT.func_229705_a_(s));
         }
      }

      compound.func_218657_a("allowedList", tagList);
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
      this.maxAllowedPlayers = compound.func_74762_e("maxallowed");
      ListNBT tagList = compound.func_150295_c("allowedList", 8);

      for(int i = 0; i < tagList.size(); ++i) {
         this.allowedPlayers.add(i, tagList.func_150307_f(i));
      }

      if (compound.func_150297_b("CustomName", 8)) {
         this.customName = Serializer.func_240643_a_(compound.func_74779_i("CustomName"));
      }

   }

   public SUpdateTileEntityPacket func_189518_D_() {
      return new SUpdateTileEntityPacket(this.field_174879_c, 1, this.func_189517_E_());
   }

   public CompoundNBT func_189517_E_() {
      return this.func_189515_b(new CompoundNBT());
   }

   public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
      this.allowedPlayers.clear();
      this.func_230337_a_((BlockState)null, pkt.func_148857_g());
   }

   public void func_70296_d() {
      BlockState state = this.field_145850_b.func_180495_p(this.func_174877_v());
      this.field_145850_b.func_184138_a(this.func_174877_v(), state, state, 3);
   }

   public Container createMenu(int id, PlayerInventory inventoryPlayer, PlayerEntity player) {
      return new ContainerVault2by2(id, inventoryPlayer, this.func_174877_v());
   }

   public ITextComponent func_145748_c_() {
      return NAME;
   }
}
