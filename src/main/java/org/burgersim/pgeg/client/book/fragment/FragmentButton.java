package org.burgersim.pgeg.client.book.fragment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.utils.Reference;

public class FragmentButton extends GuiButton implements IPageFragment {
    private final int offsetX;
    private final int offsetY;
    private final int color;
    private final FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
    private final int textLength;

    public FragmentButton(int offsetX, int offsetY, int width, int height, int id, String text, int color) {
        super(id, offsetX, offsetY, width, height, text);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.color = color;
        textLength = fontRenderer.getStringWidth(displayString);
    }


    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        this.x = x + offsetX;
        this.y = y + offsetY;
        drawButton(mouseX, mouseY, 0.0f);
    }

    @Override
    public void drawButton(int x, int y, float p_drawButton_3_) {
        this.hovered = x >= this.x && y >= this.y && x < this.x + this.width && y < this.y + this.height;
        Minecraft.getMinecraft().getTextureManager().bindTexture(Reference.COMPENDIUM_TEXTURES);
        int texX = 0;
        int texY = 203;
        if (this.hovered) {
            texY += 19;
        }
        Gui.drawModalRectWithCustomSizedTexture(this.x, this.y, texX, texY, 108, 19, 256, 256);
        drawButtonForegroundLayer(x, y);
    }

    @Override
    public void drawButtonForegroundLayer(int x, int y) {
        fontRenderer.
                drawStringWithShadow(displayString,
                        this.x + (this.width / 2) - textLength / 2,
                        this.y + (this.height / 2) - fontRenderer.FONT_HEIGHT / 2, color);
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        return this.mouseClicked(x, y, mode);
    }
}
