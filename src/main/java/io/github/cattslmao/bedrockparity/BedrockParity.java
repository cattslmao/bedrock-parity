package io.github.cattslmao.bedrockparity;

import io.github.cattslmao.bedrockparity.effect.BedrockParityEffects;
import io.github.cattslmao.bedrockparity.mixin.ItemAccessor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedrockParity implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Bedrock Parity");

	@Override
	public void onInitialize() {
		ParityConfig.initializeConfig();
		BedrockParityEffects.registerEffects();
	}


	public static void setupWorld() {
		// cake stacking
		((ItemAccessor) Items.CAKE).setMaxCount(ParityConfig.CAKE_STACKING.asBool() ? 64 : 1);
	}
}