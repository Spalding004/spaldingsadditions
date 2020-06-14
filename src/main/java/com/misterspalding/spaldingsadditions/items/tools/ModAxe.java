package com.misterspalding.spaldingsadditions.items.tools;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ModAxe extends AxeItem {

	public ModAxe(IItemTier tier) {
		super(tier, (int) tier.getAttackDamage(), -2.5F, new Item.Properties().group(ModItemGroup.instance));
		
		// TODO Auto-generated constructor stub
	}

	
	
}
