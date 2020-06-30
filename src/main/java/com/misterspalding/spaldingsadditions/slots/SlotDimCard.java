package com.misterspalding.spaldingsadditions.slots;

import com.misterspalding.spaldingsadditions.objects.items.ModDimensionalCard;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotDimCard extends Slot {
	public SlotDimCard(IInventory handler, int index, int x, int y) {
		super(handler, index, x, y);
	}

	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() instanceof ModDimensionalCard;
	}
}