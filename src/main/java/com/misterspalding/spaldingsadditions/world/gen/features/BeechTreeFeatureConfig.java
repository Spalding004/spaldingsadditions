package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.misterspalding.spaldingsadditions.inits.BlockDec;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

public class BeechTreeFeatureConfig extends BaseTreeFeatureConfig implements IFeatureConfig {

	 public final BlockStateProvider trunkProvider;
	   public final BlockStateProvider leavesProvider;
	   public final List<TreeDecorator> decorators;
	   public final int baseHeight;
	   public transient boolean forcePlacement;
	   protected net.minecraftforge.common.IPlantable sapling = (net.minecraftforge.common.IPlantable)BlockDec.BEECH_SAPLING.get();

	   protected BeechTreeFeatureConfig(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn, List<TreeDecorator> decoratorsIn, int baseHeightIn) {
	      super(leavesProviderIn, leavesProviderIn, decoratorsIn, baseHeightIn);
		  this.trunkProvider = trunkProviderIn;
	      this.leavesProvider = leavesProviderIn;
	      this.decorators = decoratorsIn;
	      this.baseHeight = baseHeightIn;
	   }

	   public void forcePlacement() {
	      this.forcePlacement = true;
	   }

	   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
	      ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();
	      builder.put(ops.createString("trunk_provider"), this.trunkProvider.serialize(ops)).put(ops.createString("leaves_provider"), this.leavesProvider.serialize(ops)).put(ops.createString("decorators"), ops.createList(this.decorators.stream().map((p_227375_1_) -> {
	         return p_227375_1_.serialize(ops);
	      }))).put(ops.createString("base_height"), ops.createInt(this.baseHeight));
	      return new Dynamic<>(ops, ops.createMap(builder.build()));
	   }

	   protected BeechTreeFeatureConfig setSapling(net.minecraftforge.common.IPlantable value) {
	      this.sapling = value;
	      return this;
	   }

	   public net.minecraftforge.common.IPlantable getSapling() {
	       return this.sapling;
	   }

	   public static <T> BeechTreeFeatureConfig deserialize(Dynamic<T> data) {
	      BlockStateProviderType<?> blockstateprovidertype = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(data.get("trunk_provider").get("type").asString().orElseThrow(RuntimeException::new)));
	      BlockStateProviderType<?> blockstateprovidertype1 = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(data.get("leaves_provider").get("type").asString().orElseThrow(RuntimeException::new)));
	      return new BeechTreeFeatureConfig(blockstateprovidertype.func_227399_a_(data.get("trunk_provider").orElseEmptyMap()), blockstateprovidertype1.func_227399_a_(data.get("leaves_provider").orElseEmptyMap()), data.get("decorators").asList((p_227374_0_) -> {
	         return Registry.TREE_DECORATOR_TYPE.getOrDefault(new ResourceLocation(p_227374_0_.get("type").asString().orElseThrow(RuntimeException::new))).func_227431_a_(p_227374_0_);
	      }), data.get("base_height").asInt(0));
	   }

	  

	   public static class Builder {
	      public final BlockStateProvider trunkProvider;
	      public final BlockStateProvider leavesProvider;
	      private List<TreeDecorator> decorators = Lists.newArrayList();
	      private int baseHeight = 0;
	      protected net.minecraftforge.common.IPlantable sapling = (net.minecraftforge.common.IPlantable)BlockDec.BEECH_SAPLING.get();

	      public Builder(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn) {
	         this.trunkProvider = trunkProviderIn;
	         this.leavesProvider = leavesProviderIn;
	      }

	      public BeechTreeFeatureConfig.Builder baseHeight(int baseHeightIn) {
	         this.baseHeight = baseHeightIn;
	         return this;
	      }

	      public BeechTreeFeatureConfig.Builder setSapling(net.minecraftforge.common.IPlantable value) {
	         this.sapling = value;
	         return this;
	      }

	      public BeechTreeFeatureConfig build() {
	         return new BeechTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.decorators, this.baseHeight).setSapling(sapling);
	      }
	   }
}