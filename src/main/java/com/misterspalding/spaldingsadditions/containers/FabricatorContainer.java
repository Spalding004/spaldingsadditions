package com.misterspalding.spaldingsadditions.containers;

import java.util.Objects;

import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.ContainersDec;
import com.misterspalding.spaldingsadditions.slots.SlotDimCard;
import com.misterspalding.spaldingsadditions.slots.SlotLapisFuel;
import com.misterspalding.spaldingsadditions.slots.SlotOutput;
import com.misterspalding.spaldingsadditions.tileentities.FabricatorTile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class FabricatorContainer extends CommonContainer {

	public final FabricatorTile tileEntity;
	private final IWorldPosCallable canInteractWithCallable;

	public FabricatorContainer(final int windowID, final PlayerInventory playerInv, final FabricatorTile tileEntity) {
		super(ContainersDec.FABRICATOR.get(), windowID, 4);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		// Machine Invent

			//card
				this.addSlot(new SlotDimCard(tileEntity, 1, 9, 44));
				//input
				this.addSlot(new SlotLapisFuel(tileEntity, 3, 151, 44));
				//fuel
				this.addSlot(new Slot(tileEntity, 0, 50, 44));
				
				//output
				this.addSlot(new SlotOutput(tileEntity, 2, 109, 44));
			

		// Player invent
		int startPlayerY = 84;
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {

				this.addSlot(new Slot(playerInv, 9 + (row * 9) + col, 8 + col * 18,
						startPlayerY + row * 18));

			}

			// Hotbar

			int hotbarY = 142;
			for (int col = 0; col < 9; ++col) {

				this.addSlot(new Slot(playerInv, col, 8 + col * 18, hotbarY));

			}
		}

	}

	private static FabricatorTile getTileEntity(final PlayerInventory playerInvent, final PacketBuffer data) {

		Objects.requireNonNull(playerInvent, "Player inventory cannot be null!");
		Objects.requireNonNull(data, "Data cannot be null!");
		final TileEntity te = playerInvent.player.world.getTileEntity(data.readBlockPos());
		if (te instanceof FabricatorTile) {
			return (FabricatorTile) te;
		}
		throw new IllegalStateException("Tile Entity " + te + " is not correct!");
	}

	public FabricatorContainer(final int windowID, final PlayerInventory playerInvent, final PacketBuffer data) {
		this(windowID, playerInvent, getTileEntity(playerInvent, data));

	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockDec.FABRICATOR.get());
	}

	
	
	
}
