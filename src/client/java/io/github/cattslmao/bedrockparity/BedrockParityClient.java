package io.github.cattslmao.bedrockparity;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class BedrockParityClient implements ClientModInitializer {
	public static final ParityConfigHandler config = new ParityConfigHandler("client");

	@Override
	public void onInitializeClient() {
		config.load();
			BlockRenderLayerMap.INSTANCE.putBlock(BedrockParity.EXAMPLE_BLOCK, RenderLayer.getCutout());
		config.save();
	}
}