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

public class ModEndfection extends Block {

	private String type;
	
	public ModEndfection(String type) {
		super(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(.4F, .4F)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(0)
				.tickRandomly()
				.lightValue(7)
				);
		
		this.type = type;
		
	}
	
	
	@Override
	 public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		
		if (!worldIn.getBlockState(pos.up()).isAir(worldIn, pos)) {
			
			worldIn.setBlockState(pos, BlockDec.ENDCROACHED_NETHERRACK.get().getDefaultState());
			
		}
		
		switch (type) {
		
		
		case "C":
			//case C endfections do not spread.
			break;
		default:
			spreadEnfection(state, worldIn, pos, rand, type);

			spreadEnfection(state, worldIn, pos, rand, type);
		}
		
	}
	
	public void spreadEnfection(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand, String type) {
		
	//	int spread_check = rand.nextInt(20);
		
		BlockPos target_pos = ModHelpers.getRandomAdjacentBlock(pos);
		
	//	if (spread_check < 3) {
		
			if (worldIn.getBlockState(target_pos).getBlock() == Blocks.NETHERRACK) {
			
				worldIn.setBlockState(target_pos, BlockDec.ENDCROACHED_NETHERRACK.get().getDefaultState());
			
			}
		
			if (worldIn.getBlockState(target_pos).getBlock() == Blocks.NETHER_QUARTZ_ORE) {
			
				worldIn.setBlockState(target_pos, BlockDec.ENDFECTED_NETHER_QUARTZ_ORE.get().getDefaultState());
			
		//	}
		}
		
	}
	
}
