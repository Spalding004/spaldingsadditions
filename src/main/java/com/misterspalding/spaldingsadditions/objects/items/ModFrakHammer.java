package com.misterspalding.spaldingsadditions.objects.items;

import java.util.Set;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;
import com.misterspalding.spaldingsadditions.recipes.fabricator.AutoFrakRecipes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;

public class ModFrakHammer extends ToolItem {

	 private static final Set<Block> effectiveBlocks = null;
	  protected final float efficiency;

	 public ModFrakHammer(int damage, float attack, float speed, IItemTier tier) {
		super(attack, speed, tier, effectiveBlocks, new Item.Properties()
				.maxDamage(damage)
				.group(ModItemGroup.instance)
				
			);
		this.efficiency = tier.getEfficiency();
		 
		
	}
	
	 public float getDestroySpeed(ItemStack stack, BlockState state) {
	      if (canHarvestBlock(state)) return efficiency;
	      return 1.0F;
	   }
	 
	 public boolean canHarvestBlock(BlockState blockIn) {
	      
		 
	      return blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE || blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.AXE ;
	   }
	 
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		ItemStack toReturn = stack.copy();
		toReturn.setDamage(stack.getDamage() + 1);
		
		if (toReturn.getDamage() >= getMaxDamage(stack)) {
			return ItemStack.EMPTY;
		}
		
		return toReturn;
	}

	
}
