package org.burgersim.pgeg.tileentity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import org.burgersim.pgeg.tileentity.TileEntityQuartzStand;

public class TileEntityQuartzStandRenderer extends TileEntityRenderer<TileEntityQuartzStand> {
    @Override
    public void func_199341_a(TileEntityQuartzStand tileEntityQuartzStand, double x, double y, double z, float partialTicks, int destroyStage) {
        ItemStack stack = tileEntityQuartzStand.getStackInSlot(0);
        if (!stack.isEmpty()) {
            GlStateManager.pushAttrib();
            GlStateManager.pushMatrix();

            GlStateManager.disableRescaleNormal();
            GlStateManager.enableLighting();
            float time = (1 - partialTicks) * tileEntityQuartzStand.getPrevTime() + partialTicks * tileEntityQuartzStand.getTime();
            GlStateManager.translate(x + .5, y + 1.2, z + .5);
            GlStateManager.translate(0, Math.sin((Math.PI / 180) * (time * 4)) / 15 + .15, 0);
            GlStateManager.rotate(time * 3, 0, 1, 0);
            GlStateManager.scale(0.7, 0.7, 0.7);
            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.GROUND);

            GlStateManager.popMatrix();
            GlStateManager.popAttrib();
        }

    }
}
