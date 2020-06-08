package com.misterspalding.spaldingsadditions.world.feature;

import java.util.Random;
import java.util.function.Function;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class YewTree extends Tree {

	public static final TreeFeatureConfig YEW_TREE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockDec.YEW_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockDec.YEW_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(3, 0))
				.baseHeight(5)
				.heightRandA(2)
				.ignoreVines()
				.foliageHeight(2)
				.setSapling((IPlantable)BlockDec.YEW_SAPLING.get())
				
				.build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		// TODO Auto-generated method stub
		return Feature.NORMAL_TREE.withConfiguration(YEW_TREE_CONFIG);
	}
				
				
				
				


	

	
	
	

	
	
}
