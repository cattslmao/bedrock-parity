package io.github.cattslmao.bedrockparity;

import io.github.cattslmao.bedrockparity.mixin.ItemAccessor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedrockParity implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("bedrock-parity");
	public static final ParityConfig config = new ParityConfig();

	@Override
	public void onInitialize() {
		ParityConfig.Setting CAKE_STACKING = config.register(new ParityConfig.Setting("cakeStacking").setDefault(true));

		config.load();

		if ( CAKE_STACKING.getBoolean() ) {
			((ItemAccessor) Items.CAKE).setMaxCount(64);
			LOGGER.info("Cakes patched.");
		} else {
			LOGGER.info("Cakes not patched.");
		}

		config.debugPrint();

		// config.save();
	}
}