package org.burgersim.pgeg.client.book.fragment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.burgersim.pgeg.client.book.IPageFragment;

public class FragmentMultiLineText implements IPageFragment {
    private final int offsetX;
    private final int offsetY;
    private final int maxWidth;
    private final String text;
    private final int color;
    private final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

    public FragmentMultiLineText(int offsetX, int offsetY, int maxWidth, String text, int color) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.maxWidth = maxWidth;
        this.text = text;
        this.color = color;
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        fontRenderer.drawSplitString(text, x + offsetX, y + offsetY, maxWidth, color);
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        return false;
    }
}
