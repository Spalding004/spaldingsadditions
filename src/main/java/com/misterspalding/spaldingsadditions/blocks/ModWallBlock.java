package com.misterspalding.spaldingsadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

/**
 * @author mclai
 *
 */
public class ModWallBlock extends WallBlock {

	public ModWallBlock() {
		super(Block.Properties
				.create(Material.ROCK)
				
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(0)
				);
		
	
		
		
		
	}

}
