package org.burgersim.pgeg.client.book;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.client.book.compendium.PageCategory;
import org.burgersim.pgeg.client.book.compendium.PageItemInfo;
import org.burgersim.pgeg.client.book.fragment.icon.IconTexture;
import org.burgersim.pgeg.client.book.rune.PageRuneInfo;
import org.burgersim.pgeg.client.gui.GuiCompendium;
import org.burgersim.pgeg.listener.PgegRegistry;
import org.burgersim.pgeg.rune.Rune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class BookHelper {
    public static IBookPage BuildBook(GuiCompendium gui) {
        return new PageCategory(gui, "gui.compendium.name",
                new PageCategory(gui, "gui.compendium.category.runes.name", new IconTexture(new ResourceLocation(MOD_ID, "textures/rune/rune_pain.png")),
                        BookHelper.createRunesCategory(gui,
                                new PageItemInfo(gui,
                                        "rune_pedestals",
                                        Ingredient.fromItems(
                                                PgegRegistry.RUNE_PEDESTAL_STONE,
                                                PgegRegistry.RUNE_PEDESTAL_QUARTZ,
                                                PgegRegistry.RUNE_PEDESTAL_PURPUR)
                                )
                        )
                )
        );
    }

    private static IBookPage[] createRunesCategory(GuiCompendium gui, IBookPage... pages) {
        List<IBookPage> runes = new ArrayList<>(Arrays.asList(pages));
        Rune.REGISTRY.iterator().forEachRemaining(rune -> runes.add(new PageRuneInfo(gui, rune)));
        return runes.toArray(new IBookPage[0]);
    }
}
