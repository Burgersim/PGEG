package org.burgersim.pgeg.recipe.aei.cauldron;

import com.gmail.zendarva.aei.api.IRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import org.burgersim.pgeg.recipe.RecipesSpellCauldron;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PgegCauldronRecipe implements IRecipe<ItemStack> {
    private final RecipesSpellCauldron recipe;

    public PgegCauldronRecipe(RecipesSpellCauldron recipe) {
        this.recipe = recipe;
    }

    @Override
    public String getId() {
        return "pgeg:spell_cauldron";
    }

    @Override
    public List<ItemStack> getOutput() {
        List<ItemStack> output = new LinkedList<>();
        output.add(recipe.getRecipeOutput().copy());
        return output;
    }

    @Override
    public List<List<ItemStack>> getInput() {
        List<List<ItemStack>> input = new LinkedList<>();
        for (Ingredient ingredient : recipe.getIngredients()) {
            List<ItemStack> ingList = new LinkedList<>(Arrays.asList(ingredient.getMatchingStacks()));
            input.add(ingList);
        }
        input.add(getWands());
        return input;
    }

    public List<ItemStack> getWands() {
        List<ItemStack> wands = new LinkedList<>();
        for (Ingredient ingredient : recipe.getWandItems()) {
            wands.addAll(Arrays.asList(ingredient.getMatchingStacks()));
        }
        return wands;
    }
}
