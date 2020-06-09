package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.Random;

import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.FeaturesDec;
import com.misterspalding.spaldingsadditions.world.feature.ModYewTree;

import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class YewTree extends ModYewTree {

	 public static final YewTreeFeatureConfig YEW_TREE_CONFIG = (new YewTreeFeatureConfig.Builder(
			 new SimpleBlockStateProvider(BlockDec.YEW_LOG.get().getDefaultState()), 
			 new SimpleBlockStateProvider(BlockDec.YEW_LEAVES.get().getDefaultState()))
			 .baseHeight(4)
			 .setSapling((net.minecraftforge.common.IPlantable)BlockDec.YEW_SAPLING.get()).build());

	@Override
	protected ConfiguredFeature<YewTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		// TODO Auto-generated method stub
		return FeaturesDec.FEATURE_YEW_TREE.withConfiguration(YEW_TREE_CONFIG);
	}
	
}
