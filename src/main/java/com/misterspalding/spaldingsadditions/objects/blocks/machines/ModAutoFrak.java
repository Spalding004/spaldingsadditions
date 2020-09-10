package com.misterspalding.spaldingsadditions.objects.blocks.machines;

import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.tileentities.machines.AutoFrakTileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ModAutoFrak extends MachineCommon {

	 public ModAutoFrak() {
	       
	    }
	 
	 @Nullable
	    @Override
	    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
	        return new AutoFrakTileEntity();
	    }
	 
	 @Override
		public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
			if (state.getBlock() != newState.getBlock()) {
				TileEntity te = worldIn.getTileEntity(pos);
				if (te instanceof AutoFrakTileEntity) {
					InventoryHelper.dropItems(worldIn, pos, ((AutoFrakTileEntity) te).getItems());
					worldIn.removeTileEntity(pos);
				}
			}
		}
	 
	 @Override
	    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
	        return 0;
	    }
}
