package org.burgersim.pgeg.tileentity;

import com.github.ondee.snowflake.block.BlockWaterlogged;
import com.github.ondee.snowflake.tileentity.TileEntityInventory;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import org.burgersim.pgeg.block.BlockSpellCauldron;
import org.burgersim.pgeg.recipe.RecipesSpellCauldron;

import javax.annotation.Nullable;
import java.util.Iterator;

import static org.burgersim.pgeg.listener.PgegTileEntityTypes.SPELL_CAULDRON;

public class TileEntitySpellCauldron extends TileEntityInventory implements ITickable {
    private static final int TIME_TO_HEAT = 60;

    private int heatTicks;
    private int time;
    private int prevTime;
    private NonNullList<ItemStack> cachedContent;
    private IRecipe cachedRecipe;

    public TileEntitySpellCauldron() {
        super(SPELL_CAULDRON, 9, "tile.pgeg.spell_cauldron");
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            if (!getBlockState().getValue(BlockSpellCauldron.IS_HEATED) && !getBlockState().getValue(BlockWaterlogged.isWaterlogged)) {
                Block block = world.getBlockState(pos.down()).getBlock();
                if (getBlockState().getValue(BlockSpellCauldron.HAS_WATER) && (block == Blocks.LAVA || block == Blocks.MAGMA_BLOCK)) {
                    if (heatTicks < TIME_TO_HEAT) {
                        heatTicks++;
                    } else {
                        world.setBlockState(pos, getBlockState().withProperty(BlockSpellCauldron.IS_HEATED, true));
                        heatTicks = 0;
                    }
                }
            }
        } else {
            prevTime = time;
            time++;

            if (time > Integer.MAX_VALUE / 4) {
                time = 0;
            }

        }
    }

    public int getTime() {
        return time;
    }

    public int getPrevTime() {
        return prevTime;
    }

    public boolean hasEmptySpace() {
        for (ItemStack stack : getContent()) {
            if (stack.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void addItem(ItemStack stack) {
        for (int i = 0; i < getContent().size(); i++) {
            if (isItemValidForSlot(i, stack)) {
                setInventorySlotContents(i, stack);
                return;
            }
        }
    }

    public ItemStack removeItem() {
        for (int i = getContent().size() - 1; i >= 0; i--) {
            ItemStack remove = getStackInSlot(i);
            if (!remove.isEmpty()) {
                setInventorySlotContents(i, ItemStack.EMPTY);
                return remove;
            }
        }
        return ItemStack.EMPTY;
    }

    public IRecipe getRecipe() {
        if (getContent().equals(cachedContent)) {
            return cachedRecipe;
        } else {
            RecipesSpellCauldron recipe = (RecipesSpellCauldron) world.getRecipeManager().getRecipe(this, world);
            cachedContent = getContent();
            cachedRecipe = recipe;
            return recipe;
        }
    }

    public int itemCount() {
        int count = 0;
        for (ItemStack stack : getContent()) {
            if (!stack.isEmpty()) {
                count++;
            }
        }
        return count;
    }

}
