package fr.fifoube.blocks.tileentity.specialrenderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.fifoube.blocks.models.ModelBills;
import fr.fifoube.blocks.tileentity.TileEntityBlockBills;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class TileEntityBlockBillsSpecialRenderer extends TileEntityRenderer<TileEntityBlockBills> {
   private static ResourceLocation texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_0.png");
   private static ModelBills modelBlock = new ModelBills(RenderType::func_228634_a_);

   public TileEntityBlockBillsSpecialRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
      super(rendererDispatcherIn);
   }

   public void render(TileEntityBlockBills te, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
      this.checkBillRef(te);
      matrixStackIn.func_227860_a_();
      switch (te.getDirection()) {
         case 0:
            matrixStackIn.func_227861_a_((double)0.125F, (double)0.53F, (double)0.25F);
            matrixStackIn.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 180.0F, true));
            break;
         case 1:
            matrixStackIn.func_227861_a_((double)0.75F, (double)0.53F, (double)0.125F);
            matrixStackIn.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 90.0F, true));
            break;
         case 2:
            matrixStackIn.func_227861_a_((double)0.875F, (double)0.53F, (double)0.75F);
            matrixStackIn.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 360.0F, true));
            break;
         case 3:
            matrixStackIn.func_227861_a_((double)0.25F, (double)0.53F, (double)0.875F);
            matrixStackIn.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 270.0F, true));
      }

      matrixStackIn.func_227862_a_(0.3335F, 0.3335F, 0.3335F);
      matrixStackIn.func_227863_a_(new Quaternion(new Vector3f(0.0F, 0.0F, 1.0F), 180.0F, true));
      IVertexBuilder renderBuffer = bufferIn.getBuffer(modelBlock.func_228282_a_(texture));
      modelBlock.renderAll(te, matrixStackIn, renderBuffer, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStackIn.func_227865_b_();
   }

   public void checkBillRef(TileEntityBlockBills tile) {
      switch (tile.getBillRef()) {
         case "item.economyinc.item_oneb":
            texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_1.png");
            break;
         case "item.economyinc.item_fiveb":
            texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_5.png");
            break;
         case "item.economyinc.item_tenb":
            texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_10.png");
            break;
         case "item.economyinc.item_twentyb":
            texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_20.png");
            break;
         case "item.economyinc.item_fiftybe":
            texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_50.png");
            break;
         case "item.economyinc.item_hundreedb":
            texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_100.png");
            break;
         case "item.economyinc.item_twohundreedb":
            texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_200.png");
            break;
         case "item.economyinc.item_fivehundreedb":
            texture = new ResourceLocation("economyinc", "textures/blocks_models/block_bills_500.png");
      }

   }

   public boolean isGlobalRenderer(TileEntityBlockBills te) {
      return false;
   }
}
