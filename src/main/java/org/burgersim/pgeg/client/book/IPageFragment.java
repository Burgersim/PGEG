package org.burgersim.pgeg.client.book;

public interface IPageFragment {
    void draw(int x, int y, int mouseX, int mouseY);

    boolean onMouseClicked(double x, double y, int mode);
}
