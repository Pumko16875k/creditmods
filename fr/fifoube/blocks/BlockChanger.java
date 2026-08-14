package fr.fifoube.blocks;

import fr.fifoube.blocks.tileentity.TileEntityBlockChanger;
import fr.fifoube.items.ItemsRegistery;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockChanger extends ContainerBlock {
   public static final DirectionProperty FACING;
   private static final TranslationTextComponent NAME;

   public BlockChanger(AbstractBlock.Properties properties) {
      super(properties);
      this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a(FACING, Direction.NORTH));
   }

   public TileEntity func_196283_a_(IBlockReader worldIn) {
      return new TileEntityBlockChanger();
   }

   public boolean hasTileEntity(BlockState state) {
      return true;
   }

   public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hit) {
      boolean canOpen = true;
      if (!worldIn.field_72995_K) {
         TileEntity tileentity = worldIn.func_175625_s(pos);
         if (tileentity instanceof TileEntityBlockChanger) {
            TileEntityBlockChanger te = (TileEntityBlockChanger)tileentity;
            if (te != null) {
               if (te.getNumbUse() >= 1) {
                  canOpen = false;
               }

               if (canOpen) {
                  NetworkHooks.openGui((ServerPlayerEntity)playerIn, te, (buf) -> buf.func_179255_a(pos));
                  te.setNumbUse(1);
                  te.setEntityPlayer(playerIn);
                  te.func_70296_d();
                  return ActionResultType.SUCCESS;
               }

               playerIn.func_146105_b(new TranslationTextComponent("title.alreadyUsed"), true);
               return ActionResultType.FAIL;
            }
         }
      }

      return ActionResultType.FAIL;
   }

   public void func_196270_a(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
      TileEntity tileentity = worldIn.func_175625_s(pos);
      if (tileentity instanceof TileEntityBlockChanger) {
         TileEntityBlockChanger te = (TileEntityBlockChanger)tileentity;
         ItemStack stack = player.func_184614_ca();
         if (te != null && stack.func_77969_a(new ItemStack(ItemsRegistery.ITEM_REMOVER)) && te.getNumbUse() < 1) {
            worldIn.func_175655_b(pos, true);
            worldIn.func_175713_t(pos);
            ItemEntity itemBase = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(BlocksRegistry.BLOCK_CHANGER));
            worldIn.func_217376_c(itemBase);

            for(int i = 0; i < te.getHandler().getSlots(); ++i) {
               Item toDrop = te.getStackInSlot(i).func_77973_b();
               if (toDrop != null && toDrop != Items.field_190931_a) {
                  ItemEntity item = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(toDrop));
                  float multiplier = 0.1F;
                  float motionX = worldIn.field_73012_v.nextFloat() - 0.5F;
                  float motionY = worldIn.field_73012_v.nextFloat() - 0.5F;
                  float motionZ = worldIn.field_73012_v.nextFloat() - 0.5F;
                  item.field_70142_S = (double)(motionX * multiplier);
                  item.field_70137_T = (double)(motionY * multiplier);
                  item.field_70136_U = (double)(motionZ * multiplier);
                  worldIn.func_217376_c(item);
               }
            }
         }
      }

   }

   public void func_180633_a(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
      super.func_180633_a(worldIn, pos, state, placer, stack);
      worldIn.func_180501_a(pos, (BlockState)state.func_206870_a(FACING, placer.func_174811_aO().func_176734_d()), 2);
   }

   public void func_220082_b(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
      this.setDefaultFacing(worldIn, pos, state);
   }

   private void setDefaultFacing(World worldIn, BlockPos pos, BlockState state) {
      if (!worldIn.field_72995_K) {
         BlockState blockstate = worldIn.func_180495_p(pos.func_177978_c());
         BlockState blockstate1 = worldIn.func_180495_p(pos.func_177968_d());
         BlockState blockstate2 = worldIn.func_180495_p(pos.func_177976_e());
         BlockState blockstate3 = worldIn.func_180495_p(pos.func_177974_f());
         Direction dir = (Direction)state.func_177229_b(FACING);
         if (dir == Direction.NORTH && blockstate.func_215704_f() && !blockstate1.func_215704_f()) {
            dir = Direction.SOUTH;
         } else if (dir == Direction.SOUTH && blockstate1.func_215704_f() && !blockstate.func_215704_f()) {
            dir = Direction.NORTH;
         } else if (dir == Direction.WEST && blockstate2.func_215704_f() && !blockstate3.func_215704_f()) {
            dir = Direction.EAST;
         } else if (dir == Direction.EAST && blockstate3.func_215704_f() && !blockstate2.func_215704_f()) {
            dir = Direction.WEST;
         }

         worldIn.func_180501_a(pos, (BlockState)state.func_206870_a(FACING, dir), 2);
      }

   }

   public BlockState func_196258_a(BlockItemUseContext context) {
      return (BlockState)this.func_176223_P().func_206870_a(FACING, context.func_195992_f().func_176734_d());
   }

   public BlockState func_185499_a(BlockState state, Rotation rot) {
      return (BlockState)state.func_206870_a(FACING, rot.func_185831_a((Direction)state.func_177229_b(FACING)));
   }

   public BlockState func_185471_a(BlockState state, Mirror mirrorIn) {
      return state.func_185907_a(mirrorIn.func_185800_a((Direction)state.func_177229_b(FACING)));
   }

   protected void func_206840_a(StateContainer.Builder<Block, BlockState> builder) {
      builder.func_206894_a(new Property[]{FACING});
   }

   public BlockRenderType func_149645_b(BlockState state) {
      return BlockRenderType.MODEL;
   }

   static {
      FACING = HorizontalBlock.field_185512_D;
      NAME = new TranslationTextComponent("container.changer");
   }
}
