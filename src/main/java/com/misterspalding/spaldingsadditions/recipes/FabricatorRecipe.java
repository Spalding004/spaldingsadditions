package com.misterspalding.spaldingsadditions.recipes;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class FabricatorRecipe implements IRecipe<IInventory> {

    public static final IRecipeType<FabricatorRecipe> basic_card = IRecipeType.register("fabricator_basic");
    public static final IRecipeType<FabricatorRecipe> nether_card = IRecipeType.register("fabricator_nether");
    public static final IRecipeType<FabricatorRecipe> end_card = IRecipeType.register("fabricator_end");
    public static final Serializer serializer = new Serializer();

    private final ResourceLocation recipeId;
    private Ingredient input;
    private Ingredient card;
    private ItemStack result;
    private int processTime;

    public FabricatorRecipe(ResourceLocation recipeId) {
        this.recipeId = recipeId;
    }

    public Ingredient getIngredient() {
        return input;
    }

    public Ingredient getCard() {
        return card;
    }

    public ItemStack getResult() {
        return result;
    }

    public int getProcessTime() {
        return processTime;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        ItemStack stack = inv.getStackInSlot(0);
        
        
        return card.test(stack);
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return recipeId;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return serializer;
    }

    @Override
    public IRecipeType<?> getType() {
     //   return recipeType;
    	//TODO add switch state on recipe type... does this even get called?
    	return basic_card;
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<FabricatorRecipe> {

        public static ArrayList<Item> ingredientList = new ArrayList<>();

        @Override
        public FabricatorRecipe read(ResourceLocation recipeId, JsonObject json) {

            FabricatorRecipe recipe = new FabricatorRecipe(recipeId);

            recipe.input = Ingredient.deserialize(json.get("input"));
           
           
            for (ItemStack stack : recipe.input.getMatchingStacks()) {
                if (!ingredientList.contains(stack.getItem())) ingredientList.add(stack.getItem());
            }
            
           

            ResourceLocation fluidResourceLocation = ResourceLocation.create(JSONUtils.getString(json.get("result").getAsJsonObject(), "output", "minecraft:empty"), ':');
            int itemAmount = JSONUtils.getInt(json.get("result").getAsJsonObject(), "amount", 0);
            recipe.result = new ItemStack(ForgeRegistries.ITEMS.getValue(fluidResourceLocation), itemAmount);

            recipe.processTime = JSONUtils.getInt(json, "processTime", 200);;

            return recipe;
        }

        @Nullable
        @Override
        public FabricatorRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            FabricatorRecipe recipe = new FabricatorRecipe(recipeId);
            recipe.input = Ingredient.read(buffer);
            recipe.card = Ingredient.read(buffer);
           
            recipe.result = buffer.readItemStack();
            recipe.processTime = buffer.readInt();
            return recipe;
        }

        @Override
        public void write(PacketBuffer buffer, FabricatorRecipe recipe) {
            recipe.input.write(buffer);
            recipe.card.write(buffer);
            
            buffer.writeItemStack(recipe.getResult());
            buffer.writeInt(recipe.getProcessTime());
        }
    }
}