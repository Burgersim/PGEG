package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;

public class AddSlabs implements BlockAdder, ItemAdder {
    Block OAK_BARK_SLAB = new BlockSlab(Block.Builder.create(Material.WOOD, MapColor.WOOD).hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD));
    Block SPRUCE_BARK_SLAB = new BlockSlab(Block.Builder.create(Material.WOOD, MapColor.WOOD).hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD));
    Block BIRCH_BARK_SLAB = new BlockSlab(Block.Builder.create(Material.WOOD, MapColor.WOOD).hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD));
    Block JUNGLE_BARK_SLAB = new BlockSlab(Block.Builder.create(Material.WOOD, MapColor.WOOD).hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD));
    Block ACACIA_BARK_SLAB = new BlockSlab(Block.Builder.create(Material.WOOD, MapColor.WOOD).hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD));
    Block DARK_OAK_BARK_SLAB = new BlockSlab(Block.Builder.create(Material.WOOD, MapColor.WOOD).hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD));

    @Override
    public void registerBlocks() {
        Block.registerBlock(new ResourceLocation("pgeg:oak_bark_slab"), OAK_BARK_SLAB);
        Block.registerBlock(new ResourceLocation("pgeg:spruce_bark_slab"), SPRUCE_BARK_SLAB);
        Block.registerBlock(new ResourceLocation("pgeg:birch_bark_slab"), BIRCH_BARK_SLAB);
        Block.registerBlock(new ResourceLocation("pgeg:jungle_bark_slab"), JUNGLE_BARK_SLAB);
        Block.registerBlock(new ResourceLocation("pgeg:acacia_bark_slab"), ACACIA_BARK_SLAB);
        Block.registerBlock(new ResourceLocation("pgeg:dark_oak_bark_slab"), DARK_OAK_BARK_SLAB);
    }

    @Override
    public void registerItems() {
        Item.registerItemBlock(OAK_BARK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(SPRUCE_BARK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(BIRCH_BARK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(JUNGLE_BARK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(ACACIA_BARK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(DARK_OAK_BARK_SLAB, ItemGroup.BUILDING_BLOCKS);
    }
}