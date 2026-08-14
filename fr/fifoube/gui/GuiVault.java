package fr.fifoube.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.fifoube.blocks.tileentity.TileEntityBlockVault;
import fr.fifoube.gui.container.ContainerVault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import org.lwjgl.opengl.GL11;

public class GuiVault extends ContainerScreen<ContainerVault> {
   protected TileEntityBlockVault tile_getter = ((ContainerVault)this.func_212873_a_()).getTile();
   protected PlayerInventory playerInventory_getter;
   private static final ResourceLocation background = new ResourceLocation("economyinc", "textures/gui/container/gui_vault.png");
   protected int field_146999_f = 176;
   protected int field_147000_g = 168;
   protected int field_147003_i;
   protected int field_147009_r;

   public GuiVault(ContainerVault container, PlayerInventory playerInventory, ITextComponent name) {
      super(container, playerInventory, name);
      this.playerInventory_getter = playerInventory;
   }

   protected void func_231160_c_() {
      super.func_231160_c_();
      int i = (this.field_230708_k_ - this.field_146999_f) / 2;
      int j = (this.field_230709_l_ - this.field_147000_g) / 2;
   }

   public void func_231164_f_() {
      super.func_231164_f_();
      if (this.tile_getter.getIsOpen()) {
         this.tile_getter.setIsOpen(false);
         this.tile_getter.func_70296_d();
      }

   }

   protected void actionPerformed(int buttonId) {
      switch (buttonId) {
         case 0:
            Minecraft.func_71410_x().field_71439_g.func_145747_a(new StringTextComponent("Not available right now."), Minecraft.func_71410_x().field_71439_g.func_110124_au());
         default:
      }
   }

   public void func_230430_a_(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
      this.func_230446_a_(matrixStack);
      super.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
      this.func_230459_a_(matrixStack, mouseX, mouseY);
   }

   protected void func_230451_b_(MatrixStack matrixStack, int mouseX, int mouseY) {
      this.field_230712_o_.func_238421_b_(matrixStack, I18n.func_135052_a("title.block_vault", new Object[0]), 8.0F, 5.0F, 4210752);
      this.field_230712_o_.func_238421_b_(matrixStack, this.field_213127_e.func_145748_c_().getString(), 8.0F, (float)(this.field_147000_g - 94), 4210752);
   }

   protected void func_230450_a_(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.getMinecraft().func_110434_K().func_110577_a(background);
      int k = (this.field_230708_k_ - this.field_146999_f) / 2;
      int l = (this.field_230709_l_ - this.field_147000_g) / 2;
      this.func_238474_b_(matrixStack, k, l, 0, 0, this.field_146999_f, this.field_147000_g);
   }
}
