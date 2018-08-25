package org.burgersim.pgeg.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import org.burgersim.pgeg.listener.PgegRegistry;

public class ItemManaDust extends Item {
    public ItemManaDust(Builder p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext context) {
        IWorld world = context.getWorld();
        BlockPos blockPos = context.getPos().up();
        if (context.getFace() == EnumFacing.UP  && PgegRegistry.MANA_DUST_WIRE.getDefaultState().isValidPosition(world, blockPos)) {
            world.setBlockState(blockPos, PgegRegistry.MANA_DUST_WIRE.getDefaultState(), 11);
            EntityPlayer player = context.getPlayer();
            ItemStack stack = context.getItem();
            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, blockPos, stack);
            }

            stack.shrink(1);
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.PASS;
        }
    }
}
