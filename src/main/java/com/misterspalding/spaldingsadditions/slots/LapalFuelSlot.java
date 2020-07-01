package com.misterspalding.spaldingsadditions.slots;

import com.misterspalding.spaldingsadditions.fuels.LapalFuels;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class LapalFuelSlot extends Slot {

	public LapalFuelSlot(IInventory itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		
	}
	public boolean isItemValid(ItemStack stack) {
	      return LapalFuels.getFuelStr(stack) > 0.0D;
	   }
}
