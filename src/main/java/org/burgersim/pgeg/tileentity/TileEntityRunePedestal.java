package org.burgersim.pgeg.tileentity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.burgersim.pgeg.block.BlockRunePedestal;
import org.burgersim.pgeg.rune.Rune;

import javax.annotation.Nullable;

import static org.burgersim.pgeg.listener.PgegTileEntityTypes.RUNE_PEDESTAL;

public class TileEntityRunePedestal extends TileEntity implements ITickable {
    private Rune rune;
    private int cooldown;
    private int time;

    public TileEntityRunePedestal() {
        super(RUNE_PEDESTAL);
    }

    @Override
    public void update() {
        if (rune != null && !world.isRemote()) {
            if (cooldown <= rune.getWorkSpeed()) {
                cooldown++;
            } else {
                switch (rune.getRuneType()) {
                    case BLOCK:
                        cooldown = 0;
                        BlockPos.getAllInBox(
                                new BlockPos(pos.getX() - getLevel() * rune.getWorkRadius(), pos.getY() - 1, pos.getZ() - getLevel() * rune.getWorkRadius()),
                                new BlockPos(pos.getX() + getLevel() * rune.getWorkRadius(), pos.getY() + 2, pos.getZ() + getLevel() * rune.getWorkRadius()))
                                .forEach((blockPos -> {
                                    if (world.rand.nextFloat() <= rune.getWorkChance()) {
                                        rune.processBlock(world, blockPos, pos, getLevel());
                                    }
                                }));
                        break;
                    case ENTITY:
                        cooldown = 0;
                        world.getEntitiesWithinAABB(Entity.class,
                                new AxisAlignedBB(
                                        new BlockPos(pos.getX() - getLevel() * rune.getWorkRadius(), pos.getY() - 1, pos.getZ() - getLevel() * rune.getWorkRadius()),
                                        new BlockPos(pos.getX() + getLevel() * rune.getWorkRadius(), pos.getY() + 2, pos.getZ() + getLevel() * rune.getWorkRadius())))
                                .stream()
                                .filter((entity) -> world.rand.nextFloat() <= rune.getWorkChance())
                                .forEach((entity) -> rune.processEntity(entity, pos, getLevel()));
                        break;
                    case TOUCH:
                        break;
                }
            }
        }
        if (world.isRemote) {
            time++;
            if (time > Integer.MAX_VALUE / 4) {
                time = 0;
            }
        }
    }

    public void onCollide(World world, BlockPos blockpos, Entity entity) {
        if (rune != null) {
            if (cooldown >= rune.getWorkSpeed() && world.rand.nextFloat() <= getRune().getWorkChance()) {
                rune.processCollide(world, entity, blockpos, getLevel());
                cooldown = 0;
            }
        }
    }

    public void setRune(ResourceLocation location) {
        rune = Rune.getRune(location);
    }

    public Rune getRune() {
        return rune;
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        rune = Rune.getRune(new ResourceLocation(tagCompound.getString("rune")));
        cooldown = tagCompound.getInteger("cooldown");

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
        NBTTagCompound compound = super.writeToNBT(tagCompound);
        compound.setString("rune", Rune.REGISTRY.getNameForObject(rune).toString());
        compound.setInteger("cooldown", cooldown);
        return compound;
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound compound = super.getUpdateTag();
        compound.setString("rune", Rune.REGISTRY.getNameForObject(rune).toString());
        compound.setInteger("cooldown", cooldown);
        return new SPacketUpdateTileEntity(pos, -1, compound);
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound compound = super.getUpdateTag();
        compound.setString("rune", Rune.REGISTRY.getNameForObject(rune).toString());
        compound.setInteger("cooldown", cooldown);
        return compound;
    }

    public int getTime() {
        return time;
    }

    public int getLevel() {
        return ((BlockRunePedestal) getBlockState().getBlock()).getLevel();
    }
}
