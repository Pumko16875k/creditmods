package fr.fifoube.packets;

import fr.fifoube.blocks.tileentity.TileEntityBlockSeller;
import java.util.function.Supplier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketSellerCreated {
   private boolean created;
   private double cost;
   private int x;
   private int y;
   private int z;
   private String name = "";
   private int amount = 0;
   private boolean admin;

   public PacketSellerCreated() {
   }

   public PacketSellerCreated(boolean createdS, double costS, String nameS, int amountS, int xS, int yS, int zS, boolean adminS) {
      this.created = createdS;
      this.cost = costS;
      this.name = nameS;
      this.amount = amountS;
      this.x = xS;
      this.y = yS;
      this.z = zS;
      this.admin = adminS;
   }

   public static PacketSellerCreated decode(PacketBuffer buf) {
      boolean created = buf.readBoolean();
      double cost = buf.readDouble();
      String name = buf.func_150789_c(32767);
      int amount = buf.readInt();
      int x = buf.readInt();
      int y = buf.readInt();
      int z = buf.readInt();
      boolean admin = buf.readBoolean();
      return new PacketSellerCreated(created, cost, name, amount, x, y, z, admin);
   }

   public static void encode(PacketSellerCreated packet, PacketBuffer buf) {
      buf.writeBoolean(packet.created);
      buf.writeDouble(packet.cost);
      buf.func_180714_a(packet.name);
      buf.writeInt(packet.amount);
      buf.writeInt(packet.x);
      buf.writeInt(packet.y);
      buf.writeInt(packet.z);
      buf.writeBoolean(packet.admin);
   }

   public static void handle(PacketSellerCreated packet, Supplier<NetworkEvent.Context> ctx) {
      ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
         PlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
         World world = player.field_70170_p;
         BlockPos pos = new BlockPos(packet.x, packet.y, packet.z);
         TileEntityBlockSeller te = (TileEntityBlockSeller)world.func_175625_s(pos);
         if (te != null) {
            te.setCreated(packet.created);
            te.setCost(packet.cost);
            te.setItem(packet.name);
            te.setAdmin(packet.admin);
            te.func_70296_d();
         }

      });
      ((NetworkEvent.Context)ctx.get()).setPacketHandled(true);
   }
}
