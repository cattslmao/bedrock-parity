package io.github.cattslmao.bedrockparity.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.cattslmao.bedrockparity.BedrockParity;
import io.github.cattslmao.bedrockparity.effect.BedrockParityEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net/minecraft/client/gui/hud/InGameHud$HeartType")
@Environment(EnvType.CLIENT)
public abstract class FatalPoisonHeart {

    @ModifyExpressionValue(method = "fromPlayerState", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z", ordinal = 0))
    private static boolean ifFatalPoison(boolean isPoisoned, PlayerEntity player){
        return isPoisoned || player.hasStatusEffect(BedrockParityEffects.FATAL_POISON);
    }
}