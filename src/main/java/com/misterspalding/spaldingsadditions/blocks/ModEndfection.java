package com.misterspalding.spaldingsadditions.blocks;

import java.util.Random;

import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.DamagesDec;
import com.misterspalding.spaldingsadditions.utils.ModHelpers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class ModEndfection extends Block {

	private String type;
	
	public ModEndfection(String type) {
		super(Block.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(.4F, .4F)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(0)
				.tickRandomly()
				.lightValue(7)
				);
		
		this.type = type;
		
	}
	
	
	@Override
	 public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		
		if (!worldIn.getBlockState(pos.up()).isAir(worldIn, pos)) {
			
			worldIn.setBlockState(pos, BlockDec.ENDCROACHED_NETHERRACK.get().getDefaultState());
			
		}
		
		switch (type) {
		
		
		case "C":
			//case C endfections do not spread.
			break;
		default:
			spreadEnfection(state, worldIn, pos, rand, type);

			spreadEnfection(state, worldIn, pos, rand, type);
		}
		
	}
	
	public void spreadEnfection(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand, String type) {
		
	//	int spread_check = rand.nextInt(20);
		
		BlockPos target_pos = ModHelpers.getRandomAdjacentBlock(pos);
		
	//	if (spread_check < 3) {
		
			if (worldIn.getBlockState(target_pos).getBlock() == Blocks.NETHERRACK) {
			
				worldIn.setBlockState(target_pos, BlockDec.ENDCROACHED_NETHERRACK.get().getDefaultState());
			
			}
		
			if (worldIn.getBlockState(target_pos).getBlock() == Blocks.NETHER_QUARTZ_ORE) {
			
				worldIn.setBlockState(target_pos, BlockDec.ENDFECTED_NETHER_QUARTZ_ORE.get().getDefaultState());
			
		//	}
		}
		
	}
	
	@OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	      	int chance = rand.nextInt(25);
		
			if (chance == 1) {
	         spawnParticles(worldIn, pos);
	      }

	   }
	
	private void spawnParticles(World worldIn, BlockPos pos) {
	      Random random = worldIn.rand;
	      for(int i = 0; i < 6; ++i) {
	         double d1 = (double)((float)pos.getX() + random.nextFloat());
	         double d2 = (double)((float)pos.getY() + random.nextFloat());
	         double d3 = (double)((float)pos.getZ() + random.nextFloat());
	         if (i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube(worldIn, pos)) {
	            d2 = (double)pos.getY() + 0.0625D + 1.0D;
	         }

	         if (i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube(worldIn, pos)) {
	            d2 = (double)pos.getY() - 0.0625D;
	         }

	         if (i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube(worldIn, pos)) {
	            d3 = (double)pos.getZ() + 0.0625D + 1.0D;
	         }

	         if (i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube(worldIn, pos)) {
	            d3 = (double)pos.getZ() - 0.0625D;
	         }

	         if (i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube(worldIn, pos)) {
	            d1 = (double)pos.getX() + 0.0625D + 1.0D;
	         }

	         if (i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube(worldIn, pos)) {
	            d1 = (double)pos.getX() - 0.0625D;
	         }

	         if (d1 < (double)pos.getX() || d1 > (double)(pos.getX() + 1) || d2 < 0.0D || d2 > (double)(pos.getY() + 1) || d3 < (double)pos.getZ() || d3 > (double)(pos.getZ() + 1)) {
	            worldIn.addParticle(ParticleTypes.PORTAL, d1, d2, d3, 0.0D, -0.4D, 0.0D);
	         }
	      }
	}
	
	@Override
	public void onEntityWalk(World world, BlockPos pos, Entity entity) {
		entity.attackEntityFrom(DamagesDec.VOID_WALKING, 2.0F);
	}
	
}
