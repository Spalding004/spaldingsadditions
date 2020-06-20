package com.misterspalding.spaldingsadditions.blocks.machines;

import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.inits.TileEntityDec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ModFabricator extends ModMachine {

	public ModFabricator() {	
		
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world){
		
		return TileEntityDec.FABRICATOR.get().create();
		
	}
	
	 @Override
	    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
	        if (entity != null) {
	            world.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, entity)), 2);
	        }
	    }
	
	public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
        Vec3d vec = entity.getPositionVec();
        return Direction.getFacingFromVector((float) (vec.x - clickedBlock.getX()), (float) (vec.y - clickedBlock.getY()), (float) (vec.z - clickedBlock.getZ()));
    }
	
	@Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }
}
	

