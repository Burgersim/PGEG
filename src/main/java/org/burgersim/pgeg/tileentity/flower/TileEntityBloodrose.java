package org.burgersim.pgeg.tileentity.flower;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

import static org.burgersim.pgeg.listener.PgegTileEntityTypes.BLOODROSE;

public class TileEntityBloodrose extends TileEntity implements ITickable {
    private static final int WORK_SPEED = 100;
    private static final int WORK_RADIUS = 2;

    public TileEntityBloodrose() {
        super(BLOODROSE);
    }

    private int time;

    @Override
    public void tick() {
        if (!world.isRemote) {
            time++;
            if (time == WORK_SPEED) {
                time = 0;
                world.getEntitiesWithinAABB(EntityPlayer.class,
                        new AxisAlignedBB(this.pos.add(WORK_RADIUS, -1, WORK_RADIUS)
                                , this.pos.add(-WORK_RADIUS, 2, -WORK_RADIUS)))
                        .forEach(this::processEntity);
            }
        }
    }

    private void processEntity(EntityPlayer player) {
        player.heal(2.0f);
    }
}
