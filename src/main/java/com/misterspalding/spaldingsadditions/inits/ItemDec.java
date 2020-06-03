package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.Main.ModItemGroup;
import com.misterspalding.spaldingsadditions.items.tier.ModTiers.ModItemTiers;
import com.misterspalding.spaldingsadditions.items.tools.ModAxe;
import com.misterspalding.spaldingsadditions.items.tools.ModHoe;
import com.misterspalding.spaldingsadditions.items.tools.ModPickaxe;
import com.misterspalding.spaldingsadditions.items.tools.ModShovel;
import com.misterspalding.spaldingsadditions.items.tools.ModSword;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD)	
@ObjectHolder(Main.MOD_ID)
public class ItemDec {
	
	public static final Item vendar_chunk = null;
	public static final Item polishing_stone = null;
	
	public static final Item vendar_nugget = null;
	public static final Item vendar_ingot = null;
	
	public static final Item tool_enhanced_handle = null;
	
	public static final Item tool_vendar_pickaxe = null;
	public static final Item tool_vendar_axe = null;
	public static final Item tool_vendar_hoe = null;
	public static final Item tool_vendar_shovel = null;
	public static final Item tool_vendar_sword = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		
		event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroup.instance)).setRegistryName("vendar_chunk"));
		event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroup.instance)).setRegistryName("polishing_stone"));
		event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroup.instance)).setRegistryName("vendar_nugget"));
		event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroup.instance)).setRegistryName("vendar_ingot"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(ModItemGroup.instance)).setRegistryName("tool_enhanced_handle"));
		
		event.getRegistry().register(new ModPickaxe("tool_vendar_pickaxe", ModItemTiers.VENDAR));
		event.getRegistry().register(new ModAxe("tool_vendar_axe", ModItemTiers.VENDAR));
		event.getRegistry().register(new ModHoe("tool_vendar_hoe", ModItemTiers.VENDAR));
		event.getRegistry().register(new ModShovel("tool_vendar_shovel", ModItemTiers.VENDAR));
		event.getRegistry().register(new ModSword("tool_vendar_sword", ModItemTiers.VENDAR));
		
	}
	

}
