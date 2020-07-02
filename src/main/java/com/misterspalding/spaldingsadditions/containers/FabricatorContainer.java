package com.misterspalding.spaldingsadditions.containers;

import javax.annotation.Nonnull;

import com.misterspalding.spaldingsadditions.inits.ContainersDec;
import com.misterspalding.spaldingsadditions.slots.DimCardSlot;
import com.misterspalding.spaldingsadditions.slots.LapalFuelSlot;
import com.misterspalding.spaldingsadditions.slots.MachineOutputSlot;
import com.misterspalding.spaldingsadditions.tileentities.machines.FabricatorTileEntity;
import com.misterspalding.spaldingsadditions.tileentities.machines.TileEntityMachineCommon;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.world.World;

public class FabricatorContainer extends CommonContainer {

	private World world;
	private static int numSlots = 4;

	public FabricatorContainer(int id, PlayerInventory playerInventory) {
		this(id, playerInventory, new FabricatorTileEntity(), new IntArray(8), numSlots);
	}

	public FabricatorContainer(int id, PlayerInventory playerInventory, TileEntityMachineCommon tileEntity, IIntArray fields,
			int size) {
		super(ContainersDec.FABRICATOR, id, playerInventory, tileEntity, fields, numSlots);
		this.world = playerInventory.player.world;

		// input
		this.addSlot(new DimCardSlot(tileEntity, 1, 9, 44));
		// fuel
		this.addSlot(new LapalFuelSlot(tileEntity, 3, 151, 44));
		// card
		this.addSlot(new Slot(tileEntity, 0, 50, 44));
		// output
		this.addSlot(new MachineOutputSlot(tileEntity, 2, 109, 44));

		this.addPlayerSlots(playerInventory);

	}

	@Override
	@Nonnull
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot)this.inventorySlots.get(index);
		//prevent shift clicking into output that has items with 2nd && statement
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index < invenSize) {
				if (!this.mergeItemStack(itemstack1, invenSize, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, invenSize, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
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

	public ItemStack getInputItem() { 
		
		return this.getSlot(0).getStack();
	}
	
	public ItemStack getCardItem() { 
		
		return this.getSlot(1).getStack();
	}
	
	public boolean isCardLoaded() {
		
		return this.fields.get(2) > 0;
		
	}
	
	public int getCurrentFuel() {
		return this.fields.get(3);
	}

	public int getMaxFuel() {
		return this.fields.get(4);
	}

	public int getProcessTime() {
		return this.fields.get(5);
	}

	public int getProcessTimeTotal() {
		return this.fields.get(6);
	}

	public int getProgressScaled(int width) {
		int i = this.getProcessTime();
		int j = this.getProcessTimeTotal();
		return i != 0 && j != 0 ? i * width / j : 0;
	}
	
	public int getFuelScaled(int width) {
		int i = this.getCurrentFuel()*10;
		int j = this.getMaxFuel()*10;
		return i != 0 && j != 0 ? i * width / j : 0;
	}

}
