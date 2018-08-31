package org.burgersim.pgeg.client.book.fragment.icon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import org.burgersim.pgeg.client.gui.GuiCompendium;

public class IconIngredient extends IconAbstract {
    private final Ingredient icon;

    public IconIngredient(Ingredient icon) {
        this.icon = icon;
    }

    @Override
    public void draw(GuiCompendium gui, int x, int y) {
        World world = gui.getWorld();
        RenderHelper.enableGUIStandardItemLighting();
        ItemStack stack = icon.getMatchingStacks()[(int) ((world.getWorldTime() / 40) % icon.getMatchingStacks().length)];
        Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(stack, x, y);
        RenderHelper.disableStandardItemLighting();
    }
}
