package org.burgersim.pgeg.recipe.aei.cauldron;

import com.gmail.zendarva.aei.api.IDisplayCategory;
import com.gmail.zendarva.aei.gui.widget.AEISlot;
import com.gmail.zendarva.aei.gui.widget.Control;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("NoTranslation")
public class PgegCauldronCategory implements IDisplayCategory<PgegCauldronRecipe> {
    private PgegCauldronRecipe recipe;

    @Override
    public String getId() {
        return "pgeg:spell_cauldron";
    }

    @Override
    public String getDisplayName() {
        return new TextComponentTranslation("pgeg.aei.spell_cauldron").getString();
    }

    @Override
    public void setRecipe(PgegCauldronRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public List<AEISlot> setupDisplay() {
        List<AEISlot> slots = new LinkedList<>();
        int offsetPerSlot = 360 / 10;
        for (int i = 0; i < 10; i++) {
            int offset = 117 - offsetPerSlot * i;
            float rad = offset * (float) Math.PI / 180F;
            float cos = (float) Math.cos(rad);
            float sin = (float) Math.sin(rad);
            float x = 80 + (30f) * cos - (30f) * sin;
            float y = 80 + (30f) * sin + (30f) * cos;
            AEISlot slot = new AEISlot((int) x, (int) y);
            slot.setDrawBackground(true);
            if (i < recipe.getInput().size() - 1) {
                slot.setStackList(recipe.getInput().get(i));
            }
            slots.add(slot);
        }
        AEISlot output = new AEISlot(80, 170);
        output.setDrawBackground(true);
        output.setStackList(recipe.getOutput());
        slots.add(output);
        AEISlot wands = new AEISlot(80, 80);
//        wands.setDrawBackground();
        wands.setStackList(recipe.getWands());
        slots.add(wands);
        return slots;
    }

    @Override
    public boolean canDisplay(PgegCauldronRecipe recipe) {
        return false;
    }

    @Override
    public void drawExtras() {
    }

    @Override
    public void addWidget(List<Control> controls) {

    }
}
