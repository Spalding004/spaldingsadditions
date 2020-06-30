package com.misterspalding.spaldingsadditions.objects.blocks.machines;

import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.inits.TileEntityDec;
import com.misterspalding.spaldingsadditions.tileentities.FabricatorTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ModFabricator extends ModMachine {

	public ModFabricator() {	
		
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity te = worldIn.getTileEntity(pos);
			if (te instanceof FabricatorTile) {
				InventoryHelper.dropItems(worldIn, pos, ((FabricatorTile) te).getItems());
			}
		}
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
	 
	 @Override
		public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
			if(world.isRemote) {
				return ActionResultType.SUCCESS;
			} else {
				TileEntity tile = world.getTileEntity(pos);
				if (tile instanceof FabricatorTile) {
					NetworkHooks.openGui((ServerPlayerEntity)player, (FabricatorTile)tile, pos);
					
				}
				return ActionResultType.SUCCESS;
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
	

