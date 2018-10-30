package org.burgersim.pgeg.mixin.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLivingBase extends Entity {

    public MixinEntityLivingBase(EntityType<?> p_i48580_1_, World p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_);
    }

    @Shadow
    public abstract boolean addPotionEffect(PotionEffect p_addPotionEffect_1_);

    @Inject(method = "damageEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityLivingBase;setHealth(F)V"),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void onDamageEntity(DamageSource source, float damage, CallbackInfo ci, float finalDamage) {
        if (source.getTrueSource() instanceof EntityLivingBase) {
            EntityLivingBase trueSource = (EntityLivingBase) source.getTrueSource();
            ItemStack stack = trueSource.getHeldItemMainhand();
            if (stack.isEnchanted()) {
                NBTTagList enchantments = stack.getEnchantmentTagList();
                int vampirismLevel = 0;
                int poisonousLevel = 0;
                boolean isPainCursed = false;
                boolean isRandomized = false;
                for (int i = 0; i < enchantments.size(); i++) {
                    NBTTagCompound compound = enchantments.getCompoundTagAt(i);
                    if ((MOD_ID + ":vampirism").equals(compound.getString("id"))) {
                        vampirismLevel = compound.getInteger("lvl");
                    }
                    if ((MOD_ID + ":poisonous").equals(compound.getString("id"))) {
                        poisonousLevel = compound.getInteger("lvl");
                    }
                    if ((MOD_ID + ":curse_pain").equals(compound.getString("id"))) {
                        isPainCursed = true;
                    }
                    if ((MOD_ID + ":randomization").equals(compound.getString("id"))) {
                        isRandomized = true;
                    }
                }
                if (isPainCursed) {
                    trueSource.attackEntityFrom(DamageSource.MAGIC, 1.0f);
                }
                if (isRandomized) {
                    BlockPos newPos = new BlockPos(posX, posY, posZ).add(-8 + rand.nextInt(17),
                            rand.nextInt(8), -8 + rand.nextInt(17));
                    if (!world.getBlockState(newPos).isSolid()) {
                        this.setPositionAndUpdate(newPos.getX(), newPos.getY(), newPos.getZ());
                    }
                }
                trueSource.setHealth(trueSource.getHealth() + finalDamage * 0.01f * vampirismLevel);
                this.addPotionEffect(new PotionEffect(MobEffects.POISON, 5 * 20 * poisonousLevel));
            }
        }
    }

    @Inject(method = "onDeath", at = @At("RETURN"))
    private void onDeath(DamageSource source, CallbackInfo ci) {
        if (source.getTrueSource() instanceof EntityLivingBase) {
            EntityLivingBase trueSource = (EntityLivingBase) source.getTrueSource();
            ItemStack stack = trueSource.getHeldItemMainhand();
            if (stack.isEnchanted()) {
                NBTTagList enchantments = stack.getEnchantmentTagList();
                int beheadingLevel = 0;
                for (int i = 0; i < enchantments.size(); i++) {
                    NBTTagCompound compound = enchantments.getCompoundTagAt(i);
                    if ((MOD_ID + ":beheading").equals(compound.getString("id"))) {
                        beheadingLevel = compound.getInteger("lvl");
                    }
                }
                if (rand.nextFloat() < 0.1f * beheadingLevel) {
                    switch (this.getType().getTranslationKey()) {
                        case "entity.minecraft.skeleton":
                            this.entityDropItem(new ItemStack(Items.SKELETON_SKULL));
                            break;
                        case "entity.minecraft.creeper":
                            this.entityDropItem(new ItemStack(Items.CREEPER_HEAD));
                            break;
                        case "entity.minecraft.zombie":
                            this.entityDropItem(new ItemStack(Items.ZOMBIE_HEAD));
                            break;
                        case "entity.minecraft.wither_skeleton":
                            this.entityDropItem(new ItemStack(Items.WITHER_SKELETON_SKULL));
                            break;
                        default:
                            break;
                    }
                }
            }
        }

    }

}
