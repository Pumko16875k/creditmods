package fr.fifoube.main.capabilities;

import fr.fifoube.packets.PacketMoneyData;
import fr.fifoube.packets.PacketsRegistery;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.network.PacketDistributor;

@EventBusSubscriber(
   modid = "economyinc",
   bus = Bus.FORGE
)
public class CapabilityMoney {
   public static final ResourceLocation CAP_KEY = new ResourceLocation("economyinc", "money");
   @CapabilityInject(IMoney.class)
   public static final Capability<IMoney> MONEY_CAPABILITY = null;

   public static void register() {
      CapabilityManager.INSTANCE.register(IMoney.class, new DefaultMoneyStorage(), MoneyHolder::new);
   }

   @SubscribeEvent
   public static void attachToPlayer(AttachCapabilitiesEvent<Entity> event) {
      if (event.getObject() instanceof PlayerEntity) {
         IMoney holder;
         if (event.getObject() instanceof ServerPlayerEntity) {
            holder = new PlayerMoneyHolder((ServerPlayerEntity)event.getObject());
         } else {
            holder = (IMoney)MONEY_CAPABILITY.getDefaultInstance();
         }

         PlayerMoneyWrapper wrapper = new PlayerMoneyWrapper(holder);
         event.addCapability(CAP_KEY, wrapper);
      }

   }

   @SubscribeEvent
   public static void onPlayerClone(PlayerEvent.Clone event) {
      PlayerEntity oldPlayer = event.getOriginal();
      oldPlayer.revive();
      PlayerEntity newPlayer = event.getPlayer();
      oldPlayer.getCapability(MONEY_CAPABILITY).ifPresent((oldData) -> newPlayer.getCapability(MONEY_CAPABILITY).ifPresent((data) -> data.setMoney(oldData.getMoney())));
   }

   @SubscribeEvent
   public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
      if (!event.getPlayer().field_70170_p.field_72995_K) {
         event.getPlayer().getCapability(MONEY_CAPABILITY).ifPresent((data) -> data.setMoney(data.getMoney()));
      }

   }

   @SubscribeEvent
   public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
      if (!event.getPlayer().field_70170_p.field_72995_K && event.getPlayer() instanceof ServerPlayerEntity) {
         ServerPlayerEntity player = (ServerPlayerEntity)event.getPlayer();
         event.getPlayer().getCapability(MONEY_CAPABILITY, (Direction)null).ifPresent((data) -> PacketsRegistery.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new PacketMoneyData(data.getMoney())));
      }

   }
}
