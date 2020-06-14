package com.misterspalding.spaldingsadditions.world.gen;

import com.misterspalding.spaldingsadditions.inits.BlockDec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

public class ModStoneGen {

	public static void generateOre() {
		
		
		
		for (Biome biome : ForgeRegistries.BIOMES) {
			
			ConfiguredPlacement<CountRangeConfig> config_marcasite = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 1, 0, 120));
			ConfiguredPlacement<CountRangeConfig> config_apatite = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 1, 0, 120));
			ConfiguredPlacement<CountRangeConfig> config_pumice = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 1, 0, 55));
			ConfiguredPlacement<CountRangeConfig> config_shale = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 10, 0, 120));
			ConfiguredPlacement<CountRangeConfig> config_shale2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 10, 0, 90));
			ConfiguredPlacement<CountRangeConfig> config_vendar = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 12, 0, 40));
			ConfiguredPlacement<CountRangeConfig> config_vendar2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(200, 12, 0, 30));
			ConfiguredPlacement<CountRangeConfig> config_umber = Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 40, 0, 180));
			ConfiguredPlacement<CountRangeConfig> config_alunite = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 90, 0, 180));
			ConfiguredPlacement<CountRangeConfig> config_cormalite = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 20, 0, 95));
			
			ConfiguredPlacement<CountRangeConfig> config_coal_diamond = Placement.COUNT_RANGE.configure(new CountRangeConfig(30, 1, 0, 20));
			ConfiguredPlacement<CountRangeConfig> config_coal_iron = Placement.COUNT_RANGE.configure(new CountRangeConfig(70, 1, 0, 80));
			ConfiguredPlacement<CountRangeConfig> config_coal_gold = Placement.COUNT_RANGE.configure(new CountRangeConfig(60, 1, 0, 40));
			ConfiguredPlacement<CountRangeConfig> config_coal_redstone = Placement.COUNT_RANGE.configure(new CountRangeConfig(45, 1, 0, 20));
			ConfiguredPlacement<CountRangeConfig> config_coal_lapis = Placement.COUNT_RANGE.configure(new CountRangeConfig(45, 1, 0, 40));
			ConfiguredPlacement<CountRangeConfig> config_coal_emerald = Placement.COUNT_RANGE.configure(new CountRangeConfig(35, 1, 0, 64));
			
			ConfiguredPlacement<CountRangeConfig> config_emerald = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 1, 0, 16));
			
			/*
			 * 
		
        
            this.runGenerator(this.coal_lapis, world, random, chunkX, chunkZ, 45, 1, 40);
            this.runGenerator(this.coal_emerald, world, random, chunkX, chunkZ, 35, 1, 64);
			 * 
			 * 
			 * 
			 */
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("COAL_ORE_FILLER", null, new BlockMatcher(Blocks.COAL_ORE)), 
							BlockDec.COAL_ORE_DIAMOND.get().getDefaultState(), 3))
							.withPlacement(config_coal_diamond));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("COAL_ORE_FILLER", null, new BlockMatcher(Blocks.COAL_ORE)), 
							BlockDec.COAL_ORE_EMERALD.get().getDefaultState(), 3))
							.withPlacement(config_coal_emerald));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("COAL_ORE_FILLER", null, new BlockMatcher(Blocks.COAL_ORE)), 
							BlockDec.COAL_ORE_IRON.get().getDefaultState(), 3))
							.withPlacement(config_coal_iron));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("COAL_ORE_FILLER", null, new BlockMatcher(Blocks.COAL_ORE)), 
							BlockDec.COAL_ORE_GOLD.get().getDefaultState(), 3))
							.withPlacement(config_coal_gold));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("COAL_ORE_FILLER", null, new BlockMatcher(Blocks.COAL_ORE)), 
							BlockDec.COAL_ORE_REDSTONE.get().getDefaultState(), 3))
							.withPlacement(config_coal_redstone));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("COAL_ORE_FILLER", null, new BlockMatcher(Blocks.COAL_ORE)), 
							BlockDec.COAL_ORE_LAPIS.get().getDefaultState(), 3))
							.withPlacement(config_coal_lapis));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
							Blocks.EMERALD_ORE.getDefaultState(), 5)).withPlacement(config_emerald));
			
			if(biome == Biomes.RIVER || BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
								BlockDec.SHALE.get().getDefaultState(), 33)).withPlacement(config_shale));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
						Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
								BlockDec.SHALE.get().getDefaultState(), 3)).withPlacement(config_shale2));
			}
			//																				rarity, y-min, y-max offset, y-max???
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
							BlockDec.APATITE.get().getDefaultState(), 33)).withPlacement(config_apatite));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
							BlockDec.PUMICE.get().getDefaultState(), 10)).withPlacement(config_pumice));
						
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, 
							BlockDec.MARCASITE.get().getDefaultState(), 33)).withPlacement(config_marcasite));
			
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, 
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, 
							BlockDec.UMBER.get().getDefaultState(), 33)).withPlacement(config_umber));
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
