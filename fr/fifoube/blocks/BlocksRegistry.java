package fr.fifoube.blocks;

import fr.fifoube.main.ModEconomyInc;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(
   modid = "economyinc",
   bus = Bus.MOD
)
public class BlocksRegistry {
   @ObjectHolder("economyinc:block_vault")
   public static final Block BLOCK_VAULT = null;
   @ObjectHolder("economyinc:block_vault2by2")
   public static final Block BLOCK_VAULT_2BY2 = null;
   @ObjectHolder("economyinc:block_atm")
   public static final Block BLOCK_ATM = null;
   @ObjectHolder("economyinc:block_changer")
   public static final Block BLOCK_CHANGER = null;
   @ObjectHolder("economyinc:block_seller")
   public static final Block BLOCK_SELLER = null;
   @ObjectHolder("economyinc:block_bills")
   public static final Block BLOCK_BILLS = null;

   @SubscribeEvent
   public static void registerBlocks(RegistryEvent.Register<Block> event) {
      event.getRegistry().register((new BlockVault(Properties.func_200945_a(Material.field_151573_f).func_200948_a(-1.0F, 3600000.0F))).setRegistryName("block_vault"));
      event.getRegistry().register((new BlockVault2by2(Properties.func_200945_a(Material.field_151573_f).func_200948_a(-1.0F, 3600000.0F))).setRegistryName("block_vault2by2"));
      event.getRegistry().register((new BlockATM(Properties.func_200945_a(Material.field_151573_f).func_200948_a(-1.0F, 3600000.0F))).setRegistryName("block_atm"));
      event.getRegistry().register((new BlockChanger(Properties.func_200945_a(Material.field_151573_f).func_200948_a(-1.0F, 3600000.0F))).setRegistryName("block_changer"));
      event.getRegistry().register((new BlockSeller(Properties.func_200945_a(Material.field_151575_d).func_200948_a(-1.0F, 3600000.0F))).setRegistryName("block_seller"));
      event.getRegistry().register((new BlockBills(Properties.func_200945_a(Material.field_151573_f))).setRegistryName("block_bills"));
   }

   @SubscribeEvent
   public static void registerItemsBlocks(RegistryEvent.Register<Item> event) {
      event.getRegistry().register((new BlockItem(BLOCK_VAULT, (new Item.Properties()).func_200916_a(ModEconomyInc.EIC))).setRegistryName(BLOCK_VAULT.getRegistryName()));
      event.getRegistry().register((new BlockItem(BLOCK_VAULT_2BY2, new Item.Properties())).setRegistryName(BLOCK_VAULT_2BY2.getRegistryName()));
      event.getRegistry().register((new BlockItem(BLOCK_ATM, (new Item.Properties()).func_200916_a(ModEconomyInc.EIC))).setRegistryName(BLOCK_ATM.getRegistryName()));
      event.getRegistry().register((new BlockItem(BLOCK_CHANGER, (new Item.Properties()).func_200916_a(ModEconomyInc.EIC))).setRegistryName(BLOCK_CHANGER.getRegistryName()));
      event.getRegistry().register((new BlockItem(BLOCK_SELLER, (new Item.Properties()).func_200916_a(ModEconomyInc.EIC))).setRegistryName(BLOCK_SELLER.getRegistryName()));
      event.getRegistry().register((new BlockItem(BLOCK_BILLS, (new Item.Properties()).func_200916_a(ModEconomyInc.EIC))).setRegistryName(BLOCK_BILLS.getRegistryName()));
   }
}
