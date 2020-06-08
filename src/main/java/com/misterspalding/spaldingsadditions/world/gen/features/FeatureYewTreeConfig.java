package com.misterspalding.spaldingsadditions.world.gen.features;

import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

public class FeatureYewTreeConfig extends BaseTreeFeatureConfig {

	public final int height_base;
	public final int height_random;
	
	protected FeatureYewTreeConfig(BlockStateProvider trunk, BlockStateProvider leaves,
			  List<TreeDecorator> decorators, int height_base, int height_random) {
		super(trunk, leaves, decorators, height_base);
		this.height_base = height_base;
		this.height_random = height_random;
		
	}
	
	 @Override
	  public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
	    ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();

	    builder
	        .put(ops.createString("trunk_provider"), this.trunkProvider.serialize(ops))
	        .put(ops.createString("leaves_provider"), this.leavesProvider.serialize(ops))
	        .put(ops.createString("decorators"), ops.createList(this.decorators.stream().map(treeDecorator -> treeDecorator.serialize(ops))))
	        .put(ops.createString("base_height"), ops.createInt(this.height_base))
	        .put(ops.createString("height_random"), ops.createInt(this.height_random));

	    return new Dynamic<>(ops, ops.createMap(builder.build()));
	  }
	
	 public static <T> FeatureYewTreeConfig deserialize(Dynamic<T> dynamic) {
		    BlockStateProviderType<?> trunk = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(dynamic.get("trunk_provider").get("type").asString().orElseThrow(RuntimeException::new)));
		    BlockStateProviderType<?> leaves = Registry.BLOCK_STATE_PROVIDER_TYPE.getOrDefault(new ResourceLocation(dynamic.get("leaves_provider").get("type").asString().orElseThrow(RuntimeException::new)));

		    return new FeatureYewTreeConfig(
		        trunk.func_227399_a_(dynamic.get("trunk_provider").orElseEmptyMap()),
		        leaves.func_227399_a_(dynamic.get("leaves_provider").orElseEmptyMap()),
		        dynamic.get("decorators").asList(
		            dynamicx -> Registry.TREE_DECORATOR_TYPE.getOrDefault(
		                new ResourceLocation(dynamicx.get("type").asString().orElseThrow(RuntimeException::new))
		            ).func_227431_a_(dynamicx)
		        ),
		        dynamic.get("base_height").asInt(0),
		        dynamic.get("height_random").asInt(0)
		    );
		  }
	 
	 public static class Builder extends BaseTreeFeatureConfig.Builder {
		    private List<TreeDecorator> decorators = Lists.newArrayList();
		    private int baseheight;
		    private int heightRandom;

		    public Builder(BlockStateProvider trunk, BlockStateProvider leaves) {
		      super(trunk, leaves);
		    }

		    public Builder baseLength(int height) {
		      this.baseheight = height;
		      return this;
		    }

		    public Builder lengthRandom(int variance) {
		      this.heightRandom = variance;
		      return this;
		    }

		    @Override
		    public FeatureYewTreeConfig build() {
		      return new FeatureYewTreeConfig(this.trunkProvider, this.leavesProvider, this.decorators, this.baseheight, this.heightRandom);
		    }
		  }
		

}
