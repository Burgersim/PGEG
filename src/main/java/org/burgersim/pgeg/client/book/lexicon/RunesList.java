package org.burgersim.pgeg.client.book.lexicon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.gui.RuneLexiconGui;
import org.burgersim.pgeg.rune.Rune;

import java.util.ArrayList;
import java.util.List;

public class RunesList implements IBookPage {
    private final RuneLexiconGui gui;
    List<GuiButton> buttons = new ArrayList<>();

    public RunesList(RuneLexiconGui gui) {
        this.gui = gui;
        int x = (gui.width - 285) / 2;
        int y = (gui.height - 179) / 2;
        Rune.REGISTRY.forEach(
                (rune) -> buttons.add(
                        new RunePageButton(rune.getId(), x + 16, y + 16 * rune.getId() + 32, 120, 16, rune.getNameKey(), new RuneInfo(gui, rune)))
        );
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        int x = (gui.width - 285) / 2;
        int y = (gui.height - 179) / 2;
        int titleWidth = Minecraft.getMinecraft().fontRenderer.getStringWidth(I18n.format("gui.lexicon.title.runes"));
        Minecraft.getMinecraft().fontRenderer.drawString(I18n.format("gui.lexicon.title.runes"), x + 143 / 2 - titleWidth / 2, y + 16, 4210752);
        buttons.forEach((guiButton -> guiButton.drawButtonForegroundLayer(0, 0)));
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        boolean flag = false;
        for (GuiButton button : buttons) {
            flag = button.mouseClicked(x, y, mode);
        }
        return flag;
    }

    private class RunePageButton extends GuiButton {
        private final IBookPage destination;

        public RunePageButton(int id, int x, int y, int width, int height, String text, IBookPage destination) {
            super(id, x, y, width, height, text);
            this.destination = destination;
        }

        @Override
        public void mousePressed(double x, double y) {
            gui.setPage(destination, true);
        }

        @Override
        public void drawButtonForegroundLayer(int offsetX, int offsetY) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(Rune.REGISTRY.getObjectById(id).getTextureLocation());
            Gui.drawModalRectWithCustomSizedTexture(x + offsetX, y + offsetY, 0, 0, 16, 16, 16, 16);
            Minecraft.getMinecraft().fontRenderer.drawString(I18n.format(this.displayString), x + offsetX + 16, y + offsetY + 4, 4210752);
        }
    }
}
