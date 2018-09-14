package org.burgersim.pgeg.recipe.aei.wand;

import com.gmail.zendarva.aei.api.IDisplayCategory;
import com.gmail.zendarva.aei.gui.widget.AEISlot;
import com.gmail.zendarva.aei.gui.widget.Control;

import java.util.LinkedList;
import java.util.List;

public class PgegWandCraftingCategory implements IDisplayCategory<PgegWandRecipe> {
    private PgegWandRecipe recipe;

    @Override
    public String getId() {
        return "pgeg:wand";
    }

    @Override
    public String getDisplayName() {
        return "Wand crafting";
    }

    @Override
    public void setRecipe(PgegWandRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public List<AEISlot> setupDisplay() {
        List<AEISlot> slots = new LinkedList<>();
        AEISlot input = new AEISlot(80, 75);
        AEISlot wand = new AEISlot(80, 100);
        AEISlot output = new AEISlot(80, 125);
        input.setDrawBackground(true);
        input.setStackList(recipe.getInput().get(0));
        slots.add(input);
        wand.setDrawBackground(false);
        wand.setStackList(recipe.getWands());
        slots.add(wand);
        output.setDrawBackground(true);
        output.setStackList(recipe.getOutput());
        slots.add(output);
        return slots;
    }

    @Override
    public boolean canDisplay(PgegWandRecipe recipe) {
        return false;
    }

    @Override
    public void drawExtras() {

    }

    @Override
    public void addWidget(List<Control> controls) {

    }
}
