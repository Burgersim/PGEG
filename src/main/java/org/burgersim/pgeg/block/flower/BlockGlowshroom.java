package org.burgersim.pgeg.block.flower;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;

public class BlockGlowshroom extends BlockFlower {
    public BlockGlowshroom(Builder p_i48396_1_) {
        super(p_i48396_1_);
    }

    @Override
    public int getLightValue(IBlockState p_getLightValue_1_) {
        return 15;
    }
}
