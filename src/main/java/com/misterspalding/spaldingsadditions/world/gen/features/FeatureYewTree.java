package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import com.misterspalding.spaldingsadditions.blocks.ModLeaves;
import com.misterspalding.spaldingsadditions.blocks.ModLogs;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;

public class FeatureYewTree extends  AbstractTreeFeature<FeatureYewTreeConfig> {
	  public FeatureYewTree(Function<Dynamic<?>, FeatureYewTreeConfig> function) {
	    super(function);
	  }
	  
	  @Override
	  protected boolean place(IWorldGenerationReader world, Random rand, BlockPos origin, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, FeatureYewTreeConfig config) {
	  
		  
		  // Total log length
	    int height = rand.nextInt(5) + config.baseHeight +1;
	    int branchheight = height - 3;

	    
	    
	  
	    
	    BlockPos.Mutable pos = new BlockPos.Mutable(origin);
	    BlockState log = config.trunkProvider.getBlockState(rand, pos);
	    BlockState leaf = config.leavesProvider.getBlockState(rand, pos);
	    
	    
	    //build trunk
	    
	    for (int x = 0; x < height; x++) {
	    world.setBlockState(pos.up(x), log, 1|2);
	     }
	    
	    //build branches
	    Direction.Axis axisX = Direction.Axis.X;
	    Direction.Axis axisZ = Direction.Axis.Z;
	    
	    world.setBlockState(pos.up(branchheight).east(), log.with(ModLogs.AXIS, axisX), 1|2);
	    world.setBlockState(pos.up(branchheight).east(2), log.with(ModLogs.AXIS, axisX), 1|2);
	    world.setBlockState(pos.up(branchheight).east(3).up(), log, 1|2);
	    
	    world.setBlockState(pos.up(branchheight).west(), log.with(ModLogs.AXIS, axisX), 1|2);
	    world.setBlockState(pos.up(branchheight).west(2), log.with(ModLogs.AXIS, axisX), 1|2);
	    world.setBlockState(pos.up(branchheight).west(3).up(), log, 1|2);
	    
	    world.setBlockState(pos.up(branchheight).north(), log.with(ModLogs.AXIS, axisZ), 1|2);
	    world.setBlockState(pos.up(branchheight).north(2), log.with(ModLogs.AXIS, axisZ), 1|2);
	    world.setBlockState(pos.up(branchheight).north(3).up(), log, 1|2);
	    
	    world.setBlockState(pos.up(branchheight).south(), log.with(ModLogs.AXIS, axisZ), 1|2);
	    world.setBlockState(pos.up(branchheight).south(2), log.with(ModLogs.AXIS, axisZ), 1|2);
	    world.setBlockState(pos.up(branchheight).south(3).up(), log, 1|2);
	    
	    //build leaves
	    //layer 0
	    world.setBlockState(pos.up(branchheight).east(1).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight).east(2).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight).east(1).north(2), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight).west(1).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight).west(2).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight).west(1).north(2), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight).east(1).south(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight).east(2).south(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight).east(1).south(2), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight).west(1).south(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight).west(2).south(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight).west(1).south(2), leaf, 1|2);
	    
	    return true;
	  }
	}