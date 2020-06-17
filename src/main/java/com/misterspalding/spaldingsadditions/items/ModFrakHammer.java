package com.misterspalding.spaldingsadditions.items;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModFrakHammer extends Item {

	public ModFrakHammer() {
		super(new Item.Properties().group(ModItemGroup.instance));
		this.hasContainerItem(new ItemStack(this));
	}
	
}
