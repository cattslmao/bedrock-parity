package io.github.cattslmao.bedrockparity.mixin.block.lightfiltering;

import io.github.cattslmao.bedrockparity.ParityConfig;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AnvilBlock.class)
public abstract class AnvilLightFiltering extends Block {

    public AnvilLightFiltering(Settings settings) {
        super(settings);
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos p) {
        return ParityConfig.LIGHT_FILTERING.asBool() ? 3 : super.getOpacity(state, world, p);
    }
}