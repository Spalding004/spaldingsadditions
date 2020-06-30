package com.misterspalding.spaldingsadditions.objects.items;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;

import net.minecraft.item.Item;

public class ModDimensionalCard extends Item {

	public ModDimensionalCard(int i) {
		super(new Item.Properties().group(ModItemGroup.instance)
				.maxStackSize(1)
				.maxDamage(i));
	
		
	}
	
}
