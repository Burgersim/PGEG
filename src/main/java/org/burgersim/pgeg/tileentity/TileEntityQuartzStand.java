package org.burgersim.pgeg.tileentity;

import com.github.ondee.snowflake.tileentity.TileEntityInventory;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;
import java.util.Iterator;

import static org.burgersim.pgeg.listener.PgegTileEntityTypes.QUARTZ_STAND;

public class TileEntityQuartzStand extends TileEntityInventory implements ITickable {

    private int time;
    private int prevTime;

    public TileEntityQuartzStand() {
        super(QUARTZ_STAND, 1, "tile.pgeg.quartz_stand");
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }


    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return getStackInSlot(i).isEmpty();
    }

    @Override
    public void update() {
        if (world.isRemote) {
            prevTime = time;
            time++;

            if (time > Integer.MAX_VALUE / 4) {
                time = 0;
            }
        }
    }

    public int getTime() {
        return time;
    }

    public int getPrevTime() {
        return prevTime;
    }
}
