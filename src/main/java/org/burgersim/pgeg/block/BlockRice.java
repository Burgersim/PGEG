package org.burgersim.pgeg.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReaderBase;
import org.burgersim.pgeg.listener.PgegRegistry;

public class BlockRice extends BlockCrops implements IBucketPickupHandler, ILiquidContainer {
    public final static BooleanProperty isWaterlogged;

    public BlockRice(Builder builder) {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return PgegRegistry.RICE;
    }

    @Override
    protected IItemProvider getCropsItem() {
        return PgegRegistry.RICE;
    }
    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader blockReader, BlockPos blockPos) {
        return (state.getBlock() == Blocks.DIRT) && blockReader.getBlockState(blockPos.up()).isAir();
    }

    @Override
    public boolean isValidPosition(IBlockState state, IWorldReaderBase worldReaderBase, BlockPos blockPos) {
        return (worldReaderBase.getLightSubtracted(blockPos, 0) >= 8 || worldReaderBase.canSeeSky(blockPos)) &&
                state.get(isWaterlogged) && worldReaderBase.isAirBlock(blockPos.up());
    }

    @Override
    public Fluid pickupFluid(IWorld iWorld, BlockPos blockPos, IBlockState iBlockState) {
        if (iBlockState.get(isWaterlogged)) {
            iWorld.setBlockState(blockPos, iBlockState.with(isWaterlogged, false), 3);
            return Fluids.WATER;
        } else {
            return Fluids.EMPTY;
        }
    }

    public IBlockState getStateForPlacement(BlockItemUseContext useContext) {
        IFluidState fluidState = useContext.getWorld().getFluidState(useContext.getPos());
        return this.getDefaultState().with(isWaterlogged, fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    public boolean canContainFluid(IBlockReader iBlockReader, BlockPos blockPos, IBlockState iBlockState, Fluid fluid) {
        return !iBlockState.get(isWaterlogged) && fluid == Fluids.WATER;
    }

    @Override
    public boolean receiveFluid(IWorld iWorld, BlockPos blockPos, IBlockState iBlockState, IFluidState iFluidState) {
        if (!iBlockState.get(isWaterlogged) && iFluidState.getFluid() == Fluids.WATER) {
            if (!iWorld.isRemote()) {
                iWorld.setBlockState(blockPos, iBlockState.with(isWaterlogged, true), 3);
                iWorld.getPendingFluidTicks().scheduleTick(blockPos, iFluidState.getFluid(), iFluidState.getFluid().getTickRate(iWorld));
            }
            return true;
        }
        return false;
    }


    public IBlockState updatePostPlacement(IBlockState state, EnumFacing facing, IBlockState state1, IWorld world, BlockPos blockPos, BlockPos blockPos1) {
        if (state.get(isWaterlogged)) {
            world.getPendingFluidTicks().scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.updatePostPlacement(state, facing, state1, world, blockPos, blockPos1);
    }

    @Override
    protected void fillStateContainer(net.minecraft.state.StateContainer.Builder<Block, IBlockState> map) {
        super.fillStateContainer(map);
        map.add(isWaterlogged);
    }

    @Override
    public boolean isFullCube(IBlockState p_isFullCube_1_) {
        return false;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockReader reader, IBlockState blockState, BlockPos pos, EnumFacing facing) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public IFluidState getFluidState(IBlockState blockState) {
        return blockState.get(isWaterlogged) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(blockState);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    public int getOpacity(IBlockState p_getOpacity_1_, IBlockReader p_getOpacity_2_, BlockPos p_getOpacity_3_) {
        return Blocks.WATER.getDefaultState().getOpacity(p_getOpacity_2_, p_getOpacity_3_);
    }

    static {
        isWaterlogged = BlockStateProperties.WATERLOGGED;
    }
}
