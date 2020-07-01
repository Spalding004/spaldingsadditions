package com.misterspalding.spaldingsadditions.containers;

import com.misterspalding.spaldingsadditions.inits.ContainersDec;
import com.misterspalding.spaldingsadditions.slots.DimCardSlot;
import com.misterspalding.spaldingsadditions.slots.LapalFuelSlot;
import com.misterspalding.spaldingsadditions.slots.MachineOutputSlot;
import com.misterspalding.spaldingsadditions.tileentities.FabricatorTileEntity;
import com.misterspalding.spaldingsadditions.tileentities.TileEntityMachine;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.world.World;

public class FabricatorContainer extends CommonContainer{
	
	 private World world;
	 private static int numSlots = 4;

	    public FabricatorContainer(int id, PlayerInventory playerInventory) {
	        this(id, playerInventory, new FabricatorTileEntity(), new IntArray(8), numSlots);
	    }
	    
	    public FabricatorContainer(int id, PlayerInventory playerInventory, TileEntityMachine tileEntity, IIntArray fields, int size) {
	        super(ContainersDec.FABRICATOR, id, playerInventory, tileEntity, fields, numSlots);
	        this.world = playerInventory.player.world;

	        //input
	        this.addSlot(new DimCardSlot(tileEntity, 1, 9, 44));
			//fuel
			this.addSlot(new LapalFuelSlot(tileEntity, 3, 151, 44));
			//card
			this.addSlot(new Slot(tileEntity, 0, 50, 44));
			//output
			this.addSlot(new MachineOutputSlot(tileEntity, 2, 109, 44));

	        this.addPlayerSlots(playerInventory);

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
	    
}
