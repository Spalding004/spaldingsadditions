package com.misterspalding.spaldingsadditions;

import java.util.ArrayList;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.misterspalding.spaldingsadditions.events.loot_modifiers.SpecialDropsModifier;
import com.misterspalding.spaldingsadditions.inits.BiomeDec;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.ContainersDec;
import com.misterspalding.spaldingsadditions.inits.DamagesDec;
import com.misterspalding.spaldingsadditions.inits.FeaturesDec;
import com.misterspalding.spaldingsadditions.inits.ItemDec;
import com.misterspalding.spaldingsadditions.inits.PlacementsDec;
import com.misterspalding.spaldingsadditions.inits.TileEntityDec;
import com.misterspalding.spaldingsadditions.recipes.RecipeDec;
import com.misterspalding.spaldingsadditions.tileentities.FabricatorTile;
import com.misterspalding.spaldingsadditions.world.gen.ModStoneGen;
import com.misterspalding.spaldingsadditions.world.gen.ModStructGen;
import com.misterspalding.spaldingsadditions.world.gen.ModTreeGen;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@SuppressWarnings("deprecation")
@Mod("spaldingsadditions")
@Mod.EventBusSubscriber(modid = SpaldingsAdditions.MOD_ID, bus = Bus.MOD)
public class SpaldingsAdditions {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "spaldingsadditions";
	public static SpaldingsAdditions instance;
	public static ArrayList<Block> CUT_OUT_BLOCKS = new ArrayList<Block>();

	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

	public SpaldingsAdditions() {

		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::enqueueIMC);
		modEventBus.addListener(this::processIMC);
		modEventBus.addListener(this::doClientStuff);

		DamagesDec.initDamages();

		ItemDec.ITEMS.register(modEventBus);
		BlockDec.BLOCKS.register(modEventBus);
		RecipeDec.RECIPE_SERIALIZERS.register(modEventBus);
		 TileEntityDec.TILES.register(modEventBus);
		 ContainersDec.CONTAINERS.register(modEventBus);

		BiomeDec.BIOMES.register(modEventBus);
		MinecraftForge.EVENT_BUS.register(PlacementsDec.ENDFECTION);
		instance = this;

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {

		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockDec.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(ModItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);

		});

	}

	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		BiomeDec.registerBiomes();

	}

	private void setup(final FMLCommonSetupEvent event) {

		DeferredWorkQueue.runLater(ModStoneGen::generateOre);
		DeferredWorkQueue.runLater(ModTreeGen::genTrees);
		DeferredWorkQueue.runLater(ModStructGen::genStructs);
	}

	private void doClientStuff(final FMLClientSetupEvent event) {

	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
		// InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello
		// world from the MDK"); return "Hello world";});
	}

	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
		/*
		 * LOGGER.info("Got IMC {}", event.getIMCStream().
		 * map(m->m.getMessageSupplier().get()). collect(Collectors.toList()));
		 */
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	@SubscribeEvent
	public static void registerModifierSerializers(
			@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {

		event.getRegistry().register(new SpecialDropsModifier.Serializer()
				.setRegistryName(new ResourceLocation(SpaldingsAdditions.MOD_ID, "special_drops")));

	}

	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
		/*
		 * 
		 * Apparently the correct way to to do this is to use a deferred work queue
		 * BUT...
		 * 
		 * That method is deprecated with no real info on what is going to replace it.
		 * We'll stick with this until it breaks.
		 * 
		 * 
		 * ModTreeGen.genTrees(); ModStoneGen.generateOre(); ModStructGen.genStructs();
		 *
		 * Update: it broke.
		 *
		 */
	}

	@SubscribeEvent
	public static void onRegisterFeatures(RegistryEvent.Register<Feature<?>> event) {
		FeaturesDec.register(event);
	}

	public static class ModItemGroup extends ItemGroup {

		private ModItemGroup(int index, String label) {

			super(index, label);

		}

		@Override
		public ItemStack createIcon() {

			return new ItemStack(ItemDec.FRACTURED_LAPIS.get());

		}

		public static final ModItemGroup instance = new ModItemGroup(ItemGroup.GROUPS.length, "mod_creative_tab");

	}

}
