package org.burgersim.pgeg.client.book.rune;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.book.fragment.FragmentButton;
import org.burgersim.pgeg.client.book.fragment.FragmentRecipeIngredientsRow;
import org.burgersim.pgeg.client.book.fragment.FragmentText;
import org.burgersim.pgeg.client.gui.GuiCompendium;
import org.burgersim.pgeg.recipe.RecipesRune;
import org.burgersim.pgeg.rune.Rune;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NoTranslation")
public class PageRuneRecipe implements IBookPage {
    private final GuiCompendium gui;
    private List<Ingredient> ingredients;
    private List<IPageFragment> fragments = new ArrayList<>();

    public PageRuneRecipe(GuiCompendium gui, Rune rune) {
        this.gui = gui;
        RecipesRune recipe = (RecipesRune) gui.getWorld().getRecipeManager().getRecipe(new RecipesRune.RuneCrafting(new ResourceLocation(rune.getName())), gui.getWorld());
        if (recipe != null) {
            ingredients = recipe.getIngredients();
        }
        fragments.add(new FragmentText(16, 16, I18n.format("gui.compendium.category.runes.title.ingredients"), 4210752));
        fragments.add(new FragmentRecipeIngredientsRow(16, 26, 16, 16, 7, recipe, ingredients, gui.getWorld(), gui));
        fragments.add(new FragmentButton(16, 130, 108, 19, 0, I18n.format("gui.compendium.category.runes.button.set_rune"), 0xffffff) {
            @Override
            public void onClick(double x, double y) {
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
    public GuiCompendium getGui() {
        return gui;
    }

    @Override
    public IBookPage nextPage() {
        return null;
    }
}
