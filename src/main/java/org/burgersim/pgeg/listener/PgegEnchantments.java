package org.burgersim.pgeg.listener;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.enchantment.*;
import org.dimdev.rift.listener.EnchantmentAdder;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegEnchantments implements EnchantmentAdder {
    public static Enchantment VAMPIRISM;
    public static Enchantment POISONOUS;
    public static Enchantment CURSE_PAIN;
    public static Enchantment BEHEADING;
    public static Enchantment RANDOMIZATION;
    public static Enchantment EXPANSION;

    @Override
    public void registerEnchantments() {
        VAMPIRISM = registerEnchantment(new ResourceLocation(MOD_ID, "vampirism"), new EnchantmentVampirism());
        POISONOUS = registerEnchantment(new ResourceLocation(MOD_ID, "poisonous"), new EnchantmentPoisonous());
        CURSE_PAIN = registerEnchantment(new ResourceLocation(MOD_ID, "curse_pain"), new EnchantmentCursePain());
        BEHEADING = registerEnchantment(new ResourceLocation(MOD_ID, "beheading"), new EnchantmentBeheading());
        RANDOMIZATION = registerEnchantment(new ResourceLocation(MOD_ID, "randomization"), new EnchantmentRandomization());
        EXPANSION = registerEnchantment(new ResourceLocation(MOD_ID, "expansion"), new EnchantmentExpansion());
    }

    private Enchantment registerEnchantment(ResourceLocation location, Enchantment enchantment) {
        Enchantment.registerEnchantment(location.toString(), enchantment);
        return Enchantment.REGISTRY.get(location);
    }
}
