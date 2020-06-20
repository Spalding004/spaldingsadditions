package com.misterspalding.spaldingsadditions.slots;

import com.misterspalding.spaldingsadditions.items.ModDimensionalCard;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotDimCard extends SlotItemHandler {
	public SlotDimCard(IItemHandler handler, int index, int x, int y) {
		super(handler, index, x, y);
	}

	public boolean fisItemValid(ItemStack stack) {
		return stack.getItem() instanceof ModDimensionalCard;
	}
}