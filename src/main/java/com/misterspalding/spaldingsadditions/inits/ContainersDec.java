package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.containers.PalmChestContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@SuppressWarnings("unused")
public class ContainersDec {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, SpaldingsAdditions.MOD_ID);
	
	public static final RegistryObject<ContainerType<PalmChestContainer>> PALM_CHEST = CONTAINERS
			.register("palm_chest", () -> IForgeContainerType.create(PalmChestContainer::new));
	
}
