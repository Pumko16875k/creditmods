package fr.fifoube.packets;

import fr.fifoube.blocks.tileentity.TileEntityBlockVault2by2;
import java.util.function.Supplier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketVaultSettings {
   private BlockPos pos;
   private String playerToAdd;
   private boolean remove;
   private int id;

   public PacketVaultSettings() {
   }

   public PacketVaultSettings(BlockPos pos, String playerToAddOrRemove, boolean remove, int id) {
      this.pos = pos;
      this.playerToAdd = playerToAddOrRemove;
      this.remove = remove;
      this.id = id;
   }

   public static PacketVaultSettings decode(PacketBuffer buf) {
      BlockPos pos = buf.func_179259_c();
      String playerToAdd = buf.func_150789_c(32767);
      boolean remove = buf.readBoolean();
      int id = buf.readInt();
      return new PacketVaultSettings(pos, playerToAdd, remove, id);
   }

   public static void encode(PacketVaultSettings packet, PacketBuffer buf) {
      buf.func_179255_a(packet.pos);
      buf.func_180714_a(packet.playerToAdd);
      buf.writeBoolean(packet.remove);
      buf.writeInt(packet.id);
   }

   public static void handle(PacketVaultSettings packet, Supplier<NetworkEvent.Context> ctx) {
      ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
         PlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
         TileEntity tile = player.field_70170_p.func_175625_s(packet.pos);
         if (tile instanceof TileEntityBlockVault2by2) {
            TileEntityBlockVault2by2 te = (TileEntityBlockVault2by2)tile;
            if (!packet.remove) {
               te.addAllowedPlayers(packet.playerToAdd);
               te.addToMax();
               te.func_70296_d();
            } else {
               te.getAllowedPlayers().remove(packet.id);
               te.removeToMax();
               te.func_70296_d();
            }
         }

      });
   }
}
