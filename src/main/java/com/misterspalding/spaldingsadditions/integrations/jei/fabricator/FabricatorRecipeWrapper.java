package com.misterspalding.spaldingsadditions.integrations.jei.fabricator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.helpers.IModIdHelper;
import mezz.jei.api.helpers.IStackHelper;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;

public class FabricatorRecipeWrapper implements IJeiHelpers {
	
	private final List<ItemStack> inputs;
	private final ItemStack output;
	 private final Map<ItemStack, ItemStack> ingredients = new LinkedHashMap<>();
	   
	 public FabricatorRecipeWrapper(List<ItemStack> inputs2, ItemStack output) {
	      this.inputs = inputs2;
	      this.output = output;
	   }

	   public void getIngredients(IIngredients ingredients) {
		   
	    //  ingredients.setInputs(VanillaTypes.ITEM, this.inputs);
	     
	    //  ingredients.setOutput(VanillaTypes.ITEM, this.output);
	   }
	   
	   public List<ItemStack> getIngredientList() {
		   
		   return this.inputs;
		   
	   }

	@Override
	public IGuiHelper getGuiHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IStackHelper getStackHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IModIdHelper getModIdHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	 public Map<ItemStack, ItemStack> getIngredientMap() {
        return ImmutableMap.copyOf(ingredients);
    }

	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return output;
	}
}
