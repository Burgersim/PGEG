package org.burgersim.pgeg.client.book.fragment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.burgersim.pgeg.client.book.IPageFragment;

public class FragmentText implements IPageFragment {
    private final int offsetX;
    private final int offsetY;
    private final String text;
    private final int color;
    private final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

    public FragmentText(int offsetX, int offsetY, String text, int color) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.text = text;
        this.color = color;
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        fontRenderer.drawString(text, x + offsetX, y + offsetY, color);
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        return false;
    }
}
