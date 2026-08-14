package fr.fifoube.blocks.tileentity;

import fr.fifoube.gui.container.ContainerSeller;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent.Serializer;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBlockSeller extends TileEntity implements INamedContainerProvider, ITickableTileEntity {
   private static final TranslationTextComponent NAME = new TranslationTextComponent("container.seller");
   ItemStackHandler inventory_seller;
   private String owner;
   private String ownerName;
   private double funds_total;
   private double cost;
   private boolean created;
   private int amount;
   private String item;
   private boolean admin;
   private String facing;
   private ITextComponent customName;
   private int timer;

   public TileEntityBlockSeller() {
      this(TileEntityRegistery.TILE_SELLER);
   }

   public TileEntityBlockSeller(TileEntityType<?> tileEntityTypeIn) {
      super(tileEntityTypeIn);
      this.inventory_seller = new ItemStackHandler(1);
      this.owner = "";
      this.ownerName = "";
      this.item = "";
      this.facing = "";
   }

   public ItemStackHandler getHandler() {
      return this.inventory_seller;
   }

   public SUpdateTileEntityPacket func_189518_D_() {
      return new SUpdateTileEntityPacket(this.field_174879_c, 1, this.func_189517_E_());
   }

   public CompoundNBT func_189517_E_() {
      return this.func_189515_b(new CompoundNBT());
   }

   public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
      this.deserializeNBT(pkt.func_148857_g());
   }

   public ItemStack getStackInSlot(int slot) {
      return this.inventory_seller.getStackInSlot(slot);
   }

   public ItemStack removeStackInSlot(int slot) {
      return this.inventory_seller.getStackInSlot(slot).func_77979_a(1);
   }

   public void setFacing(String face) {
      this.facing = face;
   }

   public String getFacing() {
      return this.facing;
   }

   public void setAdmin(Boolean adminS) {
      this.admin = adminS;
   }

   public boolean getAdmin() {
      return this.admin;
   }

   public void setOwner(String string) {
      this.owner = string;
   }

   public String getOwner() {
      return this.owner;
   }

   public void setOwnerName(String stringName) {
      this.ownerName = stringName;
   }

   public String getOwnerName() {
      return this.ownerName;
   }

   public void setCost(double costS) {
      this.cost = costS;
   }

   public double getCost() {
      return this.cost;
   }

   public void setFundsTotal(double fundsS) {
      this.funds_total = fundsS;
   }

   public double getFundsTotal() {
      return this.funds_total;
   }

   public void setCreated(boolean createdS) {
      this.created = createdS;
   }

   public boolean getCreated() {
      return this.created;
   }

   public void setItem(String itemS) {
      this.item = itemS;
   }

   public String getItem() {
      return this.inventory_seller.getStackInSlot(0).func_200301_q().getString();
   }

   public int getAmount() {
      return this.inventory_seller.getStackInSlot(0).func_190916_E();
   }

   public void setTime(int time) {
      this.timer = time;
   }

   public int getTime() {
      return this.timer;
   }

   public CompoundNBT func_189515_b(CompoundNBT compound) {
      compound.func_218657_a("inventory", this.inventory_seller.serializeNBT());
      compound.func_74778_a("ownerS", this.owner);
      compound.func_74778_a("ownerName", this.ownerName);
      compound.func_74780_a("cost", this.cost);
      compound.func_74768_a("amount", this.amount);
      compound.func_74778_a("item", this.item);
      compound.func_74780_a("funds_total", this.funds_total);
      compound.func_74757_a("created", this.created);
      compound.func_74757_a("admin", this.admin);
      compound.func_74778_a("facing", this.facing);
      if (this.func_145748_c_() != null) {
         compound.func_74778_a("CustomName", Serializer.func_150696_a(this.func_145748_c_()));
      }

      compound.func_74768_a("timer", this.timer);
      return super.func_189515_b(compound);
   }

   public void func_230337_a_(BlockState state, CompoundNBT compound) {
      super.func_230337_a_(state, compound);
      this.inventory_seller.deserializeNBT(compound.func_74775_l("inventory"));
      this.owner = compound.func_74779_i("ownerS");
      this.ownerName = compound.func_74779_i("ownerName");
      this.cost = compound.func_74769_h("cost");
      this.amount = compound.func_74762_e("amount");
      this.item = compound.func_74779_i("item");
      this.funds_total = compound.func_74769_h("funds_total");
      this.created = compound.func_74767_n("created");
      this.admin = compound.func_74767_n("admin");
      this.facing = compound.func_74779_i("facing");
      if (compound.func_150297_b("CustomName", 8)) {
         this.customName = Serializer.func_240643_a_(compound.func_74779_i("CustomName"));
      }

      this.timer = compound.func_74762_e("timer");
   }

   public void func_70296_d() {
      BlockState state = this.field_145850_b.func_180495_p(this.func_174877_v());
      this.field_145850_b.func_184138_a(this.func_174877_v(), state, state, 3);
   }

   public Container createMenu(int id, PlayerInventory inventoryPlayer, PlayerEntity playerEntity) {
      return new ContainerSeller(id, inventoryPlayer, this.func_174877_v());
   }

   public ITextComponent func_145748_c_() {
      return NAME;
   }

   public void func_73660_a() {
      if (this.timer != 0) {
         --this.timer;
      }

   }
}
