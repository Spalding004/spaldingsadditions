package com.misterspalding.spaldingsadditions.slots;

import com.misterspalding.spaldingsadditions.fuels.LapalFuels;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotLapisFuel extends SlotItemHandler {
	   public SlotLapisFuel(IItemHandler handler, int index, int x, int y) {
	      super(handler, index, x, y);
	   }

	   public boolean fisItemValid(ItemStack stack) {
	      return LapalFuels.getFuelStr(stack) > 0.0D;
	   }
	}
