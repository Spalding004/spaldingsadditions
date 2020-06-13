package com.misterspalding.spaldingsadditions.world.gen;

import com.misterspalding.spaldingsadditions.inits.FeaturesDec;
import com.misterspalding.spaldingsadditions.inits.PlacementsDec;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

public class ModStructGen {

	public static void genStructs() {
		
		
		
		for (Biome biome : ForgeRegistries.BIOMES) {
			
			
			
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER)) {
			
				biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, 
						FeaturesDec.FEATURE_ENDFECTION.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(PlacementsDec.ENDFECTION.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
				
				
			
			     
		
			}
		
		
		
		
		}
	}
}
