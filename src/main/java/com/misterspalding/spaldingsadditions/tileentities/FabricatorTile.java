package com.misterspalding.spaldingsadditions.tileentities;

import java.util.Optional;

import com.misterspalding.spaldingsadditions.fuels.LapalFuels;
import com.misterspalding.spaldingsadditions.inits.TileEntityDec;
import com.misterspalding.spaldingsadditions.recipes.FabricatorRecipe;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;

public class FabricatorTile extends TileEntity implements ITickableTileEntity, ISidedInventory {

	private int SLOT_INPUT = 0;
	private int SLOT_CARD = 1;
	private int SLOT_FUEL = 2;
	private int SLOT_OUTPUT = 3;

	private int[] TOP_SLOTS = new int[] { 0 };
	private int[] BOTTOM_SLOTS = new int[] { 3 };
	private int[] SIDE_SLOTS = new int[] { 2, 1 };

	private double targetProcessTime;
	private double currentProcessTime;
	private double fuelRemaining;
	private double maxFuel;

	private int num_slots = 4;
	private NonNullList<ItemStack> fabricatorContents = NonNullList.withSize(num_slots, ItemStack.EMPTY);

	public FabricatorTile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

	}

	public FabricatorTile() {
		this(TileEntityDec.FABRICATOR.get());
	}

	@Override
	public int getSizeInventory() {
		return num_slots;
	}

	@Override
	public boolean isEmpty() {

		for (int x = 0; x < num_slots; ++x) {

			if (fabricatorContents.get(x).getItem() != ItemStack.EMPTY.getItem()) {
				return false;
			}

		}

		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.fabricatorContents.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.fabricatorContents, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.fabricatorContents, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		{
			ItemStack itemstack = this.fabricatorContents.get(index);
			boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack)
					&& ItemStack.areItemStackTagsEqual(stack, itemstack);
			this.fabricatorContents.set(index, stack);

			if (stack.getCount() > this.getInventoryStackLimit()) {
				stack.setCount(this.getInventoryStackLimit());
			}

			if (index == 0 && !flag) {
				// this.totalCookTime = this.getCookTime(stack);
				// this.cookTime = 0;
				this.markDirty();
			}
		}

	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		if (this.world.getTileEntity(this.pos) != this) {
			return false;
		} else {
			return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
					(double) this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}

	@Override
	public void clear() {

		this.fabricatorContents.clear();

	}

	public NonNullList<ItemStack> getInventoryForRecipe() {
		
		return fabricatorContents;
		
	}
	
	@Override
	public int[] getSlotsForFace(Direction side) {
		if (side == Direction.DOWN) {
			return BOTTOM_SLOTS;
		}
		if (side == Direction.UP) {
			return TOP_SLOTS;
		}

		return SIDE_SLOTS;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		if (direction == Direction.DOWN) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void tick() {

		--this.fuelRemaining;
		if (this.fuelRemaining <= 0) {

			this.fuelRemaining = 0;
			if (!this.fabricatorContents.get(SLOT_FUEL).isEmpty()) {
				ItemStack fuel = this.fabricatorContents.get(SLOT_FUEL).getStack();
				fuel.shrink(1);
				ItemStack containerItem = fuel.getItem().getContainerItem(fuel.copy());
				if (!containerItem.isEmpty()) {
					this.fabricatorContents.set(2, containerItem.copy());
				}
				this.fuelRemaining = LapalFuels.getFuelStr(fuel);
				this.maxFuel = fuelRemaining;
				trySmelt();

			} else {

			}

		}

	}
	//CrusherRecipe recipe = world.getRecipeManager().getRecipe(CrusherRecipe.crushing, inventory, world).orElse(null);
	 
	
	private void trySmelt() {
		
		//Inventory inventory = new Inventory();
		FabricatorRecipe recipe = world.getRecipeManager().getRecipe(FabricatorRecipe.recipeType, inventory, world);
		
		
		if(!this.fabricatorContents.get(SLOT_INPUT).isEmpty() && !this.fabricatorContents.get(SLOT_CARD).isEmpty()) {
			ItemStack targetOutput = recipe.getResult();
			if (this.targetProcessTime == 0) {
				
				
				if (!targetOutput.isEmpty()) {
					
					this.targetProcessTime = recipe.getProcessTime();
					
				}
				
				
			}
			
			
			
		}
		
	}

}
