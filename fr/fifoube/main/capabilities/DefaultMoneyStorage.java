package fr.fifoube.main.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class DefaultMoneyStorage implements Capability.IStorage<IMoney> {
   public INBT writeNBT(Capability<IMoney> capability, IMoney instance, Direction side) {
      CompoundNBT nbt = new CompoundNBT();
      nbt.func_74780_a("money", instance.getMoney());
      return nbt;
   }

   public void readNBT(Capability<IMoney> capability, IMoney instance, Direction side, INBT nbt) {
      CompoundNBT tag = (CompoundNBT)nbt;
      instance.setMoney(tag.func_74769_h("money"));
   }
}
