package fr.fifoube.blocks;

import fr.fifoube.blocks.tileentity.TileEntityBlockSeller;
import fr.fifoube.gui.ClientGuiScreen;
import fr.fifoube.items.ItemsRegistery;
import java.util.Random;
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
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockSeller extends ContainerBlock {
   public static final BooleanProperty POWERED;
   public static final DirectionProperty FACING;
   private static final TranslationTextComponent NAME;

   public BlockSeller(AbstractBlock.Properties properties) {
      super(properties);
      this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a(FACING, Direction.NORTH)).func_206870_a(POWERED, false));
   }

   public TileEntity func_196283_a_(IBlockReader worldIn) {
      return new TileEntityBlockSeller();
   }

   public boolean hasTileEntity(BlockState state) {
      return true;
   }

   public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      if (!worldIn.field_72995_K) {
         TileEntity tileentity = worldIn.func_175625_s(pos);
         if (tileentity instanceof TileEntityBlockSeller) {
            TileEntityBlockSeller te = (TileEntityBlockSeller)tileentity;
            if (te.getOwner() != null) {
               String checkONBT = te.getOwner();
               String checkOBA = player.func_110124_au().toString();
               if (checkONBT.equals(checkOBA)) {
                  if (!te.getCreated()) {
                     NetworkHooks.openGui((ServerPlayerEntity)player, te, (buf) -> buf.func_179255_a(pos));
                     return ActionResultType.SUCCESS;
                  }

                  if (te.getCreated() && player.func_184614_ca().func_77969_a(new ItemStack(ItemsRegistery.ITEM_REMOVER))) {
                     NetworkHooks.openGui((ServerPlayerEntity)player, te, (buf) -> buf.func_179255_a(pos));
                  }
               }
            }
         }
      } else if (worldIn.field_72995_K) {
         TileEntity tileentity = worldIn.func_175625_s(pos);
         if (tileentity instanceof TileEntityBlockSeller) {
            TileEntityBlockSeller te = (TileEntityBlockSeller)tileentity;
            if (te.getOwner() != null && te.getCreated()) {
               ClientGuiScreen.openGui(1, te);
               return ActionResultType.SUCCESS;
            }
         }
      }

      return ActionResultType.FAIL;
   }

   public void func_196270_a(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
      TileEntity tileentity = worldIn.func_175625_s(pos);
      if (tileentity instanceof TileEntityBlockSeller) {
         TileEntityBlockSeller te = (TileEntityBlockSeller)tileentity;
         ItemStack stack = player.func_184614_ca();
         worldIn.func_180495_p(pos);
         if (te != null && stack.func_77969_a(new ItemStack(ItemsRegistery.ITEM_REMOVER))) {
            String checkONBT = te.getOwner();
            String checkOBA = player.func_110124_au().toString();
            if (checkONBT.equals(checkOBA)) {
               worldIn.func_175655_b(pos, true);
               worldIn.func_175713_t(pos);
               this.dropBlocks(tileentity, worldIn, pos);
            }
         }
      }

   }

   public void dropBlocks(TileEntity tileentity, World world, BlockPos pos) {
      if (tileentity instanceof TileEntityBlockSeller) {
         TileEntityBlockSeller te = (TileEntityBlockSeller)tileentity;
         ItemEntity itemBase = new ItemEntity(world, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(BlocksRegistry.BLOCK_SELLER));
         world.func_217376_c(itemBase);
         if (te.getStackInSlot(0) != null) {
            ItemEntity itemContainer = new ItemEntity(world, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, te.getStackInSlot(0));
            world.func_217376_c(itemContainer);
         }
      }

   }

   public void func_180633_a(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
      super.func_180633_a(worldIn, pos, state, placer, stack);
      worldIn.func_180501_a(pos, (BlockState)state.func_206870_a(FACING, placer.func_174811_aO()), 2);
      TileEntity tileentity = worldIn.func_175625_s(pos);
      if (tileentity instanceof TileEntityBlockSeller) {
         TileEntityBlockSeller te = (TileEntityBlockSeller)tileentity;
         te.setOwner(placer.func_110124_au().toString());
         te.setFacing(state.toString().substring(38, 43));
         te.setOwnerName(placer.func_200200_C_().getString());
      }

   }

   public void func_220082_b(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
      this.setDefaultFacing(worldIn, pos, state);

      for(Direction direction : Direction.values()) {
         worldIn.func_195593_d(pos.func_177972_a(direction), this);
      }

   }

   public void func_196243_a(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
      if (!isMoving) {
         for(Direction direction : Direction.values()) {
            worldIn.func_195593_d(pos.func_177972_a(direction), this);
         }
      }

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
         } else if (dir == Direction.SOUTH && blockstate1.func_215704_f() && !blockstate.func_200132_m()) {
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
      builder.func_206894_a(new Property[]{FACING, POWERED});
   }

   public BlockRenderType func_149645_b(BlockState state) {
      return BlockRenderType.MODEL;
   }

   public boolean func_149744_f(BlockState state) {
      return true;
   }

   public int func_180656_a(BlockState state, IBlockReader blockAccess, BlockPos pos, Direction side) {
      return (Boolean)state.func_177229_b(POWERED) ? 15 : 0;
   }

   public void func_225534_a_(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      super.func_225534_a_(state, worldIn, pos, rand);
      if ((Boolean)state.func_177229_b(POWERED)) {
         worldIn.func_180501_a(pos, (BlockState)state.func_206870_a(POWERED, false), 3);
         this.updateNeighbors(state, worldIn, pos);
      }

   }

   public void scheduleTick(BlockState state, World worldIn, BlockPos pos) {
      worldIn.func_180501_a(pos, (BlockState)state.func_206870_a(POWERED, true), 3);
      this.updateNeighbors(state, worldIn, pos);
      worldIn.func_205220_G_().func_205360_a(pos, this, 20);
   }

   private void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
      worldIn.func_195593_d(pos, this);
      worldIn.func_195593_d(pos.func_177972_a(((Direction)state.func_177229_b(FACING)).func_176734_d()), this);
   }

   static {
      POWERED = BlockStateProperties.field_208194_u;
      FACING = HorizontalBlock.field_185512_D;
      NAME = new TranslationTextComponent("container.seller_buy");
   }
}
