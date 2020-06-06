package com.misterspalding.spaldingsadditions.blocks;

import java.util.Random;

import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.utils.ModHelpers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

public class ModEndfectedOre extends Block {

	
	public ModEndfectedOre() {
		super(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(3F, 3F)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(0)
				.tickRandomly()
				);
		
		
		
	}
	
	@Override
	 public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		
		
			spreadEnfection(state, worldIn, pos, rand);
		
		
	}
	
	public void spreadEnfection(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		
		
		BlockPos target_pos = ModHelpers.getRandomAdjacentBlock(pos);
		
		if (worldIn.getBlockState(target_pos).getBlock() == Blocks.NETHERRACK) {
			
			worldIn.setBlockState(target_pos, BlockDec.ENDCROACHED_NETHERRACK.get().getDefaultState());
			
		}
		
		if (worldIn.getBlockState(target_pos).getBlock() == Blocks.NETHER_QUARTZ_ORE) {
			
			worldIn.setBlockState(target_pos, BlockDec.ENDFECTED_NETHER_QUARTZ_ORE.get().getDefaultState());
			
		}
		
	}
	
	
}
