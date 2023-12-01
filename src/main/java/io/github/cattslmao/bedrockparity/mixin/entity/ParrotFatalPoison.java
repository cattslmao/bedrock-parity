package io.github.cattslmao.bedrockparity.mixin.entity;

import io.github.cattslmao.bedrockparity.BedrockParity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ParrotEntity.class)
public class ParrotFatalPoison {
    @Inject(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/ParrotEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z"), cancellable = true)
        private void parrotFatalPoison(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir){
        ((ParrotEntity) (Object) this).addStatusEffect(new StatusEffectInstance(BedrockParity.FATAL_POISON, 900));
        cir.setReturnValue(ActionResult.success(((ParrotEntity) (Object) this).getWorld().isClient));
        cir.cancel();
    }
}
