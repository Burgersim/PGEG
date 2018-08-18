package org.burgersim.pgeg.listener;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import org.burgersim.pgeg.tileentity.TileEntityQuartzStand;
import org.burgersim.pgeg.tileentity.render.TileEntityQuartzStandRenderer;
import org.dimdev.rift.listener.client.TileEntityRendererAdder;

import java.util.Map;

public class PgegTileEntityRenderer implements TileEntityRendererAdder {
    @Override
    public void addTileEntityRenderers(Map<Class<? extends TileEntity>, TileEntityRenderer<? extends TileEntity>> renderers) {
        renderers.put(TileEntityQuartzStand.class, new TileEntityQuartzStandRenderer());
    }
}
