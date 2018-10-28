package org.burgersim.pgeg.client.book.fragment;

import org.burgersim.pgeg.client.book.fragment.icon.IconAbstract;

public abstract class LinkProvider {

    public abstract IconAbstract getIcon(int i);

    public abstract String getText(int i);

    public abstract int getSize();

    public boolean onMouseClicked(FragmentLink link, double x, double y, int mode) {
        return x > link.x && x < link.x + link.getWidth() && y > link.y && y < link.y + link.getButtonHeight();
    }

    public abstract int getOffset();
}