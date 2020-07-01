package com.misterspalding.spaldingsadditions.containers;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.tileentities.TileEntityMachine;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIntArray;


public class CommonContainer extends Container {
	
	 public TileEntityMachine machineTileEntity;
	 protected IIntArray fields;
	 protected final int invenSize;
	 
	 CommonContainer(@Nullable ContainerType<?> type, int id, PlayerInventory playerInventory, TileEntityMachine tileEntity, IIntArray fields, int size) {
	        super(type, id);
	        invenSize = size;
	        this.machineTileEntity = tileEntity;

	        this.fields = fields;
	        this.trackIntArray(fields);

	    }
	 
	 @Override
		@Nonnull
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot)this.inventorySlots.get(index);

			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

				if (index <  invenSize) {
					if (!this.mergeItemStack(itemstack1, invenSize, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
				}
				else if (!this.mergeItemStack(itemstack1, 0, invenSize, false)) {
					return ItemStack.EMPTY;
				}

				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				}
				else {
					slot.onSlotChanged();
				}
			}

			return itemstack;
		}
	 
	 protected void addPlayerSlots(PlayerInventory playerInventory) {
	        for (int i = 0; i < 3; ++i) {
	            for (int j = 0; j < 9; ++j) {
	                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	            }
	        }

	        for (int k = 0; k < 9; ++k) {
	            this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
	        }
	    }
	 
	 @Override
	    public boolean canInteractWith(PlayerEntity playerIn) {
	        return this.machineTileEntity.isUsableByPlayer(playerIn);
	    }

	 public IIntArray getFields() {
	        return fields;
	    }
	 
	 
}
