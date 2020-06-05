package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.blocks.ModFenceBlock;
import com.misterspalding.spaldingsadditions.blocks.ModOre;
import com.misterspalding.spaldingsadditions.blocks.ModPlanks;
import com.misterspalding.spaldingsadditions.blocks.ModStairsBlockWood;
import com.misterspalding.spaldingsadditions.blocks.ModStone;
import net.minecraft.block.Block;
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
	
	public static final RegistryObject<Block> PUMICE = BLOCKS.register("pumice", () -> new ModStone());
	
	
	//ores
	public static final RegistryObject<Block> VENDAR_ORE = BLOCKS.register("vendar_ore", () -> new ModOre(3));
	public static final RegistryObject<Block> VENDAR_ORE_DENSE = BLOCKS.register("vendar_ore_dense", () -> new ModOre(3));
	
	//wood
	public static final RegistryObject<Block> BEECH_PLANKS = BLOCKS.register("beech_planks", () -> new ModPlanks());
	public static final RegistryObject<Block> BEECH_STAIRS = BLOCKS.register("beech_stairs", () -> new ModStairsBlockWood(BlockDec.BEECH_PLANKS.get()));
	public static final RegistryObject<Block> BEECH_FENCE = BLOCKS.register("beech_fence", () -> new ModFenceBlock());
	
	
	public static final RegistryObject<Block> PALM_PLANKS = BLOCKS.register("palm_planks", () -> new ModPlanks());
	public static final RegistryObject<Block> YEW_PLANKS = BLOCKS.register("yew_planks", () -> new ModPlanks());
	
	public static final RegistryObject<Block> PETRIFIED_PLANKS = BLOCKS.register("petrified_planks", () -> new ModStone());
}
