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

public class ModEndcroachment extends Block {

	public ModEndcroachment() {
		super(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(.4F, .4F)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(0)
				.tickRandomly()
				.lightValue(4)
				);
		
	}
	
	
	@Override
	 public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		
		boolean shouldgrow = rand.nextInt(10) == 1;
		boolean shouldSpread = rand.nextInt(10) > 2;
		
		if (shouldgrow && worldIn.getBlockState(pos.up()).isAir(worldIn, pos)) {
		int type = rand.nextInt(100);
			if (type <= 69) {
				worldIn.setBlockState(pos, BlockDec.ENDFECTED_NETHERRACK_C.get().getDefaultState());
			} 
			
			if (type > 69 && type <= 85 ) {
				worldIn.setBlockState(pos, BlockDec.ENDFECTED_NETHERRACK_A.get().getDefaultState());
			} 

			if (type > 85) {
				worldIn.setBlockState(pos, BlockDec.ENDFECTED_NETHERRACK_B.get().getDefaultState());
			}
			
		}
		
		if (shouldSpread) {
		
		pos = ModHelpers.getRandomAdjacentBlock(pos);
			
		
		
		if (worldIn.getBlockState(pos).getBlock() ==  Blocks.NETHERRACK) {
			
			//worldIn.setBlockState(pos, BlockDec.ENDCROACHED_NETHERRACK.get().getDefaultState());
			
		} 
		
		
		}
	}
	
	
	
}
