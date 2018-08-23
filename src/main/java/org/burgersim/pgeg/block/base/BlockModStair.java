package org.burgersim.pgeg.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class BlockModStair extends BlockStairs {

    public BlockModStair(Block block, Builder builder) {
        super(block.getDefaultState(), builder);
    }

}
