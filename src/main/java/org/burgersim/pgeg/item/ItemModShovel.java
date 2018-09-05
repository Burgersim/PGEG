package org.burgersim.pgeg.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemSpade;

public class ItemModShovel extends ItemSpade {
    public ItemModShovel(IItemTier itemTier, float damageModifier, float attackSpeed, Builder builder) {
        super(itemTier, damageModifier, attackSpeed, builder);
    }
}
