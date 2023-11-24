package io.github.cattslmao.bedrockparity;

import io.github.cattslmao.bedrockparity.effect.FatalPoisonStatusEffect;
import io.github.cattslmao.bedrockparity.mixin.ItemAccessor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedrockParity implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Bedrock Parity");
	public static final ParityConfig config = new ParityConfig("server");
	public static final StatusEffect FATAL_POISON = new FatalPoisonStatusEffect(true);
	@Override
	public void onInitialize() {
		config.load();
		Registry.register(Registries.STATUS_EFFECT, new Identifier("bedrockparity", "fatal_poison"), FATAL_POISON);
		config.save();
	}

	public static final ParityConfig.Setting CAKE_STACKING = config.register(new ParityConfig.Setting("cakeStacking").setDefault(true));

	public static void setupWorld() {
		// cake stacking
		((ItemAccessor) Items.CAKE).setMaxCount(CAKE_STACKING.getAsBoolean() ? 64 : 1);
	}
}