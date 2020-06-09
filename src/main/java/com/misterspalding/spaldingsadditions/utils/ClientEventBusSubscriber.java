package com.misterspalding.spaldingsadditions.utils;

import com.misterspalding.spaldingsadditions.Main;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
		registerCutouts();
		
		
	}
	
	public static void registerCutouts() {
		
		
		int len = Main.CUT_OUT_BLOCKS.size();
		
		for (int x = 0; x < len; x++) {
			
			RenderTypeLookup.setRenderLayer(Main.CUT_OUT_BLOCKS.get(x), RenderType.getCutout());
			
		}
		
	}
}
