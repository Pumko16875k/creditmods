import fr.fifoube.main.util.MoneyFormatter;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.fifoube.main.capabilities.CapabilityMoney;
import fr.fifoube.packets.PacketCardChange;
import fr.fifoube.packets.PacketsRegistery;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class GuiCreditCard extends Screen {
   private static final ResourceLocation background = new ResourceLocation("economyinc", "textures/gui/screen/gui_item.png");
   private Button oneB;
   private Button fiveB;
   private Button tenB;
   private Button twentyB;
   private Button fiftyB;
   private Button hundreedB;
   private Button twoHundreedB;
   private Button fiveHundreedB;
   private Button oneBMinus;
   private Button fiveBMinus;
   private Button tenBMinus;
   private Button twentyBMinus;
   private Button fiftyBMinus;
   private Button hundreedBMinus;
   private Button twoHundreedBMinus;
   private Button fiveHundreedBMinus;
   private double funds_s;
   private String name;
   protected int xSize;
   protected int ySize;
   protected int guiLeft;
   protected int guiTop;

   public GuiCreditCard() {
      super(new TranslationTextComponent("gui.creditcard"));
      this.name = Minecraft.func_71410_x().field_71439_g.func_145748_c_().getString();
      this.xSize = 256;
      this.ySize = 124;
   }

   public void func_231160_c_() {
      this.guiLeft = (this.field_230708_k_ - this.xSize) / 2;
      this.guiTop = (this.field_230709_l_ - this.ySize) / 2;
      this.oneB = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 90, this.field_230709_l_ / 2 - 55, 30, 20, (new StringTextComponent("+1")).func_240699_a_(TextFormatting.GREEN), (press) -> this.actionPerformed(0)));
      this.fiveB = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 120, this.field_230709_l_ / 2, 30, 20, (new StringTextComponent("+5")).func_240699_a_(TextFormatting.GREEN), (press) -> this.actionPerformed(1)));
      this.tenB = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 85, this.field_230709_l_ / 2, 30, 20, (new StringTextComponent("+10")).func_240699_a_(TextFormatting.GREEN), (press) -> this.actionPerformed(2)));
      this.twentyB = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 50, this.field_230709_l_ / 2, 30, 20, (new StringTextComponent("+20")).func_240699_a_(TextFormatting.GREEN), (press) -> this.actionPerformed(3)));
      this.fiftyB = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 15, this.field_230709_l_ / 2, 30, 20, (new StringTextComponent("+50")).func_240699_a_(TextFormatting.GREEN), (press) -> this.actionPerformed(4)));
      this.hundreedB = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 20, this.field_230709_l_ / 2, 30, 20, (new StringTextComponent("+100")).func_240699_a_(TextFormatting.GREEN), (press) -> this.actionPerformed(5)));
      this.twoHundreedB = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 55, this.field_230709_l_ / 2, 30, 20, (new StringTextComponent("+200")).func_240699_a_(TextFormatting.GREEN), (press) -> this.actionPerformed(6)));
      this.fiveHundreedB = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 90, this.field_230709_l_ / 2, 30, 20, (new StringTextComponent("+500")).func_240699_a_(TextFormatting.GREEN), (press) -> this.actionPerformed(7)));
      this.oneBMinus = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 90, this.field_230709_l_ / 2 - 25, 30, 20, (new StringTextComponent("-1")).func_240699_a_(TextFormatting.RED), (press) -> this.actionPerformed(8)));
      this.fiveBMinus = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 120, this.field_230709_l_ / 2 + 30, 30, 20, (new StringTextComponent("-5")).func_240699_a_(TextFormatting.RED), (press) -> this.actionPerformed(9)));
      this.tenBMinus = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 85, this.field_230709_l_ / 2 + 30, 30, 20, (new StringTextComponent("-10")).func_240699_a_(TextFormatting.RED), (press) -> this.actionPerformed(10)));
      this.twentyBMinus = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 50, this.field_230709_l_ / 2 + 30, 30, 20, (new StringTextComponent("-20")).func_240699_a_(TextFormatting.RED), (press) -> this.actionPerformed(11)));
      this.fiftyBMinus = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 15, this.field_230709_l_ / 2 + 30, 30, 20, (new StringTextComponent("-50")).func_240699_a_(TextFormatting.RED), (press) -> this.actionPerformed(12)));
      this.hundreedBMinus = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 20, this.field_230709_l_ / 2 + 30, 30, 20, (new StringTextComponent("-100")).func_240699_a_(TextFormatting.RED), (press) -> this.actionPerformed(13)));
      this.twoHundreedBMinus = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 55, this.field_230709_l_ / 2 + 30, 30, 20, (new StringTextComponent("-200")).func_240699_a_(TextFormatting.RED), (press) -> this.actionPerformed(14)));
      this.fiveHundreedBMinus = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 90, this.field_230709_l_ / 2 + 30, 30, 20, (new StringTextComponent("-500")).func_240699_a_(TextFormatting.RED), (press) -> this.actionPerformed(15)));
      super.func_231160_c_();
   }

   public boolean func_231177_au__() {
      return false;
   }

   public boolean func_231178_ax__() {
      return true;
   }

   public void func_231023_e_() {
      super.func_231023_e_();
      PlayerEntity playerIn = this.getMinecraft().field_71439_g;
      playerIn.getCapability(CapabilityMoney.MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> this.funds_s = data.getMoney());
   }

   public void actionPerformed(int buttonId) {
      int[] listNumber = new int[]{-1, -5, -10, -20, -50, -100, -200, -500, 1, 5, 10, 20, 50, 100, 200, 500};
      PacketsRegistery.CHANNEL.sendToServer(new PacketCardChange((double)listNumber[buttonId]));
   }

   public void func_230430_a_(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
      this.func_230446_a_(matrixStack);
      this.field_230706_i_.func_110434_K().func_110577_a(background);
      this.func_238474_b_(matrixStack, this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
      InventoryScreen.func_228187_a_(this.guiLeft + 25, this.guiTop + 58, 25, (float)(this.guiLeft + 51) - (float)mouseX, (float)(this.guiTop + 75 - 50) - (float)mouseY, this.getMinecraft().field_71439_g);
      super.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
      this.field_230712_o_.func_238421_b_(matrixStack, I18n.func_135052_a("title.ownerCard", new Object[0]) + ": " + this.name, (float)(this.field_230708_k_ / 2 - 75), (float)(this.field_230709_l_ / 2 - 55), Color.DARK_GRAY.getRGB());
      this.field_230712_o_.func_238421_b_(matrixStack, I18n.func_135052_a("title.fundsCard", new Object[0]) + ": " + this.funds_s, (float)(this.field_230708_k_ / 2 - 75), (float)(this.field_230709_l_ / 2 - 45), Color.DARK_GRAY.getRGB());
   }
}
