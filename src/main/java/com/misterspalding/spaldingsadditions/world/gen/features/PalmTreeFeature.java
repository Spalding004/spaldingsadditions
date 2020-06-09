package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;

public class PalmTreeFeature extends  AbstractTreeFeature<PalmTreeFeatureConfig> {
	  public PalmTreeFeature(Function<Dynamic<?>, PalmTreeFeatureConfig> function) {
	    super(function);
	  }
	  
	  @Override
	  protected boolean place(IWorldGenerationReader worldIn, Random rand, BlockPos origin, Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box, PalmTreeFeatureConfig config) {
	  
		  
		  int direction = rand.nextInt(4);
	      int f = 2 + rand.nextInt(3) + 1;
	      int j = 3 + rand.nextInt(3) + 1;

	      for(int i = 0; i < 3; ++i) {
	         BlockPos blockpos = origin;

	         int k;
	         for(k = 0; k < f; ++k) {
	            worldIn.setBlockState(blockpos.up(k), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         }

	         blockpos = blockpos.up(f);
	         switch(direction) {
	         case 0:
	            blockpos = blockpos.east();
	            break;
	         case 1:
	            blockpos = blockpos.west();
	            break;
	         case 2:
	            blockpos = blockpos.north();
	            break;
	         case 3:
	            blockpos = blockpos.south();
	            break;
	         default:
	            blockpos = blockpos.east();
	         }

	         for(k = 0; k < j; ++k) {
	            worldIn.setBlockState(blockpos.up(k), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         }

	         blockpos = blockpos.add(0, j, 0);
	         blockpos = blockpos.down(2);
	         worldIn.setBlockState(blockpos.up(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.up(1).west(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.up(1).east(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.up(1).north(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.up(1).south(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(1), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(2).down(1), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(1).north(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(1).south(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(2).north(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(2).south(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(2).north(1).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(2).south(1).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(1), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(2).down(1), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(1).north(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(1).south(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(2).north(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(2).south(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(2).north(1).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(2).south(1).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.south(2).east(1).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.south(2).west(1).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.north(2).east(1).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.north(2).west(1).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.north(1), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.north(2).down(1), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.north(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(1).north(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(1).south(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.south(1), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.south(2).down(1), BlockDec.PALM_LOG.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.south(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(1).north(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(1).south(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.north(3).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.north(3).down(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.south(3).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.south(3).down(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(3).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.east(3).down(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(3).down(1), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	         worldIn.setBlockState(blockpos.west(3).down(2), BlockDec.PALM_LEAVES.get().getDefaultState(), 1|2);
	      }
	    return true;
	  }
	}