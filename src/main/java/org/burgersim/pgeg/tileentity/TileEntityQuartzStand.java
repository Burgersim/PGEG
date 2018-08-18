package org.burgersim.pgeg.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;
import java.util.Iterator;

import static org.burgersim.pgeg.listener.PgegTileEntityTypes.QUARTZ_STAND;

public class TileEntityQuartzStand extends TileEntity implements IInventory, ITickable {

    private NonNullList<ItemStack> content;
    private int time;
    private int prevTime;

    public TileEntityQuartzStand() {
        super(QUARTZ_STAND);
        content = NonNullList.withSize(1, ItemStack.EMPTY);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if (world != null)
        {
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
    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        writeContent(tag);
        return tag;
    }

    NBTTagCompound writeContent(NBTTagCompound tag)
    {
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
        return new TextComponentTranslation("tile.pgeg.quartz_stand");
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
        if (world.isRemote)
        {
            prevTime = time;
            time++;

            if (time > Integer.MAX_VALUE / 4)
            {
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
}
