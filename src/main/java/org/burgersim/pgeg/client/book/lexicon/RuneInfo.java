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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.book.fragment.*;
import org.burgersim.pgeg.client.gui.RuneLexiconGui;
import org.burgersim.pgeg.recipe.RecipesRune;
import org.burgersim.pgeg.rune.Rune;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NoTranslation")
public class RuneInfo implements IBookPage {
    private final RuneLexiconGui gui;
    private List<Ingredient> ingredients;
    private List<IPageFragment> fragments = new ArrayList<>();

    public RuneInfo(RuneLexiconGui gui, Rune rune) {
        this.gui = gui;
        RecipesRune recipe = (RecipesRune) gui.getWorld().getRecipeManager().getRecipe(new RecipesRune.RuneCrafting(new ResourceLocation(rune.getName())), gui.getWorld());
        if (recipe != null) {
            ingredients = recipe.getIngredients();
        }
        fragments.add(new FragmentTitle(0, 16, 146, I18n.format(rune.getNameKey()), 4210752));
        fragments.add(new FragmentMultiLineText(16, 32, 115, I18n.format(rune.getDescriptionKey()), 4210752));
        fragments.add(new FragmentText(154, 16, I18n.format("gui.lexicon.title.ingredients"), 4210752));
        fragments.add(new FragmentRecipeIngredientsRow(154, 26, 16, 16, 7, recipe, ingredients, gui.getWorld(), gui));
        fragments.add(new FragmentButton(168, 148, 92, 20, 0, I18n.format("gui.lexicon.button.set_rune"), 0xffffff) {
            @Override
            public void mousePressed(double x, double y) {
                gui.setRune(rune.getName());
                gui.close();
            }
        });
    }

    @Override
    public List<IPageFragment> getFragments() {
        return fragments;
    }

    @Override
    public int getTopLeftX() {
        return (gui.width - 285) / 2;
    }

    @Override
    public int getTopLeftY() {
        return (gui.height - 179) / 2;
    }

}
