package org.burgersim.pgeg.listener;

import com.github.ondee.snowflake.listener.LootAdder;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

import java.util.Random;

public class PgegLootAdder implements LootAdder {
    @Override
    public void dropLoot(boolean recentlyHit, int lootingModifier, DamageSource source, EntityLiving entity) {
        Random random = entity.world.rand;
        if (entity instanceof EntitySquid) {
            if (entity.isBurning()) {
                entity.entityDropItem(new ItemStack(PgegRegistry.SQUID_COOKED, random.nextInt(8)));
            } else {
                entity.entityDropItem(new ItemStack(PgegRegistry.SQUID_RAW, random.nextInt(8)));
            }
        }
    }
}
