package com.misterspalding.spaldingsadditions.objects.items;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;

import net.minecraft.item.Item;

public class ModGenericItem extends Item {

	public ModGenericItem() {
		super(new Item.Properties().group(ModItemGroup.instance));
		
	}
	
}
