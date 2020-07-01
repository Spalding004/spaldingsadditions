package com.misterspalding.spaldingsadditions.objects.blocks.machines;

import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.tileentities.FabricatorTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ModFabricator extends ModMachine {

	 public ModFabricator() {
	       
	    }
	 
	 @Nullable
	    @Override
	    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
	        return new FabricatorTileEntity();
	    }
	 
	 @Override
		public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
			if (state.getBlock() != newState.getBlock()) {
				TileEntity te = worldIn.getTileEntity(pos);
				if (te instanceof FabricatorTileEntity) {
					InventoryHelper.dropItems(worldIn, pos, ((FabricatorTileEntity) te).getItems());
				}
			}
		}
	 
	 @Override
	    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
	        return 0;
	    }
}
