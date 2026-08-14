package fr.fifoube.main.events.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import fr.fifoube.blocks.BlockSeller;
import fr.fifoube.blocks.BlocksRegistry;
import fr.fifoube.blocks.tileentity.TileEntityBlockSeller;
import fr.fifoube.main.config.ConfigFile;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.DrawHighlightEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "economyinc",
   bus = Bus.MOD
)
public class ClientEvents {
   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public void onDrawBlockHighlightEvent(DrawHighlightEvent.HighlightBlock event) {
      if (ConfigFile.canPreviewItemInBlock) {
         World world = Minecraft.func_71410_x().field_71441_e;
         BlockPos pos = event.getTarget().func_216350_a();
         Block block = world.func_180495_p(pos).func_177230_c();
         if (block == BlocksRegistry.BLOCK_SELLER) {
            TileEntityBlockSeller te = (TileEntityBlockSeller)world.func_175625_s(pos);
            if (te != null && te.getCreated()) {
               int x = pos.func_177958_n();
               int y = pos.func_177956_o();
               int z = pos.func_177952_p();
               float i = 0.1F;
               float j = 0.0F;
               ItemRenderer renderM = Minecraft.func_71410_x().func_175599_af();
               MatrixStack matrixStack = event.getMatrix();
               IRenderTypeBuffer buffer = event.getBuffers();
               Direction direction = (Direction)world.func_180495_p(pos).func_177229_b(BlockSeller.FACING);
               matrixStack.func_227860_a_();
               ItemStack stack = new ItemStack(te.getStackInSlot(0).func_77973_b(), 1);
               if (te.getAmount() == 0) {
                  stack = new ItemStack(Blocks.field_180401_cv, 1);
               }

               Vector3d vec = event.getInfo().func_216785_c();
               matrixStack.func_227861_a_(-vec.field_72450_a, -vec.field_72448_b, -vec.field_72449_c);
               matrixStack.func_227861_a_((double)x + (double)0.5F, (double)y + (double)0.5F, (double)z + (double)0.5F);
               matrixStack.func_227862_a_(0.5F, 0.5F, 0.5F);
               switch (direction) {
                  case NORTH:
                     matrixStack.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 180.0F, true));
                     break;
                  case SOUTH:
                     matrixStack.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 0.0F, true));
                     break;
                  case WEST:
                     matrixStack.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), -90.0F, true));
                     break;
                  case EAST:
                     matrixStack.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 90.0F, true));
                     break;
                  default:
                     matrixStack.func_227863_a_(new Quaternion(new Vector3f(0.0F, 1.0F, 0.0F), 180.0F, true));
               }

               renderM.func_229110_a_(stack, TransformType.FIXED, 15728880, OverlayTexture.field_229196_a_, matrixStack, buffer);
               matrixStack.func_227865_b_();
            }
         }
      }

   }
}
