package com.misterspalding.spaldingsadditions.items.tools;

import com.misterspalding.spaldingsadditions.Main.ModItemGroup;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;

public class ModAxe extends AxeItem {

	public ModAxe(String name, IItemTier tier) {
		super(tier, (int) tier.getAttackDamage(), -2.5F, new Item.Properties().group(ModItemGroup.instance));
		this.setRegistryName(name);
		// TODO Auto-generated constructor stub
	}

	
	
}
