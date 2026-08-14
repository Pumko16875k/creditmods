package fr.fifoube.blocks.tileentity;

import com.mojang.datafixers.types.Type;
import fr.fifoube.blocks.BlocksRegistry;
import fr.fifoube.blocks.tileentity.specialrenderer.TileEntityBlockBillsSpecialRenderer;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntityType.Builder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(
   modid = "economyinc",
   bus = Bus.MOD
)
public class TileEntityRegistery {
   @ObjectHolder("economyinc:block_vault_te")
   public static final TileEntityType<TileEntityBlockVault> TILE_BLOCKVAULT = null;
   @ObjectHolder("economyinc:block_vault2by2_te")
   public static final TileEntityType<TileEntityBlockVault2by2> TILE_BLOCKVAULT_2BY2 = null;
   @ObjectHolder("economyinc:block_seller_te")
   public static final TileEntityType<TileEntityBlockSeller> TILE_SELLER = null;
   @ObjectHolder("economyinc:block_changer_te")
   public static final TileEntityType<TileEntityBlockChanger> TILE_CHANGER = null;
   @ObjectHolder("economyinc:block_bills_te")
   public static final TileEntityType<TileEntityBlockBills> TILE_BILLS = null;

   @SubscribeEvent
   public static void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
      event.getRegistry().register(Builder.func_223042_a(TileEntityBlockVault::new, new Block[]{BlocksRegistry.BLOCK_VAULT}).func_206865_a((Type)null).setRegistryName("economyinc:block_vault_te"));
      event.getRegistry().register(Builder.func_223042_a(TileEntityBlockVault2by2::new, new Block[]{BlocksRegistry.BLOCK_VAULT_2BY2}).func_206865_a((Type)null).setRegistryName("economyinc:block_vault2by2_te"));
      event.getRegistry().register(Builder.func_223042_a(TileEntityBlockSeller::new, new Block[]{BlocksRegistry.BLOCK_SELLER}).func_206865_a((Type)null).setRegistryName("economyinc:block_seller_te"));
      event.getRegistry().register(Builder.func_223042_a(TileEntityBlockChanger::new, new Block[]{BlocksRegistry.BLOCK_CHANGER}).func_206865_a((Type)null).setRegistryName("economyinc:block_changer_te"));
      event.getRegistry().register(Builder.func_223042_a(TileEntityBlockBills::new, new Block[]{BlocksRegistry.BLOCK_BILLS}).func_206865_a((Type)null).setRegistryName("economyinc:block_bills_te"));
   }

   @OnlyIn(Dist.CLIENT)
   public static void registerTileRenderer() {
      ClientRegistry.bindTileEntityRenderer(TILE_BILLS, TileEntityBlockBillsSpecialRenderer::new);
   }
}
