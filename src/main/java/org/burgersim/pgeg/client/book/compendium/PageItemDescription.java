package org.burgersim.pgeg.client.book.compendium;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.book.fragment.FragmentMultiLineText;
import org.burgersim.pgeg.client.book.fragment.FragmentTitle;
import org.burgersim.pgeg.client.gui.GuiCompendium;

import java.util.ArrayList;
import java.util.List;

public class PageItemDescription implements IBookPage {
    private final GuiCompendium gui;
    private final Ingredient ingredient;
    private List<IPageFragment> fragments = new ArrayList<>();

    public PageItemDescription(GuiCompendium gui, String name, Ingredient ingredient) {
        this.gui = gui;
        this.ingredient = ingredient;
        fragments.add(new FragmentTitle(0, 16, 146, I18n.format("gui.compendium.page." + name + ".name"), 4210752));
        fragments.add(new FragmentMultiLineText(16, 32, 115, I18n.format("gui.compendium.page." + name + ".description"), 4210752));
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
