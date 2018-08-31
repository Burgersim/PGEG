package org.burgersim.pgeg.rune;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Particles;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RuneMagnetizm extends Rune {
    public RuneMagnetizm() {
        super(RuneType.ENTITY, 5 * 20, 1.0f, 2, 0x553C8F, new ResourceLocation(MOD_ID, "textures/rune/rune_binding.png"));
    }

    @Override
    public void processEntity(Entity entity, BlockPos runePos, int levelModifier) {
        if (entity instanceof EntityPlayer) {
            return;
        }
        entity.setPositionAndUpdate(runePos.getX() + .5, runePos.getY() + .5, runePos.getZ() + .5);
        for (int i = 0; i < 5; i++)
            entity.getEntityWorld().addOptionalParticle(Particles.PORTAL, entity.posX, entity.posY, entity.posZ, 0, 1, 0);
    }
}
