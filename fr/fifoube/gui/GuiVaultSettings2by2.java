package fr.fifoube.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.fifoube.blocks.tileentity.TileEntityBlockVault2by2;
import fr.fifoube.packets.PacketVaultSettings;
import fr.fifoube.packets.PacketsRegistery;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import org.lwjgl.opengl.GL11;

public class GuiVaultSettings2by2 extends Screen {
   private static final ResourceLocation BACKGROUND = new ResourceLocation("economyinc", "textures/gui/screen/gui_item.png");
   protected int xSize = 256;
   protected int ySize = 124;
   protected int guiLeft;
   protected int guiTop;
   protected TextFieldWidget commandTextField;
   protected TileEntityBlockVault2by2 tile;
   List<Button> buttonList = new ArrayList();

   public GuiVaultSettings2by2(TileEntityBlockVault2by2 te) {
      super(new TranslationTextComponent("gui.vaultsettings"));
      this.tile = te;
   }

   protected void func_231160_c_() {
      super.func_231160_c_();
      this.field_230706_i_.field_195559_v.func_197967_a(true);
      this.commandTextField = new TextFieldWidget(this.field_230712_o_, this.field_230708_k_ / 2 - 75, this.field_230709_l_ / 2 - 70, 150, 20, new TranslationTextComponent("gui.vaultsettings"));
      this.commandTextField.func_146203_f(35);
      this.commandTextField.func_146180_a("Add other players.");
      this.field_230705_e_.add(this.commandTextField);
      this.buttonList.clear();

      for(int i = 0; i < 5; ++i) {
         Button button = new Button((this.field_230708_k_ - this.xSize) / 2 + 164, (this.field_230709_l_ - this.ySize) / 2 + 18 * (i + 1), 40, 13, (new StringTextComponent("âœ–")).func_240699_a_(TextFormatting.DARK_RED), (press) -> this.actionPerformed(i));
         this.buttonList.add(i, button);
         button.field_230693_o_ = false;
         this.func_230480_a_(button);
      }

   }

   public void func_231023_e_() {
      this.commandTextField.func_146178_a();
      if (this.tile.getMax() == 5) {
         this.commandTextField.func_146184_c(false);
         this.commandTextField.func_146180_a("Max players allowed reached");
      }

   }

   public void func_230430_a_(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
      this.func_230446_a_(matrixStack);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_230706_i_.func_110434_K().func_110577_a(BACKGROUND);
      int k = (this.field_230708_k_ - this.xSize) / 2;
      int l = (this.field_230709_l_ - this.ySize) / 2;
      this.func_238474_b_(matrixStack, k, l, 0, 0, this.xSize, this.ySize);
      super.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
      if (!Minecraft.func_71410_x().func_71356_B() && this.tile.getOwnerS().equals(Minecraft.func_71410_x().field_71439_g.func_110124_au().toString())) {
         this.commandTextField.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
      }

      for(int i = 0; i < this.tile.getAllowedPlayers().size(); ++i) {
         String playerName = ((String)this.tile.getAllowedPlayers().get(i)).substring(0, ((String)this.tile.getAllowedPlayers().get(i)).indexOf(","));
         this.field_230712_o_.func_238421_b_(matrixStack, playerName, (float)((this.field_230708_k_ - this.xSize) / 2 + 52), (float)((this.field_230709_l_ - this.ySize) / 2 + 20 * (i + 1)), 0);
      }

      for(int j = 0; j < 5; ++j) {
         if (!this.tile.getAllowedPlayers().isEmpty()) {
            if (this.tile.getAllowedPlayers().size() > j) {
               ((Button)this.buttonList.get(j)).field_230693_o_ = true;
            } else {
               ((Button)this.buttonList.get(j)).field_230693_o_ = false;
            }
         } else {
            ((Button)this.buttonList.get(j)).field_230693_o_ = false;
         }
      }

   }

   protected void actionPerformed(int id) {
      PacketsRegistery.CHANNEL.sendToServer(new PacketVaultSettings(this.tile.func_174877_v(), "", true, id));
   }

   public boolean func_231046_a_(int keyPressedCode, int p_keyPressed_2_, int p_keyPressed_3_) {
      if (keyPressedCode != 257 && keyPressedCode != 335) {
         return super.func_231046_a_(keyPressedCode, p_keyPressed_2_, p_keyPressed_3_);
      } else if (this.tile.getMax() < 5) {
         this.addPlayerToTileEntity();
         this.commandTextField.func_146180_a("");
         return true;
      } else {
         this.commandTextField.func_146180_a("Max players allowed reached ");
         return false;
      }
   }

   private void addPlayerToTileEntity() {
      String s = this.commandTextField.func_146179_b();
      List<AbstractClientPlayerEntity> playerList = Minecraft.func_71410_x().field_71441_e.func_217369_A();
      if (playerList != null) {
         for(int i = 0; i < playerList.size(); ++i) {
            if (((AbstractClientPlayerEntity)playerList.get(i)).func_200200_C_().getString().equals(s) && !((AbstractClientPlayerEntity)playerList.get(i)).func_110124_au().toString().equals(this.tile.ownerS)) {
               UUID playerUUID = ((AbstractClientPlayerEntity)playerList.get(i)).func_110124_au();
               boolean flag = this.checkForSamePlayer(playerUUID);
               if (flag) {
                  String playerName = ((AbstractClientPlayerEntity)playerList.get(i)).func_145748_c_().func_150261_e();
                  PacketsRegistery.CHANNEL.sendToServer(new PacketVaultSettings(this.tile.func_174877_v(), playerName + "," + playerUUID.toString(), false, i));
               }
            }
         }
      }

   }

   private boolean checkForSamePlayer(UUID uuid) {
      if (!this.tile.getAllowedPlayers().isEmpty()) {
         for(int i = 0; i < this.tile.getAllowedPlayers().size(); ++i) {
            String playerUUID = ((String)this.tile.getAllowedPlayers().get(i)).substring(((String)this.tile.getAllowedPlayers().get(i)).indexOf(",") + 1);
            UUID uuidPlayer = UUID.fromString(playerUUID);
            if (uuidPlayer.equals(uuid)) {
               return false;
            }
         }
      }

      return true;
   }

   public void func_231164_f_() {
      super.func_231164_f_();
      this.getMinecraft().field_195559_v.func_197967_a(false);
   }
}
