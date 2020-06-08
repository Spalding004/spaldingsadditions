package com.misterspalding.spaldingsadditions.blocks;

import com.misterspalding.spaldingsadditions.inits.FlammablesDec;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.Material;

public class ModLogs extends LogBlock {

	public ModLogs() {
		super(Material.WOOD.getColor(), Block.Properties.from(Blocks.OAK_LOG)	
				
				);
			
		FlammablesDec.registerFlammable(this.getBlock(), 5, 5);
		
	}
	
	
	
	
}
