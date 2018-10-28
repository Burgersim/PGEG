package org.burgersim.pgeg.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.burgersim.pgeg.client.model.ModelCube;
import org.burgersim.pgeg.tileentity.TileEntityRunePedestal;

public class TileEntityRunePedestalRenderer extends TileEntityRenderer<TileEntityRunePedestal> {
    final private ModelCube cube = new ModelCube();

    @Override
    public void render(TileEntityRunePedestal pedestal, double x, double y, double z, float partialTicks, int destroyStage) {
        if (pedestal.getRune() != null) {
            Minecraft.getInstance().profiler.startSection("rune_pedestal");
            GlStateManager.pushLightingAttrib();
            GlStateManager.pushMatrix();
            GlStateManager.translated(x + .5, y - .8, z + .5);
            GlStateManager.color3f(1f, 1f, 1f);
            cube.renderCubes(4, pedestal.getLevel(), pedestal.getTime(), 0.1f, pedestal.getRune().getColor());

            GlStateManager.popMatrix();
            GlStateManager.popAttrib();

            GlStateManager.pushLightingAttrib();
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            float yR = (float) (0.17f + (0.009f * Math.sin((pedestal.getTime() / 0.15f % 360F) * Math.PI / 180F)));
            GlStateManager.translated(x + .3, y - .7 + yR, z + .3);
            GlStateManager.scaled(.4, 1f, .4);
            GlStateManager.color3f(1f, 1f, 1f);
            bindTexture(pedestal.getRune().getTextureLocation());
            Tessellator tes = Tessellator.getInstance();
            BufferBuilder bb = tes.getBuffer();
            bb.begin(7, DefaultVertexFormats.POSITION_TEX);
            bb.pos(0, 1, 0).tex(0, 0).endVertex();
            bb.pos(0, 1, 1).tex(0, 1).endVertex();
            bb.pos(1, 1, 1).tex(1, 1).endVertex();
            bb.pos(1, 1, 0).tex(1, 0).endVertex();
            tes.draw();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
            GlStateManager.popAttrib();
            Minecraft.getInstance().profiler.endSection();
        }
    }
}
