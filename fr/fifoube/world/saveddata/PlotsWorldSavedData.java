package fr.fifoube.world.saveddata;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.world.storage.WorldSavedData;

public class PlotsWorldSavedData extends WorldSavedData {
   public static final String DATA_NAME = "economyinc_PlotsData";
   List<PlotsData> listContainer = new ArrayList();

   public PlotsWorldSavedData() {
      super("economyinc_PlotsData");
   }

   public PlotsWorldSavedData(String name) {
      super(name);
   }

   public void func_76184_a(CompoundNBT nbt) {
      ListNBT tagListContainer = nbt.func_150295_c("listContainer", 9);
      String name = "";
      String owner = "";
      int xPosFirst = 0;
      int zPosFirst = 0;
      int xPosSecond = 0;
      int zPosSecond = 0;
      int yPos = 0;
      float price = 0.0F;
      boolean bought = false;

      for(int i = 0; i < tagListContainer.size(); ++i) {
         ListNBT tagList = (ListNBT)tagListContainer.get(i);
         name = tagList.func_150307_f(0);
         owner = tagList.func_150307_f(1);
         xPosFirst = Integer.valueOf(tagList.func_150307_f(2));
         zPosFirst = Integer.valueOf(tagList.func_150307_f(3));
         xPosSecond = Integer.valueOf(tagList.func_150307_f(4));
         zPosSecond = Integer.valueOf(tagList.func_150307_f(5));
         yPos = Integer.valueOf(tagList.func_150307_f(6));
         price = Float.valueOf(tagList.func_150307_f(7));
         bought = Boolean.getBoolean(tagList.func_150307_f(8));
         PlotsData plotsData = new PlotsData(name, owner, xPosFirst, zPosFirst, xPosSecond, zPosSecond, yPos, (double)price, bought);
         this.listContainer.add(plotsData);
      }

   }

   public CompoundNBT func_189551_b(CompoundNBT compound) {
      ListNBT tagListContainer = new ListNBT();

      for(int i = 0; i < this.listContainer.size(); ++i) {
         ListNBT tagList = new ListNBT();

         for(int j = 0; j < ((PlotsData)this.listContainer.get(i)).getList().size(); ++j) {
            String s = (String)((PlotsData)this.listContainer.get(i)).getList().get(j);
            if (s != null) {
               tagList.add(StringNBT.func_229705_a_(s));
            }
         }

         tagListContainer.add(tagList);
      }

      compound.func_218657_a("listContainer", tagListContainer);
      return compound;
   }

   public List<PlotsData> getListContainer() {
      return this.listContainer;
   }
}
