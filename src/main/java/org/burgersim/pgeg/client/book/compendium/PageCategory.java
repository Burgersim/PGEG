package org.burgersim.pgeg.client.book.compendium;

import net.minecraft.client.resources.I18n;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.book.fragment.FragmentLink;
import org.burgersim.pgeg.client.book.fragment.FragmentLinksList;
import org.burgersim.pgeg.client.book.fragment.FragmentTitle;
import org.burgersim.pgeg.client.book.fragment.LinkProvider;
import org.burgersim.pgeg.client.book.fragment.icon.IconAbstract;
import org.burgersim.pgeg.client.gui.GuiCompendium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageCategory implements IBookPage {
    private IBookPage nextPage = null;
    private final GuiCompendium gui;
    private final IconAbstract icon;
    private List<IBookPage> pages;
    private String name;
    private List<IPageFragment> fragments = new ArrayList<>();

    public PageCategory(GuiCompendium gui, String name, IBookPage... content) {
        this(gui, name, null, content);
    }

    public PageCategory(GuiCompendium gui, String name, IconAbstract icon, IBookPage... content) {
        this.gui = gui;
        this.name = name;
        this.icon = icon;
        pages = Arrays.asList(content);
        if (pages.size() > 9) {
            nextPage = new PageCategory(gui, name, pages.subList(9, pages.size()).toArray(new IBookPage[0]));
        }
        fragments.add(new FragmentTitle(0, 16, 146, I18n.format(name), 4210752));
        fragments.add(new FragmentLinksList(gui, 0, 26, new CategoryLinkProvider(), 4210752));
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
        return name;
    }

    @Override
    public IconAbstract getIcon() {
        return icon;
    }


    private class CategoryLinkProvider extends LinkProvider {

        @Override
        public IconAbstract getIcon(int i) {
            return pages.get(i).getIcon();
        }

        @Override
        public String getText(int i) {
            return I18n.format(pages.get(i).getName());
        }

        @Override
        public int getSize() {
            return Math.min(pages.size(), 9);
        }

        @Override
        public int getOffset() {
            return 0;
        }

        @Override
        public boolean onMouseClicked(FragmentLink link, double x, double y, int mode) {
            if (super.onMouseClicked(link, x, y, mode)) {
                gui.setPage(pages.get(link.id), true);
                return true;
            }
            return false;
        }
    }
}
