package org.burgersim.pgeg.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;

public class ModelCube extends ModelBase {
    final ModelRenderer cube;

    public ModelCube() {
        cube = new ModelRenderer(this, 0, 0);
        cube.addBox(0, 0, 0, 1, 1, 1);
        cube.setRotationPoint(0.5f, 0.5f, 0.5f);
        cube.setTextureSize(16, 16);
    }

    public void renderCubes(int cubes, int level, int ticks, float radius, int color) {
        float R = (float) ((color >> 16) & 255) / 255f;
        float G = (float) ((color >> 8) & 255) / 255f;
        float B = (float) (color & 255) / 255f;
        for (int j = 1; j <= level; j++) {
            float offsetPerCube = 360 / (cubes * j);
            GlStateManager.pushMatrix();
            GlStateManager.disableTexture2D();
            GlStateManager.translatef(-0.025F, 0.85F, -0.025F);
            for (int i = 0; i < (cubes * j); i++) {
                float offset = offsetPerCube * i;
                float deg = (int) (ticks / 0.2F % 360F + offset);
                float rad = deg * (float) Math.PI / 180F;
                float cos = (float) Math.cos(rad);
                float sin = (float) Math.sin(rad);
                float x = (radius * j) * cos - (radius * j) * sin;
                float z = (radius * j) * sin + (radius * j) * cos;
                float y = (float) (0.2f + Math.pow(-1, j) * (0.1f * Math.sin(x + z + j + (ticks / 0.5f % 360F) * Math.PI / 180F)));
                GlStateManager.pushMatrix();
                GlStateManager.translatef(x, y, z);
                GlStateManager.enableBlend();
                GlStateManager.color4f(R, G, B, 0.7f);
                cube.render(1f / 16f);
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            GlStateManager.enableTexture2D();
            GlStateManager.popMatrix();
        }
    }
}
