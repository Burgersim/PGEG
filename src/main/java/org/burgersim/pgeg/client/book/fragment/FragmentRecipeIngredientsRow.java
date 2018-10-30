package org.burgersim.pgeg.client.book.fragment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import org.burgersim.pgeg.client.book.IPageFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecipeIngredientsRow implements IPageFragment {
    private final int offsetX;
    private final int offsetY;
    private final int offsetPerColumn;
    private final int offsetPerRow;
    private final int columns;
    private final IRecipe recipe;
    private final List<Ingredient> ingredients;
    private final World world;
    private final GuiScreen guiScreen;

    public FragmentRecipeIngredientsRow(int offsetX, int offsetY, int offsetPerColumn, int offsetPerRow, int columns, IRecipe recipe, List<Ingredient> ingredients, World world, GuiScreen guiScreen) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetPerColumn = offsetPerColumn;
        this.offsetPerRow = offsetPerRow;
        this.columns = columns;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.world = world;
        this.guiScreen = guiScreen;
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();
        GlStateManager.pushLightingAttrib();
        if (recipe != null) {
            for (int i = 0; i < ingredients.size(); i++) {
                int itemX = x + offsetX + offsetPerColumn * (i % columns);
                int itemY = y + offsetY + (i / columns) * offsetPerRow;
                RenderHelper.enableGUIStandardItemLighting();
                ItemStack stack = ingredients.get(i).getMatchingStacks()[(int) ((world.getWorldTime() / 40) % ingredients.get(i).getMatchingStacks().length)];
                Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(stack, itemX, itemY);
                RenderHelper.disableStandardItemLighting();
            }
            for (int i = 0; i < ingredients.size(); i++) {
                int itemX = x + offsetX + offsetPerColumn * (i % columns);
                int itemY = y + offsetY + (i / columns) * offsetPerRow;

                if (mouseX > itemX && mouseY > itemY && mouseX < itemX + 16 && mouseY < itemY + 16) {
                    ItemStack stack = ingredients.get(i).getMatchingStacks()[(int) ((world.getWorldTime() / 40) % ingredients.get(i).getMatchingStacks().length)];
                    List<ITextComponent> tooltips = stack.getTooltip(Minecraft.getInstance().player, ITooltipFlag.TooltipFlags.NORMAL);
                    List<String> tooltip = new ArrayList<>();
                    tooltips.forEach(iTextComponent -> tooltip.add(iTextComponent.getFormattedText()));
                    guiScreen.drawHoveringText(tooltip, mouseX, mouseY);
                }
            }
        }
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        return false;
    }
}
