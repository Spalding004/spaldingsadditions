package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.world.gen.features.BeechTreeFeature;
import com.misterspalding.spaldingsadditions.world.gen.features.BeechTreeFeatureConfig;
import com.misterspalding.spaldingsadditions.world.gen.features.PalmTreeFeature;
import com.misterspalding.spaldingsadditions.world.gen.features.PalmTreeFeatureConfig;
import com.misterspalding.spaldingsadditions.world.gen.features.YewTreeFeature;
import com.misterspalding.spaldingsadditions.world.gen.features.YewTreeFeatureConfig;

import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class FeaturesDec {

	public static Feature<PalmTreeFeatureConfig> FEATURE_PALM_TREE = new PalmTreeFeature(PalmTreeFeatureConfig::deserialize);
	public static Feature<YewTreeFeatureConfig> FEATURE_YEW_TREE = new YewTreeFeature(YewTreeFeatureConfig::deserialize);
	public static Feature<BeechTreeFeatureConfig> FEATURE_BEECH_TREE = new BeechTreeFeature(BeechTreeFeatureConfig::deserialize);
	
	public static void register(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
	    
		registry.register(FEATURE_YEW_TREE.setRegistryName(Main.MOD_ID, "yew_tree"));
		registry.register(FEATURE_PALM_TREE.setRegistryName(Main.MOD_ID, "palm_tree"));

		registry.register(FEATURE_BEECH_TREE.setRegistryName(Main.MOD_ID, "beech_tree"));
	}
	
}
