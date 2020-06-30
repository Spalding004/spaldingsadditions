package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.containers.FabricatorContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@SuppressWarnings("unused")
public class ContainersDec {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, SpaldingsAdditions.MOD_ID);
	
	
	public static final RegistryObject<ContainerType<FabricatorContainer>> FABRICATOR = CONTAINERS
			.register("fabricator_container", () -> IForgeContainerType.create(FabricatorContainer::new));
	
}
