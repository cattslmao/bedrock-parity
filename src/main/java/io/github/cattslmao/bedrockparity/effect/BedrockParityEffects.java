package io.github.cattslmao.bedrockparity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BedrockParityEffects {
    public static final StatusEffect FATAL_POISON = new FatalPoisonStatusEffect(true);

    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier("bedrock-parity", "fatal_poison"), FATAL_POISON);
    }
}
