package org.burgersim.pgeg.item;

import net.minecraft.item.IItemTier;

public class ItemModSword extends net.minecraft.item.ItemSword {
    public ItemModSword(IItemTier itemTier, int damageModifier, float attackSpeed, Builder builder) {
        super(itemTier, damageModifier, attackSpeed, builder);
    }
}
