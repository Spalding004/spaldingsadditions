package com.misterspalding.spaldingsadditions.blocks;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

public class ModSapling extends BushBlock implements IGrowable {
	
	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0D, 2.0D, 14.0D, 12.0D, 14.0D);
	
	private final Tree tree;
	
	public ModSapling (Tree tree) {
		super(Block.Properties.from(Blocks.OAK_SAPLING));
		this.tree = tree;
		
		
	}

	
	
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		// TODO Auto-generated method stub
		return SHAPE;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		if(state.get(STAGE) == 0) {
			
			worldIn.setBlockState(pos, state.cycle(STAGE), 4);
			
		} else {
			if(!ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) {
				
				return;
				
			}
			
			this.tree.place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), pos, state, rand);
		}
		
	}



	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		// TODO Auto-generated method stub
		super.tick(state, worldIn, pos, rand);
		if (!worldIn.isAreaLoaded(pos, 1)) {
			return;
		}
		if (worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
			
			this.grow(worldIn, rand, pos, state);
			
		}
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE);
		
	}
	

}
