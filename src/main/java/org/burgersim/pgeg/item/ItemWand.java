package org.burgersim.pgeg.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.burgersim.pgeg.mana.IManaHandler;
import org.burgersim.pgeg.recipe.ModRecipes;
import org.burgersim.pgeg.recipe.RecipesWand;

public class ItemWand extends Item {
    private final int wandLevel;

    public ItemWand(int wandLevel) {
        super(new Item.Builder().group(ItemGroup.TOOLS).maxStackSize(1).rarity(EnumRarity.UNCOMMON));
        this.wandLevel = wandLevel;
    }

    @Override
    public EnumActionResult onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getPos();
        IBlockState blockState = world.getBlockState(blockPos);
        EntityPlayer player = context.getPlayer();
        IManaHandler handler = (IManaHandler) player;
        RecipesWand recipe = (RecipesWand) world.getRecipeManager().getRecipe(
                new ModRecipes.InWorldCrafting(world.getBlockState(blockPos).getBlock()), world);
        if (recipe != null && recipe.getWandLevel() <= wandLevel && recipe.getManaCost() <= handler.getMana()) {
            if (!world.isRemote()) {
                if (handler.getMaxMana() <= 0) {
                    handler.setMaxMana(100);
                }
                if (!player.capabilities.isCreativeMode) {
                    handler.setMana(handler.getMana() - recipe.getManaCost());
                }
                if ("item".equals(recipe.getOutputType())) {
                    world.setBlockToAir(blockPos);
                    world.spawnEntity(
                            new EntityItem(
                                    world,
                                    blockPos.getX() + .5,
                                    blockPos.getY() + .5,
                                    blockPos.getZ() + .5,
                                    recipe.getCraftingResult(null)));
                    spawnEnchantParticle(world, blockPos);
                    playSound(world, player, blockPos);
                } else if ("block".equals(recipe.getOutputType())) {
                    world.setBlockState(blockPos, Block.getBlockFromItem(recipe.getCraftingResult(null).getItem()).getDefaultState());
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

    public int getWandLevel() {
        return wandLevel;
    }
}
