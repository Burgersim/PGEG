package org.burgersim.pgeg.client.book.fragment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.gui.GuiCompendium;

public class FragmentIngredient implements IPageFragment {
    private final int offsetX;
    private final int offsetY;
    private final GuiCompendium gui;
    private final Ingredient ingredient;

    public FragmentIngredient(int offsetX, int offsetY, GuiCompendium gui, Ingredient ingredient) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.gui = gui;
        this.ingredient = ingredient;
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        GlStateManager.pushLightingAttrib();
        GlStateManager.pushMatrix();
        World world = gui.getWorld();
        GlStateManager.translated(x + offsetX, y+offsetY, 0);
        GlStateManager.scaled(5, 5, 5);
        RenderHelper.enableGUIStandardItemLighting();
        ItemStack stack = ingredient.getMatchingStacks()[(int) ((world.getWorldTime() / 40) % ingredient.getMatchingStacks().length)];
        Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(stack, 0, 0);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        return false;
    }
}
