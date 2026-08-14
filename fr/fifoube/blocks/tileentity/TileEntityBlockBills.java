package fr.fifoube.blocks.tileentity;

import fr.fifoube.items.ItemsRegistery;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityBlockBills extends TileEntity {
   private byte direction;
   public int numbBills;
   public String billRef;

   public TileEntityBlockBills(TileEntityType<?> tileEntityTypeIn) {
      super(tileEntityTypeIn);
      this.numbBills = 0;
      this.billRef = "";
   }

   public TileEntityBlockBills() {
      this(TileEntityRegistery.TILE_BILLS);
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

   public String getBillRef() {
      return this.billRef;
   }

   public void setBillRef(String billRefIn) {
      this.billRef = billRefIn;
   }

   public int getNumbBills() {
      return this.numbBills;
   }

   public void setNumbUse(int numbBillsIn) {
      this.numbBills = numbBillsIn;
   }

   public void addBill() {
      ++this.numbBills;
   }

   public byte getDirection() {
      return this.direction;
   }

   public void setDirection(byte direction) {
      this.direction = direction;
   }

   public CompoundNBT func_189515_b(CompoundNBT compound) {
      compound.func_74768_a("numbBills", this.numbBills);
      compound.func_74774_a("direction", this.direction);
      compound.func_74778_a("billRef", this.billRef);
      return super.func_189515_b(compound);
   }

   public void func_230337_a_(BlockState state, CompoundNBT compound) {
      super.func_230337_a_(state, compound);
      this.numbBills = compound.func_74762_e("numbBills");
      this.direction = compound.func_74771_c("direction");
      this.billRef = compound.func_74779_i("billRef");
   }

   public void func_70296_d() {
      BlockState state = this.field_145850_b.func_180495_p(this.func_174877_v());
      this.field_145850_b.func_184138_a(this.func_174877_v(), state, state, 3);
   }

   public Item getItemBill() {
      switch (this.getBillRef()) {
         case "item.economyinc.item_oneb":
            return ItemsRegistery.ITEM_ONEB;
         case "item.economyinc.item_fiveb":
            return ItemsRegistery.ITEM_FIVEB;
         case "item.economyinc.item_tenb":
            return ItemsRegistery.ITEM_TENB;
         case "item.economyinc.item_twentyb":
            return ItemsRegistery.ITEM_TWENTYB;
         case "item.economyinc.item_fiftybe":
            return ItemsRegistery.ITEM_FIFTYB;
         case "item.economyinc.item_hundreedb":
            return ItemsRegistery.ITEM_HUNDREEDB;
         case "item.economyinc.item_twohundreedb":
            return ItemsRegistery.ITEM_TWOHUNDREEDB;
         case "item.economyinc.item_fivehundreedb":
            return ItemsRegistery.ITEM_FIVEHUNDREEDB;
         default:
            return null;
      }
   }
}
