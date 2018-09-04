package org.burgersim.pgeg.mixin.common;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityDamaged {

    @Inject(method = "damageEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;setHealth(F)V"),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void onDamageEntity(DamageSource source, float damage, CallbackInfo ci, float finalDamage) {
        if (source.getTrueSource() instanceof EntityLivingBase) {
            EntityLivingBase trueSource = (EntityLivingBase) source.getTrueSource();
            ItemStack stack = trueSource.getHeldItemMainhand();
            if (stack.isItemEnchanted()) {
                NBTTagList enchantments = stack.getEnchantmentTagList();
                int vampirismLevel = 0;
                for (int i = 0; i < enchantments.size(); i++) {
                    NBTTagCompound compound = enchantments.getCompoundTagAt(i);
                    if ((MOD_ID + ":vampirism").equals(compound.getString("id"))) {
                        vampirismLevel = compound.getInteger("lvl");
                    }
                }
                trueSource.setHealth(trueSource.getHealth() + finalDamage * 0.01f * vampirismLevel);
            }
        }
    }

}
