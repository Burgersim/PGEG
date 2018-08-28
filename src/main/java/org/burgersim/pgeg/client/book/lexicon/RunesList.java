package org.burgersim.pgeg.client.book.lexicon;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.client.book.IBookPage;
import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.book.fragment.FragmentLink;
import org.burgersim.pgeg.client.book.fragment.FragmentLinksList;
import org.burgersim.pgeg.client.book.fragment.FragmentTitle;
import org.burgersim.pgeg.client.book.fragment.LinkProvider;
import org.burgersim.pgeg.client.gui.RuneLexiconGui;
import org.burgersim.pgeg.rune.Rune;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NoTranslation")
public class RunesList implements IBookPage {
    private final RuneLexiconGui gui;
    private List<IPageFragment> fragments = new ArrayList<>();

    public RunesList(RuneLexiconGui gui) {
        this.gui = gui;
        fragments.add(new FragmentTitle(0, 16, 146, I18n.format("gui.lexicon.title.runes"), 4210752));
        fragments.add(new FragmentLinksList(0, 26, new RuneLinkProvider(), 4210752));
        fragments.add(new FragmentLinksList(140, 16, new RuneLinkProvider(9, 10), 4210752));
    }

    @Override
    public List<IPageFragment> getFragments() {
        return fragments;
    }

    @Override
    public int getTopLeftX() {
        return (gui.width - 285) / 2;
    }

    @Override
    public int getTopLeftY() {
        return (gui.height - 179) / 2;
    }

    private class RuneLinkProvider extends LinkProvider {
        private final int offset;
        private final int max;

        public RuneLinkProvider() {
            this(0, 9);
        }

        public RuneLinkProvider(int offset, int max) {
            this.offset = offset;
            this.max = max;
        }

        @Override
        public ResourceLocation getIcon(int i) {
            return Rune.REGISTRY.getObjectById(i + offset).getTextureLocation();
        }

        @Override
        public String getText(int i) {
            return I18n.format(Rune.REGISTRY.getObjectById(i + offset).getNameKey());
        }

        @Override
        public int getSize() {
            return Math.min(Rune.REGISTRY.getKeys().size() - offset, max);
        }

        @Override
        public boolean onMouseClicked(FragmentLink link, double x, double y, int mode) {
            if (super.onMouseClicked(link, x, y, mode)) {
                gui.setPage(new RuneInfo(gui, Rune.REGISTRY.getObjectById(link.id)), true);
                return true;
            }
            return false;
        }

        @Override
        public int getOffet() {
            return offset;
        }
    }
}
