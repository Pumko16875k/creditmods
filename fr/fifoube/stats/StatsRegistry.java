package fr.fifoube.stats;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.stats.StatType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(
   modid = "economyinc",
   bus = Bus.MOD
)
public class StatsRegistry {
   public static ResourceLocation CHANGED_GOLD_TO_MONEY;

   @SubscribeEvent
   public static void registerAll(RegistryEvent.Register<StatType<?>> event) {
      if (event.getName().equals(ForgeRegistries.STAT_TYPES.getRegistryName())) {
         CHANGED_GOLD_TO_MONEY = register("changed_gold_money", IStatFormatter.field_223218_b_);
      }

   }

   private static ResourceLocation register(String name, IStatFormatter formatter) {
      ResourceLocation id = new ResourceLocation("economyinc", name);
      Registry.func_218325_a(Registry.field_212623_l, name, id);
      Stats.field_199092_j.func_199077_a(id, formatter);
      return id;
   }
}
