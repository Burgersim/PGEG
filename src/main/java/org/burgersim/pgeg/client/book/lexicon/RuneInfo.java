package org.burgersim.pgeg.client.book.lexicon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.gui.RuneLexiconGui;
import org.burgersim.pgeg.recipe.RecipesRune;
import org.burgersim.pgeg.rune.Rune;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NoTranslation")
public class RuneInfo implements IBookPage {
    private final RuneLexiconGui gui;
    private final Rune rune;
    private final GuiButton setRuneButton;
    private final String runeName;
    private final String runeDescription;
    private final String ingredientsTitle;
    private final RecipesRune recipe;
    private List<Ingredient> ingredients;

    public RuneInfo(RuneLexiconGui gui, Rune rune) {
        this.gui = gui;
        this.rune = rune;
        setRuneButton = new SetRuneButton(0, ((gui.width - 285) / 2) + 168, ((gui.height - 179) / 2) + 148);
        runeName = I18n.format(rune.getNameKey());
        runeDescription = I18n.format(rune.getDescriptionKey());
        ingredientsTitle = I18n.format("gui.lexicon.title.ingredients");
        recipe = (RecipesRune) gui.getWorld().getRecipeManager().getRecipe(new RecipesRune.RuneCrafting(new ResourceLocation(rune.getName())), gui.getWorld());
        if (recipe != null) {
            ingredients = recipe.getIngredients();
        }
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        int x = (gui.width - 285) / 2;
        int y = (gui.height - 179) / 2;
        int titleWidth = Minecraft.getMinecraft().fontRenderer.getStringWidth(I18n.format(rune.getNameKey()));
        Minecraft.getMinecraft().fontRenderer.drawString(runeName, x + 146 / 2 - titleWidth / 2, y + 16, 4210752);
        Minecraft.getMinecraft().fontRenderer.drawSplitString(runeDescription, x + 16, y + 32, 115, 4210752);
        drawRightPage(mouseX, mouseY);
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        return setRuneButton.mouseClicked(x, y, mode);
    }

    public void drawRightPage(int mouseX, int mouseY) {
        int x = ((gui.width - 285) / 2) + 154;
        int y = (gui.height - 179) / 2 + 16;
        Minecraft.getMinecraft().fontRenderer.drawString(ingredientsTitle, x, y, 4210752);
        y += Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT;
        GlStateManager.pushMatrix();
        GlStateManager.pushAttrib();
        if (recipe != null) {
            for (int i = 0; i < ingredients.size(); i++) {
                int itemX = x + 16 * (i % 7);
                int itemY = y + (i / 7) * 16;
                RenderHelper.enableGUIStandardItemLighting();
                ItemStack stack = ingredients.get(i).getMatchingStacks()[(int) ((gui.getWorld().getWorldTime() / 40) % ingredients.get(i).getMatchingStacks().length)];
                Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(stack, itemX, itemY);
                RenderHelper.disableStandardItemLighting();
            }
            for (int i = 0; i < ingredients.size(); i++) {
                int itemX = x + 16 * (i % 7);
                int itemY = y + (i / 7) * 16;

                if (mouseX > itemX && mouseY > itemY && mouseX < itemX + 16 && mouseY < itemY + 16) {
                    ItemStack stack = ingredients.get(i).getMatchingStacks()[(int) ((gui.getWorld().getWorldTime() / 40) % ingredients.get(i).getMatchingStacks().length)];
                    List<ITextComponent> tooltips = stack.getTooltip(Minecraft.getMinecraft().player, ITooltipFlag.TooltipFlags.NORMAL);
                    List<String> tooltip = new ArrayList<>();
                    tooltips.forEach(iTextComponent -> tooltip.add(iTextComponent.getFormattedText()));
                    gui.drawHoveringText(tooltip, mouseX, mouseY);
                }
            }
        }
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        setRuneButton.drawButton(0, 0, 0.0f);
    }

    private class SetRuneButton extends GuiButton {
        SetRuneButton(int id, int x, int y) {
            super(id, x, y, 92, 20, I18n.format("gui.lexicon.button.set_rune"));
        }

        @Override
        public void drawButton(int x, int y, float p_drawButton_3_) {
            super.drawButton(x, y, p_drawButton_3_);
            drawButtonForegroundLayer(x, y);
        }

        @Override
        public void drawButtonForegroundLayer(int x, int y) {
            FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
            int textLenght = fontRenderer.getStringWidth(displayString);
            fontRenderer.
                    drawStringWithShadow(displayString,
                            this.x + (this.width / 2) - textLenght / 2,
                            this.y + (this.height / 2) - fontRenderer.FONT_HEIGHT / 2, 0xffffff);
        }

        @Override
        public void mousePressed(double x, double y) {
            gui.setRune(rune.getName());
            gui.close();
        }
    }
}
