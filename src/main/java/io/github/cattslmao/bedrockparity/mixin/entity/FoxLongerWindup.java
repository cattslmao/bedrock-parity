package io.github.cattslmao.bedrockparity.mixin.entity;

import net.minecraft.entity.passive.FoxEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(FoxEntity.class)
public class FoxLongerWindup {
    @ModifyConstant(method = "tick", constant = @Constant(floatValue = 0.2F, ordinal = 1))
    private float injected(float constant){
        return constant/3.45F;
    }
}
