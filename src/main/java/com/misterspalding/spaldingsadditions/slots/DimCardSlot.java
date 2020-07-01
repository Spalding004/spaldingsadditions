package com.misterspalding.spaldingsadditions.slots;

import com.misterspalding.spaldingsadditions.objects.items.ModDimensionalCard;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class DimCardSlot extends Slot {

	public DimCardSlot(IInventory itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		
	}
	public boolean isItemValid(ItemStack stack) {
	      return stack.getItem() instanceof ModDimensionalCard;
	   }
}
