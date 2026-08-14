package fr.fifoube.blocks;

import fr.fifoube.blocks.tileentity.TileEntityBlockVault2by2;
import fr.fifoube.items.ItemsRegistery;
import java.util.UUID;
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
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;

public class BlockVault2by2 extends ContainerBlock {
   public static final DirectionProperty FACING;
   private static final TranslationTextComponent NAME;
   public static final AxisAlignedBB NORTH_AABB;
   public static final AxisAlignedBB SOUTH_AABB;
   public static final AxisAlignedBB EAST_AABB;
   public static final AxisAlignedBB WEST_AABB;
   public static final VoxelShape NORTH_VOXELSHAPE;
   public static VoxelShape shapeMain;

   public BlockVault2by2(AbstractBlock.Properties properties) {
      super(properties);
      this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a(FACING, Direction.NORTH));
      shapeMain = VoxelShapes.func_197881_a(NORTH_AABB);
   }

   public TileEntity func_196283_a_(IBlockReader worldIn) {
      return new TileEntityBlockVault2by2();
   }

   public boolean hasTileEntity(BlockState state) {
      return true;
   }

   public void dropBlocks(TileEntity tileentity, World world, BlockPos pos) {
      if (tileentity instanceof TileEntityBlockVault2by2) {
         TileEntityBlockVault2by2 te = (TileEntityBlockVault2by2)tileentity;
         IItemHandler inventory = te.getHandler();
         ItemEntity itemBase = new ItemEntity(world, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(BlocksRegistry.BLOCK_VAULT, 4));
         world.func_217376_c(itemBase);
         if (inventory != null) {
            for(int i = 0; i < inventory.getSlots(); ++i) {
               if (inventory.getStackInSlot(i) != ItemStack.field_190927_a) {
                  ItemEntity item = new ItemEntity(world, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, inventory.getStackInSlot(i));
                  float multiplier = 0.1F;
                  float motionX = world.field_73012_v.nextFloat() - 0.5F;
                  float motionY = world.field_73012_v.nextFloat() - 0.5F;
                  float motionZ = world.field_73012_v.nextFloat() - 0.5F;
                  item.field_70142_S = (double)(motionX * multiplier);
                  item.field_70137_T = (double)(motionY * multiplier);
                  item.field_70136_U = (double)(motionZ * multiplier);
                  world.func_217376_c(item);
               }
            }
         }
      }

   }

   public void func_180633_a(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
      worldIn.func_180501_a(pos, (BlockState)state.func_206870_a(FACING, placer.func_174811_aO().func_176734_d()), 2);
      TileEntity tileentity = worldIn.func_175625_s(pos);
      if (tileentity instanceof TileEntityBlockVault2by2) {
         TileEntityBlockVault2by2 te = (TileEntityBlockVault2by2)tileentity;
         te.setString(placer.func_110124_au().toString());
         te.ownerS = placer.func_110124_au().toString();
         int direction = MathHelper.func_76128_c((double)(placer.field_70177_z * 4.0F / 360.0F) + (double)2.5F) & 3;
         te.setDirection((byte)direction);
      }

   }

   public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      if (!worldIn.field_72995_K) {
         TileEntity tileentity = worldIn.func_175625_s(pos);
         if (tileentity instanceof TileEntityBlockVault2by2) {
            TileEntityBlockVault2by2 te = (TileEntityBlockVault2by2)tileentity;
            if (te.getOwnerS() != null) {
               String checkONBT = te.getOwnerS();
               String checkOBA = player.func_110124_au().toString();
               if (checkONBT.equals(checkOBA)) {
                  NetworkHooks.openGui((ServerPlayerEntity)player, (INamedContainerProvider)tileentity, (buf) -> buf.func_179255_a(pos));
                  te.func_70296_d();
                  return ActionResultType.SUCCESS;
               }

               if (player.func_211513_k(4)) {
                  NetworkHooks.openGui((ServerPlayerEntity)player, te, (buf) -> buf.func_179255_a(pos));
                  te.func_70296_d();
                  return ActionResultType.SUCCESS;
               }

               for(int i = 0; i < te.getAllowedPlayers().size(); ++i) {
                  String fullString = (String)te.getAllowedPlayers().get(i);
                  String listToCheck = fullString.substring(fullString.indexOf(",") + 1);
                  if (player.func_110124_au().equals(UUID.fromString(listToCheck))) {
                     NetworkHooks.openGui((ServerPlayerEntity)player, (INamedContainerProvider)tileentity, (buf) -> buf.func_179255_a(pos));
                     te.func_70296_d();
                     return ActionResultType.SUCCESS;
                  }
               }
            }
         }
      }

      return ActionResultType.FAIL;
   }

   public void func_196270_a(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
      TileEntity tileentity = worldIn.func_175625_s(pos);
      if (tileentity instanceof TileEntityBlockVault2by2) {
         TileEntityBlockVault2by2 te = (TileEntityBlockVault2by2)tileentity;
         ItemStack stack = player.func_184614_ca();
         worldIn.func_180495_p(pos);
         if (te != null && stack.func_77969_a(new ItemStack(ItemsRegistery.ITEM_REMOVER))) {
            String checkONBT = te.getOwnerS();
            String checkOBA = player.func_110124_au().toString();
            if (checkONBT.equals(checkOBA)) {
               worldIn.func_175655_b(pos, false);
               this.dropBlocks(te, worldIn, pos);
               worldIn.func_175713_t(pos);
            }
         }
      }

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
         if (dir == Direction.NORTH && blockstate.func_200132_m() && blockstate1.func_200132_m()) {
            dir = Direction.SOUTH;
         } else if (dir == Direction.SOUTH && blockstate1.func_200132_m() && blockstate.func_200132_m()) {
            dir = Direction.NORTH;
         } else if (dir == Direction.WEST && blockstate2.func_200132_m() && blockstate3.func_200132_m()) {
            dir = Direction.EAST;
         } else if (dir == Direction.EAST && blockstate3.func_200132_m() && blockstate2.func_200132_m()) {
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

   public boolean func_189539_a(BlockState state, World worldIn, BlockPos pos, int id, int param) {
      TileEntity tileentity = worldIn.func_175625_s(pos);
      return tileentity == null ? false : tileentity.func_145842_c(id, param);
   }

   public VoxelShape func_220053_a(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return this.getShapeMainFromDir(state);
   }

   public VoxelShape func_196247_c(BlockState state, IBlockReader worldIn, BlockPos pos) {
      return this.getShapeMainFromDir(state);
   }

   public VoxelShape func_220071_b(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return this.getShapeMainFromDir(state);
   }

   public VoxelShape func_199600_g(BlockState state, IBlockReader worldIn, BlockPos pos) {
      return this.getShapeMainFromDir(state);
   }

   public VoxelShape getShapeMainFromDir(BlockState state) {
      Direction dir = (Direction)state.func_177229_b(FACING);
      switch (dir) {
         case NORTH:
            shapeMain = VoxelShapes.func_197881_a(NORTH_AABB);
            break;
         case SOUTH:
            shapeMain = VoxelShapes.func_197881_a(SOUTH_AABB);
            break;
         case WEST:
            shapeMain = VoxelShapes.func_197881_a(WEST_AABB);
            break;
         case EAST:
            shapeMain = VoxelShapes.func_197881_a(EAST_AABB);
            break;
         default:
            shapeMain = VoxelShapes.func_197881_a(NORTH_AABB);
      }

      return shapeMain;
   }

   static {
      FACING = HorizontalBlock.field_185512_D;
      NAME = new TranslationTextComponent("container.vault2by2");
      NORTH_AABB = new AxisAlignedBB((double)0.0F, (double)0.0F, (double)0.0F, (double)2.0F, (double)2.0F, (double)1.0F);
      SOUTH_AABB = new AxisAlignedBB((double)-1.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)2.0F, (double)1.0F);
      EAST_AABB = new AxisAlignedBB((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)2.0F, (double)2.0F);
      WEST_AABB = new AxisAlignedBB((double)0.0F, (double)0.0F, (double)-1.0F, (double)1.0F, (double)2.0F, (double)1.0F);
      NORTH_VOXELSHAPE = Block.func_208617_a((double)0.0F, (double)0.0F, (double)0.0F, (double)32.0F, (double)32.0F, (double)16.0F);
   }
}
