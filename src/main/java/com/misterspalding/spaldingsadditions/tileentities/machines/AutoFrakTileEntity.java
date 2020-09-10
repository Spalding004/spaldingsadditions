package com.misterspalding.spaldingsadditions.tileentities.machines;

import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.containers.AutoFrakContainer;
import com.misterspalding.spaldingsadditions.fuels.LapalFuels;
import com.misterspalding.spaldingsadditions.inits.TileEntityDec;
import com.misterspalding.spaldingsadditions.objects.items.ModFrakHammer;
import com.misterspalding.spaldingsadditions.recipes.fabricator.AutoFrakRecipes;
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

public class AutoFrakTileEntity extends TileEntityMachineCommon {

	public AutoFrakTileEntity() {
		super(TileEntityDec.AUTOFRAK.get());
		
	}

	AutoFrakRecipes recipeInstance = AutoFrakRecipes.instance();


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
                    AutoFrakTileEntity.this.currentFuel = value;
                    break;
                case 5:
                	AutoFrakTileEntity.this.maxFuel = value;
                    break;
                case 6:
                	AutoFrakTileEntity.this.targetProcessTime = value;
                    break;
                case 7:
                	AutoFrakTileEntity.this.currentProcessTime = value;
                    break;
            }
        }

        @Override
        public int get(int index) {
            switch (index) {
            	case 2:
            	return AutoFrakTileEntity.this.getStackInSlot(SLOT_INPUT).getCount();
            	
                case 3:
                    // currentpower
                    return (int) (AutoFrakTileEntity.this.currentFuel);
                case 4:
                    // max power
                    return (int) AutoFrakTileEntity.this.maxFuel;
                case 5:
                    // Process time
                    return (int) AutoFrakTileEntity.this.currentProcessTime;
                case 6:
                    // Total process time
                    return (int) AutoFrakTileEntity.this.targetProcessTime;
                
                default:
                    return 0;
            }
        }
    };
	
	@Override
	int[] getInputSlots() {
		
		return new int[] {SLOT_INPUT, SLOT_FUEL, SLOT_CARD};
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
			ItemStack container_item = input_content;
			Boolean hasContainer = false;

			if (output_content.getCount() < output_content.getMaxStackSize()) {
				this.handleFuel();
				if (this.slotsAreValidForRecipe(SLOT_INPUT) && goodRecipe(input_content)) {

					this.targetProcessTime = getRecipeTime(this.getStackInSlot(SLOT_INPUT));
					++this.currentProcessTime;

					if (this.currentProcessTime >= this.targetProcessTime - 1) {
						this.currentProcessTime = 0;
						if (input_content.getItem().hasContainerItem(input_content)) {
							container_item = input_content.getContainerItem();
							hasContainer = true;
						}
						input_content.shrink(1);
						if (hasContainer) input_content = container_item;

						if (output_content == ItemStack.EMPTY) {

							output_content = result;

						} else

						if (this.getStackInSlot(SLOT_OUTPUT).getItem() == getRecipeOutput(getStackInSlot(SLOT_INPUT))
								.getItem()) {

							int countToGrow = getRecipeOutput(getStackInSlot(SLOT_INPUT)).getCount();
							int maxStack = getRecipeOutput(getStackInSlot(SLOT_INPUT)).getItem().getMaxStackSize();
							
							if ((output_content.getCount() + countToGrow) > maxStack ) {
								output_content.setCount(maxStack);
							} else  {
								output_content.grow(countToGrow);
							}
							
							//output_content.grow(getRecipeOutput(getStackInSlot(SLOT_INPUT)).getCount());


						} else {
							if (output_content.getCount() > 0) {
								output_content.grow(getRecipeOutput(getStackInSlot(SLOT_INPUT)).getCount());
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
		return this.currentProcessTime > 0 && !this.getStackInSlot(SLOT_INPUT).isEmpty();
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

	
			toReturn = recipeInstance.getProcessTime(input_contents, input_card.getItem());

		
		return toReturn;
	}

	public  ItemStack getRecipeOutput(ItemStack input_contents) {
		ItemStack input_card = this.getStackInSlot(SLOT_CARD);
		ItemStack toReturn = ItemStack.EMPTY;

		
			toReturn = recipeInstance.getResult(input_contents, input_card.getItem());

		

		return toReturn;
	}
	
	

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
    	
    	if (index == SLOT_INPUT) {
    		return true;
    	}
    	
    	if (index == SLOT_CARD) {
    		return itemStackIn.getItem() instanceof ModFrakHammer;
    	}
    	
    	if (index == SLOT_FUEL) {
    		return LapalFuels.getFuelStr(itemStackIn) > 0D;
    	}
    	
    	if (index == SLOT_OUTPUT) {
    		return false;
    	}
    	
    	return this.isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return index == SLOT_OUTPUT;
    }

    @Override
    public ITextComponent getDisplayName() {
        return TextUtils.translate("container", "autofrak");
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new AutoFrakContainer(id, playerInventory, this, this.fields, this.getSizeInventory());
    }
    
    public NonNullList<ItemStack> getItems() {
		return this.stacks;
	}
    
   

}
