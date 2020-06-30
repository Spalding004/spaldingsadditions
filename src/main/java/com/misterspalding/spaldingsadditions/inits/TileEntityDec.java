package com.misterspalding.spaldingsadditions.inits;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.tileentities.FabricatorTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class TileEntityDec {
	
	public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, SpaldingsAdditions.MOD_ID);
	 
	public static final RegistryObject<TileEntityType<FabricatorTile>> FABRICATOR = TILES
			.register("fabricator", () -> TileEntityType.Builder.create(FabricatorTile::new, BlockDec.FABRICATOR.get()).build(null));
	
	
}
