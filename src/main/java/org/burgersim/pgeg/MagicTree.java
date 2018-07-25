package org.burgersim.pgeg;

import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;

public class MagicTree implements BlockAdder, ItemAdder {
    Block MAGIC_OAK_LOG = new BlockLog(MapColor.COLORS[0x46567c], Block.Builder.create(Material.WOOD));
    Block MAGIC_OAK_PLANKS = new Block(Block.Builder.create(Material.WOOD, MapColor.COLORS[0x55668f]));
    Block MAGIC_OAK_LEAVES = new BlockLeaves(Block.Builder.create(Material.LEAVES, MapColor.COLORS[0xecc67a]));
    Block MAGIC_DOOR = new BlockDoor(Block.Builder.create(Material.WOOD, MapColor.COLORS[0x55668f]));

    @Override
    public void registerBlocks() {
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_log"), MAGIC_OAK_LOG);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_planks"), MAGIC_OAK_PLANKS);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_leaves"), MAGIC_OAK_LEAVES);
        Block.registerBlock(new ResourceLocation("pgeg:magic_door"), MAGIC_DOOR);

    }

    @Override
    public void registerItems() {
        Item.registerItemBlock(MAGIC_OAK_LOG, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LEAVES, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MAGIC_OAK_PLANKS, ItemGroup.BUILDING_BLOCKS);
    }
}
