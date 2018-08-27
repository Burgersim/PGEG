package org.burgersim.pgeg.client.book;

public interface IBookPage {

    void draw(int mouseX, int mouseY);

    boolean onMouseClicked(double x, double y, int mode);
}
