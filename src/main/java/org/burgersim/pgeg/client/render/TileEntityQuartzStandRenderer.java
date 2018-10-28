package org.burgersim.pgeg.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import org.burgersim.pgeg.tileentity.TileEntityQuartzStand;

public class TileEntityQuartzStandRenderer extends TileEntityRenderer<TileEntityQuartzStand> {
    @Override
    public void render(TileEntityQuartzStand tileEntityQuartzStand, double x, double y, double z, float partialTicks, int destroyStage) {
        ItemStack stack = tileEntityQuartzStand.getStackInSlot(0);
        if (!stack.isEmpty()) {
            GlStateManager.pushLightingAttrib();
            GlStateManager.pushMatrix();

            GlStateManager.disableRescaleNormal();
            GlStateManager.enableLighting();
            float time = (1 - partialTicks) * tileEntityQuartzStand.getPrevTime() + partialTicks * tileEntityQuartzStand.getTime();
            GlStateManager.translated(x + .5, y + 1.2, z + .5);
            GlStateManager.translated(0, Math.sin((Math.PI / 180) * (time * 4)) / 15 + .15, 0);
            GlStateManager.rotatef(time * 3, 0, 1, 0);
            GlStateManager.scaled(0.7, 0.7, 0.7);

            Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.GROUND);

            GlStateManager.popMatrix();
            GlStateManager.popAttrib();
        }

    }
}
