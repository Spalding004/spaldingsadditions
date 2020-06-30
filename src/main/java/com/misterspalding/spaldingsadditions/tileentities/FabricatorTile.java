package com.misterspalding.spaldingsadditions.tileentities;

import javax.annotation.Nonnull;

import com.misterspalding.spaldingsadditions.containers.FabricatorContainer;
import com.misterspalding.spaldingsadditions.fuels.LapalFuels;
import com.misterspalding.spaldingsadditions.inits.ItemDec;
import com.misterspalding.spaldingsadditions.inits.TileEntityDec;
import com.misterspalding.spaldingsadditions.recipes.fabricator.FabricatorRecipesEnd;
import com.misterspalding.spaldingsadditions.recipes.fabricator.FabricatorRecipesNether;
import com.misterspalding.spaldingsadditions.recipes.fabricator.FabricatorRecipesOverworld;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public class FabricatorTile extends TileEntity
		implements ITickableTileEntity, ISidedInventory, INamedContainerProvider {

	private int SLOT_INPUT = 0;
	private int SLOT_CARD = 1;
	private int SLOT_FUEL = 3;
	private int SLOT_OUTPUT = 2;

	private int[] TOP_SLOTS = new int[] { 0 };
	private int[] BOTTOM_SLOTS = new int[] { 3 };
	private int[] SIDE_SLOTS = new int[] { 2, 1 };

	private double targetProcessTime;
	private double currentProcessTime;
	private double fuelRemaining;
	private double maxFuel;

	FabricatorRecipesOverworld recipeInstanceNormal = FabricatorRecipesOverworld.instance();
	FabricatorRecipesEnd recipeInstanceEnd = FabricatorRecipesEnd.instance();
	FabricatorRecipesNether recipeInstanceNether = FabricatorRecipesNether.instance();

	public final ItemStackHandler inventory;
	protected final LazyOptional<ItemStackHandler> inventoryCapability;

	private int num_slots = 4;
	private NonNullList<ItemStack> fabricatorContents = NonNullList.withSize(num_slots, ItemStack.EMPTY);

	public FabricatorTile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

		this.inventory = createItemStackHandler(num_slots);
		this.inventoryCapability = LazyOptional.of(() -> this.inventory);

	}

	public FabricatorTile() {
		this(TileEntityDec.FABRICATOR.get());
	}

	@Override
	public int getSizeInventory() {
		return num_slots;
	}

	private ItemStackHandler createItemStackHandler(int size) {
		return new ItemStackHandler(size) {
			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return isItemValidForSlot(slot, stack);
			}

			@Override
			public int getSlotLimit(int slot) {

				if (slot == SLOT_INPUT) {
					return 1;
				}

				return 64;
			}

			@Override
			protected void onContentsChanged(int slot) {
				super.onContentsChanged(slot);
				if (slot == SLOT_INPUT) {

					if (goodRecipe(slotContent(SLOT_INPUT))) {

						FabricatorTile.this.setMaxTime(FabricatorTile.this.getRecipeTime(slotContent(SLOT_INPUT)));
						FabricatorTile.this.setCurrentTime(0);

					}

				}
				markDirty();
			}
		};
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
		return slotContent(index);
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
			ItemStack itemstack = slotContent(index);
			boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack)
					&& ItemStack.areItemStackTagsEqual(stack, itemstack);
			this.fabricatorContents.set(index, stack);

			if (stack.getCount() > this.getInventoryStackLimit()) {
				stack.setCount(this.getInventoryStackLimit());
			}

			if (index == 0 && !flag) {

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

		if (this.currentProcessTime <= 0)
			this.currentProcessTime = 0;

		if (this.currentProcessTime >= this.targetProcessTime)
			this.currentProcessTime = 0;

		if (this.slotContent(SLOT_FUEL).getCount() == 0 && this.fuelRemaining <= 0)
			--this.currentProcessTime;

		if (this.slotContent(SLOT_INPUT).getCount() == 0 || this.slotContent(SLOT_CARD).getCount() == 0)
			this.currentProcessTime = 0;

		this.process();
		this.markDirty();

	}

	private void process() {
		if (this.shouldFuel()) {

			ItemStack result = this.getRecipeOutput(slotContent(SLOT_INPUT));
			ItemStack output_content = this.slotContent(SLOT_OUTPUT);
			ItemStack input_content = this.slotContent(SLOT_INPUT);
			ItemStack card_item = this.slotContent(SLOT_CARD);

			if (output_content.getCount() < output_content.getMaxStackSize()) {
				this.handleFuel();
				if (this.slotsAreValidForRecipe(SLOT_INPUT) && goodRecipe(input_content)) {

					this.targetProcessTime = getRecipeTime(this.slotContent(SLOT_INPUT));
					++this.currentProcessTime;

					if (this.currentProcessTime >= this.targetProcessTime - 1) {
						this.currentProcessTime = 0;
						input_content.shrink(1);

						if (output_content == ItemStack.EMPTY) {

							output_content = result;

						} else

						if (slotContent(SLOT_OUTPUT).getItem() == getRecipeOutput(slotContent(SLOT_INPUT)).getItem()) {

							output_content.grow(1);

						} else {
							if (output_content.getCount() > 0) {
								output_content.grow(1);
							} else {
								output_content = result;
							}
						}
						card_item = damageItem(card_item, 1);
						this.fabricatorContents.set(SLOT_CARD, card_item.copy());
						this.fabricatorContents.set(SLOT_INPUT, input_content.copy());
						this.fabricatorContents.set(SLOT_OUTPUT, output_content.copy());
					}

				}
			}

		}

	}

	private ItemStack damageItem(ItemStack card_item, int damage_amount) {
		int init_damage = card_item.getDamage();
		card_item.setDamage(init_damage + damage_amount);
		if (card_item.getDamage() >= card_item.getMaxDamage()) {
			card_item = ItemStack.EMPTY;
		}
		return card_item;

	}

	private boolean slotsAreValidForRecipe(int IN_SLOT) {

		if (this.slotContent(SLOT_OUTPUT) == ItemStack.EMPTY
				|| this.slotContent(SLOT_OUTPUT).getItem() == getRecipeOutput(this.slotContent(IN_SLOT)).getItem()) {

			return true;
		} else

			return false;
	}

	protected void onContentsChanged(int slot) {
		if (slot == 0 || slot == 1) {
			ItemStack input = slotContent(SLOT_INPUT);
			ItemStack input2 = slotContent(SLOT_CARD);
			if (!input.isEmpty() && !input2.isEmpty()) {
				this.targetProcessTime = this.getRecipeTime(input);
			} else {
				this.currentProcessTime = 0;
			}
		}

	}

	private ItemStack slotContent(int slot) {

		return this.fabricatorContents.get(slot);

	}

	private float getRecipeTime(ItemStack input_contents) {
		ItemStack input_card = this.slotContent(SLOT_CARD);
		float toReturn = 0;

		if (input_card.getItem() == ItemDec.CARD_BASIC.get()) {

			toReturn = recipeInstanceNormal.getProcessTime(input_contents);

		}

		if (input_card.getItem() == ItemDec.CARD_NETHER.get()) {

			toReturn = recipeInstanceNether.getProcessTime(input_contents);

		}

		if (input_card.getItem() == ItemDec.CARD_END.get()) {

			toReturn = recipeInstanceEnd.getProcessTime(input_contents);

		}
		return toReturn;
	}

	private ItemStack getRecipeOutput(ItemStack input_contents) {
		ItemStack input_card = this.slotContent(SLOT_CARD);
		ItemStack toReturn = ItemStack.EMPTY;

		if (input_card.getItem() == ItemDec.CARD_BASIC.get()) {

			toReturn = recipeInstanceNormal.getResult(input_contents);

		}

		if (input_card.getItem() == ItemDec.CARD_NETHER.get()) {

			toReturn = recipeInstanceNether.getResult(input_contents);

		}

		if (input_card.getItem() == ItemDec.CARD_END.get()) {

			toReturn = recipeInstanceEnd.getResult(input_contents);

		}

		return toReturn;
	}

	private void handleFuel() {
		if (this.fuelRemaining > 0) {
			--this.fuelRemaining;
		} else {
			ItemStack fuel = slotContent(SLOT_FUEL);
			if (goodRecipe(slotContent(SLOT_INPUT))) {
				this.fuelRemaining = LapalFuels.getFuelStr(fuel);
				this.maxFuel = this.fuelRemaining;
				if (fuel == ItemStack.EMPTY) {
					if (this.currentProcessTime > 0)
						--this.currentProcessTime;
				}
				fuel.shrink(1);
				if (fuel.getCount() == 0) {
					this.fabricatorContents.set(SLOT_FUEL, ItemStack.EMPTY);

				} else {
					this.fabricatorContents.set(SLOT_FUEL, fuel.copy());
				}
			}
		}
	}

	private boolean shouldFuel() {
		ItemStack input = this.slotContent(SLOT_INPUT);

		if (!goodRecipe(input)) {
			return false;
		} else

			return true;
	}

	private boolean goodRecipe(ItemStack input) {
		if (getRecipeOutput(input) == ItemStack.EMPTY) {
			return false;
		} else

			return true;
	}

	private void setCurrentTime(int time) {
		this.currentProcessTime = time;
	}

	private void setMaxTime(float f) {
		this.targetProcessTime = f;
	}

	private boolean isStackAir(ItemStack input) {

		return input.getItem() == Items.AIR;
	}

	public String getGuiID() {
		return "spaldingsadditions:fabricator";
	}

	@Override
	public Container createMenu(int id, PlayerInventory player, PlayerEntity entity) {

		return new FabricatorContainer(id, player, this);
	}

	@Override
	public ITextComponent getDisplayName() {

		return new TranslationTextComponent("container.fabricator");
	}

	public NonNullList<ItemStack> getItems() {
		return this.fabricatorContents;
	}

}
