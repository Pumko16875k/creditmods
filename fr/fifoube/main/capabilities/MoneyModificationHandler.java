package fr.fifoube.main.capabilities;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(
   modid = "economyinc"
)
public class MoneyModificationHandler {
   @SubscribeEvent
   public static void onDimensionTravel(PlayerEvent.PlayerChangedDimensionEvent event) {
      if (!event.getPlayer().field_70170_p.field_72995_K) {
         event.getPlayer().getCapability(CapabilityMoney.MONEY_CAPABILITY).ifPresent((data) -> data.setMoney(data.getMoney()));
      }

   }
}
