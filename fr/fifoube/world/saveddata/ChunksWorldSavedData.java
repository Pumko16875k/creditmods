package fr.fifoube.world.saveddata;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.storage.WorldSavedData;

public class ChunksWorldSavedData extends WorldSavedData {
   public static final String DATA_NAME = "economyinc_PlotsChunkData";
   List<PlotsChunkData> listContainer = new ArrayList();

   public ChunksWorldSavedData() {
      super("economyinc_PlotsChunkData");
   }

   public ChunksWorldSavedData(String name) {
      super(name);
   }

   public void func_76184_a(CompoundNBT nbt) {
      ListNBT tagListContainer = nbt.func_150295_c("listContainer", 9);
      List<ChunkPos> listChunk = new ArrayList();

      for(int i = 0; i < tagListContainer.size(); ++i) {
         ListNBT tagList = (ListNBT)tagListContainer.get(i);

         for(int j = 0; j < tagList.size(); ++j) {
            String pos = tagList.func_150307_f(j);
            int xPos = Integer.valueOf(pos.substring(pos.indexOf("[") + 1, pos.indexOf(",")));
            int zPos = Integer.valueOf(pos.substring(pos.indexOf(",") + 2, pos.indexOf("]")));
            ChunkPos chunkPos = new ChunkPos(xPos, zPos);
            listChunk.add(chunkPos);
         }

         PlotsChunkData plotsData = new PlotsChunkData(listChunk);
         this.listContainer.add(plotsData);
      }

   }

   public CompoundNBT func_189551_b(CompoundNBT compound) {
      ListNBT tagListContainer = new ListNBT();

      for(int i = 0; i < this.listContainer.size(); ++i) {
         ListNBT tagList = new ListNBT();

         for(int j = 0; j < ((PlotsChunkData)this.listContainer.get(i)).getList().size(); ++j) {
            String s = (String)((PlotsChunkData)this.listContainer.get(i)).getList().get(j);
            if (s != null) {
               tagList.add(StringNBT.func_229705_a_(s));
            }
         }

         tagListContainer.add(tagList);
      }

      compound.func_218657_a("listContainer", tagListContainer);
      return compound;
   }

   public List<PlotsChunkData> getListContainer() {
      return this.listContainer;
   }
}
