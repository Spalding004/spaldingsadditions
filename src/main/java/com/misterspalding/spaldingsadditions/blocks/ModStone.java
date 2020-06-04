package com.misterspalding.spaldingsadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModStone extends Block {

	public ModStone() {
		super(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(1.5F, 6F)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(0)
				);
		
	
		
		
		
	}

}
