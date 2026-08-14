package fr.fifoube.main.capabilities;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerMoneyWrapper implements ICapabilitySerializable<INBT> {
   private IMoney holder;
   private final LazyOptional<IMoney> lazyOptional = LazyOptional.of(() -> this.holder);

   public PlayerMoneyWrapper(IMoney money) {
      this.holder = money;
   }

   public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
      return CapabilityMoney.MONEY_CAPABILITY.orEmpty(cap, this.lazyOptional);
   }

   public INBT serializeNBT() {
      return CapabilityMoney.MONEY_CAPABILITY.writeNBT(this.holder, (Direction)null);
   }

   public void deserializeNBT(INBT nbt) {
      CapabilityMoney.MONEY_CAPABILITY.readNBT(this.holder, (Direction)null, nbt);
   }
}
