package com.misterspalding.spaldingsadditions.objects.items;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModFrakHammer extends Item {

	
	public ModFrakHammer(int damage) {
		super(new Item.Properties()
				.maxDamage(damage)
				.group(ModItemGroup.instance)
			);
		
		
		
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		ItemStack toReturn = stack.copy();
		toReturn.setDamage(stack.getDamage() + 1);
		
		if (toReturn.getDamage() >= getMaxDamage(stack)) {
			return ItemStack.EMPTY;
		}
		
		return toReturn;
	}

	
}
