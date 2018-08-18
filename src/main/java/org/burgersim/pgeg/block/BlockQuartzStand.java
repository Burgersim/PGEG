package org.burgersim.pgeg.block;


import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ShapeUtils;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.burgersim.pgeg.tileentity.TileEntityQuartzStand;

import javax.annotation.Nullable;

public class BlockQuartzStand extends Block implements ITileEntityProvider {

    public BlockQuartzStand() {
        super(Block.Builder.from(Blocks.QUARTZ_PILLAR));
    }
    private static final VoxelShape SHAPE;
    static {
        VoxelShape shape1 = ShapeUtils.create(0.0, 0.0, 0.0, 1.0, 0.1, 1.0);
        VoxelShape shape2 = ShapeUtils.create(0.0, 0.8, 0.0, 1.0, 0.9, 1.0);
        VoxelShape shape3 = ShapeUtils.create(0.1, 0.0, 0.1, 0.9, 0.9, 0.9);
        SHAPE = ShapeUtils.func_197872_a(ShapeUtils.func_197872_a(shape1, shape2), shape3);
    }

    @Override
    public VoxelShape getShape(IBlockState p_getShape_1_, IBlockReader p_getShape_2_, BlockPos p_getShape_3_) {
        return SHAPE;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader iBlockReader) {
        return new TileEntityQuartzStand();
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World world, BlockPos blockPos, EntityPlayer player, EnumHand hand, EnumFacing facing, float x, float y, float z) {
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(blockPos);
        if (te instanceof TileEntityQuartzStand) {
            TileEntityQuartzStand stand = (TileEntityQuartzStand) te;
            ItemStack held = player.getHeldItem(hand);
            if (!held.isEmpty()) {
                if (stand.isItemValidForSlot(0, held)) {
                    ItemStack add = held.copy();
                    add.setCount(1);
                    stand.setInventorySlotContents(0, add);
                    stand.markDirty();

                    if (!player.capabilities.isCreativeMode) {
                        held.shrink(1);
                        player.openContainer.detectAndSendChanges();
                    }
                }
            } else {
                ItemStack remove = stand.getStackInSlot(0).copy();
                if (!remove.isEmpty()) {
                    stand.setInventorySlotContents(0, ItemStack.EMPTY);
                    stand.markDirty();

                    if (!player.inventory.addItemStackToInventory(remove)) {
                        InventoryHelper.spawnItemStack(world, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), remove);
                    } else {
                        player.openContainer.detectAndSendChanges();
                    }
                }
            }
        }
        return true;
    }
}
