package com.misterspalding.spaldingsadditions.slots;

import com.misterspalding.spaldingsadditions.items.ModDimensionalCard;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotOutput extends Slot {
	public SlotOutput(IInventory handler, int index, int x, int y) {
		super(handler, index, x, y);
	}

	public boolean isItemValid(ItemStack stack) {
		return false;
	}
}