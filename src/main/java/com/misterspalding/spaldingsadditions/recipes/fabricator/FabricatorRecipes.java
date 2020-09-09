package com.misterspalding.spaldingsadditions.recipes.fabricator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;
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

public class FabricatorRecipes {

	

	private static final FabricatorRecipes SMELTING_BASE = new FabricatorRecipes();

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

	public static FabricatorRecipes instance() {
		return SMELTING_BASE;
	}

	private FabricatorRecipes() {

		/*
		 * 
		 * Overworld Recipes
		 * 
		 */
		
		Item forCard = ItemDec.CARD_BASIC.get();
		int STANDARD_TIME = 60;
		this.addFabricating(ItemDec.CHARGED_CARBON.get(), new ItemStack(Items.DIAMOND), STANDARD_TIME, forCard);
		
		this.addFabricating(Items.DIAMOND, new ItemStack(ItemDec.ENERGETIC_CRYSTAL.get()), STANDARD_TIME*5, forCard);
	
		this.addFabricating(ItemDec.INDIRIUM_INGOT.get(), new ItemStack(Items.IRON_INGOT), STANDARD_TIME, forCard);
		this.addFabricating(ItemDec.GELDAR_INGOT.get(), new ItemStack(ItemDec.INDIRIUM_INGOT.get()), STANDARD_TIME,
				forCard);
		this.addFabricating(ItemDec.VIRONIUM_INGOT.get(), new ItemStack(ItemDec.INDIRIUM_INGOT.get()), STANDARD_TIME,
				forCard);
		this.addFabricating(Items.ROTTEN_FLESH, new ItemStack(Items.LEATHER), STANDARD_TIME, forCard);
		this.addFabricating(Items.WATER_BUCKET, new ItemStack(Blocks.ICE), STANDARD_TIME, forCard);
		this.addFabricatingOreItem("ingots/silver", new ItemStack(ItemDec.VENDAR_INGOT.get()),
				(int) (STANDARD_TIME * 1.2), forCard);
		this.addFabricating(Items.COAL, new ItemStack(ItemDec.CHARGED_CARBON.get()), STANDARD_TIME*7, forCard);

		/*
		 * 
		 * NETHER RECIPES
		 * 
		 */
		
		forCard = ItemDec.CARD_NETHER.get();
		STANDARD_TIME = 75;

		this.addFabricatingOreItem("glass", new ItemStack(Items.OBSIDIAN), STANDARD_TIME, forCard);
		this.addFabricatingOreItem("sand", new ItemStack(Items.SOUL_SAND), STANDARD_TIME, forCard);
		this.addFabricating(Items.WATER_BUCKET, new ItemStack(Items.LAVA_BUCKET), STANDARD_TIME, forCard);
		this.addFabricatingOreItem("bones", new ItemStack(Items.BLAZE_ROD), (int) (STANDARD_TIME * 1.5), forCard);
		this.addFabricatingOreItem("ingots/silver", new ItemStack(Items.GOLD_INGOT), STANDARD_TIME, forCard);
		this.addFabricating(Items.FLINT, new ItemStack(Items.QUARTZ), STANDARD_TIME, forCard);
		this.addFabricating(ItemDec.INDIRIUM_INGOT.get(), new ItemStack(ItemDec.GELDAR_INGOT.get()), STANDARD_TIME,
				forCard);
		this.addFabricating(ItemDec.VIRONIUM_INGOT.get(), new ItemStack(ItemDec.GELDAR_INGOT.get()), STANDARD_TIME,
				forCard);
		this.addFabricating(Items.ENDER_PEARL, new ItemStack(ItemDec.NETHER_PEARL.get()), STANDARD_TIME, forCard);
		
		/*
		 * 
		 * END RECIPES
		 * 
		 */
		
		forCard = ItemDec.CARD_END.get();
		STANDARD_TIME = 90;

		this.addFabricating(Items.COBBLESTONE, new ItemStack(Items.END_STONE), STANDARD_TIME, forCard);
		this.addFabricating(Items.NETHERRACK, new ItemStack(BlockDec.ENDFECTED_NETHERRACK_A.get()), STANDARD_TIME,
				forCard);
		this.addFabricating(Items.APPLE, new ItemStack(Items.CHORUS_FRUIT), STANDARD_TIME, forCard);
		this.addFabricatingOreItem("chests/wooden", new ItemStack(Items.SHULKER_BOX), STANDARD_TIME, forCard);
		this.addFabricating(ItemDec.INDIRIUM_INGOT.get(), new ItemStack(ItemDec.VIRONIUM_INGOT.get()), STANDARD_TIME,
				forCard);
		this.addFabricating(ItemDec.GELDAR_INGOT.get(), new ItemStack(ItemDec.VIRONIUM_INGOT.get()), STANDARD_TIME,
				forCard);

	}

	@SuppressWarnings("unused")
	private void addFabricatingOre(Tag<Item> tag, ItemStack itemStack, int time, Item card) {
		if (tag == null) {
			return;
		} else {
			for (Item item : tag.getAllElements()) {

				if (card == ItemDec.CARD_BASIC.get()) {
					this.smeltingListOverworld.put(new ItemStack(item, 1), itemStack);
					this.timeListOverworld.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListOverworld.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.CARD_NETHER.get()) {
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
				if (card == ItemDec.CARD_BASIC.get()) {
					this.smeltingListOverworld.put(new ItemStack(item, 1), itemStack);
					this.timeListOverworld.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListOverworld.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.CARD_NETHER.get()) {
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

				if (card == ItemDec.CARD_BASIC.get()) {
					this.smeltingListOverworld.put(new ItemStack(item, 1), itemStack);
					this.timeListOverworld.put(new ItemStack(item, 1), Float.valueOf(time));
					this.ingredientListOverworld.add(new ItemStack(item, 1));
				}

				if (card == ItemDec.CARD_NETHER.get()) {
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
		if (card == ItemDec.CARD_BASIC.get()) {
			this.smeltingListOverworld.put(input, stack);
			this.timeListOverworld.put(input, Float.valueOf(experience));
			this.ingredientListOverworld.add(input);
		}

		if (card == ItemDec.CARD_NETHER.get()) {
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
		if (card == ItemDec.CARD_BASIC.get()) {
			for (Entry<ItemStack, ItemStack> entry : this.smeltingListOverworld.entrySet()) {
				if (this.compareItemStacks(stack, entry.getKey())) {
					return entry.getValue();
				}
			}
		}

		if (card == ItemDec.CARD_NETHER.get()) {
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
		if (card == ItemDec.CARD_BASIC.get()) {
			return this.smeltingListOverworld;
		}
		if (card == ItemDec.CARD_NETHER.get()) {
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
		if (card == ItemDec.CARD_BASIC.get()) {
			for (Entry<ItemStack, Float> entry : this.timeListOverworld.entrySet()) {
				if (this.compareItemStacks(stack, entry.getKey())) {
					return ((Float) entry.getValue()).floatValue();
				}
			}
		}
		if (card == ItemDec.CARD_NETHER.get()) {
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

}
