package org.burgersim.pgeg.listener;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import org.burgersim.pgeg.client.render.TileEntityQuartzStandRenderer;
import org.burgersim.pgeg.client.render.TileEntityRunePedestalRenderer;
import org.burgersim.pgeg.client.render.TileEntitySpellCauldronRenderer;
import org.burgersim.pgeg.tileentity.TileEntityQuartzStand;
import org.burgersim.pgeg.tileentity.TileEntityRunePedestal;
import org.burgersim.pgeg.tileentity.TileEntitySpellCauldron;
import org.dimdev.rift.listener.client.TileEntityRendererAdder;

import java.util.Map;

public class PgegTileEntityRenderer implements TileEntityRendererAdder {
    @Override
    public void addTileEntityRenderers(Map<Class<? extends TileEntity>, TileEntityRenderer<? extends TileEntity>> renderers) {
        renderers.put(TileEntityQuartzStand.class, new TileEntityQuartzStandRenderer());
        renderers.put(TileEntitySpellCauldron.class, new TileEntitySpellCauldronRenderer());
        renderers.put(TileEntityRunePedestal.class, new TileEntityRunePedestalRenderer());
    }
}
