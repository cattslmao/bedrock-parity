package io.github.cattslmao.bedrockparity.mixin;

import io.github.cattslmao.bedrockparity.BedrockParity;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class LoadWorld {
    @Inject(at = @At("TAIL"), method = "loadWorld")
    private void init(CallbackInfo info) {
        BedrockParity.setupWorld();
    }
}