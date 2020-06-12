package com.misterspalding.spaldingsadditions.world.gen;

import com.misterspalding.spaldingsadditions.inits.FeaturesDec;
import com.misterspalding.spaldingsadditions.world.gen.features.BeechTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTreeGenAlt {

	public static void genTrees() {
		
		
		
		for (Biome biome : ForgeRegistries.BIOMES) {
			
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS))
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
					FeaturesDec.FEATURE_BEECH_TREE.withConfiguration(BeechTree.BEECH_TREE_CONFIG)
					.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.01F, 1))));
		}
		
		
		
		
		
	}
	
}
