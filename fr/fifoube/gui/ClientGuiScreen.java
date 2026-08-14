package fr.fifoube.gui;

import fr.fifoube.blocks.tileentity.TileEntityBlockSeller;
import fr.fifoube.blocks.tileentity.TileEntityBlockVault2by2;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class ClientGuiScreen {
   public static void openGui(int id, TileEntity te) {
      switch (id) {
         case 0:
            Minecraft.func_71410_x().func_147108_a(new GuiCreditCard());
            break;
         case 1:
            Minecraft.func_71410_x().func_147108_a(new GuiSellerBuy((TileEntityBlockSeller)te));
            break;
         case 2:
            Minecraft.func_71410_x().func_147108_a(new GuiVaultSettings2by2((TileEntityBlockVault2by2)te));
      }

   }
}
