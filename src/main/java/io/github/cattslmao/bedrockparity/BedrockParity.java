package io.github.cattslmao.bedrockparity;

import io.github.cattslmao.bedrockparity.mixin.ItemAccessor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedrockParity implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Bedrock Parity");
	public static final ParityConfig config = new ParityConfig("server");

	@Override
	public void onInitialize() {
		config.load();

		config.save();
	}

	public static final ParityConfig.Setting CAKE_STACKING = config.register(new ParityConfig.Setting("cakeStacking").setDefault(true));

	public static void setupWorld() {
		// cake stacking
		((ItemAccessor) Items.CAKE).setMaxCount(CAKE_STACKING.getAsBoolean() ? 64 : 1);
	}
}