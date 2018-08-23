package org.burgersim.pgeg.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.biome.BiomeColorHelper;
import org.dimdev.rift.listener.client.EntityRendererAdder;

import java.util.Map;

public class PgegEntityRenderers implements EntityRendererAdder {
    @Override
    public void addEntityRenderers(Map<Class<? extends Entity>, Render<? extends Entity>> entityRenderMap, RenderManager renderManager) {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, reader, pos, tint) -> {
            return reader != null && pos != null ? BiomeColorHelper.getWaterColorAtPos(reader, pos) : -1;
        }, PgegRegistry.SPELL_CAULDRON);
    }
}
