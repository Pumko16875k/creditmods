package fr.fifoube.main.events.server;

import fr.fifoube.world.saveddata.ChunksWorldSavedData;
import fr.fifoube.world.saveddata.PlotsChunkData;
import fr.fifoube.world.saveddata.PlotsData;
import fr.fifoube.world.saveddata.PlotsWorldSavedData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   modid = "economyinc",
   bus = Bus.MOD
)
public class ServerEvents {
   @SubscribeEvent
   public void onPlacedBlock(BlockEvent.EntityPlaceEvent event) {
      ServerPlayerEntity player = null;
      if (event.getEntity() instanceof ServerPlayerEntity) {
         player = (ServerPlayerEntity)event.getEntity();
      }

      if (player != null) {
         ServerWorld worldIn = player.func_71121_q();
         List<ChunkPos> listPos = new ArrayList();
         DimensionSavedDataManager storage = worldIn.func_217481_x();
         ChunksWorldSavedData data = (ChunksWorldSavedData)storage.func_215753_b(ChunksWorldSavedData::new, "economyinc_PlotsChunkData");
         if (data != null) {
            List<PlotsChunkData> listC = data.getListContainer();

            for(int i = 0; i < listC.size(); ++i) {
               PlotsChunkData plotsChunkData = (PlotsChunkData)listC.get(i);

               for(int j = 0; j < plotsChunkData.getList().size(); ++j) {
                  String s = (String)plotsChunkData.getList().get(j);
                  int xPos = Integer.valueOf(s.substring(s.indexOf("[") + 1, s.indexOf(",")));
                  int zPos = Integer.valueOf(s.substring(s.indexOf(",") + 2, s.indexOf("]")));
                  listPos.add(new ChunkPos(xPos, zPos));
               }
            }
         }

         for(ChunkPos pos : listPos) {
            if ((new ChunkPos(event.getPos())).equals(pos)) {
               Vector3d vec = new Vector3d((double)event.getPos().func_177958_n(), (double)event.getPos().func_177956_o(), (double)event.getPos().func_177952_p());
               List<AxisAlignedBB> listAABB = new ArrayList();
               PlotsWorldSavedData plotsDataWSD = (PlotsWorldSavedData)storage.func_215753_b(PlotsWorldSavedData::new, "economyinc_PlotsData");
               UUID uuidOwner = null;
               if (plotsDataWSD != null) {
                  List<PlotsData> listC = plotsDataWSD.getListContainer();

                  for(int i = 0; i < listC.size(); ++i) {
                     PlotsData plotsData = (PlotsData)plotsDataWSD.getListContainer().get(i);

                     for(int j = 0; j < plotsData.getList().size(); ++j) {
                        uuidOwner = UUID.fromString((String)plotsData.getList().get(1));
                        int xPosFirst = Integer.valueOf((String)plotsData.getList().get(2));
                        int zPosFirst = Integer.valueOf((String)plotsData.getList().get(3));
                        int xPosSecond = Integer.valueOf((String)plotsData.getList().get(4));
                        int zPosSecond = Integer.valueOf((String)plotsData.getList().get(5));
                        listAABB.add((new AxisAlignedBB((double)xPosFirst, (double)0.0F, (double)zPosFirst, (double)xPosSecond, (double)255.0F, (double)zPosSecond)).func_72314_b((double)2.0F, (double)1.0F, (double)2.0F));
                     }
                  }
               }

               for(AxisAlignedBB checker : listAABB) {
                  if (checker.func_72318_a(vec) && uuidOwner != null && !player.func_110124_au().equals(uuidOwner)) {
                     if (player.func_211513_k(4)) {
                        event.setCanceled(false);
                     } else {
                        event.setCanceled(true);
                     }
                  }
               }
            }
         }
      }

   }

   @SubscribeEvent
   public void onBreakBlock(BlockEvent.BreakEvent event) {
      ServerPlayerEntity player = null;
      if (event.getPlayer() instanceof ServerPlayerEntity) {
         player = (ServerPlayerEntity)event.getPlayer();
      }

      if (player != null) {
         ServerWorld worldIn = player.func_71121_q();
         List<ChunkPos> listPos = new ArrayList();
         DimensionSavedDataManager storage = worldIn.func_217481_x();
         ChunksWorldSavedData data = (ChunksWorldSavedData)storage.func_215753_b(ChunksWorldSavedData::new, "economyinc_PlotsChunkData");
         if (data != null) {
            List<PlotsChunkData> listC = data.getListContainer();

            for(int i = 0; i < listC.size(); ++i) {
               PlotsChunkData plotsChunkData = (PlotsChunkData)listC.get(i);

               for(int j = 0; j < plotsChunkData.getList().size(); ++j) {
                  String s = (String)plotsChunkData.getList().get(j);
                  int xPos = Integer.valueOf(s.substring(s.indexOf("[") + 1, s.indexOf(",")));
                  int zPos = Integer.valueOf(s.substring(s.indexOf(",") + 2, s.indexOf("]")));
                  listPos.add(new ChunkPos(xPos, zPos));
               }
            }
         }

         for(ChunkPos pos : listPos) {
            if ((new ChunkPos(event.getPos())).equals(pos)) {
               Vector3d vec = new Vector3d((double)event.getPos().func_177958_n(), (double)event.getPos().func_177956_o(), (double)event.getPos().func_177952_p());
               List<AxisAlignedBB> listAABB = new ArrayList();
               PlotsWorldSavedData plotsDataWSD = (PlotsWorldSavedData)storage.func_215753_b(PlotsWorldSavedData::new, "economyinc_PlotsData");
               UUID uuidOwner = null;
               if (plotsDataWSD != null) {
                  List<PlotsData> listC = plotsDataWSD.getListContainer();

                  for(int i = 0; i < listC.size(); ++i) {
                     PlotsData plotsData = (PlotsData)plotsDataWSD.getListContainer().get(i);

                     for(int j = 0; j < plotsData.getList().size(); ++j) {
                        uuidOwner = UUID.fromString((String)plotsData.getList().get(1));
                        int xPosFirst = Integer.valueOf((String)plotsData.getList().get(2));
                        int zPosFirst = Integer.valueOf((String)plotsData.getList().get(3));
                        int xPosSecond = Integer.valueOf((String)plotsData.getList().get(4));
                        int zPosSecond = Integer.valueOf((String)plotsData.getList().get(5));
                        listAABB.add((new AxisAlignedBB((double)xPosFirst, (double)0.0F, (double)zPosFirst, (double)xPosSecond, (double)255.0F, (double)zPosSecond)).func_72314_b((double)2.0F, (double)1.0F, (double)2.0F));
                     }
                  }
               }

               for(AxisAlignedBB checker : listAABB) {
                  if (checker.func_72318_a(vec) && uuidOwner != null && !event.getPlayer().func_110124_au().equals(uuidOwner)) {
                     if (player.func_211513_k(4)) {
                        event.setCanceled(false);
                     } else {
                        event.setCanceled(true);
                     }
                  }
               }
            }
         }
      }

   }
}
