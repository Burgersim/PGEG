package org.burgersim.pgeg.item;

import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class SaturniumAxe extends ItemModAxe {
    public SaturniumAxe(IItemTier itemTier, float attackDamage, float attackSpeed, Builder builder) {
        super(itemTier, attackDamage, attackSpeed, builder);
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        List<EnchantmentData> enchantmentList = EnchantmentHelper.buildEnchantmentList(random, stack, 20, true);
        enchantmentList.forEach(enchantmentData -> stack.addEnchantment(enchantmentData.enchantment, enchantmentData.enchantmentLevel));
    }
}
