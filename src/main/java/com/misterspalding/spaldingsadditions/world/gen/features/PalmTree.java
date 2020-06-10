package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.Random;

import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.FeaturesDec;
import com.misterspalding.spaldingsadditions.world.feature.ModPalmTree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class PalmTree extends ModPalmTree {

	 public static final PalmTreeFeatureConfig PALM_TREE_CONFIG = (new PalmTreeFeatureConfig.Builder(
			 new SimpleBlockStateProvider(BlockDec.PALM_LOG.get().getDefaultState()), 
			 new SimpleBlockStateProvider(BlockDec.PALM_LEAVES.get().getDefaultState()))
			 .baseHeight(4)
			 .setSapling((net.minecraftforge.common.IPlantable)BlockDec.PALM_SAPLING.get()).build());

	@Override
	protected ConfiguredFeature<PalmTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		// TODO Auto-generated method stub
		return FeaturesDec.FEATURE_PALM_TREE.withConfiguration(PALM_TREE_CONFIG);
	}
	
}
