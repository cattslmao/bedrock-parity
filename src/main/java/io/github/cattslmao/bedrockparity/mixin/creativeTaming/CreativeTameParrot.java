package io.github.cattslmao.bedrockparity.mixin.creativeTaming;

import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ParrotEntity.class)
public class CreativeTameParrot{
    // there should be a better way of doing it but idk one yet
    @Unique
    boolean creative;

    @Inject(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;nextInt(I)I"))
    private void injected(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        creative = player.getAbilities().creativeMode;
    }
    @ModifyArg(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/random/Random;nextInt(I)I"))
    private int injected(int var1){
        if (creative) return 1;
        return var1;
    }
}

