package io.github.cattslmao.bedrockparity;

import io.github.cattslmao.bedrockparity.block.ExampleBlock;
import io.github.cattslmao.bedrockparity.effect.BedrockParityEffects;
import io.github.cattslmao.bedrockparity.mixin.ItemAccessor;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedrockParity implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Bedrock Parity");
	public static final Block EXAMPLE_BLOCK  = new ExampleBlock(FabricBlockSettings.create().strength(4.0f).nonOpaque());

	@Override
	public void onInitialize() {
		ParityConfig.initializeConfig();
		BedrockParityEffects.registerEffects();
		Registry.register(Registries.BLOCK, new Identifier("bedrock-parity", "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("bedrock-parity", "example_block"), new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings()));
	}


	public static void setupWorld() {
		// cake stacking
		((ItemAccessor) Items.CAKE).setMaxCount(ParityConfig.CAKE_STACKING.asBool() ? 64 : 1);
	}
}