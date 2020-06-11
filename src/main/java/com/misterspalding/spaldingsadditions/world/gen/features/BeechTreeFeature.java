package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.blocks.ModLogs;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.utils.ModHelpers;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;

public class BeechTreeFeature extends  AbstractTreeFeature<BeechTreeFeatureConfig> {
	  public BeechTreeFeature(Function<Dynamic<?>, BeechTreeFeatureConfig> function) {
	    super(function);
	  }
	  
	  @Override
	  protected boolean place(IWorldGenerationReader worldIn, Random rand, BlockPos origin, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, BeechTreeFeatureConfig config) {
	  
		  
		 BlockPos.Mutable pos = new BlockPos.Mutable(origin);
		  BlockState log = config.trunkProvider.getBlockState(rand, pos);
		  BlockState leaf = config.leavesProvider.getBlockState(rand, pos);
		  int trunk_height = 10 + rand.nextInt(3);
		  int branch_height = trunk_height - 5;
		  
		  //pos of bottom leaf clusters
		  
		  BlockPos.Mutable northPos = new BlockPos.Mutable(origin.up(branch_height).north(6));
		  BlockPos.Mutable southPos = new BlockPos.Mutable(origin.up(branch_height).south(6));
		  BlockPos.Mutable westPos = new BlockPos.Mutable(origin.up(branch_height).west(6));
		  BlockPos.Mutable eastPos = new BlockPos.Mutable(origin.up(branch_height).east(6));
		  
		  BlockPos.Mutable northPosUp = new BlockPos.Mutable(origin.up(trunk_height-1).north(3));
		  BlockPos.Mutable southPosUp = new BlockPos.Mutable(origin.up(trunk_height-1).south(3));
		  BlockPos.Mutable westPosUp = new BlockPos.Mutable(origin.up(trunk_height-1).west(3));
		  BlockPos.Mutable eastPosUp = new BlockPos.Mutable(origin.up(trunk_height-1).east(3));
		  
		  BlockPos.Mutable northEastPos = new BlockPos.Mutable(origin.up(branch_height).north(5).east(5));
		  BlockPos.Mutable southWestPos = new BlockPos.Mutable(origin.up(branch_height).south(5).west(5));
		  BlockPos.Mutable northWestPos = new BlockPos.Mutable(origin.up(branch_height).north(5).west(5));
		  BlockPos.Mutable southEastPos = new BlockPos.Mutable(origin.up(branch_height).south(5).east(5));
		  
		  Direction.Axis axisX = Direction.Axis.X;
		  Direction.Axis axisZ = Direction.Axis.Z;
		  
		  for(int x = 0; x < trunk_height; x++) {
			  
			  worldIn.setBlockState(pos.up(x), log, 1|2);
			  worldIn.setBlockState(pos.up(x).east(), log, 1|2);
			  worldIn.setBlockState(pos.up(x).west(), log, 1|2);
			  worldIn.setBlockState(pos.up(x).north(), log, 1|2);
			  worldIn.setBlockState(pos.up(x).south(), log, 1|2);
			 }
		  
		  	worldIn.setBlockState(pos.up(trunk_height+1), log, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height), log, 1|2);
		  	
		  	//cardinal branches
		  	
		  	worldIn.setBlockState(pos.up(branch_height).east(2), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(3), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(4).down(), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(5).down(), log.with(ModLogs.AXIS, axisX), 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).east(4).down().north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(4).north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(5).down().south(), leaf, 1|2);
			worldIn.setBlockState(pos.up(branch_height).east(5).down().north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(4).down().south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(4).south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(6), log, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).east(-2), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-3), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-4).down(), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-5).down(), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-4).down().north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-5).down().south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-5).down().north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-4).north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-4).south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-4).down().south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(-6), log, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(2), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).down(), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(5).down(), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).down().east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(5).down().west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(5).down().east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).down().west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(6), log, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(-2), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-3), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-4).down(), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-5).down(), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-4).down().east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-4).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-5).down().west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-5).down().east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-4).down().west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-4).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(-6), log, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).east(4).down(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(5).down(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(4).down(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(5).down(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(4).down(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(5).down(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).down(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(5).down(2), leaf, 1|2);
		  	
		  	//upper cardinal branches
		  	
			worldIn.setBlockState(pos.up(branch_height+4).east(2).north(2), leaf, 1|2);
			worldIn.setBlockState(pos.up(branch_height+4).east(2).south(2), leaf, 1|2);
			worldIn.setBlockState(pos.up(branch_height+4).west(2).north(2), leaf, 1|2);
			worldIn.setBlockState(pos.up(branch_height+4).west(2).south(2), leaf, 1|2);
			
		  	worldIn.setBlockState(pos.up(branch_height+3).east(2), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+3).east(2).north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+3).east(2).south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+4).east(3), log, 1|2);
		  
		  	
		  	worldIn.setBlockState(pos.up(branch_height+3).west(2), log.with(ModLogs.AXIS, axisX), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+4).west(3), log, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+3).west(2).north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+3).west(2).south(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height+3).north(2), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+4).north(3), log, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+3).north(2).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+3).north(2).west(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height+3).south(2), log.with(ModLogs.AXIS, axisZ), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+4).south(3), log, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+3).south(2).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height+3).south(2).west(), leaf, 1|2);
		  	
		  	//diagonal branches
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(2).east(2), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3).east(3).down(), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).east(4).down(), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(5).east(5), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(1).east(1), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).south(2).east(2), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).east(3).down(), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(4).east(4).down(), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(5).east(5), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(1).east(1), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(2).west(2), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3).west(3).down(), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).west(4).down(), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(5).west(5), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(1).west(1), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).south(2).west(2), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).west(3).down(), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(4).west(4).down(), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(5).west(5), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(1).west(1), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	
		  
		  	
		  	// lower leaf clusters
		  	
		  	BlockPos.Mutable target = new BlockPos.Mutable();
		  	
		  	for (int y = 0; y < 12; y++) {
		  		
		  		switch(y) {
		  		
		  		case 0:
		  			target = northPos;
		  			break;
		  		case 1:
		  			target = southPos;
		  			break;
		  		case 2:
		  			target = eastPos;
		  			break;
		  		case 3:
		  			target = westPos;
		  			break;
		  		case 4:
		  			target = southWestPos;
		  			break;
		  		case 5:
		  			target = northWestPos;
		  			break;
		  		case 6:
		  			target = southEastPos;
		  			break;
		  		case 7:
		  			target = northEastPos;
		  			break;
		  		case 8:
		  			target = northPosUp;
		  			break;
		  		case 9:
		  			target = southPosUp;
		  			break;
		  		case 10:
		  			target = eastPosUp;
		  			break;
		  		case 11:
		  			target = westPosUp;
		  			break;
		  		default:
		  			target = northPos;
		  			break;
		  			
		  		}
		  	
		  		
		  		generateLeafPod(target, leaf, worldIn);
		  		
		  		
		  		}
		  		
		  	//upper fillage	
		  	
		  	
		  	
		  	worldIn.setBlockState(pos.up(branch_height).east(2).up(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(2).up().up(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(3).up(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(2).up(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(2).up().up(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3).up(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).west(2).up(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(2).up().up(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(3).up(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).south(2).up(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(2).up().up(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).up(), leaf, 1|2);
		  	
		  	
		  	
		  	worldIn.setBlockState(pos.up(branch_height).east(4), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(2).down(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(3).down(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(2).north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(3).north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(2).south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).east(3).south(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).west(4), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(2).down(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(3).down(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(2).north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(3).north(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(2).south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).west(3).south(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(4), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(2).down(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3).down(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(2).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(2).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3).east(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).south(4), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(2).down(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).down(), leaf, 1|2);
			worldIn.setBlockState(pos.up(branch_height).south(2).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(2).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).east(), leaf, 1|2);
		  	
		  	//diagonal fillage
		  	
		  	worldIn.setBlockState(pos.up(branch_height).west(3).north(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).down().west(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).down().west(2).north(2), leaf, 1|2);
		  	
		  	
		  	worldIn.setBlockState(pos.up(branch_height).up().up().up().up().west(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().up().up().west(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().up().west(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().west(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().west(2).north(2), leaf, 1|2);
		  	
		  
		  	worldIn.setBlockState(pos.up(branch_height).west(3).south(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).down().west(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).down().west(2).south(2), leaf, 1|2);
		  	
			worldIn.setBlockState(pos.up(branch_height).up().up().up().up().west(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().up().up().west(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().up().west(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().west(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().west(2).south(2), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(3).east(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).down().north(1).east(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).down().north(2).east(2), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).up().up().up().up().east(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().up().up().east(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().up().east(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().east(1).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().east(2).north(2), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).south(3).east(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).down().south(1).east(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).down().south(2).east(2), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).up().up().up().up().east(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().up().up().east(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().up().east(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().east(1).south(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).up().east(2).south(2), leaf, 1|2);
		  	
		  	//capper
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height+1).east(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height+1).west(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height+1).south(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height+1).north(2), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north().east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).south().west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).south().east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north().west(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(1).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(1).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(1).south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(1).north(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(2).east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(2).west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(2).south(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(2).north(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(1).north().east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(1).south().west(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(1).south().east(), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(1).north().west(), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(3), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).east(2).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).east(2).north(0), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).east(2).north(-1), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).east(-2).north(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).east(-2).north(0), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).east(-2).north(-1), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north(2).east(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north(2).east(0), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north(2).east(-1), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north(-2).east(1), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north(-2).east(0), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(trunk_height).up(0).north(-2).east(-1), leaf, 1|2);
		  	
		  	//more filling leaves
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(2).east(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(2).west(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(2).east(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(2).west(3), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(3).east(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).west(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).east(2), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3).west(2), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(4).east(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(4).west(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(4).east(3), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(4).west(3), leaf, 1|2);
		  	
		  	worldIn.setBlockState(pos.up(branch_height).north(3).east(4), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).west(4), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).south(3).east(4), leaf, 1|2);
		  	worldIn.setBlockState(pos.up(branch_height).north(3).west(4), leaf, 1|2);
		  	
		  	//knottiness factor
		  	for (int y = 0; y <3; y ++) {
		  	worldIn.setBlockState(origin.north().east().up(y), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(origin.south().east().up(y), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(origin.north().west().up(y), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(origin.south().west().up(y), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	}
		  
		  	worldIn.setBlockState(origin.north(2).east(2), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(origin.south(2).east(2), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(origin.north(2).west(2), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	worldIn.setBlockState(origin.south(2).west(2), BlockDec.BEECH_WOOD.get().getDefaultState(), 1|2);
		  	
		
		  	letsGetKnotty(origin.up(), worldIn, BlockDec.BEECH_WOOD.get().getDefaultState() , rand);
		  	
		  	
	    return true;
	  }
	  
	  public static void generateLeafPod(BlockPos target, BlockState leaf, IWorldGenerationReader worldIn) {
		  
		  	worldIn.setBlockState(target.up(), leaf, 1|2);
		  	worldIn.setBlockState(target.down(), leaf, 1|2);
	  		
	  		worldIn.setBlockState(target.west(), leaf, 1|2);
	  		worldIn.setBlockState(target.east(), leaf, 1|2);	
	  		worldIn.setBlockState(target.south(), leaf, 1|2);
	  		worldIn.setBlockState(target.north(), leaf, 1|2);
	  		
	  		worldIn.setBlockState(target.north().west(), leaf, 1|2);
	  		worldIn.setBlockState(target.north().east(), leaf, 1|2);
	  		
	  		worldIn.setBlockState(target.south().west(), leaf, 1|2);
	  		worldIn.setBlockState(target.south().east(), leaf, 1|2);
	  		
	  		
		  
	  }
	  
	  public static void letsGetKnotty(BlockPos target, IWorldGenerationReader worldIn, BlockState wood, Random rand) {
		  
		  BlockPos newTarget = target;
		
		  String face = "x";
		  
		 for (int x = 0; x < 4; x++) {
			 newTarget = target;
			 
			 switch(x) {
			
			 
			 case 1: 
				 newTarget = target.east();
				 face = "x";
				 generateKnots(newTarget, wood, rand, worldIn, face);
				 break;
			 case 2: 
				 newTarget = target.west();
				 face = "x";
				 generateKnots(newTarget, wood, rand, worldIn, face);
				 break;
			 case 3: 
				 newTarget = target.north();
				 face = "y";
				 generateKnots(newTarget, wood, rand, worldIn, face);
				 break;	 
			default: 
				newTarget = target.south();
				 face = "y";
				 generateKnots(newTarget, wood, rand, worldIn, face);
				 break;	 
			 
			 }
			 
			 
			 
		 }
		
		  
	  }
	  
	  public static void generateKnots(BlockPos target, BlockState wood, Random rand, IWorldGenerationReader worldIn, String face) {
		  
		  BlockState fillblock = Blocks.AIR.getDefaultState();
		  
		  int up = rand.nextInt(3)-1;
		  int side = rand.nextInt(3)-1;
		  
		  if (rand.nextInt(5) == 0 && up == 0 && side == 0) {
			  
			  fillblock = Blocks.BEE_NEST.getDefaultState();
			  
		  }
		  
		  if (face == "x") {
			  
			 worldIn.setBlockState(target.up(up).north(side), fillblock, 1|2);
			 worldIn.setBlockState(target.up(up).down().north(side), wood, 1|2); 
			 worldIn.setBlockState(target.up(up).up().north(side), wood, 1|2);			
			 
			 
		  } 

		  if (face == "y"){
			  
			  worldIn.setBlockState(target.up(up).east(side), fillblock, 1|2);
			  worldIn.setBlockState(target.up(up).down().east(side), wood, 1|2); 
			  worldIn.setBlockState(target.up(up).up().east(side), wood, 1|2);				 
			  
			  
		  }
		  
	  }
	  
	}