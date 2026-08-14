package fr.fifoube.packets;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.NetworkRegistry.ChannelBuilder;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketsRegistery {
   public static final String PROTOCOL_VERSION = String.valueOf(1);
   public static final SimpleChannel CHANNEL;

   public static void registerNetworkPackets() {
      CHANNEL.messageBuilder(PacketListNBT.class, 1).encoder(PacketListNBT::encode).decoder(PacketListNBT::decode).consumer(PacketListNBT::handle).add();
      CHANNEL.messageBuilder(PacketMoneyData.class, 2).encoder(PacketMoneyData::encode).decoder(PacketMoneyData::decode).consumer(PacketMoneyData::handle).add();
      CHANNEL.messageBuilder(PacketSellerCreated.class, 3).encoder(PacketSellerCreated::encode).decoder(PacketSellerCreated::decode).consumer(PacketSellerCreated::handle).add();
      CHANNEL.messageBuilder(PacketSellerFundsTotal.class, 4).encoder(PacketSellerFundsTotal::encode).decoder(PacketSellerFundsTotal::decode).consumer(PacketSellerFundsTotal::handle).add();
      CHANNEL.messageBuilder(PacketCardChange.class, 5).encoder(PacketCardChange::encode).decoder(PacketCardChange::decode).consumer(PacketCardChange::handle).add();
      CHANNEL.messageBuilder(PacketChangerUpdate.class, 6).encoder(PacketChangerUpdate::encode).decoder(PacketChangerUpdate::decode).consumer(PacketChangerUpdate::handle).add();
      CHANNEL.messageBuilder(PacketVaultSettings.class, 7).encoder(PacketVaultSettings::encode).decoder(PacketVaultSettings::decode).consumer(PacketVaultSettings::handle).add();
   }

   static {
      NetworkRegistry.ChannelBuilder var10000 = ChannelBuilder.named(new ResourceLocation("economyinc", "packets_ei")).networkProtocolVersion(() -> PROTOCOL_VERSION);
      String var10001 = PROTOCOL_VERSION;
      var10001.getClass();
      var10000 = var10000.clientAcceptedVersions(var10001::equals);
      var10001 = PROTOCOL_VERSION;
      var10001.getClass();
      CHANNEL = var10000.serverAcceptedVersions(var10001::equals).simpleChannel();
   }
}
