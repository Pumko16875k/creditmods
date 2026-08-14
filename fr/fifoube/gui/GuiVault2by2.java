package fr.fifoube.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.fifoube.blocks.tileentity.TileEntityBlockVault2by2;
import fr.fifoube.gui.container.ContainerVault2by2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;

public class GuiVault2by2 extends ContainerScreen<ContainerVault2by2> {
   protected TileEntityBlockVault2by2 tile_getter = ((ContainerVault2by2)this.func_212873_a_()).getTile();
   protected PlayerInventory player_inventory;
   private static final ResourceLocation background = new ResourceLocation("economyinc", "textures/gui/container/gui_vault2by2.png");
   protected int field_146999_f = 176;
   protected int field_147000_g = 222;
   protected int field_147003_i;
   protected int field_147009_r;
   private Button settings;

   public GuiVault2by2(ContainerVault2by2 container, PlayerInventory playerInventory, ITextComponent name) {
      super(container, playerInventory, name);
      this.player_inventory = playerInventory;
   }

   protected void func_231160_c_() {
      super.func_231160_c_();
      this.field_230706_i_.field_195559_v.func_197967_a(true);
      int i = (this.field_230708_k_ - this.field_146999_f) / 2;
      int j = (this.field_230709_l_ - this.field_147000_g) / 2;
      if (this.tile_getter.getOwnerS().equals(this.field_230706_i_.field_71439_g.func_110124_au().toString()) && !Minecraft.func_71410_x().func_71356_B()) {
         this.settings = (Button)this.func_230480_a_(new Button(i + 161, j, 15, 15, (new StringTextComponent("âš™")).func_240699_a_(TextFormatting.BOLD).func_240699_a_(TextFormatting.WHITE), (press) -> this.actionPerformed(0)));
      }

   }

   protected void actionPerformed(int buttonId) {
      switch (buttonId) {
         case 0:
            ClientGuiScreen.openGui(2, this.tile_getter);
         default:
      }
   }

   protected void func_230451_b_(MatrixStack matrixStack, int mouseX, int mouseY) {
      this.field_230712_o_.func_238421_b_(matrixStack, I18n.func_135052_a("title.block_vault", new Object[0]), 8.0F, -22.0F, 4210752);
      this.field_230712_o_.func_238421_b_(matrixStack, this.field_213127_e.func_145748_c_().getString(), 8.0F, (float)(this.field_147000_g - 122), 4210752);
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
