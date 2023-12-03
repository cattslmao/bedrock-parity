package io.github.cattslmao.bedrockparity.mixin.block.lightfiltering;

import io.github.cattslmao.bedrockparity.ParityConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HopperBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HopperBlock.class)
public abstract class HopperLightFiltering extends Block {

    public HopperLightFiltering(Settings settings) {
        super(settings);
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos p) {
        return ParityConfig.LIGHT_FILTERING.asBool() ? 3 : super.getOpacity(state, world, p);
    }
}