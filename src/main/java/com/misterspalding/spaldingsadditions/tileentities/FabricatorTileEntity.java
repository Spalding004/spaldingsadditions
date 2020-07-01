package com.misterspalding.spaldingsadditions.tileentities;

import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.containers.FabricatorContainer;
import com.misterspalding.spaldingsadditions.fuels.LapalFuels;
import com.misterspalding.spaldingsadditions.inits.ItemDec;
import com.misterspalding.spaldingsadditions.inits.TileEntityDec;
import com.misterspalding.spaldingsadditions.recipes.fabricator.FabricatorRecipesEnd;
import com.misterspalding.spaldingsadditions.recipes.fabricator.FabricatorRecipesNether;
import com.misterspalding.spaldingsadditions.recipes.fabricator.FabricatorRecipesOverworld;
import com.misterspalding.spaldingsadditions.utils.TextUtils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

public class FabricatorTileEntity extends TileEntityMachine {

	public FabricatorTileEntity() {
		super(TileEntityDec.FABRICATOR.get());
		// TODO Auto-TileEn constructor stub
	}

	FabricatorRecipesOverworld recipeInstanceNormal = FabricatorRecipesOverworld.instance();
	FabricatorRecipesEnd recipeInstanceEnd = FabricatorRecipesEnd.instance();
	FabricatorRecipesNether recipeInstanceNether = FabricatorRecipesNether.instance();

	private int SLOT_INPUT = 0;
	private int SLOT_CARD = 1;
	private int SLOT_FUEL = 3;
	private int SLOT_OUTPUT = 2;

	private IIntArray fields = new IIntArray() {
        @Override
        public int size() {
            return 8;
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 4:
                    FabricatorTileEntity.this.currentFuel = value;
                    break;
                case 5:
                	FabricatorTileEntity.this.maxFuel = value;
                    break;
                case 6:
                	FabricatorTileEntity.this.targetProcessTime = value;
                    break;
                case 7:
                	FabricatorTileEntity.this.currentProcessTime = value;
                    break;
            }
        }

        @Override
        public int get(int index) {
            switch (index) {
                
                case 3:
                    // currentpower
                    return (int) (FabricatorTileEntity.this.currentFuel);
                case 4:
                    // max power
                    return (int) FabricatorTileEntity.this.maxFuel;
                case 5:
                    // Process time
                    return (int) FabricatorTileEntity.this.currentProcessTime;
                case 6:
                    // Total process time
                    return (int) FabricatorTileEntity.this.targetProcessTime;
                
                default:
                    return 0;
            }
        }
    };
	
	@Override
	int[] getInputSlots() {
		
		return new int[] {SLOT_INPUT};
	}

	@Override
	int[] getOutputSlots() {
		
		return new int[] {SLOT_OUTPUT};
	}

	@Override
	public int getSizeInventory() {
		
		return 4;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		ItemStack itemstack = this.stacks.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack)
				&& ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.stacks.set(index, stack);
		if (stack.getCount() > this.getInventoryStackLimit()) {
			stack.setCount(this.getInventoryStackLimit());
		}

		if (index == 0 && !flag) {
			this.targetProcessTime = this.getRecipeTime(this.getStackInSlot(SLOT_INPUT));
			this.currentProcessTime = 0;
			this.markDirty();
		}
	}

	@Override
	public void tick() {

		boolean shouldLit = this.isActive();
		boolean flag1 = false;
		if (this.currentProcessTime <= 0)
			this.currentProcessTime = 0;

		if (this.currentProcessTime >= this.targetProcessTime)
			this.currentProcessTime = 0;

		if (this.getStackInSlot(SLOT_FUEL).getCount() == 0 && this.currentFuel <= 0)
			--this.currentProcessTime;

		if (this.getStackInSlot(SLOT_INPUT).getCount() == 0 || this.getStackInSlot(SLOT_CARD).getCount() == 0)
			this.currentProcessTime = 0;

		this.process();
		if (shouldLit != this.isActive()) {
			flag1 = true;
			this.sendUpdate(this.isActive());
		}
		if (flag1) {
			this.markDirty();
		}

	}

	private void process() {
		if (this.shouldFuel()) {

			ItemStack result = this.getRecipeOutput(getStackInSlot(SLOT_INPUT));
			ItemStack output_content = this.getStackInSlot(SLOT_OUTPUT);
			ItemStack input_content = this.getStackInSlot(SLOT_INPUT);
			ItemStack card_item = this.getStackInSlot(SLOT_CARD);

			if (output_content.getCount() < output_content.getMaxStackSize()) {
				this.handleFuel();
				if (this.slotsAreValidForRecipe(SLOT_INPUT) && goodRecipe(input_content)) {

					this.targetProcessTime = getRecipeTime(this.getStackInSlot(SLOT_INPUT));
					++this.currentProcessTime;

					if (this.currentProcessTime >= this.targetProcessTime - 1) {
						this.currentProcessTime = 0;
						input_content.shrink(1);

						if (output_content == ItemStack.EMPTY) {

							output_content = result;

						} else

						if (this.getStackInSlot(SLOT_OUTPUT).getItem() == getRecipeOutput(getStackInSlot(SLOT_INPUT))
								.getItem()) {

							output_content.grow(1);

						} else {
							if (output_content.getCount() > 0) {
								output_content.grow(1);
							} else {
								output_content = result;
							}
						}
						card_item = damageItem(card_item, 1);
						this.stacks.set(SLOT_CARD, card_item.copy());
						this.stacks.set(SLOT_INPUT, input_content.copy());
						this.stacks.set(SLOT_OUTPUT, output_content.copy());
					}

				}
			}

		}

	}

	private boolean slotsAreValidForRecipe(int IN_SLOT) {

		if (this.getStackInSlot(SLOT_OUTPUT) == ItemStack.EMPTY || this.getStackInSlot(SLOT_OUTPUT)
				.getItem() == getRecipeOutput(this.getStackInSlot(IN_SLOT)).getItem()) {

			return true;
		} else

			return false;
	}

	private ItemStack damageItem(ItemStack card_item, int damage_amount) {
		int init_damage = card_item.getDamage();
		card_item.setDamage(init_damage + damage_amount);
		if (card_item.getDamage() >= card_item.getMaxDamage()) {
			card_item = ItemStack.EMPTY;
		}
		return card_item;

	}

	private boolean isActive() {
		return this.currentFuel > 0 || this.currentProcessTime > 0;
	}

	private void handleFuel() {
		if (this.currentFuel > 0) {
			--this.currentFuel;
		} else {
			ItemStack fuel = getStackInSlot(SLOT_FUEL);
			if (goodRecipe(getStackInSlot(SLOT_INPUT))) {
				this.currentFuel = LapalFuels.getFuelStr(fuel);
				this.maxFuel = this.currentFuel;
				if (fuel == ItemStack.EMPTY) {
					if (this.currentProcessTime > 0)
						--this.currentProcessTime;
				}
				fuel.shrink(1);
				if (fuel.getCount() == 0) {
					this.stacks.set(SLOT_FUEL, ItemStack.EMPTY);

				} else {
					this.stacks.set(SLOT_FUEL, fuel.copy());
				}
			}
		}
	}

	private boolean shouldFuel() {
		ItemStack input = this.getStackInSlot(SLOT_INPUT);

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

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		return super.write(compound);
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
	}

	private float getRecipeTime(ItemStack input_contents) {
		ItemStack input_card = this.getStackInSlot(SLOT_CARD);
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

	public  ItemStack getRecipeOutput(ItemStack input_contents) {
		ItemStack input_card = this.getStackInSlot(SLOT_CARD);
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
	
	

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
    	return this.isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return index == SLOT_OUTPUT;
    }

    @Override
    public ITextComponent getDisplayName() {
        return TextUtils.translate("container", "fabricator");
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new FabricatorContainer(id, playerInventory, this, this.fields, this.getSizeInventory());
    }
    
    public NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

}
