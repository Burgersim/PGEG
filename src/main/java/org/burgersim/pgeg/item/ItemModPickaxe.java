package org.burgersim.pgeg.item;

import net.minecraft.item.IItemTier;

public class ItemModPickaxe extends net.minecraft.item.ItemPickaxe {
    public ItemModPickaxe(IItemTier itemTier, int damageModifier, float attackSpeed, Builder builder) {
        super(itemTier, damageModifier, attackSpeed, builder);
    }
}
