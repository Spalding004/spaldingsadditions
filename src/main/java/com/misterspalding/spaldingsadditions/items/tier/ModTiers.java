package com.misterspalding.spaldingsadditions.items.tier;

import java.util.function.Supplier;

import com.misterspalding.spaldingsadditions.inits.ItemDec;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public class ModTiers {

	
	
	public enum ModItemTiers implements IItemTier {
		VENDAR(3121, 9.0F, 2.5F, 4, 16, () -> {
		return Ingredient.fromItems(ItemDec.vendar_chunk);
	});
		
		private final int harvest;
		private final int dur;
		private final float eff;
		private final float att;
		private final int enchant;
		private final LazyValue<Ingredient> repair;
		
	private ModItemTiers(int dur, float eff, float att, int harvest, int enchant, Supplier<Ingredient> repair) {
		this.harvest = harvest;
		this.dur = dur;
		this.eff = eff;
		this.att = att;
		this.enchant = enchant;
		this.repair = new LazyValue<>(repair);
	}
		

		@Override
		public int getMaxUses() {
			// TODO Auto-generated method stub
			return this.dur;
		}

		@Override
		public float getEfficiency() {
			// TODO Auto-generated method stub
			return this.eff;
		}

		@Override
		public float getAttackDamage() {
			// TODO Auto-generated method stub
			return this.att;
		}

		@Override
		public int getHarvestLevel() {
			// TODO Auto-generated method stub
			return this.harvest;
		}

		@Override
		public int getEnchantability() {
			// TODO Auto-generated method stub
			return this.enchant;
		}

		@Override
		public Ingredient getRepairMaterial() {
			// TODO Auto-generated method stub
			return this.repair.getValue();
		}
		
	}
	
	
}
