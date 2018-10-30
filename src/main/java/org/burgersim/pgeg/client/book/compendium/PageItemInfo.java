package org.burgersim.pgeg.client.book.compendium;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.crafting.Ingredient;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.book.fragment.FragmentIngredient;
import org.burgersim.pgeg.client.book.fragment.FragmentTitle;
import org.burgersim.pgeg.client.book.fragment.icon.IconAbstract;
import org.burgersim.pgeg.client.book.fragment.icon.IconIngredient;
import org.burgersim.pgeg.client.gui.GuiCompendium;

import java.util.ArrayList;
import java.util.List;

public class PageItemInfo implements IBookPage {
    private final GuiCompendium gui;
    private final Ingredient ingredient;
    private final String name;
    private List<IPageFragment> fragments = new ArrayList<>();
    private final IBookPage nextPage;

    public PageItemInfo(GuiCompendium gui, String name, Ingredient ingredient) {
        this.gui = gui;
        this.ingredient = ingredient;
        this.name = name;
        nextPage = new PageItemDescription(gui, this.name);
        fragments.add(new FragmentTitle(0, 16, 146, I18n.format("gui.compendium.page." + name + ".name"), 4210752));
        fragments.add(new FragmentIngredient(32, 32, gui, ingredient));
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
        return nextPage;
    }

    @Override
    public String getName() {
        return "gui.compendium.page." + name + ".name";
    }

    @Override
    public IconAbstract getIcon() {
        return new IconIngredient(ingredient);
    }
}
