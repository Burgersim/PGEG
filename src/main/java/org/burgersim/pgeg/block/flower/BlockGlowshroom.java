package org.burgersim.pgeg.block.flower;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReaderBase;

public class BlockGlowshroom extends BlockFlowerPot {
    public BlockGlowshroom(Block p_i48395_1_, Builder p_i48395_2_) {
        super (p_i48395_1_, p_i48395_2_);
    }

    @Override
    public int getLightValue(IBlockState p_getLightValue_1_) {
        return 15;
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldReaderBase, BlockPos blockPos) {
        return worldReaderBase.getBlockState(blockPos.down()).isTopSolid();
    }

/*    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader blockReader, BlockPos blockPos) {
        return state.isTopSolid();
    }
*/
}
