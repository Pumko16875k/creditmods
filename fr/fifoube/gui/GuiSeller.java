package fr.fifoube.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.fifoube.blocks.tileentity.TileEntityBlockSeller;
import fr.fifoube.gui.container.ContainerSeller;
import fr.fifoube.packets.PacketSellerCreated;
import fr.fifoube.packets.PacketsRegistery;
import java.awt.Color;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.lwjgl.opengl.GL11;

public class GuiSeller extends ContainerScreen<ContainerSeller> {
   private TileEntityBlockSeller tile = ((ContainerSeller)this.func_212873_a_()).getTile();
   private static final ResourceLocation background = new ResourceLocation("economyinc", "textures/gui/container/gui_seller.png");
   protected int field_146999_f = 176;
   protected int field_147000_g = 168;
   protected int field_147003_i;
   protected int field_147009_r;
   private Button validate;
   private Button one;
   private Button five;
   private Button ten;
   private Button twenty;
   private Button fifty;
   private Button hundreed;
   private Button twoHundreed;
   private Button fiveHundreed;
   private Button unlimitedStack;
   private double cost;
   private boolean admin = false;

   public GuiSeller(ContainerSeller container, PlayerInventory playerInventory, ITextComponent name) {
      super(container, playerInventory, name);
   }

   public void func_231023_e_() {
      super.func_231023_e_();
   }

   protected void func_231160_c_() {
      super.func_231160_c_();
      PlayerEntity player = this.field_230706_i_.field_71439_g;
      if (!this.tile.getCreated()) {
         this.validate = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 26, this.field_230709_l_ / 2 + 83, 55, 20, new TranslationTextComponent("title.validate"), (onPress) -> this.actionPerformed(this.validate)));
         this.one = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 121, this.field_230709_l_ / 2 - 75, 35, 20, new StringTextComponent("1"), (onPress) -> this.actionPerformed(this.one)));
         this.five = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 121, this.field_230709_l_ / 2 - 56, 35, 20, new StringTextComponent("5"), (onPress) -> this.actionPerformed(this.five)));
         this.ten = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 121, this.field_230709_l_ / 2 - 37, 35, 20, new StringTextComponent("10"), (onPress) -> this.actionPerformed(this.ten)));
         this.twenty = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 121, this.field_230709_l_ / 2 - 18, 35, 20, new StringTextComponent("20"), (onPress) -> this.actionPerformed(this.twenty)));
         this.fifty = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 121, this.field_230709_l_ / 2 + 1, 35, 20, new StringTextComponent("50"), (onPress) -> this.actionPerformed(this.fifty)));
         this.hundreed = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 121, this.field_230709_l_ / 2 + 20, 35, 20, new StringTextComponent("100"), (onPress) -> this.actionPerformed(this.hundreed)));
         this.twoHundreed = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 121, this.field_230709_l_ / 2 + 39, 35, 20, new StringTextComponent("200"), (onPress) -> this.actionPerformed(this.twoHundreed)));
         this.fiveHundreed = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 121, this.field_230709_l_ / 2 + 58, 35, 20, new StringTextComponent("500"), (onPress) -> this.actionPerformed(this.fiveHundreed)));
         if (player.func_184812_l_()) {
            this.unlimitedStack = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 2, this.field_230709_l_ / 2 - 96, 80, 13, new TranslationTextComponent("title.unlimited"), (onPress) -> this.actionPerformed(this.unlimitedStack)));
         }
      }

   }

   protected void actionPerformed(Button button) {
      PlayerEntity playerIn = this.field_230706_i_.field_71439_g;
      if (this.tile != null) {
         if (button == this.unlimitedStack) {
            if (!this.admin) {
               this.admin = true;
               this.tile.setAdmin(true);
            } else if (this.admin) {
               this.admin = false;
               this.tile.setAdmin(false);
            }
         }

         if (button == this.one) {
            this.tile.setCost((double)1.0F);
            this.cost = (double)1.0F;
         } else if (button == this.five) {
            this.tile.setCost((double)5.0F);
            this.cost = (double)5.0F;
         } else if (button == this.ten) {
            this.tile.setCost((double)10.0F);
            this.cost = (double)10.0F;
         } else if (button == this.twenty) {
            this.tile.setCost((double)20.0F);
            this.cost = (double)20.0F;
         } else if (button == this.fifty) {
            this.tile.setCost((double)50.0F);
            this.cost = (double)50.0F;
         } else if (button == this.hundreed) {
            this.tile.setCost((double)100.0F);
            this.cost = (double)100.0F;
         } else if (button == this.twoHundreed) {
            this.tile.setCost((double)200.0F);
            this.cost = (double)200.0F;
         } else if (button == this.fiveHundreed) {
            this.tile.setCost((double)500.0F);
            this.cost = (double)500.0F;
         } else if (button == this.validate) {
            if (this.tile.getCost() != (double)0.0F) {
               if (this.tile.getStackInSlot(0).func_77973_b() != Items.field_190931_a) {
                  if (!this.admin) {
                     this.tile.setAdmin(false);
                     this.tile.setCreated(true);
                     int x = this.tile.func_174877_v().func_177958_n();
                     int y = this.tile.func_174877_v().func_177956_o();
                     int z = this.tile.func_174877_v().func_177952_p();
                     int amount = this.tile.getStackInSlot(0).func_190916_E();
                     String name = this.tile.getStackInSlot(0).func_200301_q().getString();
                     this.tile.setItem(name);
                     this.tile.func_70296_d();
                     PacketsRegistery.CHANNEL.sendToServer(new PacketSellerCreated(true, this.cost, name, amount, x, y, z, false));
                     playerIn.func_71053_j();
                  } else if (this.admin) {
                     this.tile.setAdmin(true);
                     this.tile.setCreated(true);
                     int x = this.tile.func_174877_v().func_177958_n();
                     int y = this.tile.func_174877_v().func_177956_o();
                     int z = this.tile.func_174877_v().func_177952_p();
                     int amount = this.tile.getStackInSlot(0).func_190916_E();
                     String name = this.tile.getStackInSlot(0).func_200301_q().getString();
                     this.tile.setItem(name);
                     this.tile.func_70296_d();
                     PacketsRegistery.CHANNEL.sendToServer(new PacketSellerCreated(true, this.cost, name, amount, x, y, z, true));
                     playerIn.func_71053_j();
                  }
               } else {
                  playerIn.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.sellAir", new Object[0])), playerIn.func_110124_au());
               }
            } else {
               playerIn.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noCost", new Object[0])), playerIn.func_110124_au());
            }
         }
      }

   }

   public boolean func_231177_au__() {
      return false;
   }

   protected void func_230451_b_(MatrixStack matrixStack, int mouseX, int mouseY) {
      String s = "";
      if (this.admin) {
         s = I18n.func_135052_a("title.unlimitedStack", new Object[0]);
      } else {
         s = I18n.func_135052_a("title.limitedStack", new Object[0]);
      }

      this.field_230712_o_.func_238421_b_(matrixStack, I18n.func_135052_a("title.cost", new Object[0]) + this.cost, 98.0F, 34.0F, Color.DARK_GRAY.getRGB());
      this.field_230712_o_.func_238421_b_(matrixStack, I18n.func_135052_a("title.mode", new Object[0]) + s, 98.0F, 44.0F, Color.DARK_GRAY.getRGB());
      this.field_230712_o_.func_238421_b_(matrixStack, I18n.func_135052_a("title.block_seller", new Object[0]), 8.0F, 5.0F, Color.DARK_GRAY.getRGB());
      this.field_230712_o_.func_238421_b_(matrixStack, this.field_213127_e.func_145748_c_().getString(), 8.0F, (float)(this.field_147000_g - 94), 4210752);
   }

   public void func_230430_a_(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
      this.func_230446_a_(matrixStack);
      super.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
      this.func_230459_a_(matrixStack, mouseX, mouseY);
   }

   protected void func_230450_a_(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_230706_i_.func_110434_K().func_110577_a(background);
      int k = (this.field_230708_k_ - this.field_146999_f) / 2;
      int l = (this.field_230709_l_ - this.field_147000_g) / 2;
      this.func_238474_b_(matrixStack, k, l, 0, 0, this.field_146999_f, this.field_147000_g);
   }
}
