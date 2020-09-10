package com.misterspalding.spaldingsadditions.recipes.fabricator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Maps;
import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.misterspalding.spaldingsadditions.inits.ItemDec;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class AutoFrakRecipes {

	

	private static final AutoFrakRecipes SMELTING_BASE = new AutoFrakRecipes();

	private final Map<ItemStack, ItemStack> smeltingListOverworld = Maps.<ItemStack, ItemStack>newHashMap();
	private final List<ItemStack> ingredientListOverworld = new ArrayList<ItemStack>();
	private final Map<ItemStack, Float> timeListOverworld = Maps.<ItemStack, Float>newHashMap();

	private final Map<ItemStack, ItemStack> smeltingListNether = Maps.<ItemStack, ItemStack>newHashMap();
	private final List<ItemStack> ingredientListNether = new ArrayList<ItemStack>();
	private final Map<ItemStack, Float> timeListNether = Maps.<ItemStack, Float>newHashMap();

	private final Map<ItemStack, ItemStack> smeltingListEnd = Maps.<ItemStack, ItemStack>newHashMap();
	private final List<ItemStack> ingredientListEnd = new ArrayList<ItemStack>();
	private final Map<ItemStack, Float> timeListEnd = Maps.<ItemStack, Float>newHashMap();

	private final List<ItemStack> allIngredients = new ArrayList<ItemStack>();
	private final List<ItemStack> allOutputs = new ArrayList<ItemStack>();
	private final List<ItemStack> allCards = new ArrayList<ItemStack>();
	private final Set<Block> allBlocks = null;

	public static AutoFrakRecipes instance() {
		return SMELTING_BASE;
	}

	private AutoFrakRecipes() {

		
		
		/*
		 * 
		 * Iron Recipes
		 * 
		 */
		
		Item forCard = ItemDec.IRON_FRAKHAMMER.get();
		int STANDARD_TIME = 45;
		this.addFabricating(Items.LAPIS_ORE, new ItemStack(ItemDec.LAPIS_SHARD.get(), 12), STANDARD_TIME, forCard);
		this.addFabricating(Items.LAPIS_LAZULI, new ItemStack(ItemDec.LAPIS_SHARD.get(), 4), STANDARD_TIME, forCard);
		this.addFabricating(Items.COBBLESTONE, new ItemStack(Items.GRAVEL), STANDARD_TIME, forCard);
		this.addFabricating(Items.GRAVEL, new ItemStack(Items.CLAY), STANDARD_TIME, forCard);
		this.addFabricating(Items.CLAY, new ItemStack(Items.SAND), STANDARD_TIME, forCard);
		this.addFabricatingOreBlockMC("logs", new ItemStack(ItemDec.SAWDUST.get(), 2), STANDARD_TIME, forCard);
		
		/*
		 * 
		 * Vendar RECIPES
		 * 
		 */
		
		forCard = ItemDec.TOOL_VENDAR_FRAKHAMMER.get();
		STANDARD_TIME = 30;
		this.addFabricating(Items.LAPIS_ORE, new ItemStack(ItemDec.FRACTURED_LAPIS.get(), 3), STANDARD_TIME, forCard);
		
		this.addFabricating(Items.LAPIS_LAZULI, new ItemStack(ItemDec.FRACTURED_LAPIS.get()), STANDARD_TIME, forCard);
		this.addFabricating(Items.COBBLESTONE, new ItemStack(Items.GRAVEL), STANDARD_TIME, forCard);
		this.addFabricating(Items.GRAVEL, new ItemStack(Items.CLAY), STANDARD_TIME, forCard);
		this.addFabricating(Items.CLAY, new ItemStack(Items.SAND), STANDARD_TIME, forCard);
		this.addFabricatingOreBlockMC("logs", new ItemStack(ItemDec.SAWDUST.get(), 2), STANDARD_TIME, forCard);
		this.addFabricating(Items.ENDER_PEARL, new ItemStack(ItemDec.END_ESSENCE.get()), STANDARD_TIME*1.5f, forCard);
		
		
		//add block inputs to block set
		
		for (ItemStack itemstack : this.getInputs()) {
			
			Block itemToCheck = Block.getBlockFromItem(itemstack.getItem());
			
			if (itemToCheck != null) {
				SpaldingsAdditions.HAMMER_BLOCKS.add(itemToCheck);
				
			}
		}
		
	}

	@SuppressWarnings("unused")
	private void addFabricatingOre(Tag<Item> tag, ItemStack itemStack, int time, Item card) {
		if (tag == null) {
			return;
		} else {
			for (Item item : tag.getAllElements()) {

				if (card == ItemDec.IRON_FRAKHAMMER.get()) {
					this.smeltingListOverworld.put(new ItemStack(item, 1), itemStack);
					this.timeListOverworld.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListOverworld.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
					this.smeltingListNether.put(new ItemStack(item, 1), itemStack);
					this.timeListNether.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListNether.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.CARD_END.get()) {
					this.smeltingListEnd.put(new ItemStack(item, 1), itemStack);
					this.timeListEnd.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListEnd.add(new ItemStack(item, 1));
				}

				this.allCards.add(new ItemStack(card));
				this.allOutputs.add(itemStack);
				this.allIngredients.add(new ItemStack(item));
			}
		}
	}

	private void addFabricatingOreItem(String name, ItemStack itemStack, int time, Item card) {
		Tag<Item> tag = ItemTags.getCollection().get(new ResourceLocation("forge", name));
		if (tag == null) {
			return;
		} else {
			for (Item item : tag.getAllElements()) {
				if (card == ItemDec.IRON_FRAKHAMMER.get()) {
					this.smeltingListOverworld.put(new ItemStack(item, 1), itemStack);
					this.timeListOverworld.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListOverworld.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
					this.smeltingListNether.put(new ItemStack(item, 1), itemStack);
					this.timeListNether.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListNether.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.CARD_END.get()) {
					this.smeltingListEnd.put(new ItemStack(item, 1), itemStack);
					this.timeListEnd.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListEnd.add(new ItemStack(item, 1));
				}
				this.allCards.add(new ItemStack(card));
				this.allOutputs.add(itemStack);
				this.allIngredients.add(new ItemStack(item));
			}
		}
	}

	@SuppressWarnings("unused")
	private void addFabricatingOreBlock(String name, ItemStack itemStack, int time, Item card) {
		Tag<Block> tag = BlockTags.getCollection().get(new ResourceLocation("forge", name));
		if (tag == null) {
			return;
		} else {
			for (Block item : tag.getAllElements()) {

				if (card == ItemDec.IRON_FRAKHAMMER.get()) {
					this.smeltingListOverworld.put(new ItemStack(item, 1), itemStack);
					this.timeListOverworld.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListOverworld.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
					this.smeltingListNether.put(new ItemStack(item, 1), itemStack);
					this.timeListNether.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListNether.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.CARD_END.get()) {
					this.smeltingListEnd.put(new ItemStack(item, 1), itemStack);
					this.timeListEnd.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListEnd.add(new ItemStack(item, 1));
				}
				this.allCards.add(new ItemStack(card));
				this.allOutputs.add(itemStack);
				this.allIngredients.add(new ItemStack(item));
			}
		}

	}
	
	@SuppressWarnings("unused")
	private void addFabricatingOreBlockMC(String name, ItemStack itemStack, int time, Item card) {
		Tag<Block> tag = BlockTags.getCollection().get(new ResourceLocation("minecraft", name));
		if (tag == null) {
			return;
		} else {
			for (Block item : tag.getAllElements()) {

				if (card == ItemDec.IRON_FRAKHAMMER.get()) {
					this.smeltingListOverworld.put(new ItemStack(item, 1), itemStack);
					this.timeListOverworld.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListOverworld.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
					this.smeltingListNether.put(new ItemStack(item, 1), itemStack);
					this.timeListNether.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListNether.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.CARD_END.get()) {
					this.smeltingListEnd.put(new ItemStack(item, 1), itemStack);
					this.timeListEnd.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListEnd.add(new ItemStack(item, 1));
				}
				this.allCards.add(new ItemStack(card));
				this.allOutputs.add(itemStack);
				this.allIngredients.add(new ItemStack(item));
			}
		}

	}

	@SuppressWarnings("deprecation")
	public void addRecipeForBlock(Block input, ItemStack stack, float experience, Item card) {
		this.addFabricating(Item.getItemFromBlock(input), stack, experience, card);
	
	}

	public void addFabricating(Item input, ItemStack stack, float experience, Item card) {
		this.addRecipe(new ItemStack(input, 1), stack, experience, card);
		
	}

	public void addRecipe(ItemStack input, ItemStack stack, float experience, Item card) {
		if (getResult(input, card) != ItemStack.EMPTY) {
		}
		if (card == ItemDec.IRON_FRAKHAMMER.get()) {
			this.smeltingListOverworld.put(input, stack);
			this.timeListOverworld.put(input, Float.valueOf(experience));
			this.ingredientListOverworld.add(input);
		}

		if (card == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
			this.smeltingListNether.put(input, stack);
			this.timeListNether.put(input, Float.valueOf(experience));
			this.ingredientListNether.add(input);
		}

		if (card == ItemDec.CARD_END.get()) {
			this.smeltingListEnd.put(input, stack);
			this.timeListEnd.put(input, Float.valueOf(experience));
			this.ingredientListEnd.add(input);
		}
		this.allCards.add(new ItemStack(card));
		this.allOutputs.add(stack);
		this.allIngredients.add(input);
	}

	public ItemStack getResult(ItemStack stack, Item card) {
		if (card == ItemDec.IRON_FRAKHAMMER.get()) {
			for (Entry<ItemStack, ItemStack> entry : this.smeltingListOverworld.entrySet()) {
				if (this.compareItemStacks(stack, entry.getKey())) {
					return entry.getValue();
				}
			}
		}

		if (card == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
			for (Entry<ItemStack, ItemStack> entry : this.smeltingListNether.entrySet()) {
				if (this.compareItemStacks(stack, entry.getKey())) {
					return entry.getValue();
				}
			}
		}

		if (card == ItemDec.CARD_END.get()) {
			for (Entry<ItemStack, ItemStack> entry : this.smeltingListEnd.entrySet()) {
				if (this.compareItemStacks(stack, entry.getKey())) {
					return entry.getValue();
				}
			}
		}

		return ItemStack.EMPTY;
	}

	public boolean isValidIngredient(ItemStack stack) {

		return ingredientListOverworld.contains(stack) || ingredientListNether.contains(stack)
				|| ingredientListEnd.contains(stack);

	}

	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem() && (stack2.getTag() == stack1.getTag());
	}

	public Map<ItemStack, ItemStack> getSmeltingList(Item card) {
		if (card == ItemDec.IRON_FRAKHAMMER.get()) {
			return this.smeltingListOverworld;
		}
		if (card == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
			return this.smeltingListNether;
		}
		if (card == ItemDec.CARD_END.get()) {
			return this.smeltingListEnd;
		}
		return this.smeltingListOverworld;
	}

	public float getProcessTime(ItemStack stack, Item card) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;
		if (card == ItemDec.IRON_FRAKHAMMER.get()) {
			for (Entry<ItemStack, Float> entry : this.timeListOverworld.entrySet()) {
				if (this.compareItemStacks(stack, entry.getKey())) {
					return ((Float) entry.getValue()).floatValue();
				}
			}
		}
		if (card == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
			for (Entry<ItemStack, Float> entry : this.timeListNether.entrySet()) {
				if (this.compareItemStacks(stack, entry.getKey())) {
					return ((Float) entry.getValue()).floatValue();
				}
			}
		}
		if (card == ItemDec.CARD_END.get()) {
			for (Entry<ItemStack, Float> entry : this.timeListEnd.entrySet()) {
				if (this.compareItemStacks(stack, entry.getKey())) {
					return ((Float) entry.getValue()).floatValue();
				}
			}
		}
		return 0.0F;
	}

	public List<ItemStack> getInputs() {

		return this.allIngredients;

	}

	public List<ItemStack> getOutputs() {

		return this.allOutputs;

	}

	public List<ItemStack> getCards() {
		return this.allCards;
	}
	
	public Set<Block> getBlockInputs() {
		return this.allBlocks;
	}

}
