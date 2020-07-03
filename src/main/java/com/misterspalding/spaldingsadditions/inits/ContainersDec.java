package com.misterspalding.spaldingsadditions.inits;

import java.util.List;

import com.google.common.collect.Lists;
import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.containers.FabricatorContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;



@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SpaldingsAdditions.MOD_ID)
public class ContainersDec {
	
	private static final List<ContainerType<?>> CONTAINER_TYPES = Lists.newArrayList();
	
	
	public static final ContainerType<FabricatorContainer> FABRICATOR = register("fabricator", new ContainerType<>(FabricatorContainer::new));
	
	 private static <T extends ContainerType<?>> T register(String registryName, T containerType) {
	        containerType.setRegistryName(SpaldingsAdditions.MOD_ID+":"+registryName);
	        CONTAINER_TYPES.add(containerType);
	        return containerType;
	    }

	    @SubscribeEvent
	    public static void onBlockRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
	        CONTAINER_TYPES.forEach(event.getRegistry()::register);
	    }

	}
