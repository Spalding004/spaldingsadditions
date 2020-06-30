package com.misterspalding.spaldingsadditions.fuels;

import java.util.ArrayList;
import java.util.List;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.ItemDec;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class LapalFuels {

	public static double getFuelStr(ItemStack fuel) {
		Item item = fuel.getItem();
		double str = 0.0D;
		if (item == (Items.LAPIS_LAZULI).getItem()) {
			str = 1.0D;
		}

		if (item == (new ItemStack(Blocks.LAPIS_BLOCK)).getItem()) {
			str = 10.0D;
		}

		if (item == (ItemDec.REDUCED_LAPIS_INGOT.get())) {
			str = 2.5D;
		}

		if (item == (ItemDec.ENERGETIC_CRYSTAL.get())) {
			str = 10.0D;
		}

		if (item == (ItemDec.CHARGED_CARBON.get())) {
			str = 75.0D;
		}

		return str * 100;
	}
}
