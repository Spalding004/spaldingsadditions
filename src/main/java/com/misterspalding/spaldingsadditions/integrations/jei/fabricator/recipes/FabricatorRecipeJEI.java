package com.misterspalding.spaldingsadditions.integrations.jei.fabricator.recipes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.misterspalding.spaldingsadditions.inits.ItemDec;
import com.misterspalding.spaldingsadditions.integrations.jei.fabricator.FabricatorRecipeWrapper;
import com.misterspalding.spaldingsadditions.recipes.fabricator.FabricatorRecipes;

import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.helpers.IStackHelper;
import net.minecraft.item.ItemStack;

public class FabricatorRecipeJEI {
	
	public static List<IJeiHelpers> getRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		FabricatorRecipes recipes = FabricatorRecipes.instance();
		List<ItemStack> inputlist = recipes.getInputs();
		List<ItemStack> cards = recipes.getCards();
		List<ItemStack> results = recipes.getOutputs();
		List<IJeiHelpers> jeiRecipes = Lists.newArrayList();

		ItemStack card = ItemStack.EMPTY;
		ItemStack input = ItemStack.EMPTY;
		ItemStack output = ItemStack.EMPTY;

		for (int x = 0; x < inputlist.size(); x++) {

			input = inputlist.get(x);
			card = cards.get(x);
			output = results.get(x);

			List<ItemStack> inputs = Lists.newArrayList(new ItemStack[] { card, input });
			FabricatorRecipeWrapper recipe = new FabricatorRecipeWrapper(inputs, output);
			jeiRecipes.add(recipe);

		}

		return jeiRecipes;

	}

}
