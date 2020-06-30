package com.misterspalding.spaldingsadditions.recipes.fabricator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class FabricatorRecipesNether {

	
	
	 private static final FabricatorRecipesNether SMELTING_BASE = new FabricatorRecipesNether();
	    private final Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
	    private final List<ItemStack> ingredientList = new ArrayList<ItemStack>();
	    private final Map<ItemStack, Float> timeList = Maps.<ItemStack, Float>newHashMap();
	
	    

	    public static FabricatorRecipesNether instance()
	    {
	        return SMELTING_BASE;
	    }
	    
	    private FabricatorRecipesNether() {
	    	
	    	this.addFabricating(Items.APPLE, new ItemStack(Items.NETHER_BRICK), 100);
	    	
	    	
	    }
	    
	    @SuppressWarnings("deprecation")
		public void addRecipeForBlock(Block input, ItemStack stack, float experience)
	    {
	        this.addFabricating(Item.getItemFromBlock(input), stack, experience);
	    }

	    public void addFabricating(Item input, ItemStack stack, float experience)
	    {
	        this.addRecipe(new ItemStack(input, 1), stack, experience);
	    }

	    public void addRecipe(ItemStack input, ItemStack stack, float experience)
	    {
	        if (getResult(input) != ItemStack.EMPTY) { }
	        this.smeltingList.put(input, stack);
	        this.timeList.put(input, Float.valueOf(experience));
	        this.ingredientList.add(input);
	    }

	    public ItemStack getResult(ItemStack stack)
	    {
	        for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
	        {
	            if (this.compareItemStacks(stack, entry.getKey()))
	            {
	                return entry.getValue();
	            }
	        }

	        return ItemStack.EMPTY;
	    }
	    
	    public boolean isValidIngredient(ItemStack stack) {
	    	
	    	return ingredientList.contains(stack);
	    	
	    }

	    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	    {
	        return stack2.getItem() == stack1.getItem() && 
	        		(stack2.getTag() == stack1.getTag());
	    }

	    public Map<ItemStack, ItemStack> getSmeltingList()
	    {
	        return this.smeltingList;
	    }

	    public float getProcessTime(ItemStack stack)
	    {
	        float ret = stack.getItem().getSmeltingExperience(stack);
	        if (ret != -1) return ret;

	        for (Entry<ItemStack, Float> entry : this.timeList.entrySet())
	        {
	            if (this.compareItemStacks(stack, entry.getKey()))
	            {
	                return ((Float)entry.getValue()).floatValue();
	            }
	        }

	        return 0.0F;
	    }
	    
}
