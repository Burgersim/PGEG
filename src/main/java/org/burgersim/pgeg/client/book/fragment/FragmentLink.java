package org.burgersim.pgeg.client.book.fragment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.book.fragment.icon.IconAbstract;
import org.burgersim.pgeg.client.gui.GuiCompendium;

public class FragmentLink extends GuiButton implements IPageFragment {
    private final int offsetX;
    private final int offsetY;
    private final int color;
    private final GuiCompendium gui;
    private final IconAbstract icon;
    private final FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;

    public FragmentLink(GuiCompendium gui, int offsetX, int offsetY, int id, int width, int color, IconAbstract icon, String text) {
        super(id, offsetX, offsetY, width, 16, text);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.color = color;
        this.icon = icon;
        this.gui = gui;
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        this.x = x + offsetX;
        this.y = y + offsetY;
        drawButtonForegroundLayer(this.x, this.y);
    }

    @Override
    public void drawButtonForegroundLayer(int x, int y) {
        if (icon != null) {
            icon.draw(gui, x, y);
        }
        fontRenderer.drawString(displayString, icon != null ? x + 18 : x, y + 4, color);
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        return false;
    }

    public int getButtonHeight() {
        return this.height;
    }
}
