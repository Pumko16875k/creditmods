package fr.fifoube.blocks;

import fr.fifoube.gui.ClientGuiScreen;
import fr.fifoube.items.ItemCreditCard;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockATM extends Block implements INamedContainerProvider {
   public static final DirectionProperty FACING;
   private static final TranslationTextComponent NAME;

   public BlockATM(AbstractBlock.Properties properties) {
      super(properties);
      this.func_180632_j((BlockState)this.func_176223_P().func_206870_a(FACING, Direction.NORTH));
   }

   public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
      return 5;
   }

   public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
      if (worldIn.field_72995_K) {
         for(int i = 0; i <= player.field_71071_by.func_70302_i_(); ++i) {
            if (player.field_71071_by.func_70301_a(i) != null && player.field_71071_by.func_70301_a(i).func_77973_b() instanceof ItemCreditCard) {
               ItemStack stackIn = player.field_71071_by.func_70301_a(i);
               if (stackIn.func_77942_o() && stackIn.func_77978_p().func_74767_n("Owned")) {
                  ClientGuiScreen.openGui(0, (TileEntity)null);
                  return ActionResultType.SUCCESS;
               }
            }
         }
      }

      return ActionResultType.FAIL;
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

   public BlockState getStateFromMeta(int meta) {
      Direction dir = Direction.func_82600_a(meta);
      if (dir.func_176740_k() == Axis.Y) {
         dir = Direction.NORTH;
      }

      return (BlockState)this.func_176223_P().func_206870_a(FACING, dir);
   }

   public int getMetaFromState(BlockState state) {
      return ((Direction)state.func_177229_b(FACING)).func_176745_a();
   }

   protected void func_206840_a(StateContainer.Builder<Block, BlockState> builder) {
      builder.func_206894_a(new Property[]{FACING});
   }

   public ITextComponent func_145748_c_() {
      return NAME;
   }

   public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
      return new Container(ContainerType.field_221520_n, id) {
         public boolean func_75145_c(PlayerEntity playerIn) {
            return true;
         }
      };
   }

   static {
      FACING = HorizontalBlock.field_185512_D;
      NAME = new TranslationTextComponent("container.atm");
   }
}
