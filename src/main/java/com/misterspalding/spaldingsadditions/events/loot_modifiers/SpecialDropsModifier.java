package com.misterspalding.spaldingsadditions.events.loot_modifiers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;
import com.misterspalding.spaldingsadditions.SpaldingsAdditions;
import com.misterspalding.spaldingsadditions.inits.ItemDec;
import com.misterspalding.spaldingsadditions.objects.items.ModFrakHammer;
import com.misterspalding.spaldingsadditions.recipes.fabricator.AutoFrakRecipes;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialDropsModifier extends LootModifier {
    
	//AutoFrakRecipes recipeInstance = AutoFrakRecipes.instance();
	
	public SpecialDropsModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }
    
    

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
    	@SuppressWarnings("unused")
		Random random = new Random();
    	String broken = generatedLoot.toString();
    	ItemStack ctxTool = context.get(LootParameters.TOOL);
    	int enchant_level =  EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, ctxTool);
    	if (generatedLoot.size() == 0) {
    		
    		return generatedLoot;
    		
    	}
    	
    	
    	
    	ArrayList<ItemStack> ret = checkloots(generatedLoot, broken, enchant_level, ctxTool);
    	
    		if (generatedLoot.get(0).getItem() == ret.get(0).getItem() || EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, ctxTool) != 0) {
    			
    			return generatedLoot;
    			
    		} else {
    	
    	
    	
    	return ret;
    		}
    }

    /*
     * 
     * 
     * I have no doubt that this is NOT a recommended way to use the global loot modifier system.
     * 
     * If Draco18s saw this I'm sure he'd have very strong words.
     * 
     * Do as I say, not as I do. 
     * 
     * 
     */
   

    private ArrayList<ItemStack> checkloots(List<ItemStack> generatedLoot, String broken, int enchant, ItemStack tool) {
    	ArrayList<ItemStack> listReturn = new ArrayList<ItemStack>();
    	Random random = new Random();
    	

    	if (tool.getItem() instanceof ModFrakHammer) {
    		
    		for (Block block : SpaldingsAdditions.HAMMER_BLOCKS) {
    			
    			if (generatedLoot.get(0).getItem() == Item.getItemFromBlock(block)) {
    				
    				listReturn.add(AutoFrakRecipes.instance().getResult(generatedLoot.get(0), tool.getItem()));
    				return listReturn;
    			}
    			
    		if (broken.contains("lapis")) {
    			
    			if (tool.getItem() == ItemDec.TOOL_VENDAR_FRAKHAMMER.get()) {
    				listReturn.add(new ItemStack(ItemDec.FRACTURED_LAPIS.get(), 2 + random.nextInt(3)));
    				return listReturn;
    			}
    			
    			if (tool.getItem() == ItemDec.IRON_FRAKHAMMER.get()) {
    				listReturn.add(new ItemStack(ItemDec.LAPIS_SHARD.get(), 8 + random.nextInt(6)));
    				return listReturn;
    			}
    			
    		}
    		
    		if (broken.contains("clay")) {
    			listReturn.add(new ItemStack(Items.SAND));
    			return listReturn;
    		}
    			
    		}
    		
    	}
    	
    	
    	String checkedOre = "vendar";
    	if (broken.contains(checkedOre+"_ore")) {
    		
    		listReturn.add(new ItemStack(ItemDec.VENDAR_CHUNK.get(), 1 + random.nextInt(1 + enchant)));
    		
    		return listReturn;
    	}
    	
    	
    	checkedOre = "vendar";
    	if (broken.contains(checkedOre+"_ore_dense")) {
    		
    		listReturn.add(new ItemStack(ItemDec.VENDAR_CHUNK.get(), 3 + random.nextInt(1 + enchant)));
    		
    		return listReturn;
    	}
    	
    	   	
    	
    	checkedOre = "indirium";
    	if (broken.contains(checkedOre+"_ore")) {
    		
    		listReturn.add(new ItemStack(ItemDec.INDIRIUM_CHUNK.get(), 1 + random.nextInt(1 + enchant)));
    		
    		return listReturn;
    	}
    	
    	checkedOre = "vironium";
    	if (broken.contains(checkedOre+"_ore")) {
    		
    		listReturn.add(new ItemStack(ItemDec.VIRONIUM_CHUNK.get(), 1 + random.nextInt(1 + enchant)));
    		
    		return listReturn;
    	}
    	
    	checkedOre = "geldar";
    	if (broken.contains(checkedOre+"_ore")) {
    		
    		listReturn.add(new ItemStack(ItemDec.GELDAR_CHUNK.get(), 1 + random.nextInt(1 + enchant)));
    		
    		return listReturn;
    	}
    	
    	if (broken.contains("coal") && !broken.contains("coal_ore_")) {
    		listReturn = (ArrayList<ItemStack>) generatedLoot;
    		if (random.nextInt(200+enchant*2) >= 195) listReturn.add(new ItemStack(ItemDec.CHARGED_CARBON.get()));
    		
    		
    		return listReturn;
    	}
    	
    	//riddled coal ores
    	
    	checkedOre = "diamond";
    	if (broken.contains("coal_ore_"+checkedOre)) {
    		
    		listReturn.add(new ItemStack(Items.DIAMOND, 1 + random.nextInt(1 + enchant)));
    		listReturn.add(new ItemStack(Items.COAL, 1 + random.nextInt(1 + enchant)));
    		if (random.nextInt(20+enchant*2) >= 19) listReturn.add(new ItemStack(ItemDec.CHARGED_CARBON.get()));
    		return listReturn;
    	}
    	
    	checkedOre = "emerald";
    	if (broken.contains("coal_ore_"+checkedOre)) {
    		
    		listReturn.add(new ItemStack(Items.EMERALD, 1 + random.nextInt(1 + enchant)));
    		listReturn.add(new ItemStack(Items.COAL, 1 + random.nextInt(1 + enchant)));
    		if (random.nextInt(20+enchant*2) >= 19) listReturn.add(new ItemStack(ItemDec.CHARGED_CARBON.get()));
    		return listReturn;
    	}
    	
    	checkedOre = "lapis";
    	if (broken.contains("coal_ore_"+checkedOre)) {
    		
    		listReturn.add(new ItemStack(Items.LAPIS_LAZULI, 3+random.nextInt(3) + 3*random.nextInt(1 + enchant)));
    		listReturn.add(new ItemStack(Items.COAL, 1 + random.nextInt(1 + enchant)));
    		if (random.nextInt(20+enchant*2) >= 19) listReturn.add(new ItemStack(ItemDec.CHARGED_CARBON.get()));
    		return listReturn;
    	}
    	
    	checkedOre = "redstone";
    	if (broken.contains("coal_ore_"+checkedOre)) {
    		
    		listReturn.add(new ItemStack(Items.REDSTONE, 4 + random.nextInt(2) + 4*random.nextInt(1 + enchant)));
    		listReturn.add(new ItemStack(Items.COAL, 1 + random.nextInt(1 + enchant)));
    		if (random.nextInt(20+enchant*2) >= 19) listReturn.add(new ItemStack(ItemDec.CHARGED_CARBON.get()));
    		return listReturn;
    	}
    	
    	checkedOre = "iron";
    	if (broken.contains("coal_ore_"+checkedOre)) {
    		
    		if (ModList.get().isLoaded("fortunate")) {
    		listReturn.add(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("fortunate", "iron_chunk")), 1 + random.nextInt(1 + enchant)));
    		} else {
    		listReturn.add(new ItemStack(ItemDec.IRON_CHUNK.get(), 1 + random.nextInt(1 + enchant)));
    		}
    		if (random.nextInt(20+enchant*2) >= 19) listReturn.add(new ItemStack(ItemDec.CHARGED_CARBON.get()));
    		listReturn.add(new ItemStack(Items.COAL, 1 + random.nextInt(1 + enchant)));
    		return listReturn;
    	}
    	
    	checkedOre = "gold";
    	if (broken.contains("coal_ore_"+checkedOre)) {
    		
    		if (ModList.get().isLoaded("fortunate")) {
    		listReturn.add(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("fortunate", "gold_chunk")), 1 + random.nextInt(1 + enchant)));
    		} else {
    		listReturn.add(new ItemStack(ItemDec.GOLD_CHUNK.get(), 1 + random.nextInt(1 + enchant)));
    		}
    		if (random.nextInt(20+enchant*2) >= 19) listReturn.add(new ItemStack(ItemDec.CHARGED_CARBON.get()));
    		listReturn.add(new ItemStack(Items.COAL, 1 + random.nextInt(1 + enchant)));
    		return listReturn;
    	}
    	
    	return (ArrayList<ItemStack>) generatedLoot;
    	
		
		
	}



	public static class Serializer extends GlobalLootModifierSerializer<SpecialDropsModifier> {
        @Override
        public SpecialDropsModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditionsIn) {
            return new SpecialDropsModifier(conditionsIn);
        }
    }
}
