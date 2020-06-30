package com.misterspalding.spaldingsadditions.interfaceHelpers;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

public class ModItemStackHandler extends ItemStackHandler {
	   public ModItemStackHandler() {
	      this(1);
	   }

	   public ModItemStackHandler(int size) {
	      super(size);
	   }

	   public ModItemStackHandler(NonNullList<ItemStack> stacks) {
	      super(stacks);
	   }

	   public void dropItems(World world, double x, double y, double z) {
	      for(int i = 0; i < this.stacks.size(); ++i) {
	         if (!((ItemStack)this.stacks.get(i)).isEmpty()) {
	            ItemEntity entityitem = new ItemEntity(world, x, y, z, (ItemStack)this.stacks.get(i));
	            entityitem.setDefaultPickupDelay();
	            world.addEntity(entityitem);
	            this.stacks.set(i, ItemStack.EMPTY);
	         }
	      }

	   }

	   public NonNullList<ItemStack> getStacks() {
	      return this.stacks;
	   }
	}
