package com.misterspalding.spaldingsadditions.slots;

import com.misterspalding.spaldingsadditions.objects.items.ModFrakHammer;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class FrakhammerSlot extends Slot {

	public FrakhammerSlot(IInventory itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		
	}
	public boolean isItemValid(ItemStack stack) {
	      return stack.getItem() instanceof ModFrakHammer;
	   }
}
