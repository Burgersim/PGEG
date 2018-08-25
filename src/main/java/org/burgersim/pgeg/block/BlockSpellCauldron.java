package org.burgersim.pgeg.block;


import com.github.ondee.snowflake.block.BlockWaterlogged;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ShapeUtils;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.burgersim.pgeg.recipe.RecipesSpellCauldron;
import org.burgersim.pgeg.tileentity.TileEntitySpellCauldron;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockSpellCauldron extends BlockWaterlogged implements ITileEntityProvider {
    public static final BooleanProperty HAS_WATER;
    public static final BooleanProperty IS_HEATED;
    private static final VoxelShape SHAPE;
    private static final VoxelShape SHAPE1;

    public BlockSpellCauldron(Builder builder) {
        super(builder);
        this.setDefaultState(this.getDefaultState().withProperty(HAS_WATER, false).withProperty(IS_HEATED, false));
    }

    @Override
    public VoxelShape getShape(IBlockState p_getShape_1_, IBlockReader p_getShape_2_, BlockPos p_getShape_3_) {
        return SHAPE;
    }

    public boolean isFullCube(IBlockState p_isFullCube_1_) {
        return false;
    }

    public boolean isSolid(IBlockState p_isSolid_1_) {
        return false;
    }


    @Override
    public void onEntityCollision(IBlockState state, World world, BlockPos blockPos, Entity entity) {
        if (world.isRemote) {
            return;
        }
        if (entity instanceof EntityItem && state.getValue(HAS_WATER)) {
            EntityItem item = (EntityItem) entity;

            TileEntity te = world.getTileEntity(blockPos);
            if (te instanceof TileEntitySpellCauldron) {
                TileEntitySpellCauldron cauldron = (TileEntitySpellCauldron) te;
                ItemStack stack = item.getItem();
                if (cauldron.hasEmptySpace()) {
                    ItemStack add = stack.copy();
                    add.setCount(1);
                    cauldron.addItem(add);
                    cauldron.markDirty();
                    stack.shrink(1);
                }
                item.setItem(stack);
            }
        }
    }

    public BlockFaceShape getBlockFaceShape(IBlockReader p_getBlockFaceShape_1_, IBlockState p_getBlockFaceShape_2_, BlockPos p_getBlockFaceShape_3_, EnumFacing p_getBlockFaceShape_4_) {
        if (p_getBlockFaceShape_4_ == EnumFacing.UP) {
            return BlockFaceShape.BOWL;
        } else {
            return p_getBlockFaceShape_4_ == EnumFacing.DOWN ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
        }
    }

    @Override
    public boolean onBlockActivated(IBlockState state, World world, BlockPos blockPos, EntityPlayer player, EnumHand hand, EnumFacing facing, float p_onBlockActivated_7_, float p_onBlockActivated_8_, float p_onBlockActivated_9_) {
        if (world.isRemote) {
            return true;
        }

        ItemStack stack = player.getHeldItem(hand);
        if (stack.isEmpty()) {
            TileEntity te = world.getTileEntity(blockPos);
            if (te instanceof TileEntitySpellCauldron) {
                TileEntitySpellCauldron cauldron = (TileEntitySpellCauldron) te;
                ItemStack remove = cauldron.removeItem();
                if (!remove.isEmpty()) {
                    cauldron.markDirty();

                    if (!player.inventory.addItemStackToInventory(remove)) {
                        InventoryHelper.spawnItemStack(world, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), remove);
                    } else {
                        player.openContainer.detectAndSendChanges();
                    }
                }
            }
        } else {
            Item item = stack.getItem();
            if (item == Items.WATER_BUCKET) {
                if (!state.getValue(HAS_WATER) && !world.isRemote()) {
                    if (!player.capabilities.isCreativeMode) {
                        player.setHeldItem(hand, new ItemStack(Items.BUCKET));
                    }
                    player.addStat(StatList.CAULDRON_FILLED);
                    world.setBlockState(blockPos, state.withProperty(IS_HEATED, false).withProperty(HAS_WATER, true));
                    world.playSound(null, blockPos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
            }
            if (item == Items.BUCKET) {
                if (state.getValue(HAS_WATER) && !world.isRemote()) {
                    if (!player.capabilities.isCreativeMode) {
                        stack.shrink(1);
                        if (stack.isEmpty()) {
                            player.setHeldItem(hand, new ItemStack(Items.WATER_BUCKET));
                        } else if (!player.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
                            player.dropItem(new ItemStack(Items.WATER_BUCKET), false);
                        }
                    }
                    player.addStat(StatList.CAULDRON_USED);
                    world.setBlockState(blockPos, state.withProperty(IS_HEATED, false).withProperty(HAS_WATER, false));
                    TileEntity tileEntity = world.getTileEntity(blockPos);
                    if (tileEntity instanceof IInventory) {
                        InventoryHelper.dropInventoryItems(world, blockPos, (IInventory) tileEntity);
                    }
                    world.playSound(null, blockPos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
            }
            if (state.getValue(IS_HEATED)) {
                TileEntity te = world.getTileEntity(blockPos);
                if (te instanceof TileEntitySpellCauldron) {
                    TileEntitySpellCauldron cauldron = (TileEntitySpellCauldron) te;
                    RecipesSpellCauldron recipe = (RecipesSpellCauldron) cauldron.getRecipe();
                    if (recipe != null && recipe.isRightWand(stack)) {
                        if (!player.addItemStackToInventory(recipe.getCraftingResult(cauldron))) {
                            player.dropItem(recipe.getCraftingResult(cauldron), false);
                        }
                        cauldron.clear();
                        cauldron.markDirty();
                        world.setBlockState(blockPos, state.withProperty(IS_HEATED, false).withProperty(HAS_WATER, false));
                    }
                }
            }
        }
        return true;
    }


    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos blockPos, Random random) {
        if (state.getValue(IS_HEATED)) {
            for (int i = 0; i < 5; i++)
                world.addOptionalParticle(Particles.BUBBLE_POP, blockPos.getX() + .2 + random.nextFloat() * .6, blockPos.getY() + .9 + random.nextFloat() * .1, blockPos.getZ() + .2 + random.nextFloat() * .6, 0, 0, 0);
            world.addOptionalParticle(Particles.BUBBLE, blockPos.getX() + .2 + random.nextFloat() * .6, blockPos.getY() + .9 + random.nextFloat() * .1, blockPos.getZ() + .2 + random.nextFloat() * .6, 0, 0, 0);
        }
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    protected void addPropertiesToBuilder(StateContainer.Builder<Block, IBlockState> map) {
        map.add(HAS_WATER, IS_HEATED);
        super.addPropertiesToBuilder(map);
    }

    static {
        HAS_WATER = BooleanProperty.create("has_water");
        IS_HEATED = BooleanProperty.create("is_heated");
        SHAPE1 = Block.makeCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
        SHAPE = ShapeUtils.func_197878_a(ShapeUtils.fullCube(), SHAPE1, IBooleanFunction.ONLY_FIRST);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader iBlockReader) {
        return new TileEntitySpellCauldron();
    }

    @Override
    public void onReplaced(IBlockState state, World world, BlockPos pos, IBlockState newState, boolean p_beforeReplacingBlock_5_) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof IInventory) {
                InventoryHelper.dropInventoryItems(world, pos, (IInventory) tileEntity);
            }
            world.removeTileEntity(pos);
        }
        super.onReplaced(state, world, pos, newState, p_beforeReplacingBlock_5_);
    }

}
