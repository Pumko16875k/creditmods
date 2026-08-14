package fr.fifoube.blocks.tileentity;

import fr.fifoube.gui.container.ContainerChanger;
import fr.fifoube.items.ItemsRegistery;
import fr.fifoube.main.ModEconomyInc;
import fr.fifoube.main.capabilities.CapabilityMoney;
import fr.fifoube.main.config.ConfigFile;
import fr.fifoube.stats.StatsRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent.Serializer;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBlockChanger extends TileEntity implements INamedContainerProvider, ITickableTileEntity {
   private static final TranslationTextComponent NAME = new TranslationTextComponent("container.changer");
   ItemStackHandler inventory;
   private byte direction;
   public int numbUse;
   public PlayerEntity user;
   public String name;
   public int timeProcess;
   public int timePassed;
   public boolean isProcessing;
   private ITextComponent customName;

   public TileEntityBlockChanger() {
      this(TileEntityRegistery.TILE_CHANGER);
   }

   public TileEntityBlockChanger(TileEntityType<?> tileEntityTypeIn) {
      super(tileEntityTypeIn);
      this.inventory = new ItemStackHandler(3);
      this.timeProcess = ConfigFile.goldChangerDuration;
      this.timePassed = 0;
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

   public ItemStack setStackInSlot(int slot, ItemStack stack, boolean simulate) {
      return this.inventory.insertItem(slot, stack, simulate);
   }

   public ItemStackHandler getHandler() {
      return this.inventory;
   }

   public int getNumbUse() {
      return this.numbUse;
   }

   public void setNumbUse(int numbUse) {
      this.numbUse = numbUse;
   }

   public PlayerEntity getEntityPlayer() {
      return this.user;
   }

   public void setEntityPlayer(PlayerEntity currentUser) {
      this.user = currentUser;
   }

   public byte getDirection() {
      return this.direction;
   }

   public void setDirection(byte direction) {
      this.direction = direction;
   }

   public int getTimePassed() {
      return this.timePassed;
   }

   public boolean getIsProcessing() {
      return this.isProcessing;
   }

   public CompoundNBT func_189515_b(CompoundNBT compound) {
      compound.func_218657_a("inventory", this.inventory.serializeNBT());
      compound.func_74768_a("numbUse", this.numbUse);
      compound.func_74757_a("isProcessing", this.isProcessing);
      compound.func_74768_a("timePassed", this.timePassed);
      if (this.func_145748_c_() != null) {
         compound.func_74778_a("CustomName", Serializer.func_150696_a(this.func_145748_c_()));
      }

      return super.func_189515_b(compound);
   }

   public void func_230337_a_(BlockState state, CompoundNBT compound) {
      super.func_230337_a_(state, compound);
      this.numbUse = compound.func_74762_e("numbUse");
      this.isProcessing = compound.func_74767_n("isProcessing");
      this.timePassed = compound.func_74762_e("timePassed");
      this.inventory.deserializeNBT((CompoundNBT)compound.func_74781_a("inventory"));
      if (compound.func_150297_b("CustomName", 8)) {
         this.customName = Serializer.func_240643_a_(compound.func_74779_i("CustomName"));
      }

   }

   public void func_70296_d() {
      BlockState state = this.field_145850_b.func_180495_p(this.func_174877_v());
      this.field_145850_b.func_184138_a(this.func_174877_v(), state, state, 3);
   }

   public void func_73660_a() {
      TileEntity te = this.field_145850_b.func_175625_s(this.field_174879_c);
      if (te instanceof TileEntityBlockChanger) {
         TileEntityBlockChanger tile = (TileEntityBlockChanger)te;
         ItemStack slot0 = this.inventory.getStackInSlot(0);
         ItemStack slot1 = this.inventory.getStackInSlot(1);
         ItemStack slot2 = this.inventory.getStackInSlot(2);
         if (slot0 != null && slot1 != null && slot2 != null && !this.field_145850_b.field_72995_K && slot0.func_77973_b() == ItemsRegistery.ITEM_GOLDNUGGET && slot1.func_77973_b() == ItemsRegistery.ITEM_CREDITCARD && slot1.func_77942_o() && tile.getEntityPlayer() != null) {
            String nameCard = slot1.func_77978_p().func_74779_i("OwnerUUID");
            String nameGame = tile.getEntityPlayer().func_110124_au().toString();
            if (nameCard.equals(nameGame) && slot2.func_190926_b()) {
               if (this.timePassed == 0) {
                  String w = String.valueOf(this.field_145850_b.func_201674_k().nextDouble()).substring(0, 4);
                  if (slot0.func_77942_o()) {
                     if (!slot0.func_77978_p().func_74764_b("weight")) {
                        slot0.func_77978_p().func_74778_a("weight", w);
                     }
                  } else {
                     slot0.func_196082_o().func_74778_a("weight", w);
                  }
               }

               if (this.timePassed == this.timeProcess) {
                  PlayerEntity playerIn = this.getEntityPlayer();
                  playerIn.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> {
                     double fundsPrev = data.getMoney();
                     String weight = slot0.func_77978_p().func_74779_i("weight");
                     double fundsNow = fundsPrev + Double.parseDouble(weight) * (double)ConfigFile.multiplierGoldNuggetWeight;
                     data.setMoney(fundsNow);
                     slot0.func_77979_a(1);
                     ItemStack copyOfCard = slot1.func_77946_l();
                     slot1.func_77979_a(1);
                     tile.setStackInSlot(2, copyOfCard, false);
                     this.timePassed = 0;
                     this.isProcessing = false;
                     this.func_70296_d();
                     playerIn.func_195066_a(StatsRegistry.CHANGED_GOLD_TO_MONEY);
                     ModEconomyInc.LOGGER.info(playerIn.func_145748_c_().getString() + " has changed gold with the weight (" + weight + "), the change was at " + Double.parseDouble(weight) * (double)ConfigFile.multiplierGoldNuggetWeight + ". Balance was at " + fundsPrev + ", balance is now " + data.getMoney() + ".[UUID: " + playerIn.func_110124_au() + "," + te.func_174877_v() + "]");
                  });
               } else {
                  ++this.timePassed;
                  this.isProcessing = true;
                  this.func_70296_d();
               }
            }
         }

         if (slot0.func_77973_b() == Items.field_190931_a || slot1.func_77973_b() == Items.field_190931_a) {
            this.timePassed = 0;
            this.isProcessing = false;
            this.func_70296_d();
         }
      }

   }

   public ItemStack removeStackFromSlot(int index) {
      return this.inventory.getStackInSlot(index).func_77979_a(1);
   }

   public ItemStack getStackInSlot(int index) {
      return this.inventory.getStackInSlot(index);
   }

   public Container createMenu(int id, PlayerInventory inv, PlayerEntity player) {
      return new ContainerChanger(id, inv, this.func_174877_v());
   }

   public ITextComponent func_145748_c_() {
      return NAME;
   }
}
