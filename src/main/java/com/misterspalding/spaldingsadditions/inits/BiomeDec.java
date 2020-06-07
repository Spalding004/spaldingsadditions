package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.world.biomes.nether.BiomeEndfection;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeDec {

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Main.MOD_ID);
	
	public static final RegistryObject<Biome> NETHER_ENDFECTION = BIOMES.register("nether_endfection", () -> new BiomeEndfection());
	
	public static void registerBiomes() {
		
		registerBiome(NETHER_ENDFECTION.get(), 20, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.NETHER);
	}
	
	private static void registerBiome(Biome biome, int weight, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
		
		
		BiomeManager.addBiome(type, new BiomeEntry(biome, weight));
		BiomeDictionary.addTypes(biome, types);
		
		
	}
}
