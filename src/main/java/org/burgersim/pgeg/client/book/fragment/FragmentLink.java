package org.burgersim.pgeg.client.book.fragment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.rune.Rune;

public class FragmentLink extends GuiButton implements IPageFragment {
    private final int offsetX;
    private final int offsetY;
    private final int color;
    private final ResourceLocation icon;
    private final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

    public FragmentLink(int offsetX, int offsetY, int id, int width, int color, ResourceLocation icon, String text) {
        super(id, offsetX, offsetY, width, 16, text);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.color = color;
        this.icon = icon;

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
            Minecraft.getMinecraft().getTextureManager().bindTexture(icon);
            Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 16, 16, 16, 16);
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
