package com.misterspalding.spaldingsadditions.inits;

import net.minecraft.util.DamageSource;

public class DamagesDec {

	public static DamageSource VOID_WALKING;
	
	public static void initDamages() {
		VOID_WALKING = (new DamageSource("void_walking").setDamageAllowedInCreativeMode().setDamageBypassesArmor());
		
		
	}
}
