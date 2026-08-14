package fr.fifoube.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.fifoube.blocks.tileentity.TileEntityBlockChanger;
import fr.fifoube.gui.container.ContainerChanger;
import fr.fifoube.packets.PacketChangerUpdate;
import fr.fifoube.packets.PacketsRegistery;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.lwjgl.opengl.GL11;

public class GuiChanger extends ContainerScreen<ContainerChanger> {
   private TileEntityBlockChanger tile = ((ContainerChanger)this.func_212873_a_()).getTile();
   private static final ResourceLocation background = new ResourceLocation("economyinc", "textures/gui/container/gui_changer.png");
   protected int field_146999_f = 176;
   protected int field_147000_g = 168;
   protected int field_147003_i;
   protected int field_147009_r;
   private boolean isProcessing;

   public GuiChanger(ContainerChanger container, PlayerInventory playerInventory, ITextComponent name) {
      super(container, playerInventory, name);
   }

   public void func_231023_e_() {
      super.func_231023_e_();
   }

   protected void func_231160_c_() {
      super.func_231160_c_();
      int i = (this.field_230708_k_ - this.field_146999_f) / 2;
      int j = (this.field_230709_l_ - this.field_147000_g) / 2;
   }

   public boolean func_231177_au__() {
      return false;
   }

   protected void func_230451_b_(MatrixStack matrixStack, int x, int y) {
      this.field_230712_o_.func_238421_b_(matrixStack, I18n.func_135052_a("title.block_changer", new Object[0]), 8.0F, 5.0F, 4210752);
      this.field_230712_o_.func_238421_b_(matrixStack, this.field_213127_e.func_145748_c_().getString(), 8.0F, (float)(this.field_147000_g - 95), 4210752);
   }

   public void func_230430_a_(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
      this.func_230446_a_(matrixStack);
      super.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
      this.func_230459_a_(matrixStack, mouseX, mouseY);
   }

   protected void func_230450_a_(MatrixStack matrixStack, float partialTicks, int x, int y) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.getMinecraft().func_110434_K().func_110577_a(background);
      int k = (this.field_230708_k_ - this.field_146999_f) / 2;
      int l = (this.field_230709_l_ - this.field_147000_g) / 2;
      this.func_238474_b_(matrixStack, k, l, 0, 0, this.field_146999_f, this.field_147000_g);
      if (this.tile != null) {
         float display = (float)this.tile.getTimePassed() / Float.valueOf((float)this.tile.timeProcess) * 56.0F;
         if (this.tile.isProcessing) {
            this.func_238474_b_(matrixStack, k + 55, l + 34, 176, 0, Math.round(display), this.field_147000_g);
         }
      }

   }

   public void func_231164_f_() {
      this.tile.setNumbUse(0);
      PacketsRegistery.CHANNEL.sendToServer(new PacketChangerUpdate(this.tile.func_174877_v()));
   }
}
