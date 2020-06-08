package com.misterspalding.spaldingsadditions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.misterspalding.spaldingsadditions.inits.BiomeDec;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.DamagesDec;
import com.misterspalding.spaldingsadditions.inits.ItemDec;
import com.misterspalding.spaldingsadditions.world.gen.ModStoneGen;
import com.misterspalding.spaldingsadditions.world.gen.features.FeatureYewTree;
import com.misterspalding.spaldingsadditions.world.gen.features.FeatureYewTreeConfig;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("spaldingsadditions")
@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD)
public class Main
{
    @SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "spaldingsadditions";
    public static Main instance;
    
    public static Feature<FeatureYewTreeConfig> FEATURE_YEW_TREE = new FeatureYewTree(FeatureYewTreeConfig::deserialize);

    
    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public Main() {
        
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::enqueueIMC);
    	modEventBus.addListener(this::processIMC);
    	modEventBus.addListener(this::doClientStuff);
        
    	DamagesDec.initDamages();
    	
    	ItemDec.ITEMS.register(modEventBus);
    	BlockDec.BLOCKS.register(modEventBus);
    	//TileEntities go here
    	
    	  
    	BiomeDec.BIOMES.register(modEventBus);
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    	
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	BlockDec.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->  {
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
    
    private void setup(final FMLCommonSetupEvent event)
    {
       
      
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
       
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
   //     InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
      /*  LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
                */
    }
    
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
      
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	
    	ModStoneGen.GenerateOre();
    	
    }
    
    @SubscribeEvent
	  public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
	    IForgeRegistry<Feature<?>> registry = event.getRegistry();
	    registry.register(FEATURE_YEW_TREE.setRegistryName(Main.MOD_ID, "yew_tree"));
	  }
    
    public static class ModItemGroup extends ItemGroup {
    	
    	private ModItemGroup(int index, String label) {
    		
    		super(index, label);
    		
    	}
    	
    	@Override
    	public ItemStack createIcon() {
    		
    		return new ItemStack(ItemDec.POLISHING_STONE.get());
    		
    	}
    	
    	public static final ModItemGroup instance = new ModItemGroup(ItemGroup.GROUPS.length, "mod_creative_tab");
    	
    }
    
    

}
