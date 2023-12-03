package io.github.cattslmao.bedrockparity;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BedrockParityClient implements ClientModInitializer {
	public static final ParityConfigHandler config = new ParityConfigHandler("client");

	@Override
	public void onInitializeClient() {
		config.load();

		config.save();
	}
}