package org.burgersim.pgeg.block.flower;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.burgersim.pgeg.tileentity.flower.TileEntityBloodrose;

import javax.annotation.Nullable;

public class BlockBloodrose extends BlockFlowerPot implements ITileEntityProvider {
    public BlockBloodrose(Block p_i48395_1_, Builder p_i48395_2_) {
        super (p_i48395_1_, p_i48395_2_);
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

/*    @Override
    protected boolean isValidGround(IBlockState state, IBlockReader blockReader, BlockPos blockPos) {
        return state.isTopSolid();
    }
*/

}
