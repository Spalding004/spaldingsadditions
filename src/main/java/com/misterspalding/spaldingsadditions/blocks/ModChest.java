package com.misterspalding.spaldingsadditions.blocks;

import com.misterspalding.spaldingsadditions.inits.TileEntityDec;
import com.misterspalding.spaldingsadditions.tileentities.PalmChestTile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ModChest extends Block {

	public ModChest() {
		super(Block.Properties
				.create(Material.WOOD)
				.hardnessAndResistance(1F, 1.5F)
				.harvestLevel(0)
				);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		
		return TileEntityDec.PALM_CHEST.get().create();
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
		if(!world.isRemote) {
			TileEntity tile = world.getTileEntity(pos);
			if (tile instanceof PalmChestTile) {
				NetworkHooks.openGui((ServerPlayerEntity)player, (PalmChestTile)tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.FAIL;
		
	}
	
	public void onReplace(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
		if(state.getBlock() != newState.getBlock()) {
			TileEntity te = world.getTileEntity(pos);
					if (te instanceof PalmChestTile)
						InventoryHelper.dropItems(world, pos, ((PalmChestTile) te).getItems());
		}
		
	}
	
}
