package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.blocks.ModEndcroachment;
import com.misterspalding.spaldingsadditions.blocks.ModEndfectedOre;
import com.misterspalding.spaldingsadditions.blocks.ModEndfection;
import com.misterspalding.spaldingsadditions.blocks.ModFenceBlock;
import com.misterspalding.spaldingsadditions.blocks.ModLeaves;
import com.misterspalding.spaldingsadditions.blocks.ModLogs;
import com.misterspalding.spaldingsadditions.blocks.ModOre;
import com.misterspalding.spaldingsadditions.blocks.ModPlanks;
import com.misterspalding.spaldingsadditions.blocks.ModSapling;
import com.misterspalding.spaldingsadditions.blocks.ModStairsBlockStone;
import com.misterspalding.spaldingsadditions.blocks.ModStairsBlockWood;
import com.misterspalding.spaldingsadditions.blocks.ModStone;
import com.misterspalding.spaldingsadditions.blocks.ModWallBlock;
import com.misterspalding.spaldingsadditions.world.feature.ModTree;
import com.misterspalding.spaldingsadditions.world.gen.features.FeatureYewTree;
import com.misterspalding.spaldingsadditions.world.gen.features.YewTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class BlockDec {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Main.MOD_ID);
	 
	//begin blocks
	
	
	//stones
	public static final RegistryObject<Block> MARCASITE = BLOCKS.register("marcasite", () -> new ModStone());
	public static final RegistryObject<Block> MARCASITE_SMOOTH = BLOCKS.register("marcasite_smooth", () -> new ModStone());
	
	public static final RegistryObject<Block> SHALE = BLOCKS.register("shale", () -> new ModStone());
	public static final RegistryObject<Block> SHALE_SMOOTH = BLOCKS.register("shale_smooth", () -> new ModStone());
	
	public static final RegistryObject<Block> APATITE = BLOCKS.register("apatite", () -> new ModStone());
	public static final RegistryObject<Block> APATITE_SMOOTH = BLOCKS.register("apatite_smooth", () -> new ModStone());
	
	public static final RegistryObject<Block> MIXED_STONE = BLOCKS.register("mixed_stone", () -> new ModStone());
	public static final RegistryObject<Block> MIXED_STONE_STAIRS = BLOCKS.register("mixed_stone_stairs", () -> new ModStairsBlockStone(BlockDec.MIXED_STONE.get()));
	public static final RegistryObject<Block> MIXED_STONE_WALL = BLOCKS.register("mixed_stone_wall", () -> new ModWallBlock());

	
	public static final RegistryObject<Block> ALUNITE = BLOCKS.register("alunite", () -> new ModStone());
	public static final RegistryObject<Block> ALUNITE_SMOOTH = BLOCKS.register("alunite_smooth", () -> new ModStone());
	
	public static final RegistryObject<Block> UMBER = BLOCKS.register("umber", () -> new ModStone());
	public static final RegistryObject<Block> UMBER_SMOOTH = BLOCKS.register("umber_smooth", () -> new ModStone());
	
	public static final RegistryObject<Block> CORMALITE = BLOCKS.register("cormalite", () -> new ModStone());
	public static final RegistryObject<Block> CORMALITE_SMOOTH = BLOCKS.register("cormalite_smooth", () -> new ModStone());
	
	public static final RegistryObject<Block> PUMICE = BLOCKS.register("pumice", () -> new ModStone());
	
	public static final RegistryObject<Block> ENDCROACHED_NETHERRACK = BLOCKS.register("endcroached_netherrack", () -> new ModEndcroachment());
	public static final RegistryObject<Block> ENDFECTED_NETHERRACK_A = BLOCKS.register("endfected_netherrack_a", () -> new ModEndfection("A"));
	public static final RegistryObject<Block> ENDFECTED_NETHERRACK_B = BLOCKS.register("endfected_netherrack_b", () -> new ModEndfection("B"));
	public static final RegistryObject<Block> ENDFECTED_NETHERRACK_C = BLOCKS.register("endfected_netherrack_c", () -> new ModEndfection("C"));
	public static final RegistryObject<Block> ENDFECTED_NETHER_QUARTZ_ORE = BLOCKS.register("endfected_nether_quartz_ore", () -> new ModEndfectedOre());
	
	
	//ores
	public static final RegistryObject<Block> VENDAR_ORE = BLOCKS.register("vendar_ore", () -> new ModOre(3));
	public static final RegistryObject<Block> VENDAR_ORE_DENSE = BLOCKS.register("vendar_ore_dense", () -> new ModOre(3));
	public static final RegistryObject<Block> UMBER_GOLD_ORE = BLOCKS.register("umber_gold_ore", () -> new ModOre(2));
	
	//wood
	

	public static final RegistryObject<Block> BEECH_LOG = BLOCKS.register("beech_log", () -> new ModLogs());
	public static final RegistryObject<Block> BEECH_PLANKS = BLOCKS.register("beech_planks", () -> new ModPlanks());
	public static final RegistryObject<Block> BEECH_STAIRS = BLOCKS.register("beech_stairs", () -> new ModStairsBlockWood(BlockDec.BEECH_PLANKS.get()));
	public static final RegistryObject<Block> BEECH_FENCE = BLOCKS.register("beech_fence", () -> new ModFenceBlock());
	
	public static final RegistryObject<Block> PALM_LOG = BLOCKS.register("palm_log", () -> new ModLogs());
	public static final RegistryObject<Block> PALM_PLANKS = BLOCKS.register("palm_planks", () -> new ModPlanks());
	public static final RegistryObject<Block> PALM_STAIRS = BLOCKS.register("palm_stairs", () -> new ModStairsBlockWood(BlockDec.PALM_PLANKS.get()));
	public static final RegistryObject<Block> PALM_FENCE = BLOCKS.register("palm_fence", () -> new ModFenceBlock());
	
	public static final RegistryObject<Block> YEW_LOG = BLOCKS.register("yew_log", () -> new ModLogs());
	public static final RegistryObject<Block> YEW_PLANKS = BLOCKS.register("yew_planks", () -> new ModPlanks());
	public static final RegistryObject<Block> YEW_STAIRS = BLOCKS.register("yew_stairs", () -> new ModStairsBlockWood(BlockDec.YEW_PLANKS.get()));
	public static final RegistryObject<Block> YEW_FENCE = BLOCKS.register("yew_fence", () -> new ModFenceBlock());
	public static final RegistryObject<Block> YEW_LEAVES = BLOCKS.register("yew_leaves", () -> new ModLeaves());
	public static final RegistryObject<Block> YEW_SAPLING = BLOCKS.register("yew_sapling", () -> new ModSapling(() -> new YewTree()));
	
	public static final RegistryObject<Block> PETRIFIED_PLANKS = BLOCKS.register("petrified_planks", () -> new ModStone());
	public static final RegistryObject<Block> PETRIFIED_STAIRS = BLOCKS.register("petrified_stairs", () -> new ModStairsBlockStone(BlockDec.PETRIFIED_PLANKS.get()));
	public static final RegistryObject<Block> PETRIFIED_WALL = BLOCKS.register("petrified_wall", () -> new ModWallBlock());
}
