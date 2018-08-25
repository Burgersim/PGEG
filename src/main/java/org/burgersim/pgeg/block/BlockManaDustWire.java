package org.burgersim.pgeg.block;

import com.github.ondee.snowflake.block.BlockWaterlogged;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

public class BlockManaDustWire extends BlockWaterlogged {
    public static BooleanProperty EAST;
    public static BooleanProperty WEST;
    public static BooleanProperty NORTH;
    public static BooleanProperty SOUTH;
    protected static final VoxelShape[] SHAPES;

    public BlockManaDustWire(Builder builder) {
        super(builder);
        this.setDefaultState(
                this.getDefaultState()
                        .withProperty(EAST, false)
                        .withProperty(WEST, false)
                        .withProperty(NORTH, false)
                        .withProperty(SOUTH, false));
    }

    public VoxelShape getShape(IBlockState p_getShape_1_, IBlockReader p_getShape_2_, BlockPos p_getShape_3_) {
        return SHAPES[getAABBIndex(p_getShape_1_)];
    }

    private static int getAABBIndex(IBlockState state) {
        int index = 0;
        boolean north = state.getValue(NORTH);
        boolean east = state.getValue(EAST);
        boolean south = state.getValue(SOUTH);
        boolean west = state.getValue(WEST);
        if (north || south && !north && !east && !west) {
            index |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }

        if (east || west && !north && !east && !south) {
            index |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }

        if (south || north && !east && !south && !west) {
            index |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }

        if (west || east && !north && !south && !west) {
            index |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }

        return index;
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldReaderBase, BlockPos blockPos) {
        return worldReaderBase.getBlockState(blockPos.down()).isTopSolid();
    }

    @Override
    protected void addPropertiesToBuilder(StateContainer.Builder<Block, IBlockState> map) {
        super.addPropertiesToBuilder(map);
        map.add(EAST, WEST, NORTH, SOUTH);
    }

    @Override
    public IBlockState getStateForPlacement(BlockItemUseContext useContext) {
        IBlockState state = super.getStateForPlacement(useContext);
        World world = useContext.getWorld();
        BlockPos pos = useContext.getPos();
        world.notifyNeighbors(pos, this);
        return calculateState(state, world, pos);
    }

    private IBlockState calculateState(IBlockState state, World world, BlockPos pos) {
        return state
                .withProperty(EAST, world.getBlockState(pos.east()).getBlock() == this)
                .withProperty(WEST, world.getBlockState(pos.west()).getBlock() == this)
                .withProperty(NORTH, world.getBlockState(pos.north()).getBlock() == this)
                .withProperty(SOUTH, world.getBlockState(pos.south()).getBlock() == this);
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos blockPos, Block block, BlockPos blockPos1) {
        world.setBlockState(blockPos, calculateState(state, world, blockPos));
    }

    static {
        EAST = BooleanProperty.create("east");
        WEST = BooleanProperty.create("west");
        NORTH = BooleanProperty.create("north");
        SOUTH = BooleanProperty.create("south");
        SHAPES = new VoxelShape[]{Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 1.0D, 13.0D), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 1.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 13.0D, 1.0D, 13.0D), Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 13.0D, 1.0D, 16.0D), Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 13.0D, 1.0D, 13.0D), Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 13.0D, 1.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 13.0D, 1.0D, 13.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 13.0D, 1.0D, 16.0D), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 16.0D, 1.0D, 13.0D), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 16.0D, 1.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 1.0D, 13.0D), Block.makeCuboidShape(0.0D, 0.0D, 3.0D, 16.0D, 1.0D, 16.0D), Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 16.0D, 1.0D, 13.0D), Block.makeCuboidShape(3.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 13.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D)};
    }
}
