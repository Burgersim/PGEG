package org.burgersim.pgeg.mixin.common;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import org.burgersim.pgeg.mana.IManaHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

@Mixin(EntityPlayer.class)
public abstract class MixinManaHandler extends EntityLivingBase implements IManaHandler {
    private static final DataParameter<Float> MANA;
    private static final DataParameter<Float> MAX_MANA;
    private static final int REGEN_SPEED = 20;
    private static final float REGEN_AMOUNT = 1.0f;

    static {
        MANA = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.FLOAT);
        MAX_MANA = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.FLOAT);
    }

    public MixinManaHandler(EntityType<?> p_i48577_1_, World p_i48577_2_) {
        super(p_i48577_1_, p_i48577_2_);
    }

    @Override
    public void setMana(float mana) {
        this.dataManager.set(MANA, Math.min(getMaxMana(), mana));
    }

    @Override
    public void setMaxMana(float maxMana) {
        this.dataManager.set(MAX_MANA, Math.max(0.0F, maxMana));
    }

    @Override
    public void regenMana(float mana) {
        this.setMana(this.getMana() + mana);
    }

    @Override
    public float getMana() {
        return this.dataManager.get(MANA);
    }

    @Override
    public float getMaxMana() {
        return this.dataManager.get(MAX_MANA);
    }

    @Inject(method = "livingTick", at = @At("RETURN"))
    private void onPlayerUpdate(CallbackInfo ci) {
        if (this.getMana() < this.getMaxMana() && this.ticksExisted % REGEN_SPEED == 0) {
            regenMana(REGEN_AMOUNT);
        }
    }

    @Inject(method = "registerData", at = @At("TAIL"))
    private void manaInit(CallbackInfo ci) {
        this.dataManager.register(MAX_MANA, 0.0F);
        this.dataManager.register(MANA, 0.0F);
    }

    @Inject(method = "writeEntityToNBT", at = @At("RETURN"))
    private void writeMana(NBTTagCompound compound, CallbackInfo ci) {
        compound.setFloat(MOD_ID + ":MaxMana", this.getMaxMana());
        compound.setFloat(MOD_ID + ":Mana", this.getMana());
    }

    @Inject(method = "readEntityFromNBT", at = @At("RETURN"))
    private void readMana(NBTTagCompound compound, CallbackInfo ci) {
        this.setMaxMana(compound.getFloat(MOD_ID + ":MaxMana"));
        this.setMana(compound.getFloat(MOD_ID + ":Mana"));
    }


}
