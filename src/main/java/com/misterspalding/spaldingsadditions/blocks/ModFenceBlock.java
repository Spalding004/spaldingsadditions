package com.misterspalding.spaldingsadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

/**
 * @author mclai
 *
 */
public class ModFenceBlock extends FenceBlock {

	public ModFenceBlock() {
		super(Block.Properties
				.create(Material.WOOD)
				.hardnessAndResistance(1F, 1.5F)
				.harvestTool(ToolType.AXE)
				.harvestLevel(0)
				);
		
	
		
		
		
	}

}
