package org.burgersim.pgeg.mixin.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import org.burgersim.pgeg.listener.PgegPotions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLivingBase.class)
public abstract class MixinLevitationEffect extends Entity {
    public MixinLevitationEffect(EntityType<?> p_i48580_1_, World p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_);
    }

    @Shadow
    public abstract boolean isPotionActive(Potion p_isPotionActive_1_);

    @Inject(method = "travel", at = @At(value = "RETURN"))
    public void onTravel(float p_travel_1_, float p_travel_2_, float p_travel_3_, CallbackInfo ci) {
        if (this.isPotionActive(PgegPotions.HOVER)) {
            if (!this.isSneaking()) {
                this.motionY = 0.0;
                this.fallDistance = 0.0f;
            }
        }
    }
}
