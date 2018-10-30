package org.burgersim.pgeg.mixin.common;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceFluidMode;
import net.minecraft.util.math.RayTraceResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

@Mixin(PlayerInteractionManager.class)
public abstract class MixinPlayerInteraction {
    @Shadow
    public EntityPlayerMP player;

    @Shadow
    public abstract boolean tryHarvestBlock(BlockPos p_tryHarvestBlock_1_);

    @Inject(method = "stopDestroyBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/management/PlayerInteractionManager;tryHarvestBlock(Lnet/minecraft/util/math/BlockPos;)Z"))
    private void onBlockBreak(BlockPos blockPos, CallbackInfo ci) {
        ItemStack stack = player.getHeldItemMainhand();
        if (stack.isEnchanted()) {
            NBTTagList enchantments = stack.getEnchantmentTagList();
            boolean isExpanded = false;
            for (int i = 0; i < enchantments.size(); i++) {
                NBTTagCompound compound = enchantments.getCompoundTagAt(i);
                if ((MOD_ID + ":expansion").equals(compound.getString("id"))) {
                    isExpanded = true;
                }
            }
            if (isExpanded) {
                RayTraceResult traceResult = player.rayTrace(20.0f, 0.0f, RayTraceFluidMode.NEVER);
                if (traceResult != null) {
                    switch (traceResult.sideHit) {
                        case UP:
                        case DOWN:
                            BlockPos.getAllInBox(blockPos.add(-1, 0, -1), blockPos.add(1, 0, 1))
                                    .forEach(this::tryHarvestBlock);
                            break;
                        case EAST:
                        case WEST:
                            BlockPos.getAllInBox(blockPos.add(0, -1, -1), blockPos.add(0, 1, 1))
                                    .forEach(this::tryHarvestBlock);
                            break;
                        case NORTH:
                        case SOUTH:
                            BlockPos.getAllInBox(blockPos.add(-1, -1, 0), blockPos.add(1, 1, 0))
                                    .forEach(this::tryHarvestBlock);
                            break;
                    }
                }
            }
        }

    }
}
