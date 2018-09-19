package org.burgersim.pgeg.recipe.aei;

import com.gmail.zendarva.aei.api.IAEIPlugin;
import com.gmail.zendarva.aei.impl.AEIRecipeManager;
import net.minecraft.item.crafting.IRecipe;
import org.burgersim.pgeg.recipe.RecipesSpellCauldron;
import org.burgersim.pgeg.recipe.RecipesWand;
import org.burgersim.pgeg.recipe.aei.cauldron.PgegCauldronCategory;
import org.burgersim.pgeg.recipe.aei.cauldron.PgegCauldronRecipe;
import org.burgersim.pgeg.recipe.aei.wand.PgegWandCraftingCategory;
import org.burgersim.pgeg.recipe.aei.wand.PgegWandRecipe;

import java.util.LinkedList;
import java.util.List;

public class PgegPlugin implements IAEIPlugin {
    @Override
    public void register() {
        AEIRecipeManager.instance().addDisplayAdapter(new PgegWandCraftingCategory());
        AEIRecipeManager.instance().addDisplayAdapter(new PgegCauldronCategory());
        List<PgegWandRecipe> wandRecipes = new LinkedList<>();
        List<PgegCauldronRecipe> cauldronRecipes = new LinkedList<>();
        for (IRecipe recipe : AEIRecipeManager.recipeManager.getRecipes()) {
            if (recipe instanceof RecipesWand) {
                wandRecipes.add(new PgegWandRecipe((RecipesWand) recipe));
            }
            if (recipe instanceof RecipesSpellCauldron) {
                cauldronRecipes.add(new PgegCauldronRecipe((RecipesSpellCauldron) recipe));
            }
        }
        AEIRecipeManager.instance().addRecipe("pgeg:wand", wandRecipes);
        AEIRecipeManager.instance().addRecipe("pgeg:spell_cauldron", cauldronRecipes);
    }
}
