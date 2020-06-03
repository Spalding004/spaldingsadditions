package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.blocks.ModOre;
import com.misterspalding.spaldingsadditions.blocks.ModStone;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD)	
@ObjectHolder(Main.MOD_ID)
public class BlockDec {
	
	public static final ModStone marcasite = null;
	public static final ModStone marcasite_smooth = null;
	public static final ModStone shale = null;
	public static final ModStone shale_smooth = null;
	public static final ModStone apatite = null;
	public static final ModStone apatite_smooth = null;
	
	public static final ModStone pumice = null;
	
	public static final ModOre vendar_ore = null;
	public static final ModOre vendar_ore_dense = null;
	

	//Blocks
	
	@SubscribeEvent 
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new ModStone("marcasite"));
		event.getRegistry().register(new ModStone("marcasite_smooth"));
		event.getRegistry().register(new ModStone("shale"));
		event.getRegistry().register(new ModStone("shale_smooth"));
	
		event.getRegistry().register(new ModStone("apatite"));
		event.getRegistry().register(new ModStone("apatite_smooth"));

		event.getRegistry().register(new ModStone("pumice"));
		
		event.getRegistry().register(new ModOre("vendar_ore", 3));
		event.getRegistry().register(new ModOre("vendar_ore_dense", 3));
	
	}
	
	
	//ItemBlocks
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ModItemBlock(marcasite));
		event.getRegistry().register(new ModItemBlock(marcasite_smooth));
		event.getRegistry().register(new ModItemBlock(shale));
		event.getRegistry().register(new ModItemBlock(shale_smooth));
		
		event.getRegistry().register(new ModItemBlock(apatite));
		event.getRegistry().register(new ModItemBlock(apatite_smooth));

		event.getRegistry().register(new ModItemBlock(pumice));
		
		event.getRegistry().register(new ModItemBlock(vendar_ore));
		event.getRegistry().register(new ModItemBlock(vendar_ore_dense));
		
	}
	
	
	
}
