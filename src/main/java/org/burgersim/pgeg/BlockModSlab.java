package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class BlockModSlab extends BlockSlab {

    public BlockModSlab(String name) {
        super(Builder.create(new BlockModSlab(name)));
 //       Block.registerBlock(new ResourceLocation("pgeg", name), this);
    }

}
