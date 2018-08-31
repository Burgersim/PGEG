package org.burgersim.pgeg.client.book;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.client.book.fragment.icon.IconAbstract;
import org.burgersim.pgeg.client.gui.GuiCompendium;

import java.util.List;

public interface IBookPage {

    default void draw(int mouseX, int mouseY) {
        getFragments().forEach(iPageFragment -> iPageFragment.draw(getGui().getTopLeftX(), getGui().getTopLeftY(), mouseX, mouseY));
    }

    default boolean onMouseClicked(double x, double y, int mode) {
        boolean flag = false;
        for (IPageFragment fragment : getFragments()) {
            flag = fragment.onMouseClicked(x, y, mode);
        }
        return flag;
    }

    List<IPageFragment> getFragments();

    GuiCompendium getGui();

    default boolean hasNextPage() {
        return nextPage() != null;
    }

    IBookPage nextPage();

    default String getName() {
        return "unnamed";
    }

    default IconAbstract getIcon() {
        return null;
    }
}
