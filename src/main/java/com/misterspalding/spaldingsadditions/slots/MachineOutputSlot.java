package com.misterspalding.spaldingsadditions.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class MachineOutputSlot extends Slot {

	public MachineOutputSlot(IInventory itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		
	}
	public boolean isItemValid(ItemStack stack) {
	      return false;
	   }
}
