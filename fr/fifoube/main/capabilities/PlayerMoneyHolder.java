package fr.fifoube.main.capabilities;

import fr.fifoube.packets.PacketMoneyData;
import fr.fifoube.packets.PacketsRegistery;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.PacketDistributor;

public class PlayerMoneyHolder extends MoneyHolder {
   private ServerPlayerEntity player;

   public PlayerMoneyHolder(ServerPlayerEntity player) {
      this.player = player;
   }

   public void setMoney(double money) {
      super.setMoney(money);
      if (this.player.field_71135_a != null) {
         this.player.getCapability(CapabilityMoney.MONEY_CAPABILITY).ifPresent((capa) -> PacketsRegistery.CHANNEL.send(PacketDistributor.PLAYER.with(() -> this.player), new PacketMoneyData(capa.getMoney())));
      }

   }
}
