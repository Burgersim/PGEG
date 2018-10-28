package org.burgersim.pgeg.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.burgersim.pgeg.client.book.BookHelper;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.item.ItemCompendium;
import org.burgersim.pgeg.network.CPacketSetLexiconRune;

import java.util.ArrayList;
import java.util.List;

import static org.burgersim.pgeg.utils.Reference.COMPENDIUM_TEXTURES;

public class GuiCompendium extends GuiScreen {
    private final ItemCompendium.LexiconInteractionObject interactionObject;
    private IBookPage page;
    private List<IBookPage> history;
    private ButtonNavigation backButton;
    private ButtonNavigation forwardButton;
    private EntityPlayer player;

    public GuiCompendium(ItemCompendium.LexiconInteractionObject interactionObject, EntityPlayer player) {
        this.interactionObject = interactionObject;
        this.player = player;
        history = new ArrayList<>();
        page = BookHelper.BuildBook(this);
    }

    @Override
    protected void initGui() {
        backButton = this.addButton(new ButtonNavigation(2, getTopLeftX() + 6, getTopLeftY() + 156, false) {
            @Override
            public void onClick(double x, double y) {
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

        forwardButton = this.addButton(new ButtonNavigation(3, getTopLeftX() + 112, getTopLeftY() + 156, true) {
            @Override
            public void onClick(double x, double y) {
                setPage(page.nextPage(), true);
                if (!page.hasNextPage()) {
                    forwardButton.visible = false;
                }
            }


        });
        if (!page.hasNextPage()) {
            forwardButton.visible = false;
        }
    }

    @Override
    public boolean mouseClicked(double x, double y, int mode) {
        return super.mouseClicked(x, y, mode) || page.onMouseClicked(x, y, mode);
    }

    @Override
    public void render(int mouseX, int mouseY, float p_drawScreen_3_) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(COMPENDIUM_TEXTURES);
        Gui.drawModalRectWithCustomSizedTexture(getTopLeftX(), getTopLeftY(), 0, 0, 165, 179, 256, 256);
        page.draw(mouseX, mouseY);
        super.render(mouseX, mouseY, p_drawScreen_3_);
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
        backButton.visible = history.size() != 0;
        forwardButton.visible = page.hasNextPage();
    }

    public void setRune(String name) {
        Minecraft.getInstance().getConnection().sendPacket(new CPacketSetLexiconRune(interactionObject.isMainHand(), name));
    }

    public int getTopLeftX() {
        return (this.width - 145) / 2;
    }

    public int getTopLeftY() {
        return (this.height - 179) / 2;
    }

    public class ButtonNavigation extends GuiButton {
        private boolean isForward;

        public ButtonNavigation(int id, int x, int y, boolean isForward) {
            super(id, x, y, 24, 14, "");
            this.isForward = isForward;
        }


        @Override
        public void render(int mouseX, int mouseY, float p_drawButton_3_) {
            if (this.visible) {
                this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
                GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                Minecraft.getInstance().getTextureManager().bindTexture(COMPENDIUM_TEXTURES);
                int y = 193;
                if (isForward) {
                    y -= 13;
                }
                int x = 18;
                if (this.hovered) {
                    x = 0;
                }
                Gui.drawModalRectWithCustomSizedTexture(this.x + 2, this.y + 2, x, y, 18, 10, 256, 256);
            }
        }
    }

    public World getWorld() {
        return player.world;
    }
}
