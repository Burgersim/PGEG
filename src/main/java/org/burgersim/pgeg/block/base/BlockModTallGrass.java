package org.burgersim.pgeg.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlockModTallGrass extends BlockTallGrass {
    public BlockModTallGrass(Builder builder) {
        super(builder);
    }

    @Override
    protected boolean isValidGround(IBlockState p_isValidGround_1_, IBlockReader p_isValidGround_2_, BlockPos p_isValidGround_3_) {
        Block lvt_4_1_ = p_isValidGround_1_.getBlock();
        return lvt_4_1_ instanceof BlockGrass || lvt_4_1_ == Blocks.DIRT || lvt_4_1_ == Blocks.COARSE_DIRT || lvt_4_1_ == Blocks.PODZOL || lvt_4_1_ == Blocks.FARMLAND;
    }

}
