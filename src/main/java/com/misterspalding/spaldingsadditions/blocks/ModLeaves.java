package com.misterspalding.spaldingsadditions.blocks;

import com.misterspalding.spaldingsadditions.inits.FlammablesDec;

import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Tags.Items;

public class ModLeaves extends LeavesBlock {

	public ModLeaves() {
		super(Block.Properties
				.create(Material.LEAVES)
				.hardnessAndResistance(0.2F)
				.tickRandomly()
				.sound(SoundType.PLANT)
				.notSolid()
				
				);
		
		FlammablesDec.registerFlammable(this.getBlock(), 30, 60);
		 this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
		
	}

}
