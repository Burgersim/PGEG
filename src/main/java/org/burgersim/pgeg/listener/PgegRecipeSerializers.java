package org.burgersim.pgeg.listener;

import net.minecraft.item.crafting.RecipeSerializers;
import org.burgersim.pgeg.recipe.RecipesRune;
import org.burgersim.pgeg.recipe.RecipesSpellCauldron;
import org.burgersim.pgeg.recipe.RecipesWand;
import org.dimdev.rift.listener.RecipeSerializerAdder;

public class PgegRecipeSerializers implements RecipeSerializerAdder {
    @Override
    public void addRecipeSerializers() {
        RecipeSerializers.register(RecipesWand.Serializer.INSTANCE);
        RecipeSerializers.register(RecipesSpellCauldron.Serializer.INSTANCE);
        RecipeSerializers.register(RecipesRune.Serializer.INSTANCE);
    }
}
