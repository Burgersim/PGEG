package org.burgersim.pgeg.recipe.aei.wand;

import com.gmail.zendarva.aei.api.IRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import org.burgersim.pgeg.recipe.RecipesWand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PgegWandRecipe implements IRecipe<ItemStack> {
    private final RecipesWand recipe;

    public PgegWandRecipe(RecipesWand recipe) {
        this.recipe = recipe;
    }

    @Override
    public String getId() {
        return "pgeg:wand";
    }

    @Override
    public List<ItemStack> getOutput() {
        List<ItemStack> output = new LinkedList<>();
        output.add(recipe.getRecipeOutput().copy());
        return output;
    }

    @Override
    public List<List<ItemStack>> getInput() {
        List<List<ItemStack>> inputs = new ArrayList<>();
        List<ItemStack> input = new ArrayList<>(Arrays.asList(recipe.getIngredients().get(0).getMatchingStacks()));
        inputs.add(input);
        inputs.add(getWands());
        return inputs;
    }

    public List<ItemStack> getWands() {
        List<ItemStack> wands = new LinkedList<>();
        for (Ingredient ingredient : recipe.getWandItems()) {
            wands.addAll(Arrays.asList(ingredient.getMatchingStacks()));
        }
        return wands;
    }
}
