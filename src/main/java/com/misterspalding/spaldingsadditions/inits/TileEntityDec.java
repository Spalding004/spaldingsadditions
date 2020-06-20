package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.tileentities.FabricatorTile;
import com.misterspalding.spaldingsadditions.tileentities.PalmChestTile;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class TileEntityDec {
	
	public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, SpaldingsAdditions.MOD_ID);
	 
	public static final RegistryObject<TileEntityType<FabricatorTile>> FABRICATOR = TILES
			.register("fabricator", () -> TileEntityType.Builder.create(FabricatorTile::new, BlockDec.FABRICATOR.get()).build(null));
	
	public static final RegistryObject<TileEntityType<PalmChestTile>> PALM_CHEST = TILES
			.register("palm_chest", () -> TileEntityType.Builder.create(PalmChestTile::new, BlockDec.PALM_CHEST.get()).build(null));
	
}
