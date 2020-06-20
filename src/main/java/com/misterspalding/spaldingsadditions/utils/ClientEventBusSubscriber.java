package com.misterspalding.spaldingsadditions.utils;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.client.gui.PalmChestScreen;
import com.misterspalding.spaldingsadditions.inits.ContainersDec;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SpaldingsAdditions.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	
	
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
		registerCutouts();
		ScreenManager.registerFactory(ContainersDec.PALM_CHEST.get(), PalmChestScreen::new);
		
	}
	
	public static void registerCutouts() {
		
		
		int len = SpaldingsAdditions.CUT_OUT_BLOCKS.size();
		
		for (int x = 0; x < len; x++) {
			
			RenderTypeLookup.setRenderLayer(SpaldingsAdditions.CUT_OUT_BLOCKS.get(x), RenderType.getCutout());
			
		}
		
	}
}
