package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main.ModItemGroup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ModItemBlock extends BlockItem {

	public ModItemBlock(Block blockIn) {
		super(blockIn, new Item.Properties().group(ModItemGroup.instance));
		this.setRegistryName(blockIn.getRegistryName());
		
	}
	
	

}
