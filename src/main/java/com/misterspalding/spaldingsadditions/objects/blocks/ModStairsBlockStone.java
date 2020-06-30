package com.misterspalding.spaldingsadditions.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

/**
 * @author mclai
 *
 */
public class ModStairsBlockStone extends StairsBlock {

	@SuppressWarnings("deprecation")
	public ModStairsBlockStone(Block block) {
		super(block.getDefaultState(), Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(1F, 1.5F)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(0)
				);
		
	
		
		
		
	}

}
