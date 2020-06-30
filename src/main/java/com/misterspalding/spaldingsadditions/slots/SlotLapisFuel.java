package com.misterspalding.spaldingsadditions.slots;

import com.misterspalding.spaldingsadditions.fuels.LapalFuels;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotLapisFuel extends Slot {
	   public SlotLapisFuel(IInventory handler, int index, int x, int y) {
	      super(handler, index, x, y);
	   }

	   public boolean isItemValid(ItemStack stack) {
	      return LapalFuels.getFuelStr(stack) > 0.0D;
	   }
	}
