package io.github.cattslmao.bedrockparity.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.cattslmao.bedrockparity.BedrockParity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net/minecraft/client/gui/hud/InGameHud$HeartType")
@Environment(EnvType.CLIENT)
public abstract class FatalPoisonHeart {

    @ModifyExpressionValue(method = "fromPlayerState",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isFrozen()Z"))
    private static boolean ifFrozen(boolean original, PlayerEntity player){
        return original || player.hasStatusEffect(BedrockParity.FATAL_POISON);
    }

}