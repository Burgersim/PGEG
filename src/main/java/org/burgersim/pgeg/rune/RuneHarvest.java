package org.burgersim.pgeg.rune;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RuneHarvest extends Rune {
    public RuneHarvest() {
        super(RuneType.BLOCK, 20 * 5, 0.5f, 1, 0xFFFA9E, new ResourceLocation(MOD_ID, "textures/rune/rune_harvest.png"));
    }

    @Override
    public void processBlock(World world, BlockPos blockPos, BlockPos runePos, int levelModifier) {
        IBlockState state = world.getBlockState(blockPos);
        Block block = state.getBlock();
        if (block instanceof BlockCrops) {
            if (((BlockCrops) block).isMaxAge(state)) {
                world.destroyBlock(blockPos, true);
                world.setBlockState(blockPos, block.getDefaultState());
            }
        }
    }
}
