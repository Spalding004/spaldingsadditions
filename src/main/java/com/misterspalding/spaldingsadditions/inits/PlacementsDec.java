package com.misterspalding.spaldingsadditions.inits;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Stream;

import com.misterspalding.spaldingsadditions.Main;
import com.misterspalding.spaldingsadditions.world.placement.EndfectionPlacement;
import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.ChorusPlant;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class PlacementsDec <DC extends IPlacementConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<Placement<?>> {

	
	public static final Placement<NoPlacementConfig> ENDFECTION = register("endfection_place", new EndfectionPlacement(NoPlacementConfig::deserialize));
	
	   private final Function<Dynamic<?>, ? extends DC> configFactory;
	
	public static <T extends IPlacementConfig, G extends Placement<T>> G register(String key, G p_214999_1_) {
	      return (G)(Registry.<Placement<?>>register(Registry.DECORATOR, key, p_214999_1_));
	   }

	   public PlacementsDec(Function<Dynamic<?>, ? extends DC> configFactoryIn) {
	      this.configFactory = configFactoryIn;
	   }

	   public DC createConfig(Dynamic<?> p_215001_1_) {
	      return (DC)(this.configFactory.apply(p_215001_1_));
	   }

	  

	   protected <FC extends IFeatureConfig, F extends Feature<FC>> boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> p_214998_2_, Random random, BlockPos pos, DC p_214998_5_, ConfiguredFeature<FC, F> p_214998_6_) {
	      AtomicBoolean atomicboolean = new AtomicBoolean(false);
	      this.getPositions(worldIn, p_214998_2_, random, p_214998_5_, pos).forEach((p_215000_5_) -> {
	         boolean flag = p_214998_6_.place(worldIn, p_214998_2_, random, p_215000_5_);
	         atomicboolean.set(atomicboolean.get() || flag);
	      });
	      return atomicboolean.get();
	   }

	   public abstract Stream<BlockPos> getPositions(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generatorIn, Random random, DC configIn, BlockPos pos);

	   public String toString() {
	      return this.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode());
	   }
}
