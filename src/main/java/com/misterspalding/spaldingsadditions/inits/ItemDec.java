package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.items.ModGenericItem;
import com.misterspalding.spaldingsadditions.items.tier.ModTiers.ModItemTiers;
import com.misterspalding.spaldingsadditions.items.tools.ModAxe;
import com.misterspalding.spaldingsadditions.items.tools.ModHoe;
import com.misterspalding.spaldingsadditions.items.tools.ModPickaxe;
import com.misterspalding.spaldingsadditions.items.tools.ModShovel;
import com.misterspalding.spaldingsadditions.items.tools.ModSword;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ItemDec {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Main.MOD_ID);
	 
	//metal items
	
	public static final RegistryObject<Item> VENDAR_CHUNK = ITEMS.register("vendar_chunk", () -> new ModGenericItem());
	public static final RegistryObject<Item> VENDAR_INGOT = ITEMS.register("vendar_ingot", () -> new ModGenericItem());
	public static final RegistryObject<Item> VENDAR_NUGGET = ITEMS.register("vendar_nugget", () -> new ModGenericItem());
	
	//tools
	public static final RegistryObject<Item> TOOL_ENHANCED_HANDLE = ITEMS.register("tool_enhanced_handle", () -> new ModGenericItem());
	
	public static final RegistryObject<Item> TOOL_VENDAR_PICKAXE = ITEMS.register("tool_vendar_pickaxe", () -> new ModPickaxe(ModItemTiers.VENDAR));
	public static final RegistryObject<Item> TOOL_VENDAR_SWORD = ITEMS.register("tool_vendar_sword", () -> new ModSword(ModItemTiers.VENDAR));
	public static final RegistryObject<Item> TOOL_VENDAR_AXE = ITEMS.register("tool_vendar_axe", () -> new ModAxe(ModItemTiers.VENDAR));
	public static final RegistryObject<Item> TOOL_VENDAR_HOE = ITEMS.register("tool_vendar_hoe", () -> new ModHoe(ModItemTiers.VENDAR));
	public static final RegistryObject<Item> TOOL_VENDAR_SHOVEL = ITEMS.register("tool_vendar_shovel", () -> new ModShovel(ModItemTiers.VENDAR));
	
	
	
	//other items
	
	public static final RegistryObject<Item> POLISHING_STONE = ITEMS.register("polishing_stone", () -> new ModGenericItem());
	
	
	

}
