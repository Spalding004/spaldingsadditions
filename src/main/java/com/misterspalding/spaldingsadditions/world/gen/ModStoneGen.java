package com.misterspalding.spaldingsadditions.world.gen;

import com.misterspalding.spaldingsadditions.inits.BlockDec;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModStoneGen {

	public static void GenerateOre() {
		
		
		
		for (Biome biome : ForgeRegistries.BIOMES) {
			
			ConfiguredPlacement<CountRangeConfig> config = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 20, 0, 120));
			ConfiguredPlacement<CountRangeConfig> config_pumice = Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 20, 0, 120));
			ConfiguredPlacement<CountRangeConfig> config_shale = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 20, 0, 70));
			ConfiguredPlacement<CountRangeConfig> config_vendar = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 12, 0, 40));
			ConfiguredPlacement<CountRangeConfig> config_vendar2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(200, 12, 0, 30));
			ConfiguredPlacement<CountRangeConfig> config_umber = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 20, 0, 120));
			ConfiguredPlacement<CountRangeConfig> config_alunite = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 20, 0, 120));
			ConfiguredPlacement<CountRangeConfig> config_cormalite = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 20, 0, 120));
			
			if(biome == Biomes.RIVER || biome == Biomes.OCEAN) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
								BlockDec.SHALE.get().getDefaultState(), 20)).withPlacement(config_shale));
			}
			//																				rarity, y-min, y-max offset, y-max???
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
							BlockDec.APATITE.get().getDefaultState(), 33)).withPlacement(config));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
							BlockDec.PUMICE.get().getDefaultState(), 20)).withPlacement(config_pumice));
						
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
							BlockDec.MARCASITE.get().getDefaultState(), 33)).withPlacement(config));
			
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, 
							BlockDec.UMBER.get().getDefaultState(), 33)).withPlacement(config_umber));
			
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, 
							BlockDec.ALUNITE.get().getDefaultState(), 33)).withPlacement(config_alunite));
			
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, 
							BlockDec.CORMALITE.get().getDefaultState(), 33)).withPlacement(config_cormalite));
			
			//ore-replacing ore
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("CUSTOM_STONE", null, new BlockMatcher(Blocks.STONE)), 
							BlockDec.VENDAR_ORE.get().getDefaultState(), 6)).withPlacement(config_vendar));
			
			//ore-replacing ore
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("DENSE_VENDAR", null, new BlockMatcher(BlockDec.VENDAR_ORE.get())), 
							BlockDec.VENDAR_ORE_DENSE.get().getDefaultState(), 4)).withPlacement(config_vendar2));
		}
		
		
		
		
		
	}
	
}
