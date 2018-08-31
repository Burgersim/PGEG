package org.burgersim.pgeg.rune;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RuneButchery extends Rune {
    public RuneButchery() {
        super(RuneType.ENTITY, 40, 1.0f, 1, 0x644923, new ResourceLocation(MOD_ID, "textures/rune/rune_pain.png"));
    }

    @Override
    public void processEntity(Entity entity, BlockPos runePos, int levelModifier) {
        if (entity instanceof EntityPlayer || !(entity instanceof EntityLivingBase)) {
            return;
        }
        if (entity instanceof EntityTameable) {
            if (((EntityTameable) entity).isTamed()) {
                return;
            }
        }
        if (entity instanceof EntityAgeable) {
            if (((EntityAgeable) entity).isChild()) {
                return;
            }
        }
        entity.attackEntityFrom(DamageSource.MAGIC, 5.0f * levelModifier);
    }
}
