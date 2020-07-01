package com.misterspalding.spaldingsadditions.tileentities.machines;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.objects.blocks.machines.MachineCommon;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public abstract class TileEntityMachineCommon extends TileEntity implements ITickableTileEntity, ISidedInventory, INamedContainerProvider{

	protected final NonNullList<ItemStack> stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
	
	public double targetProcessTime;
	public double currentProcessTime;
	public double currentFuel;
	public double maxFuel;
	private int cooldown = -1;
	 
	public TileEntityMachineCommon(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
		
	}
	
	@Override
    public CompoundNBT write(CompoundNBT compound) {
       
		if (this.currentProcessTime > 0) compound.putDouble("ProcessTime", this.currentProcessTime);
        if (this.targetProcessTime > 0) compound.putDouble("ProcessTimeTotal", this.targetProcessTime);
        if (this.currentFuel > 0) compound.putDouble("CurrentFuel", this.currentFuel);
        if (this.maxFuel > 0) compound.putDouble("MaxFuel", this.maxFuel);
        
        ItemStackHelper.saveAllItems(compound, this.stacks, false);
        return super.write(compound);
    }
	
	@Override
    public void read(CompoundNBT compound) {
        if (compound.contains("ProcessTime", Constants.NBT.TAG_INT)) this.currentProcessTime = compound.getInt("ProcessTime");
        if (compound.contains("ProcessTimeTotal", Constants.NBT.TAG_INT)) this.targetProcessTime = compound.getInt("ProcessTimeTotal");
        if (compound.contains("CurrentFuel", Constants.NBT.TAG_INT)) this.currentFuel = compound.getInt("CurrentFuel");
        if (compound.contains("MaxFuel", Constants.NBT.TAG_INT)) this.maxFuel = compound.getInt("MaxFuel");
        
        ItemStackHelper.loadAllItems(compound, this.stacks);
        super.read(compound);
    }
	
	abstract int[] getInputSlots();

    abstract int[] getOutputSlots();

    @Override
    public int[] getSlotsForFace(Direction side) {
        return side == Direction.DOWN ? this.getOutputSlots() : this.getInputSlots();
    }
    
    
    
    @Override
    public abstract int getSizeInventory();

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.stacks) {
            if (!stack.isEmpty())
                return false;
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.stacks.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.stacks, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.stacks, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        // TODO
        this.stacks.set(index, stack);
    }


    @Override
    public boolean isUsableByPlayer(@Nonnull PlayerEntity player) {
        assert this.world != null;
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return !(player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
                    (double) this.pos.getZ() + 0.5D) > 64.0D);
        }
    }

    @Override
    public void clear() {
        this.stacks.clear();
    }
    
    @Override
    public void tick() {
        if (this.cooldown > 0) this.cooldown--;
        if (this.cooldown < 0) sendUpdate(false);
    }
    
    public void sendUpdate(boolean lit) {
        if (lit) this.cooldown = 15;
        assert this.world != null;
        boolean flag = this.getBlockState().get(MachineCommon.LIT) != lit;
        if (flag) this.world.setBlockState(this.pos, this.getBlockState().with(MachineCommon.LIT, lit));
    }

    private LazyOptional<IItemHandlerModifiable>[] itemHandlers = SidedInvWrapper.create(this, Direction.values());

	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		
		return null;
	}

	@Override
	public ITextComponent getDisplayName() {
		
		return null;
	}

	


	
}
