package org.burgersim.pgeg.block;


import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tags.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ShapeUtils;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockQuartzPillar extends Block {

    public BlockQuartzPillar() {
        super(Block.Builder.create(Blocks.QUARTZ_PILLAR));
    }

    @Override
    public VoxelShape getShape(IBlockState p_getShape_1_, IBlockReader p_getShape_2_, BlockPos p_getShape_3_) {
        VoxelShape shape = ShapeUtils.makeCuboidShape(0.0, 0.0, 0.0, 1.0, 0.1, 1.0);
        VoxelShape shape2 = ShapeUtils.makeCuboidShape(0.0, 0.8, 0.0, 1.0, 0.9, 1.0);
        VoxelShape shape3 = ShapeUtils.makeCuboidShape(0.1,0.0,0.1, 0.9, 0.9,0.9);
        return ShapeUtils.func_197872_a(ShapeUtils.func_197872_a(shape, shape2), shape3);
    }
}
