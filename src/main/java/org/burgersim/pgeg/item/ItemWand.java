package org.burgersim.pgeg.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.burgersim.pgeg.listener.PgegItems;
import org.burgersim.pgeg.mana.IManaHandler;

public class ItemWand extends Item {
    public ItemWand() {
        super(new Item.Builder().group(ItemGroup.TOOLS).maxStackSize(1).rarity(EnumRarity.UNCOMMON));
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getPos();
        IBlockState blockState = world.getBlockState(blockPos);
        if (blockState != null) {
            EntityPlayer player = context.getPlayer();
            IManaHandler handler = (IManaHandler) player;
            if (handler != null) {
                if (blockState.getBlock() == Blocks.BOOKSHELF) {
                    playSound(world, player, blockPos);
                    world.setBlockToAir(blockPos);
                    spawnEnchantParticle(world, blockPos);
                    if (handler.getMaxMana() == 0.0F) {
                        handler.setMaxMana(100.0F);
                    }
                    double xOffset = (double) (itemRand.nextFloat() * 0.5F) + 0.25D;
                    double yOffset = (double) (itemRand.nextFloat() * 0.5F) + 0.25D;
                    double zOffset = (double) (itemRand.nextFloat() * 0.5F) + 0.25D;
                    EntityItem item = new EntityItem(world, blockPos.getX() + xOffset
                            , blockPos.getY() + yOffset, blockPos.getZ() + zOffset,
                            new ItemStack(PgegItems.SPELL_BOOK, 1));
                    item.setNoDespawn();
                    item.setDefaultPickupDelay();
                    if (!world.isRemote())
                        world.spawnEntity(item);
                }
            }
        }
        return EnumActionResult.SUCCESS;
    }

    private void spawnEnchantParticle(World world, BlockPos blockPos) {
        for (int i = 0; i < 20; i++) {
            double xOffset = (double) (itemRand.nextFloat() * 0.5F) + 0.25D;
            double yOffset = (double) (itemRand.nextFloat() * 0.5F) + 0.25D;
            double zOffset = (double) (itemRand.nextFloat() * 0.5F) + 0.25D;
            world.addParticle(Particles.ENCHANT, true,
                    blockPos.getX() + xOffset,
                    blockPos.getY() + yOffset,
                    blockPos.getZ() + zOffset,
                    0.0, 0.5, 0.0);
        }
    }

    private void playSound(World world, EntityPlayer player, BlockPos blockPos) {
        world.playSound(player, blockPos, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.AMBIENT, 1.0F, 1.0F);
    }
}
