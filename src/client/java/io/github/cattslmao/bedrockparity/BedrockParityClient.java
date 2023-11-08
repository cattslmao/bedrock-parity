package io.github.cattslmao.bedrockparity;

import net.fabricmc.api.ClientModInitializer;

public class BedrockParityClient implements ClientModInitializer {
	public static final ParityConfig config = new ParityConfig("client");

	@Override
	public void onInitializeClient() {
		config.load();

		config.save();
	}
}