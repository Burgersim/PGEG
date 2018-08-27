package org.burgersim.pgeg.item;

import net.minecraft.init.Items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyLoadBase;
import org.burgersim.pgeg.listener.PgegRegistry;

import java.util.function.Supplier;

public enum ModTiers implements IItemTier {
    ORICHALCUM(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.fromItems(new IItemProvider[]{PgegRegistry.ORICHALCUM_INGOT});
    });
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> ingredient;

    ModTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> ingredientSupplier) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.ingredient = new LazyLoadBase(ingredientSupplier);
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient func_200924_f() {
        return this.ingredient.getValue();
    }
}
