package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.Random;
import java.util.function.Function;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class EndfectionFeature extends  Feature<NoFeatureConfig> {
	  public EndfectionFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
	      super(configFactoryIn);
	 
	  
	  
	  }
	  
	  
	  
	  @Override
	  public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos origin, NoFeatureConfig config) {
	      if (world.isAirBlock(origin.up()) && world.getBlockState(origin).getBlock() == Blocks.NETHERRACK) {
	    	  
	    	  BlockPos pos = new BlockPos.Mutable(origin.down());
		 		 BlockState base = BlockDec.ENDCROACHED_NETHERRACK.get().getDefaultState();
		 		 BlockState fill1 = Blocks.END_STONE.getDefaultState();
		 		 BlockState fill2 = Blocks.END_STONE_BRICKS.getDefaultState();
		 		 BlockState cover = Blocks.NETHERRACK.getDefaultState();
		 		 
		 		
		 		 
		 		 if (rand.nextInt(500) == 0) {
		 		 
		 		 int offsetx = 0;
		 		 int offsety = 0;
		 		 
		 		 int height = 4;
		 		 
		 		 int pillars = 1 + rand.nextInt(3);
		 		 
		 		 
		 		 
		 		 for (int y = 0; y < pillars; y++) {
		 			 
		 			 height = 4 + rand.nextInt(3);
		 			 offsetx = rand.nextInt(4) -2;
		 			 
		 			 offsety = rand.nextInt(4) -2;
		 			 
		 			 BlockPos target = pos.north(offsetx).east(offsety);
		 			 
		 			 generatePillar(height, offsetx, offsety, target, world, base, fill1, fill2, cover, rand);
		 			 
		 		 		}
		 		 }
	    	  
	    	  return true;
	      } else {
		return false;
	      }
	    	 
		 
	
	
	     
	      
	  }



	private void generatePillar(int height, int offsetx, int offsety, BlockPos target, IWorldGenerationReader world, BlockState base, BlockState fill1, BlockState fill2, BlockState cover, Random rand) {
		Main.LOGGER.info("Attempting to spawn pillar with height " + height + " @ " + target);
		world.setBlockState(target, base, 1|2);
		world.setBlockState(target.north(), base, 1|2);
		world.setBlockState(target.south(), base, 1|2);
		world.setBlockState(target.east(), base, 1|2);
		world.setBlockState(target.west(), base, 1|2);
		
		world.setBlockState(target.north().east(), base, 1|2);
		world.setBlockState(target.south().west(), base, 1|2);
		world.setBlockState(target.south().east(), base, 1|2);
		world.setBlockState(target.north().west(), base, 1|2);
		
		world.setBlockState(target.down(), base, 1|2);
		
		for(int z = 0; z < height; z++) {
			
			if (rand.nextInt(50) > 10 + z*5) {
				
				world.setBlockState(target.up(z), fill1, 1|2);
				
			} else {
				
				world.setBlockState(target.up(z), fill2, 1|2);
				
			}
			
		world.setBlockState(target.up(height), Blocks.PURPUR_BLOCK.getDefaultState(), 1|2);
			
		}
		
	}
	  
	  
	 
	  
	}