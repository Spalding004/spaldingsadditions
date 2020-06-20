package com.misterspalding.spaldingsadditions.recipes;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RecipeDec {
	
	 public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(ForgeRegistries.RECIPE_SERIALIZERS, SpaldingsAdditions.MOD_ID);

	 public static final RegistryObject<IRecipeSerializer<?>> FABRICATOR = RECIPE_SERIALIZERS.register("fabricator", () ->
     FabricatorRecipe.serializer);
   
}