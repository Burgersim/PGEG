package org.burgersim.pgeg.tileentity;

import com.github.ondee.snowflake.block.BlockWaterlogged;
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

public class TileEntitySpellCauldron extends TileEntity implements IInventory, ITickable {
    private static final int TIME_TO_HEAT = 60;

    private NonNullList<ItemStack> content;
    private int heatTicks;
    private int time;
    private int prevTime;
    private NonNullList<ItemStack> cachedContent;
    private IRecipe cachedRecipe;

    public TileEntitySpellCauldron() {
        super(SPELL_CAULDRON);
        content = NonNullList.withSize(9, ItemStack.EMPTY);
    }

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if (world != null) {
            IBlockState state = world.getBlockState(getPos());
            world.notifyBlockUpdate(getPos(), state, state, 3);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        content = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(tag, content);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        writeContent(tag);
        return tag;
    }

    NBTTagCompound writeContent(NBTTagCompound tag) {
        ItemStackHelper.saveAllItems(tag, content);
        return tag;
    }

    @Override
    public boolean isEmpty() {
        Iterator var1 = this.content.iterator();

        ItemStack stack;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            stack = (ItemStack) var1.next();
        } while (stack.isEmpty());

        return false;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return content.get(i);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack stack = ItemStackHelper.getAndSplit(content, index, count);

        if (!stack.isEmpty()) {
            markDirty();
        }

        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int i) {
        return ItemStackHelper.getAndRemove(content, i);
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        content.set(i, itemStack);

        if (itemStack.getCount() > this.getInventoryStackLimit()) {
            itemStack.setCount(this.getInventoryStackLimit());
        }
        markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer entityPlayer) {

    }

    @Override
    public void closeInventory(EntityPlayer entityPlayer) {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return getStackInSlot(i).isEmpty();
    }

    @Override
    public int getField(int i) {
        return 0;
    }

    @Override
    public void setField(int i, int i1) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        content.clear();
    }

    @Override
    public ITextComponent getName() {
        return new TextComponentTranslation("tile.pgeg.spell_cauldron");
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Nullable
    @Override
    public ITextComponent getCustomName() {
        return null;
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag = super.getUpdateTag();
        this.writeContent(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), -1, nbtTag);
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound tag = super.getUpdateTag();
        writeContent(tag);
        return tag;
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
        for (ItemStack stack : content) {
            if (stack.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void addItem(ItemStack stack) {
        for (int i = 0; i < content.size(); i++) {
            if (isItemValidForSlot(i, stack)) {
                setInventorySlotContents(i, stack);
                return;
            }
        }
    }

    public ItemStack removeItem() {
        for (int i = content.size() - 1; i >= 0; i--) {
            ItemStack remove = getStackInSlot(i);
            if (!remove.isEmpty()) {
                setInventorySlotContents(i, ItemStack.EMPTY);
                return remove;
            }
        }
        return ItemStack.EMPTY;
    }

    public IRecipe getRecipe() {
        if (content.equals(cachedContent)) {
            return cachedRecipe;
        } else {
            RecipesSpellCauldron recipe = (RecipesSpellCauldron) world.getRecipeManager().getRecipe(this, world);
            cachedContent = content;
            cachedRecipe = recipe;
            return recipe;
        }
    }

    public int itemCount() {
        int count = 0;
        for (ItemStack stack : content) {
            if (!stack.isEmpty()) {
                count++;
            }
        }
        return count;
    }

}
