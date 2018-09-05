package org.burgersim.pgeg.block.flower;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.burgersim.pgeg.tileentity.flower.TileEntitySnowbell;

import javax.annotation.Nullable;

public class BlockSnowbell extends BlockFlower implements ITileEntityProvider {
    public final static BooleanProperty SNOWY;

    public BlockSnowbell(Builder p_i48396_1_) {
        super(p_i48396_1_);
        this.setDefaultState(this.getDefaultState().withProperty(SNOWY, false));
    }

    static {
        SNOWY = BooleanProperty.create("snowy");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader iBlockReader) {
        return new TileEntitySnowbell();
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> map) {
        super.fillStateContainer(map);
        map.add(SNOWY);
    }

    @Override
    public void onReplaced(IBlockState state, World world, BlockPos pos, IBlockState newState, boolean p_beforeReplacingBlock_5_) {
        if (state.getBlock() != newState.getBlock()) {
            world.removeTileEntity(pos);
        }
        super.onReplaced(state, world, pos, newState, p_beforeReplacingBlock_5_);
    }
}
