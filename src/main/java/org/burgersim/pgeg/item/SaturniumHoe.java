package org.burgersim.pgeg.item;

import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class SaturniumHoe extends ItemModHoe {
    public SaturniumHoe(IItemTier itemTier, float speed, Builder builder) {
        super(itemTier, speed, builder);
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        List<EnchantmentData> enchantmentList = EnchantmentHelper.buildEnchantmentList(itemRand, stack, 20, true);
        enchantmentList.forEach(enchantmentData -> stack.addEnchantment(enchantmentData.enchantment, enchantmentData.enchantmentLevel));
    }
}
