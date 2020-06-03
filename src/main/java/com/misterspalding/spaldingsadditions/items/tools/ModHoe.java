package com.misterspalding.spaldingsadditions.items.tools;

import com.misterspalding.spaldingsadditions.Main.ModItemGroup;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ModHoe extends HoeItem {

	public ModHoe(String name, IItemTier tier) {
		super(tier, -2.5F, new Item.Properties().group(ModItemGroup.instance));
		this.setRegistryName(name);
		// TODO Auto-generated constructor stub
	}

	
	
}
