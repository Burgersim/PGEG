package org.burgersim.pgeg.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.burgersim.pgeg.mana.IManaHandler;
import org.burgersim.pgeg.recipe.InWorldCrafting;
import org.burgersim.pgeg.recipe.RecipesWand;

public class ItemWand extends Item {

    public ItemWand() {
        super(new Item.Builder().group(ItemGroup.TOOLS).maxStackSize(1).rarity(EnumRarity.UNCOMMON));
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getPos();
        EntityPlayer player = context.getPlayer();
        IManaHandler handler = (IManaHandler) player;
        RecipesWand recipe = (RecipesWand) world.getRecipeManager().getRecipe(
                new InWorldCrafting(world.getBlockState(blockPos).getBlock()), world);
        if (recipe != null && recipe.isRightWand(context.getItem()) && recipe.getManaCost() <= handler.getMana()) {
            if (!world.isRemote()) {
                if (handler.getMaxMana() <= 0) {
                    handler.setMaxMana(20);
                }
                if (!player.capabilities.isCreativeMode) {
                    handler.setMana(handler.getMana() - recipe.getManaCost());
                }
                Block result = Block.getBlockFromItem(recipe.getCraftingResult(null).getItem());
                if (result != Blocks.AIR) {
                    world.setBlockState(blockPos, result.getDefaultState());
                } else {
                    world.removeBlock(blockPos);
                    world.spawnEntity(
                            new EntityItem(
                                    world,
                                    blockPos.getX() + .5,
                                    blockPos.getY() + .5,
                                    blockPos.getZ() + .5,
                                    recipe.getCraftingResult(null)));
                    spawnEnchantParticle(world, blockPos);
                    playSound(world, player, blockPos);
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
