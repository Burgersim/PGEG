package org.burgersim.pgeg.client.book.fragment;

import org.burgersim.pgeg.client.book.IPageFragment;
import org.burgersim.pgeg.client.gui.GuiCompendium;

import java.util.ArrayList;
import java.util.List;

public class FragmentLinksList implements IPageFragment {

    private List<FragmentLink> links = new ArrayList<>();

    public FragmentLinksList(GuiCompendium gui, int offsetX, int offsetY, LinkProvider linkProvider, int color) {
        int linksCount = linkProvider.getSize();
        for (int i = 0; i < linksCount; i++) {
            links.add(new FragmentLink(gui,offsetX + 8, offsetY + i * 16, i + linkProvider.getOffset(), 146, 4210752, linkProvider.getIcon(i), linkProvider.getText(i)) {
                @Override
                public boolean onMouseClicked(double x, double y, int mode) {
                    return linkProvider.onMouseClicked(this, x, y, mode);
                }
            });
        }
    }

    @Override
    public void draw(int x, int y, int mouseX, int mouseY) {
        links.forEach(fragmentLink -> fragmentLink.draw(x, y, mouseX, mouseY));
    }

    @Override
    public boolean onMouseClicked(double x, double y, int mode) {
        boolean flag = false;
        for (FragmentLink link : links) {
            flag = link.onMouseClicked(x, y, mode);
        }
        return flag;
    }
}
