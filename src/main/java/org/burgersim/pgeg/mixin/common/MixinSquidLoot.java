package org.burgersim.pgeg.mixin.common;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.burgersim.pgeg.listener.PgegRegistry;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(EntitySquid.class)
public class MixinSquidLoot extends EntityWaterMob {
    public MixinSquidLoot(EntityType<?> p_i48565_1_, World p_i48565_2_) {
        super(p_i48565_1_, p_i48565_2_);
    }

    @Override
    public void dropLoot(boolean b, int i, DamageSource source) {
        super.dropLoot(b, i, source);
        Random random = new Random();
        if (this.isBurning()) {
            this.entityDropItem(new ItemStack(PgegRegistry.SQUID_COOKED, random.nextInt(8)));
        }else{
            this.entityDropItem(new ItemStack(PgegRegistry.SQUID_RAW, random.nextInt(8)));
        }
    }
}
