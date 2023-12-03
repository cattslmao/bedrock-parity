package io.github.cattslmao.bedrockparity.mixin.entity;

import io.github.cattslmao.bedrockparity.ParityConfig;
import net.minecraft.entity.passive.FoxEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(FoxEntity.class)
public class FoxLongerWindup {
    @ModifyConstant(method = "tick", constant = @Constant(floatValue = 0.2F, ordinal = 1))
    private float windupSpeed(float constant){
        return ParityConfig.FOX_LONGER_WINDUP.asBool() ? constant/3.45F : constant;
    }
}
