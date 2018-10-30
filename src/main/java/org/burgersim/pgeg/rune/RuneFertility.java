package org.burgersim.pgeg.rune;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RuneFertility extends Rune {
    public RuneFertility() {
        super(RuneType.ENTITY, 40, 1.0f, 1, 0xFF607B, new ResourceLocation(MOD_ID, "textures/rune/rune_fertility.png"));
    }

    @Override
    public void processEntity(Entity entity, BlockPos runePos, int levelModifier) {
        if (entity instanceof EntityAnimal) {
            if (!((EntityAnimal) entity).isInLove())
                ((EntityAnimal) entity).setInLove(null);
        }
    }
}
