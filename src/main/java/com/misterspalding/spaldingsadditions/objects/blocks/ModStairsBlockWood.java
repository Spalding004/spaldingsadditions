package com.misterspalding.spaldingsadditions.objects.blocks;

import com.misterspalding.spaldingsadditions.inits.FlammablesDec;

import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

/**
 * @author mclai
 *
 */
public class ModStairsBlockWood extends StairsBlock {

	@SuppressWarnings("deprecation")
	public ModStairsBlockWood(Block block) {
		super(block.getDefaultState(), Block.Properties
				.create(Material.WOOD)
				.hardnessAndResistance(1F, 1.5F)
				.harvestTool(ToolType.AXE)
				.harvestLevel(0)
				);
		
	
		FlammablesDec.registerFlammable(this.getBlock(), 5, 20);
		
		
	}

}
