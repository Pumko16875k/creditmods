package fr.fifoube.blocks;

import fr.fifoube.blocks.tileentity.TileEntityBlockVault;
import fr.fifoube.blocks.tileentity.TileEntityBlockVault2by2;
import fr.fifoube.items.ItemsRegistery;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;

public class BlockVault extends ContainerBlock {
   public static final DirectionProperty FACING;
   private static final TranslationTextComponent NAME;

   public BlockVault(AbstractBlock.Properties properties) {
      super(properties);
      this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a(FACING, Direction.NORTH));
   }

   public TileEntity func_196283_a_(IBlockReader worldIn) {
      return new TileEntityBlockVault();
   }

   public boolean hasTileEntity(BlockState state) {
      return true;
   }

   public void func_180633_a(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
      worldIn.func_180501_a(pos, (BlockState)state.func_206870_a(FACING, placer.func_174811_aO().func_176734_d()), 2);
      TileEntity tileentity = worldIn.func_175625_s(pos);
      if (tileentity instanceof TileEntityBlockVault) {
         TileEntityBlockVault te = (TileEntityBlockVault)tileentity;
         te.setOwner(placer.func_110124_au().toString());
         if (((Direction)state.func_177229_b(FACING)).equals(Direction.SOUTH)) {
            int xPos = te.func_174877_v().func_177958_n();
            int yPos = te.func_174877_v().func_177956_o();
            int zPos = te.func_174877_v().func_177952_p();
            if (worldIn.func_180495_p(new BlockPos(xPos + 1, yPos, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos + 1, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos + i, yPos + j, zPos));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos + 1, yPos, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.SOUTH));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos + 1, yPos, zPos));
               te2by2.setDirection((byte)0);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos - 1, yPos, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos - 1, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos - i, yPos + j, zPos));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.SOUTH));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos, zPos));
               te2by2.setDirection((byte)0);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos - 1, yPos, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos - 1, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos - i, yPos - j, zPos));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos - 1, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.SOUTH));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos - 1, zPos));
               te2by2.setDirection((byte)0);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos + 1, yPos, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos + 1, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos + i, yPos - j, zPos));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos + 1, yPos - 1, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.SOUTH));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos + 1, yPos - 1, zPos));
               te2by2.setDirection((byte)0);
               te2by2.setString(te.getOwnerS());
            }
         } else if (((Direction)state.func_177229_b(FACING)).equals(Direction.NORTH)) {
            int xPos = te.func_174877_v().func_177958_n();
            int yPos = te.func_174877_v().func_177956_o();
            int zPos = te.func_174877_v().func_177952_p();
            if (worldIn.func_180495_p(new BlockPos(xPos - 1, yPos, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos - 1, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos - i, yPos + j, zPos));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos - 1, yPos, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.NORTH));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos - 1, yPos, zPos));
               te2by2.setDirection((byte)2);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos + 1, yPos, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos + 1, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos + i, yPos + j, zPos));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.NORTH));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos, zPos));
               te2by2.setDirection((byte)2);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos + 1, yPos, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos + 1, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos + i, yPos - j, zPos));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos - 1, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.NORTH));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos - 1, zPos));
               te2by2.setDirection((byte)2);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos - 1, yPos, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos - 1, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos - i, yPos - j, zPos));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos - 1, yPos - 1, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.NORTH));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos - 1, yPos - 1, zPos));
               te2by2.setDirection((byte)2);
               te2by2.setString(te.getOwnerS());
            }
         } else if (((Direction)state.func_177229_b(FACING)).equals(Direction.WEST)) {
            int xPos = te.func_174877_v().func_177958_n();
            int yPos = te.func_174877_v().func_177956_o();
            int zPos = te.func_174877_v().func_177952_p();
            if (worldIn.func_180495_p(new BlockPos(xPos, yPos, zPos + 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos + 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos, yPos + i, zPos + j));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos, zPos + 1), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.WEST));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos, zPos + 1));
               te2by2.setDirection((byte)1);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos, yPos, zPos - 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos - 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos, yPos + i, zPos - j));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.WEST));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos, zPos));
               te2by2.setDirection((byte)1);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos, yPos, zPos - 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos - 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos, yPos - i, zPos - j));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos - 1, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.WEST));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos - 1, zPos));
               te2by2.setDirection((byte)1);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos, yPos, zPos + 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos + 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos, yPos - i, zPos + j));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos - 1, zPos + 1), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.WEST));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos - 1, zPos + 1));
               te2by2.setDirection((byte)1);
               te2by2.setString(te.getOwnerS());
            }
         } else if (((Direction)state.func_177229_b(FACING)).equals(Direction.EAST)) {
            int xPos = te.func_174877_v().func_177958_n();
            int yPos = te.func_174877_v().func_177956_o();
            int zPos = te.func_174877_v().func_177952_p();
            if (worldIn.func_180495_p(new BlockPos(xPos, yPos, zPos - 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos - 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos, yPos + i, zPos - j));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos, zPos - 1), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.EAST));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos, zPos - 1));
               te2by2.setDirection((byte)3);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos, yPos, zPos + 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos + 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos + 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos, yPos + i, zPos + j));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.EAST));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos, zPos));
               te2by2.setDirection((byte)3);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos, yPos, zPos + 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos + 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos, yPos - i, zPos + j));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos - 1, zPos), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.EAST));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos - 1, zPos));
               te2by2.setDirection((byte)3);
               te2by2.setString(te.getOwnerS());
            } else if (worldIn.func_180495_p(new BlockPos(xPos, yPos, zPos - 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos - 1)).func_177230_c() == BlocksRegistry.BLOCK_VAULT && worldIn.func_180495_p(new BlockPos(xPos, yPos - 1, zPos)).func_177230_c() == BlocksRegistry.BLOCK_VAULT) {
               for(int i = 0; i <= 1; ++i) {
                  for(int j = 0; j <= 1; ++j) {
                     this.setBlockToAir(worldIn, new BlockPos(xPos, yPos - i, zPos - j));
                  }
               }

               worldIn.func_175656_a(new BlockPos(xPos, yPos - 1, zPos - 1), (BlockState)BlocksRegistry.BLOCK_VAULT_2BY2.func_176223_P().func_206870_a(FACING, Direction.EAST));
               TileEntityBlockVault2by2 te2by2 = (TileEntityBlockVault2by2)worldIn.func_175625_s(new BlockPos(xPos, yPos - 1, zPos - 1));
               te2by2.setString(te.getOwnerS());
            }
         }
      }

      super.func_180633_a(worldIn, pos, state, placer, stack);
   }

   public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
      if (!worldIn.field_72995_K) {
         TileEntity tileentity = worldIn.func_175625_s(pos);
         if (tileentity instanceof TileEntityBlockVault) {
            TileEntityBlockVault te = (TileEntityBlockVault)tileentity;
            if (te.getOwnerS() != null) {
               String checkONBT = te.getOwnerS();
               String checkOBA = player.func_110124_au().toString();
               if (checkONBT.equals(checkOBA)) {
                  NetworkHooks.openGui((ServerPlayerEntity)player, te, (buf) -> buf.func_179255_a(pos));
                  te.setIsOpen(true);
                  te.func_70296_d();
                  return ActionResultType.SUCCESS;
               }

               if (player.func_211513_k(4)) {
                  NetworkHooks.openGui((ServerPlayerEntity)player, te, (buf) -> buf.func_179255_a(pos));
                  te.setIsOpen(true);
                  te.func_70296_d();
                  return ActionResultType.SUCCESS;
               }
            }
         }
      }

      return ActionResultType.FAIL;
   }

   public void func_196270_a(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
      TileEntity tileentity = worldIn.func_175625_s(pos);
      if (tileentity instanceof TileEntityBlockVault) {
         TileEntityBlockVault te = (TileEntityBlockVault)tileentity;
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

   public void dropBlocks(TileEntity tileentity, World world, BlockPos pos) {
      if (tileentity instanceof TileEntityBlockVault) {
         TileEntityBlockVault te = (TileEntityBlockVault)tileentity;
         IItemHandler inventory = te.getHandler();
         ItemEntity itemBase = new ItemEntity(world, (double)pos.func_177958_n() + (double)0.5F, (double)pos.func_177956_o() + (double)0.5F, (double)pos.func_177952_p() + (double)0.5F, new ItemStack(BlocksRegistry.BLOCK_VAULT));
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

   public boolean func_189539_a(BlockState state, World worldIn, BlockPos pos, int id, int param) {
      TileEntity tileentity = worldIn.func_175625_s(pos);
      return tileentity == null ? false : tileentity.func_145842_c(id, param);
   }

   public void setBlockToAir(World worldIn, BlockPos pos) {
      worldIn.func_175656_a(pos, Blocks.field_150350_a.func_176223_P());
   }

   static {
      FACING = HorizontalBlock.field_185512_D;
      NAME = new TranslationTextComponent("container.vault");
   }
}
