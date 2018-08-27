package org.burgersim.pgeg.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModLeaves extends BlockLeaves {

    private final IItemProvider drop;

    public BlockModLeaves(Builder builder, IItemProvider drop) {
        super(builder);
        this.drop = drop;
    }

    @Override
    public IItemProvider getItemDropped(IBlockState p_getItemProvider_1_, World p_getItemProvider_2_, BlockPos p_getItemProvider_3_, int p_getItemProvider_4_) {
        return drop;
    }

}
