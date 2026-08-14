package fr.fifoube.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import fr.fifoube.blocks.tileentity.TileEntityBlockSeller;
import fr.fifoube.items.ItemCreditCard;
import fr.fifoube.main.capabilities.CapabilityMoney;
import fr.fifoube.packets.PacketSellerFundsTotal;
import fr.fifoube.packets.PacketsRegistery;
import java.awt.Color;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import org.lwjgl.opengl.GL11;

public class GuiSellerBuy extends Screen {
   private TileEntityBlockSeller tile;
   private static final ResourceLocation background = new ResourceLocation("economyinc", "textures/gui/screen/gui_item.png");
   protected int xSize = 256;
   protected int ySize = 124;
   protected int guiLeft;
   protected int guiTop;
   private Button slot1;
   private Button takeFunds;
   private String owner = "";
   private String itemName = "";
   private double cost;
   private int amount;
   private double fundsTotalRecovery;
   private String sellerOwner = "";
   private String worldPlayer = "";

   public GuiSellerBuy(TileEntityBlockSeller te) {
      super(new TranslationTextComponent("gui.sellerbuy"));
      this.tile = te;
   }

   public void func_231023_e_() {
      super.func_231023_e_();
      this.amount = this.tile.getAmount();
      this.fundsTotalRecovery = this.tile.getFundsTotal();
      this.tile.setFundsTotal(this.fundsTotalRecovery);
      this.tile.func_70296_d();
      if (this.tile.getTime() != 0) {
         this.slot1.field_230693_o_ = false;
      } else {
         this.slot1.field_230693_o_ = true;
      }

   }

   protected void func_231160_c_() {
      this.guiLeft = (this.field_230708_k_ - this.xSize) / 2;
      this.guiTop = (this.field_230709_l_ - this.ySize) / 2;
      if (this.tile != null) {
         this.owner = this.tile.getOwnerName();
         this.itemName = this.tile.getItem();
         this.cost = this.tile.getCost();
         this.slot1 = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 - 50, this.field_230709_l_ / 2 + 27, 100, 20, new TranslationTextComponent("title.buy"), (press) -> this.actionPerformed(0)));
         this.sellerOwner = this.tile.getOwner();
         this.worldPlayer = this.field_230706_i_.field_71439_g.func_110124_au().toString();
         if (this.sellerOwner.equals(this.worldPlayer)) {
            this.takeFunds = (Button)this.func_230480_a_(new Button(this.field_230708_k_ / 2 + 20, this.field_230709_l_ / 2 - 75, 100, 13, new TranslationTextComponent("title.recover"), (press) -> this.actionPerformed(1)));
         }
      }

      super.func_231160_c_();
   }

   public boolean func_231177_au__() {
      return false;
   }

   protected void actionPerformed(int buttonId) {
      int x = this.tile.func_174877_v().func_177958_n();
      int y = this.tile.func_174877_v().func_177956_o();
      int z = this.tile.func_174877_v().func_177952_p();
      this.field_230706_i_.field_71439_g.getCapability(CapabilityMoney.MONEY_CAPABILITY).ifPresent((data) -> {
         if (this.tile != null) {
            if (buttonId == 0) {
               for(int i = 0; i < this.field_230706_i_.field_71439_g.field_71071_by.func_70302_i_(); ++i) {
                  if (this.field_230706_i_.field_71439_g.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemCreditCard) {
                     ItemStack creditCard = this.field_230706_i_.field_71439_g.field_71071_by.func_70301_a(i);
                     if (creditCard.func_77942_o()) {
                        if (this.field_230706_i_.field_71439_g.func_110124_au().toString().equals(creditCard.func_77978_p().func_74779_i("OwnerUUID"))) {
                           if (creditCard.func_77978_p().func_74767_n("Linked")) {
                              if (data.getMoney() >= this.tile.getCost()) {
                                 if (this.tile.getAmount() >= 1) {
                                    boolean admin = this.tile.getAdmin();
                                    if (!admin) {
                                       double fundTotal = this.tile.getFundsTotal();
                                       int amount = this.tile.getAmount();
                                       PacketsRegistery.CHANNEL.sendToServer(new PacketSellerFundsTotal(fundTotal, this.tile.getCost(), x, y, z, amount, false));
                                       this.tile.func_70296_d();
                                    } else if (admin) {
                                       double fundTotal = this.tile.getFundsTotal();
                                       int amount = this.tile.getAmount();
                                       PacketsRegistery.CHANNEL.sendToServer(new PacketSellerFundsTotal(fundTotal, this.tile.getCost(), x, y, z, amount, false));
                                       this.tile.func_70296_d();
                                    }
                                 }
                              } else {
                                 this.field_230706_i_.field_71439_g.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noEnoughFunds", new Object[0])), this.field_230706_i_.field_71439_g.func_110124_au());
                              }
                           } else {
                              this.field_230706_i_.field_71439_g.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.notLinked", new Object[0])), this.field_230706_i_.field_71439_g.func_110124_au());
                           }
                        } else {
                           this.field_230706_i_.field_71439_g.func_145747_a(new StringTextComponent(I18n.func_135052_a("title.noSameOwner", new Object[0])), this.field_230706_i_.field_71439_g.func_110124_au());
                        }
                     }
                  }
               }
            } else if (buttonId == 1) {
               this.tile.setFundsTotal((double)0.0F);
               this.tile.func_70296_d();
               PacketsRegistery.CHANNEL.sendToServer(new PacketSellerFundsTotal(this.fundsTotalRecovery, (double)0.0F, x, y, z, this.amount, true));
            }
         }

      });
   }

   public void func_230430_a_(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
      this.func_230446_a_(matrixStack);
      this.getMinecraft().func_110434_K().func_110577_a(background);
      int i = this.guiLeft;
      int j = this.guiTop;
      this.func_238474_b_(matrixStack, i, j, 0, 0, this.xSize, this.ySize);
      this.field_230712_o_.func_238421_b_(matrixStack, TextFormatting.BOLD + I18n.func_135052_a("title.seller", new Object[0]) + this.owner, (float)(this.field_230708_k_ / 2 - 120), (float)(this.field_230709_l_ / 2 - 55), Color.BLACK.getRGB());
      this.field_230712_o_.func_238421_b_(matrixStack, TextFormatting.BOLD + I18n.func_135052_a("title.item", new Object[0]) + this.itemName, (float)(this.field_230708_k_ / 2 - 120), (float)(this.field_230709_l_ / 2 - 45), Color.BLACK.getRGB());
      this.field_230712_o_.func_238421_b_(matrixStack, TextFormatting.BOLD + I18n.func_135052_a("title.cost", new Object[0]) + this.cost, (float)(this.field_230708_k_ / 2 - 120), (float)(this.field_230709_l_ / 2 - 35), Color.BLACK.getRGB());
      this.field_230712_o_.func_238421_b_(matrixStack, TextFormatting.BOLD + I18n.func_135052_a("title.amount", new Object[0]) + this.amount, (float)(this.field_230708_k_ / 2 - 120), (float)(this.field_230709_l_ / 2 - 25), Color.BLACK.getRGB());
      if (this.sellerOwner.equals(this.worldPlayer)) {
         this.field_230712_o_.func_238421_b_(matrixStack, TextFormatting.BOLD + I18n.func_135052_a("title.fundsToRecover", new Object[0]) + this.fundsTotalRecovery, (float)(this.field_230708_k_ / 2 - 120), (float)(this.field_230709_l_ / 2 - 15), Color.BLACK.getRGB());
      }

      super.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
      this.drawImageInGui();
   }

   public void drawImageInGui() {
      int i = this.guiLeft;
      int j = this.guiTop;
      GL11.glPushMatrix();
      GlStateManager.func_227623_K_();
      RenderHelper.func_227780_a_();
      GL11.glScaled((double)2.0F, (double)2.0F, (double)2.0F);
      ItemStack stack = new ItemStack(Blocks.field_180401_cv, 1);
      if (this.tile.getAmount() != 0) {
         stack = new ItemStack(this.tile.getStackInSlot(0).func_77973_b(), 1);
      }

      this.field_230707_j_.func_175042_a(stack, i / 2 + 105, j / 2 + 5);
      RenderHelper.func_74518_a();
      GlStateManager.func_227624_L_();
      GL11.glPopMatrix();
   }
}
