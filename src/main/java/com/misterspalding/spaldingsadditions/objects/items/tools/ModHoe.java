package com.misterspalding.spaldingsadditions.objects.items.tools;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ModHoe extends HoeItem {

	public ModHoe(IItemTier tier) {
		super(tier, -2.5F, new Item.Properties().group(ModItemGroup.instance));
		
		// TODO Auto-generated constructor stub
	}

	
	
}
