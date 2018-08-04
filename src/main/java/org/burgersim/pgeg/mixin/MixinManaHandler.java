package org.burgersim.pgeg.mixin;

import net.minecraft.entity.player.EntityPlayer;
import org.burgersim.pgeg.mana.IManaHandler;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityPlayer.class)
public class MixinManaHandler implements IManaHandler {

    private float mana = 0.0F;
    private float maxMana = 20.0F;

    @Override
    public void setMana(float mana) {
        this.mana = Math.max(0, Math.min(getMaxMana(), mana));
    }

    @Override
    public void setMaxMana(float maxMana) {
        this.maxMana = Math.max(0, maxMana);
    }

    @Override
    public float getMana() {
        return mana;
    }

    @Override
    public float getMaxMana() {
        return maxMana;
    }
}
