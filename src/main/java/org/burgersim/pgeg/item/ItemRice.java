package org.burgersim.pgeg.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ItemRice extends ItemSeedFood {
    private final IBlockState crop;
    public ItemRice(int healAmount, float p_i48473_2_, Block block, Builder builder) {
        super(healAmount, p_i48473_2_, block, builder);
        crop = block.getDefaultState();
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext context) {
        IWorld world = context.getWorld();
        BlockPos blockPos = context.getPos().up();
        if (context.getFace() == EnumFacing.UP && world.getBlockState(blockPos).getFluidState().isTagged(FluidTags.WATER) && crop.isValidPosition(world, blockPos)) {
            world.setBlockState(blockPos, crop, 11);
            EntityPlayer player = context.getPlayer();
            ItemStack stack = context.getItem();
            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, blockPos, stack);
            }

            stack.shrink(1);
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.PASS;
        }
    }
}
