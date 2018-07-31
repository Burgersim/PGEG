package org.burgersim.pgeg.mixin;

import jdk.nashorn.internal.ir.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(EntityAnimal.class)
public abstract class MixinEntityAnimal extends EntityAgeable {

    protected MixinEntityAnimal(EntityType<?> p_i48581_1_, World p_i48581_2_) {
        super(p_i48581_1_, p_i48581_2_);
    }

    public boolean func_205020_a(IWorld world) {
        int x = MathHelper.floor(this.posX);
        int y = MathHelper.floor(this.getEntityBoundingBox().minY);
        int z = MathHelper.floor(this.posZ);
        BlockPos pos = new BlockPos(x, y, z);
        return world.getBlockState(
                pos.down()).getBlock() instanceof BlockGrass
                        && world.getLightSubtracted(pos, 0) > 8 && super.func_205020_a(world);
    }

}
