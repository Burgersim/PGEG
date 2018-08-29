package org.burgersim.pgeg.client.book.fragment.icon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.client.gui.GuiCompendium;

public class IconTexture extends IconAbstract {
    private final ResourceLocation iconPath;

    public IconTexture(ResourceLocation iconPath) {
        this.iconPath = iconPath;
    }

    @Override
    public void draw(GuiCompendium gui, int x, int y) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(iconPath);
        Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 16, 16, 16, 16);
    }
}
