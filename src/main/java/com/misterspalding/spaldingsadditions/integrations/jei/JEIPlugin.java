package com.misterspalding.spaldingsadditions.integrations.jei;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.client.gui.FabricatorScreen;
import com.misterspalding.spaldingsadditions.containers.FabricatorContainer;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.integrations.jei.fabricator.FabricatorRecipeCategory;
import com.misterspalding.spaldingsadditions.integrations.jei.fabricator.recipes.FabricatorRecipeJEI;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;


@JeiPlugin
public class JEIPlugin implements IModPlugin {

	@Override
	public ResourceLocation getPluginUid() {

		return new ResourceLocation(SpaldingsAdditions.MOD_ID, "internal");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
		
		registration.addRecipeCategories(new FabricatorRecipeCategory(guiHelper));
	}

	@Override
	public void registerItemSubtypes(ISubtypeRegistration registration) {
		IModPlugin.super.registerItemSubtypes(registration);
	}

	
	
	
	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IJeiHelpers helpers = registration.getJeiHelpers();
		registration.addRecipes(FabricatorRecipeJEI.getRecipes(helpers), RecipeCategories.FABRICATOR);
		
		
		
	}
	
	 @Override
	    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
	        registration.addRecipeClickArea(FabricatorScreen.class, 84, 40, 27, 17, RecipeCategories.FABRICATOR);
	    }

	 @Override
	 public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
	     //   registration.addRecipeTransferHandler(FabricatorContainer.class, RecipeCategories.FABRICATOR, 0, 2, 4, 36);
	 }
	 
	 @Override
	    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
	        registration.addRecipeCatalyst(new ItemStack(BlockDec.FABRICATOR.get()), RecipeCategories.FABRICATOR);
	      
	    }
}
