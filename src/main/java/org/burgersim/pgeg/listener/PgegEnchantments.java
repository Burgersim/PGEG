package org.burgersim.pgeg.listener;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.enchantment.EnchantmentVampirism;
import org.dimdev.rift.listener.EnchantmentAdder;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegEnchantments implements EnchantmentAdder {
    public static Enchantment VAMPIRISM;

    @Override
    public void registerEnchantments() {
        VAMPIRISM = registerEnchantment(new ResourceLocation(MOD_ID, "vampirism"), new EnchantmentVampirism());
    }

    private Enchantment registerEnchantment(ResourceLocation location, Enchantment enchantment) {
        Enchantment.registerEnchantment(location.toString(), enchantment);
        return Enchantment.REGISTRY.get(location);
    }
}
