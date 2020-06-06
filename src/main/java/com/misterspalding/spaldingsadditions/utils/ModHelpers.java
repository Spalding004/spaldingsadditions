package com.misterspalding.spaldingsadditions.utils;

import java.util.Random;

import net.minecraft.util.math.BlockPos;

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
	
}
