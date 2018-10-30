package org.burgersim.pgeg.listener;

import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.rune.Rune;
import org.dimdev.rift.listener.BootstrapListener;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegBootstrap implements BootstrapListener {
    public static final Tag<Item> wands = new ItemTags.Wrapper(new ResourceLocation(MOD_ID, "wands"));

    @Override
    public void afterVanillaBootstrap() {
        Rune.registerRunes();
    }
}
