package io.github.cattslmao.bedrockparity.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ExampleBlock extends Block {

    public ExampleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos p) {
        return 10;
    }

}