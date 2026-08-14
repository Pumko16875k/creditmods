package fr.fifoube.blocks;

import fr.fifoube.blocks.tileentity.TileEntityBlockBills;
import fr.fifoube.items.ItemsRegistery;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class BlockBills extends ContainerBlock {
   public ItemEntity field_220086_i;
   public static VoxelShape shapeMain;
   public static final AxisAlignedBB platform = new AxisAlignedBB((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)0.0625F, (double)1.0F);

   public BlockBills(AbstractBlock.Properties properties) {
      super(properties);
      VoxelShape shape = VoxelShapes.func_197881_a(platform);
      shapeMain = shape;
   }

   public TileEntity func_196283_a_(IBlockReader worldIn) {
      return new TileEntityBlockBills();
   }

   public boolean hasTileEntity(BlockState state) {
      return true;
   }

   public void func_180633_a(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
      TileEntity tileentity = worldIn.func_175625_s(pos);
      if (tileentity instanceof TileEntityBlockBills) {
         TileEntityBlockBills te = (TileEntityBlockBills)tileentity;
         if (!worldIn.field_72995_K) {
            int direction = MathHelper.func_76128_c((double)(placer.field_70177_z * 4.0F / 360.0F) + (double)2.5F) & 3;
            te.setDirection((byte)direction);
            te.func_70296_d();
         }
      }

   }

   public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
      if (!worldIn.field_72995_K) {
         TileEntity tileentity = worldIn.func_175625_s(pos);
         if (tileentity instanceof TileEntityBlockBills) {
            TileEntityBlockBills te = (TileEntityBlockBills)tileentity;
            if (te.getNumbBills() != 64) {
               String unNa = player.func_184586_b(hand).func_77977_a();
               if (te.getNumbBills() == 0) {
                  if (unNa.equals("item.economyinc.item_oneb") || unNa.equals("item.economyinc.item_fiveb") || unNa.equals("item.economyinc.item_tenb") || unNa.equals("item.economyinc.item_twentyb") || unNa.equals("item.economyinc.item_fiftybe") || unNa.equals("item.economyinc.item_hundreedb") || unNa.equals("item.economyinc.item_twohundreedb") || unNa.equals("item.economyinc.item_fivehundreedb")) {
                     this.checkBillRef(te, worldIn, player, hand);
                     te.addBill();
                     player.func_184586_b(hand).func_190920_e(player.func_184614_ca().func_190916_E() - 1);
                     te.func_70296_d();
                     return ActionResultType.SUCCESS;
                  }
               } else if (te.getBillRef().equals(unNa)) {
                  te.addBill();
                  player.func_184586_b(hand).func_190920_e(player.func_184614_ca().func_190916_E() - 1);
                  te.func_70296_d();
                  return ActionResultType.SUCCESS;
               }
            }
         }
      }

      return ActionResultType.FAIL;
   }

   public void func_176208_a(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
      super.func_176208_a(worldIn, pos, state, player);
      TileEntity tileentity = worldIn.func_175625_s(pos);
      this.dropBlocks(tileentity, worldIn, pos);
   }

   public void dropBlocks(TileEntity tileentity, World world, BlockPos pos) {
      if (tileentity instanceof TileEntityBlockBills) {
         TileEntityBlockBills te = (TileEntityBlockBills)tileentity;
         ItemEntity itemBase = new ItemEntity(world, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(BlocksRegistry.BLOCK_BILLS));
         world.func_217376_c(itemBase);

         for(int i = 0; i < te.getNumbBills(); ++i) {
            Item bill = te.getItemBill();
            if (bill != null) {
               ItemEntity item = new ItemEntity(world, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(bill));
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

   public void checkBillRef(TileEntityBlockBills te, IWorld worldIn, PlayerEntity playerIn, Hand hand) {
      if (!worldIn.func_201670_d()) {
         switch (playerIn.func_184586_b(hand).func_77977_a()) {
            case "item.economyinc.item_oneb":
               te.setBillRef("item.economyinc.item_oneb");
               te.func_70296_d();
               break;
            case "item.economyinc.item_fiveb":
               te.setBillRef("item.economyinc.item_fiveb");
               te.func_70296_d();
               break;
            case "item.economyinc.item_tenb":
               te.setBillRef("item.economyinc.item_tenb");
               te.func_70296_d();
               break;
            case "item.economyinc.item_twentyb":
               te.setBillRef("item.economyinc.item_twentyb");
               te.func_70296_d();
               break;
            case "item.economyinc.item_fiftybe":
               te.setBillRef("item.economyinc.item_fiftybe");
               te.func_70296_d();
               break;
            case "item.economyinc.item_hundreedb":
               te.setBillRef("item.economyinc.item_hundreedb");
               te.func_70296_d();
               break;
            case "item.economyinc.item_twohundreedb":
               te.setBillRef("item.economyinc.item_twohundreedb");
               te.func_70296_d();
               break;
            case "item.economyinc.item_fivehundreedb":
               te.setBillRef("item.economyinc.item_fivehundreedb");
               te.func_70296_d();
               break;
            default:
               te.setBillRef("item.economyinc.item_zerob");
               te.func_70296_d();
         }
      }

   }

   public void checkBillRefForDrop(TileEntityBlockBills te, World worldIn, BlockPos pos) {
      if (!worldIn.func_201670_d()) {
         switch (te.getBillRef()) {
            case "item.economyinc.item_oneb":
               this.field_220086_i = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(ItemsRegistery.ITEM_ONEB));
               break;
            case "item.economyinc.item_fiveb":
               this.field_220086_i = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(ItemsRegistery.ITEM_FIVEB));
               break;
            case "item.economyinc.item_tenb":
               this.field_220086_i = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(ItemsRegistery.ITEM_TENB));
               break;
            case "item.economyinc.item_twentyb":
               this.field_220086_i = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(ItemsRegistery.ITEM_TWENTYB));
               break;
            case "item.economyinc.item_fiftybe":
               this.field_220086_i = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(ItemsRegistery.ITEM_FIFTYB));
               break;
            case "item.economyinc.item_hundreedb":
               this.field_220086_i = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(ItemsRegistery.ITEM_HUNDREEDB));
               break;
            case "item.economyinc.item_twohundreedb":
               this.field_220086_i = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(ItemsRegistery.ITEM_TWOHUNDREEDB));
               break;
            case "item.economyinc.item_fivehundreedb":
               this.field_220086_i = new ItemEntity(worldIn, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(ItemsRegistery.ITEM_FIVEHUNDREEDB));
         }
      }

   }

   public boolean func_189539_a(BlockState state, World worldIn, BlockPos pos, int id, int param) {
      TileEntity tileentity = worldIn.func_175625_s(pos);
      return tileentity == null ? false : tileentity.func_145842_c(id, param);
   }

   public BlockRenderType func_149645_b(BlockState state) {
      return BlockRenderType.MODEL;
   }

   public VoxelShape func_220053_a(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return shapeMain;
   }

   public VoxelShape func_196247_c(BlockState state, IBlockReader worldIn, BlockPos pos) {
      return shapeMain;
   }

   public VoxelShape func_220071_b(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return shapeMain;
   }
}
