package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class BlockModStair extends BlockStairs {

    public BlockModStair(String name, IBlockState blockState) {
        super(blockState, BlockStairs.Builder.create(new BlockModStair(name, blockState)));
        Block.registerBlock(new ResourceLocation("pgeg", name), this);
    }

}
