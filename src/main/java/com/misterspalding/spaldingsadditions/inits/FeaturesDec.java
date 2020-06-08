package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.world.gen.features.FeatureYewTree;
import com.misterspalding.spaldingsadditions.world.gen.features.FeatureYewTreeConfig;

import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class FeaturesDec {

	public static Feature<FeatureYewTreeConfig> FEATURE_YEW_TREE = new FeatureYewTree(FeatureYewTreeConfig::deserialize);

	public static void register(RegistryEvent.Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();
	    
		registry.register(FEATURE_YEW_TREE.setRegistryName(Main.MOD_ID, "yew_tree"));
		
		
	}
	
}
