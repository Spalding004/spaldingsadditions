package com.misterspalding.spaldingsadditions.items.tools;

import com.misterspalding.spaldingsadditions.Main.ModItemGroup;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class ModSword extends SwordItem {

	public ModSword(String name, IItemTier tier) {
		super(tier, (int) tier.getAttackDamage(), -2.5F, new Item.Properties().group(ModItemGroup.instance));
		this.setRegistryName(name);
		// TODO Auto-generated constructor stub
	}

	
	
}
