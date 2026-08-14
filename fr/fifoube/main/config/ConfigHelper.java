package fr.fifoube.main.config;

import net.minecraftforge.fml.config.ModConfig;

public class ConfigHelper {
   public static void bakeClient(ModConfig config) {
      ConfigFile.canPreviewItemInBlock = (Boolean)ConfigHolder.CLIENT.canPreviewItemInBlock.get();
   }

   public static void bakeServer(ModConfig config) {
      ConfigFile.multiplierGoldNuggetWeight = (Integer)ConfigHolder.SERVER.multiplierGoldNuggetWeight.get();
      ConfigFile.canAccessCardWithoutWT = (Boolean)ConfigHolder.SERVER.canAccessCardWithoutWT.get();
      ConfigFile.goldNuggetRecipe = (Boolean)ConfigHolder.SERVER.goldNuggetRecipe.get();
      ConfigFile.plotBorderBlock = (String)ConfigHolder.SERVER.plotBorderBlock.get();
      ConfigFile.goldChangerDuration = (Integer)ConfigHolder.SERVER.goldChangerDuration.get();
      ConfigFile.cooldownSeller = (Integer)ConfigHolder.SERVER.cooldownSeller.get();
   }
}
