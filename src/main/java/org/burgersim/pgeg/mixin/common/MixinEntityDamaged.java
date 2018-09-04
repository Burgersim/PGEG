package org.burgersim.pgeg.mixin.common;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityDamaged {

    @Shadow
    public abstract boolean addPotionEffect(PotionEffect p_addPotionEffect_1_);

    @Shadow
    @Final
    private static DataParameter<Integer> POTION_EFFECTS;

    @Inject(method = "damageEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;setHealth(F)V"),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void onDamageEntity(DamageSource source, float damage, CallbackInfo ci, float finalDamage) {
        if (source.getTrueSource() instanceof EntityLivingBase) {
            EntityLivingBase trueSource = (EntityLivingBase) source.getTrueSource();
            ItemStack stack = trueSource.getHeldItemMainhand();
            if (stack.isItemEnchanted()) {
                NBTTagList enchantments = stack.getEnchantmentTagList();
                int vampirismLevel = 0;
                int poisonousLevel = 0;
                for (int i = 0; i < enchantments.size(); i++) {
                    NBTTagCompound compound = enchantments.getCompoundTagAt(i);
                    if ((MOD_ID + ":vampirism").equals(compound.getString("id"))) {
                        vampirismLevel = compound.getInteger("lvl");
                    }
                    if ((MOD_ID + ":poisonous").equals(compound.getString("id"))) {
                        poisonousLevel = compound.getInteger("lvl");
                    }
                }
                trueSource.setHealth(trueSource.getHealth() + finalDamage * 0.01f * vampirismLevel);
                this.addPotionEffect(new PotionEffect(MobEffects.POISON, 5 * 20 * poisonousLevel));
            }
        }
    }

}
