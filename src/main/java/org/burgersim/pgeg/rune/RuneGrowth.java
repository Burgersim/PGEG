package org.burgersim.pgeg.rune;

import net.minecraft.block.IGrowable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RuneGrowth extends Rune {
    public RuneGrowth() {
        super(RuneType.BLOCK, 100, 0.5f, 0x1AC732, new ResourceLocation(MOD_ID, "textures/rune/rune_plant.png"));
    }

    @Override
    public void processBlock(World world, BlockPos blockPos, BlockPos runePos, int levelModifier) {
        if (world.getBlockState(blockPos).getBlock() instanceof IGrowable) {
            IGrowable growable = (IGrowable) world.getBlockState(blockPos).getBlock();
            growable.grow(world, world.rand, blockPos, world.getBlockState(blockPos));
        }
    }
}
