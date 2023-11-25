package io.github.cattslmao.bedrockparity.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FatalPoisonStatusEffect extends StatusEffect{

    public FatalPoisonStatusEffect(boolean fatal) {
        super(StatusEffectCategory.HARMFUL,0x4E9331);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
            entity.damage(entity.getDamageSources().magic(), 1.0F);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
}
