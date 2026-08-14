package fr.fifoube.gui;

import fr.fifoube.gui.container.type.ContainerTypeRegistery;
import net.minecraft.client.gui.ScreenManager;

public class GuiRegistery {
   public static void register() {
      ScreenManager.func_216911_a(ContainerTypeRegistery.SELLER_TYPE, GuiSeller::new);
      ScreenManager.func_216911_a(ContainerTypeRegistery.VAULT_TYPE, GuiVault::new);
      ScreenManager.func_216911_a(ContainerTypeRegistery.VAULT2BY2_TYPE, GuiVault2by2::new);
      ScreenManager.func_216911_a(ContainerTypeRegistery.CHANGER_TYPE, GuiChanger::new);
   }
}
