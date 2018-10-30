package org.burgersim.pgeg.tileentity;

import com.github.ondee.snowflake.tileentity.TileEntityInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;

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
    public void tick() {
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
