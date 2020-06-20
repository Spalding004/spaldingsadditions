package com.misterspalding.spaldingsadditions.containers;

import java.util.Objects;

import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.ContainersDec;
import com.misterspalding.spaldingsadditions.tileentities.PalmChestTile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class PalmChestContainer extends Container {

	public final PalmChestTile tileEntity;
	private final IWorldPosCallable canInteractWithCallable;

	public PalmChestContainer(final int windowID, final PlayerInventory playerInv, final PalmChestTile tileEntity) {
		super(ContainersDec.PALM_CHEST.get(), windowID);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		// Chest Invent

		int startX = 8;
		int startY = 18;
		int slotSizeGrown = 18;
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				this.addSlot(new Slot(tileEntity, (row * 9) + col, startX + (col * slotSizeGrown),
						startY + (row * slotSizeGrown)));

			}
		}

		// Player invent
		int startPlayerY = 84;
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {

				this.addSlot(new Slot(playerInv, 9 + (row * 9) + col, startX + col * slotSizeGrown,
						startPlayerY + row * slotSizeGrown));

			}

			// Hotbar

			int hotbarY = 142;
			for (int col = 0; col < 9; ++col) {

				this.addSlot(new Slot(playerInv, col, startX + col * slotSizeGrown, hotbarY));

			}
		}

	}

	private static PalmChestTile getTileEntity(final PlayerInventory playerInvent, final PacketBuffer data) {

		Objects.requireNonNull(playerInvent, "Player inventory cannot be null!");
		Objects.requireNonNull(data, "Data cannot be null!");
		final TileEntity te = playerInvent.player.world.getTileEntity(data.readBlockPos());
		if (te instanceof PalmChestTile) {
			return (PalmChestTile) te;
		}
		throw new IllegalStateException("Tile Entity " + te + " is not correct!");
	}

	public PalmChestContainer(final int windowID, final PlayerInventory playerInvent, final PacketBuffer data) {
		this(windowID, playerInvent, getTileEntity(playerInvent, data));

	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockDec.PALM_CHEST.get());
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < 36) {
				if (!this.mergeItemStack(itemstack1, 27, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, 27, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
}
