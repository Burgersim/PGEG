package org.burgersim.pgeg.rune;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.burgersim.pgeg.listener.PgegPotions;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RuneAir extends Rune {
    public RuneAir() {
        super(RuneType.TOUCH, 100, 1.0f, 1, 0xffffff, new ResourceLocation(MOD_ID, "textures/rune/rune_air.png"));

    }

    @Override
    public void processCollide(World world, Entity entity, BlockPos runePos, int levelModifier) {
        if (entity instanceof EntityLivingBase) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PgegPotions.HOVER, 20 * 20 * levelModifier));
        }
    }
}
