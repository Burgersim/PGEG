package org.burgersim.pgeg.block.flower;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Particles;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.burgersim.pgeg.tileentity.flower.TileEntityBloodrose;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockBloodrose extends BlockFlower implements ITileEntityProvider {
    public BlockBloodrose(Builder p_i48396_1_) {
        super(p_i48396_1_);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader iBlockReader) {
        return new TileEntityBloodrose();
    }
    @Override
    public void onReplaced(IBlockState state, World world, BlockPos pos, IBlockState newState, boolean p_beforeReplacingBlock_5_) {
        if (state.getBlock() != newState.getBlock()) {
            world.removeTileEntity(pos);
        }
        super.onReplaced(state, world, pos, newState, p_beforeReplacingBlock_5_);
    }
}
