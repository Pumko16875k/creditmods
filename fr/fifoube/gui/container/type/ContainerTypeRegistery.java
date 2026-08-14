package fr.fifoube.gui.container.type;

import fr.fifoube.gui.container.ContainerChanger;
import fr.fifoube.gui.container.ContainerSeller;
import fr.fifoube.gui.container.ContainerVault;
import fr.fifoube.gui.container.ContainerVault2by2;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(
   modid = "economyinc",
   bus = Bus.MOD
)
public class ContainerTypeRegistery {
   @ObjectHolder("economyinc:containerseller")
   public static final ContainerType<ContainerSeller> SELLER_TYPE = null;
   @ObjectHolder("economyinc:containersellerbuy")
   public static final ContainerType<ContainerSeller> SELLERBUY_TYPE = null;
   @ObjectHolder("economyinc:containervault")
   public static final ContainerType<ContainerVault> VAULT_TYPE = null;
   @ObjectHolder("economyinc:containervault2by2")
   public static final ContainerType<ContainerVault2by2> VAULT2BY2_TYPE = null;
   @ObjectHolder("economyinc:containerchanger")
   public static final ContainerType<ContainerChanger> CHANGER_TYPE = null;

   public static void registerContainers(RegistryEvent.Register<ContainerType<?>> event) {
      event.getRegistry().register(IForgeContainerType.create(ContainerSeller::new).setRegistryName("containerseller"));
      event.getRegistry().register(IForgeContainerType.create(ContainerSeller::new).setRegistryName("containersellerbuy"));
      event.getRegistry().register(IForgeContainerType.create(ContainerVault::new).setRegistryName("containervault"));
      event.getRegistry().register(IForgeContainerType.create(ContainerVault2by2::new).setRegistryName("containervault2by2"));
      event.getRegistry().register(IForgeContainerType.create(ContainerChanger::new).setRegistryName("containerchanger"));
   }
}
