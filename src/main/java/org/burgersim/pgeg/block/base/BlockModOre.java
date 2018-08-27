package org.burgersim.pgeg.block.base;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockModOre extends BlockOre {
    private final IItemProvider drop;
    private final int xpMin;
    private final int xpMax;

    public BlockModOre(Builder builder, IItemProvider drop, int xpMin, int xpMax) {
        super(builder);
        this.drop = drop;
        this.xpMin = xpMin;
        this.xpMax = xpMax;
    }

    @Override
    public void dropBlockAsItemWithChance(IBlockState state, World world, BlockPos blockPos, float p_dropBlockAsItemWithChance_4_, int p_dropBlockAsItemWithChance_5_) {
        super.dropBlockAsItemWithChance(state, world, blockPos, p_dropBlockAsItemWithChance_4_, p_dropBlockAsItemWithChance_5_);
        int xp = MathHelper.getInt(world.rand, xpMin, xpMax);
        this.dropXpOnBlockBreak(world, blockPos, xp);
    }

    @Override
    public IItemProvider getItemDropped(IBlockState p_getItemDropped_1_, World p_getItemDropped_2_, BlockPos p_getItemDropped_3_, int p_getItemDropped_4_) {
        return drop;
    }
}
