package org.burgersim.pgeg.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.book.lexicon.RunesList;
import org.burgersim.pgeg.item.ItemRuneLexicon;

import java.util.ArrayList;
import java.util.List;

import static org.burgersim.pgeg.utils.Reference.RUNE_LEXICON_TEXTURES;

public class RuneLexiconGui extends GuiScreen {
    private final ItemRuneLexicon.LexiconInteractionObject interactionObject;
    private IBookPage page;
    private List<IBookPage> history;
    private BackButton backButton;
    private final World world;

    public RuneLexiconGui(ItemRuneLexicon.LexiconInteractionObject interactionObject, World world) {
        this.interactionObject = interactionObject;
        this.world = world;
        history = new ArrayList<>();
    }

    @Override
    protected void initGui() {
        if (page == null) page = new RunesList(this);
        backButton = this.addButton(new BackButton(2, (this.width - 285) / 2 + 24, (this.height - 179) / 2 + 156) {
            @Override
            public void mousePressed(double p_mousePressed_1_, double p_mousePressed_3_) {
                setPage(history.get(history.size() - 1), false);
                history.remove(history.size() - 1);
                if (history.size() == 0) {
                    backButton.visible = false;
                }
            }
        });
        if (history.size() == 0) {
            backButton.visible = false;
        }
    }

    @Override
    public boolean mouseClicked(double x, double y, int mode) {
        return super.mouseClicked(x, y, mode) || page.onMouseClicked(x, y, mode);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float p_drawScreen_3_) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(RUNE_LEXICON_TEXTURES);
        int x = (this.width - 285) / 2;
        int y = (this.height - 179) / 2;
        Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 285, 179, 384, 256);
        page.draw(mouseX, mouseY);
        super.drawScreen(mouseX, mouseY, p_drawScreen_3_);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void setPage(IBookPage page, boolean saveHistory) {
        if (this.page != null && saveHistory) {
            history.add(this.page);
        }
        this.page = page;
        if (history.size() == 0) {
            backButton.visible = false;
        } else {
            backButton.visible = true;
        }
    }

    public void setRune(String name) {
        NBTTagCompound compound = getLexicon().getTagCompound();
        if (compound == null) {
            compound = new NBTTagCompound();
        }
        compound.setString("rune", name);
        getLexicon().setTagCompound(compound);
    }

    public ItemStack getLexicon() {
        return interactionObject.getStack();
    }

    public class BackButton extends GuiButton {

        public BackButton(int id, int x, int y) {
            super(id, x, y, 24, 14, "");
        }


        @Override
        public void drawButton(int mouseX, int mouseY, float p_drawButton_3_) {
            if (this.visible) {
                this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                Minecraft.getMinecraft().getTextureManager().bindTexture(RUNE_LEXICON_TEXTURES);
                int y = 180;
                if (this.hovered) {
                    y += 11;
                }
                Gui.drawModalRectWithCustomSizedTexture(this.x + 2, this.y + 2, 1, y, 18, 10, 384, 256);
            }
        }
    }

    public World getWorld() {
        return world;
    }
}
