package org.burgersim.pgeg.client.book.rune;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.book.fragment.FragmentMultiLineText;
import org.burgersim.pgeg.client.book.fragment.FragmentTitle;
import org.burgersim.pgeg.client.book.fragment.icon.IconAbstract;
import org.burgersim.pgeg.client.book.fragment.icon.IconTexture;
import org.burgersim.pgeg.client.gui.GuiCompendium;
import org.burgersim.pgeg.rune.Rune;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NoTranslation")
public class PageRuneInfo implements IBookPage {
    private final GuiCompendium gui;
    private final Rune rune;
    private List<IPageFragment> fragments = new ArrayList<>();
    private final IBookPage nextPage;

    public PageRuneInfo(GuiCompendium gui, Rune rune) {
        this.gui = gui;
        this.rune = rune;
        nextPage = new PageRuneRecipe(gui, rune);
        fragments.add(new FragmentTitle(0, 16, 146, I18n.format(rune.getNameKey()), 4210752));
        fragments.add(new FragmentMultiLineText(16, 32, 115, I18n.format(rune.getDescriptionKey()), 4210752));
    }

    @Override
    public IBookPage nextPage() {
        return nextPage;
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
    public String getName() {
        return rune.getNameKey();
    }

    @Override
    public IconAbstract getIcon() {
        return new IconTexture(rune.getTextureLocation());
    }
}
