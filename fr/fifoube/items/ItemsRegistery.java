package fr.fifoube.items;

import fr.fifoube.main.ModEconomyInc;
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
public class ItemsRegistery {
   @ObjectHolder("economyinc:item_remover")
   public static final Item ITEM_REMOVER = null;
   @ObjectHolder("economyinc:item_creditcard")
   public static final Item ITEM_CREDITCARD = null;
   @ObjectHolder("economyinc:item_wireless")
   public static final Item ITEM_WIRELESS = null;
   @ObjectHolder("economyinc:item_oneb")
   public static final Item ITEM_ONEB = null;
   @ObjectHolder("economyinc:item_fiveb")
   public static final Item ITEM_FIVEB = null;
   @ObjectHolder("economyinc:item_tenb")
   public static final Item ITEM_TENB = null;
   @ObjectHolder("economyinc:item_twentyb")
   public static final Item ITEM_TWENTYB = null;
   @ObjectHolder("economyinc:item_fiftybe")
   public static final Item ITEM_FIFTYB = null;
   @ObjectHolder("economyinc:item_hundreedb")
   public static final Item ITEM_HUNDREEDB = null;
   @ObjectHolder("economyinc:item_twohundreedb")
   public static final Item ITEM_TWOHUNDREEDB = null;
   @ObjectHolder("economyinc:item_fivehundreedb")
   public static final Item ITEM_FIVEHUNDREEDB = null;
   @ObjectHolder("economyinc:item_packetone")
   public static final Item ITEM_PACKETONEB = null;
   @ObjectHolder("economyinc:item_packetfive")
   public static final Item ITEM_PACKETFIVEB = null;
   @ObjectHolder("economyinc:item_packetten")
   public static final Item ITEM_PACKETTENB = null;
   @ObjectHolder("economyinc:item_packettwenty")
   public static final Item ITEM_PACKETTWENTYB = null;
   @ObjectHolder("economyinc:item_packetfifty")
   public static final Item ITEM_PACKETFIFTYB = null;
   @ObjectHolder("economyinc:item_packethundreed")
   public static final Item ITEM_PACKETHUNDREEDB = null;
   @ObjectHolder("economyinc:item_packettwohundreed")
   public static final Item ITEM_PACKETTWOHUNDREEDB = null;
   @ObjectHolder("economyinc:item_packetfivehundreed")
   public static final Item ITEM_PACKETFIVEHUNDREEDB = null;
   @ObjectHolder("economyinc:item_gear")
   public static final Item ITEM_GEAR = null;
   @ObjectHolder("economyinc:item_gearmechanism")
   public static final Item ITEM_GEARSMECHANISM = null;
   @ObjectHolder("economyinc:item_goldnuggetsubs")
   public static final Item ITEM_GOLDNUGGET = null;

   @SubscribeEvent
   public static void registerItems(RegistryEvent.Register<Item> event) {
      event.getRegistry().register((new ItemRemover((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(1))).setRegistryName("item_remover"));
      event.getRegistry().register((new ItemCreditCard((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(1))).setRegistryName("item_creditcard"));
      event.getRegistry().register((new ItemWireless((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(1))).setRegistryName("item_wireless"));
      event.getRegistry().register((new ItemOneB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_oneb"));
      event.getRegistry().register((new ItemFiveB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_fiveb"));
      event.getRegistry().register((new ItemTenB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_tenb"));
      event.getRegistry().register((new ItemTwentyB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_twentyb"));
      event.getRegistry().register((new ItemFiftyB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_fiftybe"));
      event.getRegistry().register((new ItemHundreedB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_hundreedb"));
      event.getRegistry().register((new ItemTwoHundreedB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_twohundreedb"));
      event.getRegistry().register((new ItemFiveHundreedB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_fivehundreedb"));
      event.getRegistry().register((new ItemPacketOneB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_packetone"));
      event.getRegistry().register((new ItemPacketFiveB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_packetfive"));
      event.getRegistry().register((new ItemPacketTenB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_packetten"));
      event.getRegistry().register((new ItemPacketTwentyB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_packettwenty"));
      event.getRegistry().register((new ItemPacketFiftyB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_packetfifty"));
      event.getRegistry().register((new ItemPacketHundreedB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_packethundreed"));
      event.getRegistry().register((new ItemPacketTwoHundreedB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_packettwohundreed"));
      event.getRegistry().register((new ItemPacketFiveHundreedB((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_packetfivehundreed"));
      event.getRegistry().register((new ItemGear((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_gear"));
      event.getRegistry().register((new ItemGearMechanism((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(64))).setRegistryName("item_gearmechanism"));
      event.getRegistry().register((new ItemGoldNuggetSubs((new Item.Properties()).func_200916_a(ModEconomyInc.EIC).func_200917_a(1))).setRegistryName("item_goldnuggetsubs"));
   }
}
