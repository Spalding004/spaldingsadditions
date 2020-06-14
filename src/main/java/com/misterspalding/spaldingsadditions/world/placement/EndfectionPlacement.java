package com.misterspalding.spaldingsadditions.world.placement;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.misterspalding.spaldingsadditions.utils.ModHelpers;
import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class EndfectionPlacement  extends Placement<NoPlacementConfig> {

	 public EndfectionPlacement(Function<Dynamic<?>, ? extends NoPlacementConfig> config) {
	      super(config);
	      
	   }
	 
	 public Stream<BlockPos> getPositions(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generatorIn, Random random, NoPlacementConfig configIn, BlockPos pos) {
	      int i = random.nextInt(5);
	      return IntStream.range(0, i).mapToObj((p_227435_3_) -> {
	         int j = random.nextInt(16) + pos.getX();
	         int k = random.nextInt(16) + pos.getZ();
	        // int l = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, j, k);
	         
	         int l = ModHelpers.getGroundFromAboveNether(worldIn, j, k);
	         
	         if (l > 20) {
	            //int i1 = l;
	            int i1 = l + 2;
	            return new BlockPos(j, i1, k);
	         } else {
	            return null;
	         }
	      }).filter(Objects::nonNull);
	   }
	
	
}
