package com.misterspalding.spaldingsadditions.integrations.jei.autofrak;

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

public class AutoFrakRecipeCategory extends AbstractAutoFrakRecipeCategory {
	   protected static final ResourceLocation TEXTURES = new ResourceLocation("spaldingsadditions:textures/gui/frakhammer_jei.png");
	   private final IDrawable background;
	   private final String name;
	   private final IDrawable icon;

	   public AutoFrakRecipeCategory(IGuiHelper helper) {
	      super(helper);
	      this.background = helper.createDrawable(TEXTURES, 0, 0, 104, 52);
	      this.name = "Automatic Frakhammer";
	      icon = helper.createDrawableIngredient(new ItemStack(BlockDec.AUTOFRAK.get()));
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
	      return new ResourceLocation(SpaldingsAdditions.MOD_ID, "autofrak");
	   }

	   public void setRecipe(IRecipeLayout recipeLayout, AutoFrakRecipeWrapper recipeWrapper, IIngredients ingredients) {
	      IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
	      stacks.init(this.INPUT, true, 6, 18);
	      stacks.init(this.CARD, true, 27, 18);
	      stacks.init(this.OUTPUT, false, 78, 18);
	      stacks.set(ingredients);
	   }

	@Override
	public Class<? extends AutoFrakRecipeWrapper> getRecipeClass() {
		// TODO Auto-generated method stub
		return AutoFrakRecipeWrapper.class;
	}

	@Override
	public IDrawable getIcon() {
		
		return icon;
	}

	@Override
	public void setIngredients(AutoFrakRecipeWrapper recipe, IIngredients ingredients) {
		
	ingredients.setInputs(VanillaTypes.ITEM, recipe.getIngredientList());
	ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
				}
	}

