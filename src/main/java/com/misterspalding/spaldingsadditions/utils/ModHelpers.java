package com.misterspalding.spaldingsadditions.utils;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ModHelpers {

	
	
	public static BlockPos getRandomAdjacentBlock(BlockPos pos) {
		Random rand = new Random();
		int checkLayer = rand.nextInt(3);
		
		switch (checkLayer) {
		case 0:
			pos = pos.up();
			break;
		case 1:
			break;
		case 2: 
			pos = pos.down();
		default: 
		
		}
		
		int checkCompass = rand.nextInt(9);
		switch (checkCompass) {
		case 0: 
			pos = pos.east();
			break;
		case 1: 
			pos = pos.east().north();
			break;
		case 2: 
			pos = pos.north();
			break;
		case 3: 
			pos = pos.north().west();
			break;
		case 4: 
			pos = pos.west();
			break;
		case 5: 
			pos = pos.south().west();
			break;
		case 6: 
			pos = pos.south();
			break;
		case 7: 
			pos = pos.south().east();
			break;
		case 8: 
			
			break;
		default:
			
		}
		return pos;
	}
	
	
	  public static int getGroundFromAbove(IWorld world, int x, int z) {
          int y = 255;

          Block blockAt;
          for(boolean foundGround = false; !foundGround && y-- >= 0; foundGround = blockAt == Blocks.GRASS_BLOCK) {
             blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();
          }

          return y;
       }
	
	  public static int getGroundFromAboveNether(IWorld world, int x, int z) {
          int y = 65;

          Block blockAt;
          for(boolean foundGround = false; !foundGround && y-- >= 0; foundGround = blockAt == Blocks.NETHERRACK) {
             blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();
          }

          return y;
       }
	
}
