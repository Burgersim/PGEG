package org.burgersim.pgeg.listener;

import net.minecraft.item.crafting.RecipeSerializers;
import org.burgersim.pgeg.recipe.RecipesWand;
import org.dimdev.rift.listener.BootstrapListener;

public class PgegBootstrap implements BootstrapListener {
    @Override
    public void afterVanillaBootstrap() {
        RecipeSerializers.register(RecipesWand.Serizalizer.INSTANCE);
    }
}
