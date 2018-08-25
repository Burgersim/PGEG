package org.burgersim.pgeg.item;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemRune extends Item {
    private final ResourceLocation rune;
    public ItemRune(Builder p_i48487_1_, ResourceLocation rune) {
        super(p_i48487_1_);
        this.rune = rune;
    }

    public ResourceLocation getRune() {
        return rune;
    }
}
