package io.github.cattslmao.bedrockparity.mixin.entity;

import io.github.cattslmao.bedrockparity.BedrockParity;
import io.github.cattslmao.bedrockparity.ParityConfig;
import io.github.cattslmao.bedrockparity.effect.BedrockParityEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ParrotEntity.class)
public class ParrotFatalPoison {
//      could do it this way maybe
//    @ModifyArg(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/effect/StatusEffectInstance;<init>(Lnet/minecraft/entity/effect/StatusEffect;I)V"), index = 0)
//    private StatusEffect injected(StatusEffect type){
//        return BedrockParityEffects.FATAL_POISON;
//    }
    @Inject(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/ParrotEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z"), cancellable = true)
        private void parrotFatalPoison(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir){
        ((ParrotEntity) (Object) this).addStatusEffect(new StatusEffectInstance(BedrockParityEffects.FATAL_POISON, 900));
        cir.setReturnValue(ActionResult.success(((ParrotEntity) (Object) this).getWorld().isClient));
        cir.cancel();
    }
}
