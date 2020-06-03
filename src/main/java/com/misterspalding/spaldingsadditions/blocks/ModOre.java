package com.misterspalding.spaldingsadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModOre extends Block {

	public ModOre(String name, int harvest) {
		super(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(1.5F+harvest, 6F)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(harvest)
				);
		
		this.setRegistryName(name);
		
		
		
	}

}
