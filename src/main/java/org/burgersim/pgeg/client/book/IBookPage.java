package org.burgersim.pgeg.client.book;

import java.util.List;

public interface IBookPage {

    default void draw(int mouseX, int mouseY) {
        getFragments().forEach(iPageFragment -> iPageFragment.draw(getTopLeftX(), getTopLeftY(), mouseX, mouseY));
    }

    default boolean onMouseClicked(double x, double y, int mode) {
        boolean flag = false;
        for (IPageFragment fragment : getFragments()) {
            flag = fragment.onMouseClicked(x, y, mode);
        }
        return flag;
    }

    List<IPageFragment> getFragments();

    int getTopLeftX();

    int getTopLeftY();
}
