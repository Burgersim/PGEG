package org.burgersim.pgeg.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentCursePain extends Enchantment {
    public EnchantmentCursePain() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public int getMinEnchantability(int level) {
        return 1 + (level - 1) * 11;
    }
}
