package org.burgersim.pgeg.tileentity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import org.burgersim.pgeg.recipe.RecipesSpellCauldron;
import org.burgersim.pgeg.tileentity.TileEntitySpellCauldron;

public class TileEntitySpellCauldronRenderer extends TileEntityRenderer<TileEntitySpellCauldron> {
    @Override
    public void render(TileEntitySpellCauldron cauldron, double x, double y, double z, float partialTicks, int destroyStage) {
        if (!cauldron.isEmpty()) {
            GlStateManager.pushAttrib();
            GlStateManager.pushMatrix();


            GlStateManager.translate(x + .5, y + .5, z + .5);

            GlStateManager.disableRescaleNormal();
            GlStateManager.enableLighting();

            float offsetPerItem = 360 / (cauldron.itemCount());
            float time = (1 - partialTicks) * cauldron.getPrevTime() + partialTicks * cauldron.getTime();
            for (int i = 0; i < 9; i++) {
                ItemStack stack = cauldron.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    float offset = offsetPerItem * i;
                    float rad = offset * (float) Math.PI / 180F;
                    float cos = (float) Math.cos(rad);
                    float sin = (float) Math.sin(rad);
                    float xR = (.2f) * cos - (.2f) * sin;
                    float zR = (.2f) * sin + (.2f) * cos;
                    float yR = (float) (0.17f + (0.009f * Math.sin(x + z + offset + (time / 0.15f % 360F) * Math.PI / 180F)));
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(xR, yR + .28, zR);
                    GlStateManager.rotate(90, 1, 0, 0);
                    GlStateManager.scale(.3, .3, .3);
                    Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.GROUND);
                    GlStateManager.popMatrix();
                }
            }
            RecipesSpellCauldron recipe = (RecipesSpellCauldron) cauldron.getRecipe();
            if (recipe != null) {
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.disableLighting();
                GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);
                GlStateManager.translate(0, .7, 0);
                GlStateManager.rotate(getWorld().getWorldTime(), 0, 1, 0);
                IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getItemModel(recipe.getRecipeOutput());
                ItemCameraTransforms itemCameraTransforms = model.getItemCameraTransforms();
                ItemCameraTransforms.applyTransformSide(itemCameraTransforms.ground, false);
                Minecraft.getMinecraft().getRenderItem().renderItem(recipe.getRecipeOutput(), model);
                GlStateManager.disableBlend();
                GlStateManager.enableLighting();
                GlStateManager.popMatrix();
            }
            GlStateManager.popMatrix();
            GlStateManager.popAttrib();
        }

    }
}
