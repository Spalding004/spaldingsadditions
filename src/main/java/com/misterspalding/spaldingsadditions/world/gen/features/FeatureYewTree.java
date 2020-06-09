package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;
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
	    
	    int bee = 1;
	    
	    if (branchheight >= 4) bee = rand.nextInt(100);
	    
	    bee = rand.nextInt(100);
	    int bee_direction = rand.nextInt(3);
	  
	    
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
	    
	    if (bee == 0) {
	    	
	    BlockPos beePos = pos.up(branchheight);
	    switch(bee_direction) {
	    case 0:
	    	beePos = beePos.east(3).down();
	    	break;
	    case 1:
	    	beePos = beePos.north(3).down();
	    	break;
	    case 2:
	    	beePos = beePos.west(3).down();
	    	break;
	    case 3:
	    	beePos = beePos.south(3).down();
	    	break;
	    default:
	    	beePos = beePos.east(3).down();
	    	break;
	    }
	    
	    world.setBlockState(beePos, Blocks.BEE_NEST.getDefaultState(), 1|2);
	    
	    }
	    
	    //build leaves
	    //layer 0
	    int height_offset = 0;
	    world.setBlockState(pos.up(branchheight+height_offset).east(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).north(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).south(3), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(2), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).west(1).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(2).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(1).north(2), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).south(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).south(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).south(2), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).west(1).south(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(2).south(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(1).south(2), leaf, 1|2);
	    
	    //layer 1
	    height_offset = 1;
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(4), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(0).north(4), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(4), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).west(4).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(4).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(4).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(4).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(4).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(4).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).south(4), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(0).south(4), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).south(4), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).north(2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(0).north(2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(2), leaf, 1|2);
	    
	     world.setBlockState(pos.up(branchheight+height_offset).east(2).north(1), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(1), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(0).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(1), leaf, 1|2);
	    
	     world.setBlockState(pos.up(branchheight+height_offset).east(2).north(0), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(0), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(0), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).north(3), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(3), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(3), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).south(3), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).south(3), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(-1).south(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).south(3), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).north(2).east(3), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).north(1).east(3), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).north(-1).east(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).north(-2).east(3), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).north(2).west(3), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).north(1).west(3), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).north(-1).west(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).north(-2).west(3), leaf, 1|2);
	    
	     world.setBlockState(pos.up(branchheight+height_offset).east(2).north(-1), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(-1), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(0).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(-1), leaf, 1|2);
	    
	     world.setBlockState(pos.up(branchheight+height_offset).east(2).north(-2), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(-2), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(0).north(-2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(-2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(-2), leaf, 1|2);
	    
	    //layer 2
	    height_offset = 2;
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).north(2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(0).north(2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(2), leaf, 1|2);
	    
	     world.setBlockState(pos.up(branchheight+height_offset).east(2).north(1), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(1), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(0).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(1), leaf, 1|2);
	    
	     world.setBlockState(pos.up(branchheight+height_offset).east(2).north(0), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(0), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(0), leaf, 1|2);
	     
	     world.setBlockState(pos.up(branchheight+height_offset).east(2).north(-1), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(-1), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(0).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(-1), leaf, 1|2);
	    
	     world.setBlockState(pos.up(branchheight+height_offset).east(2).north(-2), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(1).north(-2), leaf, 1|2);
	     world.setBlockState(pos.up(branchheight+height_offset).east(0).north(-2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(-2), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-2).north(-2), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(0).north(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).north(3), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).west(3).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(3).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(3).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(3).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(3).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(3).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).south(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(0).south(3), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(-1).south(3), leaf, 1|2);
	    
	    //layer 3
	    height_offset = 3;
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(1).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).west(1).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(1).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(1).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(2).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).west(2).north(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(2).north(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(2).north(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).north(2).east(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).north(2).east(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).north(2).east(1), leaf, 1|2);
	    
	    world.setBlockState(pos.up(branchheight+height_offset).south(2).west(-1), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).south(2).west(0), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).south(2).west(1), leaf, 1|2);
	    
	    //layer 4
	    
	    height_offset = 4;
	    
	    int stepN = rand.nextInt(2);
	    int stepE = rand.nextInt(2);
	    
	    if (stepN == 0) stepN = -1;
	    if (stepE == 0) stepE = -1;
	    
	    world.setBlockState(pos.up(branchheight+height_offset).north(), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).south(), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).north(stepN).east(stepE), leaf, 1|2);
	    
	    // layer 5
	    
	    height_offset = 5;
	    
	    world.setBlockState(pos.up(branchheight+height_offset).north(), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).south(), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).east(), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset).west(), leaf, 1|2);
	    world.setBlockState(pos.up(branchheight+height_offset), leaf, 1|2);
	    
	    
	    return true;
	  }
	}