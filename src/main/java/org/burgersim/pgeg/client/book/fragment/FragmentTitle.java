package org.burgersim.pgeg.client.book.fragment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.gui.GuiCompendium;

public class FragmentTitle implements IPageFragment {
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final String title;
    private final int color;
    private final int titleLenght;
    private final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

    public FragmentTitle(int offsetX, int offsetY, int width, String title, int color) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.title = title;
        this.color = color;
        this.titleLenght = fontRenderer.getStringWidth(title);
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        fontRenderer.drawString(title, x + offsetX + width / 2 - titleLenght / 2, y + offsetY, color);
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        return false;
    }
}
