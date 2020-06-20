package com.misterspalding.spaldingsadditions.tileentities;

import javax.annotation.Nonnull;

import com.misterspalding.spaldingsadditions.blocks.ModChest;
import com.misterspalding.spaldingsadditions.containers.PalmChestContainer;
import com.misterspalding.spaldingsadditions.inits.TileEntityDec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class PalmChestTile extends LockableLootTileEntity {

	private NonNullList<ItemStack> chestContents = NonNullList.withSize(27, ItemStack.EMPTY);
	protected int numPlayersUsing;
	private IItemHandlerModifiable items = createHandler();
	private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

	public PalmChestTile(TileEntityType<?> typeIn) {
		super(typeIn);
	}

	public PalmChestTile() {
		this(TileEntityDec.PALM_CHEST.get());
	}

	@Override
	public int getSizeInventory() {
		return 27;
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.chestContents;
	}

	@Override
	public void setItems(NonNullList<ItemStack> itemsIn) {
		this.chestContents = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {

		return new TranslationTextComponent("container.palm_chest");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {

		return new PalmChestContainer(id, player, this);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {

		super.write(compound);
		if (!this.checkLootAndWrite(compound)) {

			ItemStackHelper.saveAllItems(compound, this.chestContents);

		}
		return compound;
	}

	@Override
	public void read(CompoundNBT compound) {

		super.read(compound);
		this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.loadAllItems(compound, this.chestContents);
		}
	}

	@Override
	public boolean receiveClientEvent(int id, int type) {
		if (id == 1) {
			this.numPlayersUsing = type;
			return true;
		} else {
			return super.receiveClientEvent(id, type);
		}

	}

	@Override
	public void openInventory(PlayerEntity player) {
		if (!player.isSpectator()) {
			if (this.numPlayersUsing < 0) {
				this.numPlayersUsing = 0;
			}

			++this.numPlayersUsing;
			this.onOpenOrClose();
		}
		super.openInventory(player);
	}

	@Override
	public void closeInventory(PlayerEntity player) {
		if (!player.isSpectator()) {
			--this.numPlayersUsing;
			this.onOpenOrClose();
		}
	}

	protected void onOpenOrClose() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof ModChest) {
			this.world.addBlockEvent(pos, block, 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(pos, block);
		}

	}

	public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {

		BlockState state = reader.getBlockState(pos);
		if (state.hasTileEntity()) {
			TileEntity te = reader.getTileEntity(pos);
			if (te instanceof PalmChestTile) {
				return ((PalmChestTile) te).numPlayersUsing;
			}
		}
		return 0;
	}

	public static void swapContents(PalmChestTile te, PalmChestTile te2) {
		NonNullList<ItemStack> list = te.getItems();
		te.setItems(te2.getItems());
		te2.setItems(list);
	}

	@Override
	public void updateContainingBlockInfo() {

		super.updateContainingBlockInfo();

		if (this.itemHandler != null) {
			this.itemHandler.invalidate();
			this.itemHandler = null;
		}
	}

	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {

		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return itemHandler.cast();
		}
		return super.getCapability(cap, side);
	}

	private IItemHandlerModifiable createHandler() {

		return new InvWrapper(this);

	}
	
	@Override
	public void remove() {
		super.remove();
		if(itemHandler != null) {
			itemHandler.invalidate();
		}
	}

}
