package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.objects.items.ModDimensionalCard;
import com.misterspalding.spaldingsadditions.objects.items.ModFrakHammer;
import com.misterspalding.spaldingsadditions.objects.items.ModGenericItem;
import com.misterspalding.spaldingsadditions.objects.items.ModNetherGaze;
import com.misterspalding.spaldingsadditions.objects.items.ModNetherPearl;
import com.misterspalding.spaldingsadditions.objects.items.toolTiers.ModTiers.ModItemTiers;
import com.misterspalding.spaldingsadditions.objects.items.tools.ModAxe;
import com.misterspalding.spaldingsadditions.objects.items.tools.ModHoe;
import com.misterspalding.spaldingsadditions.objects.items.tools.ModPickaxe;
import com.misterspalding.spaldingsadditions.objects.items.tools.ModShovel;
import com.misterspalding.spaldingsadditions.objects.items.tools.ModSword;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ItemDec {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, SpaldingsAdditions.MOD_ID);
	 
	//metal items
	
	public static final RegistryObject<Item> UMBER_GOLD_CHUNK = ITEMS.register("umber_gold_chunk", () -> new ModGenericItem());
	public static final RegistryObject<Item> VENDAR_CHUNK = ITEMS.register("vendar_chunk", () -> new ModGenericItem());
	public static final RegistryObject<Item> VENDAR_INGOT = ITEMS.register("vendar_ingot", () -> new ModGenericItem());
	public static final RegistryObject<Item> VENDAR_NUGGET = ITEMS.register("vendar_nugget", () -> new ModGenericItem());
	public static final RegistryObject<Item> GELDAR_NUGGET = ITEMS.register("geldar_nugget", () -> new ModGenericItem());
	public static final RegistryObject<Item> VIRONIUM_NUGGET = ITEMS.register("vironium_nugget", () -> new ModGenericItem());
	public static final RegistryObject<Item> GELDAR_INGOT = ITEMS.register("geldar_ingot", () -> new ModGenericItem());
	public static final RegistryObject<Item> VIRONIUM_INGOT = ITEMS.register("vironium_ingot", () -> new ModGenericItem());
	
	public static final RegistryObject<Item> IRON_CHUNK = ITEMS.register("iron_chunk", () -> new ModGenericItem());
	public static final RegistryObject<Item> GOLD_CHUNK = ITEMS.register("gold_chunk", () -> new ModGenericItem());
	public static final RegistryObject<Item> GELDAR_CHUNK = ITEMS.register("geldar_ore_chunk", () -> new ModGenericItem());
	public static final RegistryObject<Item> VIRONIUM_CHUNK = ITEMS.register("vironium_ore_chunk", () -> new ModGenericItem());

	public static final RegistryObject<Item> END_ESSENCE = ITEMS.register("end_essence", () -> new ModGenericItem());
	public static final RegistryObject<Item> NETHER_PEARL = ITEMS.register("nether_pearl", () -> new ModNetherPearl());
	public static final RegistryObject<Item> NETHER_GAZE = ITEMS.register("nether_gaze", () -> new ModNetherGaze());
	
	public static final RegistryObject<Item> CHARGED_CARBON = ITEMS.register("charged_carbon", () -> new ModGenericItem());
	public static final RegistryObject<Item> ENERGETIC_CRYSTAL = ITEMS.register("energetic_crystal", () -> new ModGenericItem());
	public static final RegistryObject<Item> REPLICATING_CRYSTAL = ITEMS.register("replicating_crystal", () -> new ModGenericItem());

	public static final RegistryObject<Item> INERT_CRYSTAL = ITEMS.register("inert_crystal", () -> new ModGenericItem());
	
	public static final RegistryObject<Item> FRACTURED_LAPIS = ITEMS.register("fractured_lapis", () -> new ModGenericItem());
	public static final RegistryObject<Item> LAPIS_SHARD = ITEMS.register("lapis_shard", () -> new ModGenericItem());
	
	public static final RegistryObject<Item> INDIRIUM_CHUNK = ITEMS.register("indirium_chunk", () -> new ModGenericItem());
	public static final RegistryObject<Item> INDIRIUM_INGOT = ITEMS.register("indirium_ingot", () -> new ModGenericItem());
	public static final RegistryObject<Item> INDIRIUM_NUGGET = ITEMS.register("indirium_nugget", () -> new ModGenericItem());
	
	public static final RegistryObject<Item> REDUCED_LAPIS_NUGGET = ITEMS.register("reduced_lapis_nugget", () -> new ModGenericItem());
	public static final RegistryObject<Item> REDUCED_LAPIS_INGOT = ITEMS.register("reduced_lapis_ingot", () -> new ModGenericItem());
	
	//tools
	public static final RegistryObject<Item> TOOL_ENHANCED_HANDLE = ITEMS.register("tool_enhanced_handle", () -> new ModGenericItem());
	
	public static final RegistryObject<Item> TOOL_VENDAR_PICKAXE = ITEMS.register("tool_vendar_pickaxe", () -> new ModPickaxe(ModItemTiers.VENDAR));
	public static final RegistryObject<Item> TOOL_VENDAR_SWORD = ITEMS.register("tool_vendar_sword", () -> new ModSword(ModItemTiers.VENDAR));
	public static final RegistryObject<Item> TOOL_VENDAR_AXE = ITEMS.register("tool_vendar_axe", () -> new ModAxe(ModItemTiers.VENDAR));
	public static final RegistryObject<Item> TOOL_VENDAR_HOE = ITEMS.register("tool_vendar_hoe", () -> new ModHoe(ModItemTiers.VENDAR));
	public static final RegistryObject<Item> TOOL_VENDAR_SHOVEL = ITEMS.register("tool_vendar_shovel", () -> new ModShovel(ModItemTiers.VENDAR));
	
	public static final RegistryObject<Item> TOOL_VENDAR_FRAKHAMMER = ITEMS.register("tool_vendar_frakhammer", () -> new ModFrakHammer(512));
	public static final RegistryObject<Item> IRON_FRAKHAMMER = ITEMS.register("iron_frakhammer", () -> new ModFrakHammer(126));
	
	
	
	//other items
	public static final RegistryObject<Item> CARD_BASIC = ITEMS.register("card_basic", () -> new ModDimensionalCard(64));
	public static final RegistryObject<Item> CARD_NETHER = ITEMS.register("card_nether", () -> new ModDimensionalCard(48));
	public static final RegistryObject<Item> CARD_END = ITEMS.register("card_end", () -> new ModDimensionalCard(48));
	
	public static final RegistryObject<Item> POLISHING_STONE = ITEMS.register("polishing_stone", () -> new ModGenericItem());
	
	
	

}
