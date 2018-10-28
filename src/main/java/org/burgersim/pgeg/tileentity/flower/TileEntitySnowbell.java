package org.burgersim.pgeg.tileentity.flower;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import org.burgersim.pgeg.block.flower.BlockSnowbell;
import org.burgersim.pgeg.listener.PgegRegistry;

import static org.burgersim.pgeg.listener.PgegTileEntityTypes.SNOWBELL;

public class TileEntitySnowbell extends TileEntity implements ITickable {
    private static final int WORK_SPEED = 80;
    private static final int WORK_RADIUS = 2;
    private static final float SNOW_CHANCE = 0.2f;

    public TileEntitySnowbell() {
        super(SNOWBELL);
    }

    private int time;

    @Override
    public void tick() {
        if (!world.isRemote) {
            time++;
            if (time == WORK_SPEED) {
                time = 0;
                BlockPos.getAllInBox(this.pos.add(WORK_RADIUS, -1, WORK_RADIUS),
                        this.pos.add(-WORK_RADIUS, 2, -WORK_RADIUS))
                        .forEach(this::processBlock);
            }
        }
    }

    private void processBlock(BlockPos blockPos) {
        Block block = world.getBlockState(blockPos).getBlock();
        Block ground = world.getBlockState(blockPos.down()).getBlock();
        if (world.isAirBlock(blockPos) && ground.isTopSolid(world.getBlockState(blockPos.down()))) {
            if (world.rand.nextFloat() < SNOW_CHANCE) {
                world.setBlockState(blockPos, Blocks.SNOW.getDefaultState());
            }
        }
        if (block == PgegRegistry.SNOWBELL && !world.getBlockState(blockPos).get(BlockSnowbell.SNOWY)) {
            if (world.rand.nextFloat() < SNOW_CHANCE) {
                world.setBlockState(blockPos, world.getBlockState(blockPos).with(BlockSnowbell.SNOWY, true));
            }
        }
        if (block == Blocks.WATER) {
            if (world.rand.nextFloat() < SNOW_CHANCE) {
                world.setBlockState(blockPos, Blocks.ICE.getDefaultState());
            }
        }
        if (block == Blocks.LAVA) {
            if (world.rand.nextFloat() < SNOW_CHANCE) {
                world.setBlockState(blockPos, Blocks.OBSIDIAN.getDefaultState());
            }
        }
    }
}
