package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.Random;

import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.FeaturesDec;
import com.misterspalding.spaldingsadditions.world.feature.tree.ModBeechTree;

import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class BeechTree extends ModBeechTree {

	 public static final BeechTreeFeatureConfig BEECH_TREE_CONFIG = (new BeechTreeFeatureConfig.Builder(
			 new SimpleBlockStateProvider(BlockDec.BEECH_LOG.get().getDefaultState()), 
			 new SimpleBlockStateProvider(BlockDec.BEECH_LEAVES.get().getDefaultState()))
			 .baseHeight(4)
			 .setSapling((net.minecraftforge.common.IPlantable)BlockDec.BEECH_SAPLING.get()).build());

	@Override
	protected ConfiguredFeature<BeechTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		// TODO Auto-generated method stub
		return FeaturesDec.FEATURE_BEECH_TREE.withConfiguration(BEECH_TREE_CONFIG);
	}
	
}
