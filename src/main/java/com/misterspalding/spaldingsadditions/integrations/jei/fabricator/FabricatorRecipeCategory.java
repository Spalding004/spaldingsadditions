package com.misterspalding.spaldingsadditions.integrations.jei.fabricator;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.inits.BlockDec;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class FabricatorRecipeCategory extends AbstractFabricatorRecipeCategory {
	   protected static final ResourceLocation TEXTURES = new ResourceLocation("spaldingsadditions:textures/gui/lapal_infuser_jei.png");
	   private final IDrawable background;
	   private final String name;
	   private final IDrawable icon;

	   public FabricatorRecipeCategory(IGuiHelper helper) {
	      super(helper);
	      this.background = helper.createDrawable(TEXTURES, 0, 0, 104, 52);
	      this.name = "Dimensional Fabricator";
	      icon = helper.createDrawableIngredient(new ItemStack(BlockDec.FABRICATOR.get()));
	   }

	   public IDrawable getBackground() {
	      return this.background;
	   }

	   public void drawExtras(Minecraft minecraft) {
	      this.animatedArrow.draw(48, 20);
	   }

	   public String getTitle() {
	      return this.name;
	   }

	   public String getModName() {
	      return "Spalding's Additions";
	   }

	   public ResourceLocation getUid() {
	      return new ResourceLocation(SpaldingsAdditions.MOD_ID, "fabricator");
	   }

	   public void setRecipe(IRecipeLayout recipeLayout, FabricatorRecipeWrapper recipeWrapper, IIngredients ingredients) {
	      IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
	      stacks.init(this.INPUT, true, 6, 18);
	      stacks.init(this.CARD, true, 27, 18);
	      stacks.init(this.OUTPUT, false, 78, 18);
	      stacks.set(ingredients);
	   }

	@Override
	public Class<? extends FabricatorRecipeWrapper> getRecipeClass() {
		// TODO Auto-generated method stub
		return FabricatorRecipeWrapper.class;
	}

	@Override
	public IDrawable getIcon() {
		
		return icon;
	}

	@Override
	public void setIngredients(FabricatorRecipeWrapper recipe, IIngredients ingredients) {
		
	ingredients.setInputs(VanillaTypes.ITEM, recipe.getIngredientList());
	ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
				}
	}

