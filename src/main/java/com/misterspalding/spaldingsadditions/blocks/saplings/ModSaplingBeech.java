package com.misterspalding.spaldingsadditions.blocks.saplings;

import java.util.Random;
import java.util.function.Supplier;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.world.feature.tree.ModBeechTree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

public class ModSaplingBeech extends BushBlock implements IGrowable {
	
	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0D, 2.0D, 14.0D, 12.0D, 14.0D);
	
	private final Supplier<ModBeechTree> tree;
	
	public ModSaplingBeech(Supplier<ModBeechTree> tree) {
		super(Block.Properties.from(Blocks.OAK_SAPLING));
		this.tree = tree;
		this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, Integer.valueOf(0)));
		Main.CUT_OUT_BLOCKS.add(this);
	}

	public boolean canBeReplacedByLogs(BlockState state, IWorldReader world, BlockPos pos)
    {
        return (isAir(state, world, pos) || state.isIn(BlockTags.LEAVES)) || this == Blocks.GRASS_BLOCK || state.isIn(net.minecraftforge.common.Tags.Blocks.DIRT)
            || getBlock().isIn(BlockTags.LOGS) || getBlock().isIn(BlockTags.SAPLINGS) || this == Blocks.VINE;
    }
	
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		// TODO Auto-generated method stub
		return true;
	}

	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		// TODO Auto-generated method stub
		return SHAPE;
	}

	
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		return (double)worldIn.rand.nextFloat() < 0.45D;
	}

	
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		if(state.get(STAGE) == 0) {
			
			worldIn.setBlockState(pos, state.cycle(STAGE), 2);
			
		} else {
			if(!ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) {
				
				return;
				
			}
			//worldIn.removeBlock(pos, false);

		    worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState(), 1|2);
			this.tree.get().place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), pos, state, rand);
		}
		
	}



	@SuppressWarnings("deprecation")
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
