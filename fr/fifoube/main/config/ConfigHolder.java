package fr.fifoube.main.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@EventBusSubscriber(
   modid = "economyinc",
   bus = Bus.MOD
)
public class ConfigHolder {
   public static final ForgeConfigSpec CLIENT_SPEC;
   public static final ForgeConfigSpec SERVER_SPEC;
   static final ClientConfig CLIENT;
   static final ServerConfig SERVER;

   @SubscribeEvent
   public static void onModConfigEvent(ModConfig.ModConfigEvent event) {
      ModConfig config = event.getConfig();
      if (config.getSpec() == CLIENT_SPEC) {
         ConfigHelper.bakeClient(config);
      } else if (config.getSpec() == SERVER_SPEC) {
         ConfigHelper.bakeServer(config);
      }

   }

   static {
      Pair<ClientConfig, ForgeConfigSpec> specPair = (new ForgeConfigSpec.Builder()).configure(ClientConfig::new);
      CLIENT = (ClientConfig)specPair.getLeft();
      CLIENT_SPEC = (ForgeConfigSpec)specPair.getRight();
      specPair = (new ForgeConfigSpec.Builder()).configure(ServerConfig::new);
      SERVER = (ServerConfig)specPair.getLeft();
      SERVER_SPEC = (ForgeConfigSpec)specPair.getRight();
   }
}
