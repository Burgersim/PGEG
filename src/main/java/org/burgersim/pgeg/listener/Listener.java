package org.burgersim.pgeg.listener;

import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import org.burgersim.pgeg.biome.MagicForestBiome;
import org.burgersim.pgeg.block.*;
import org.burgersim.pgeg.block.tree.MagicOakTree;
import org.dimdev.rift.listener.BiomeAdder;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;

import java.util.Arrays;
import java.util.Collection;

public class Listener implements BlockAdder, ItemAdder, BiomeAdder {
    public static final String MOD_ID = "pgeg";

    public static Item MANA_CRYSTAL_DUST = new Item(new Item.Builder().group(ItemGroup.MISC));

    public static Block MANA_GRASS = new BlockModGrass(BlockGrass.Builder.create(Material.GRASS, MapColor.LIGHT_BLUE)
            .hardnessAndResistance(0.6f,1).soundType(SoundType.GROUND));
    public static Block MAGIC_OAK_LOG = new BockModLog(BlockLog.Builder.create(Material.WOOD, MapColor.BLUE)
            .hardnessAndResistance(2.0F, 2.0F)
            .soundType(SoundType.WOOD), MapColor.BLUE);
    public static Block MAGIC_OAK_PLANKS = new BlockModPlanks(Block.Builder.create(Material.WOOD, MapColor.LIGHT_BLUE)
            .hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD));

    public static Block MAGIC_OAK_SAPLING = new BlockModSapling(new MagicOakTree(),
            BlockSapling.Builder.create(Material.PLANTS, MapColor.LIGHT_BLUE).needsRandomTick());
    public static Block MAGIC_OAK_LEAVES = new BlockModLeaves(BlockLeaves.Builder.create(Material.LEAVES, MapColor.GOLD)
            .hardnessAndResistance(0.2f, 0.2f).soundType(SoundType.PLANT)
            , MAGIC_OAK_SAPLING);
    public static Block MAGIC_OAK_STAIRS = new BlockModStair(MAGIC_OAK_PLANKS, BlockStairs.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_TRAPDOOR = new BlockModTrapDoor(BlockTrapDoor.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_DOOR = new BlockModDoor(BlockDoor.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_PRESSURE_PLATE = new BlockModPressurePlate(BlockPressurePlate.Sensitivity.EVERYTHING,
            BlockPressurePlate.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_FENCE = new BlockModFence(BlockFence.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_FENCE_GATE = new BlockModFenceGate(BlockFenceGate.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_BUTTON = new BlockModButtonWood(BlockButtonWood.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_SLAB = new BlockModSlab(BlockSlab.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MANA_CRYSTAL_ORE = new BlockModOre(BlockOre.Builder.create(Material.ROCK, MapColor.STONE)
            .hardnessAndResistance(3.0f,4)
            .soundType(SoundType.STONE), MANA_CRYSTAL_DUST, 3, 7);

    public static Biome MAGIC_FOREST_BIOME = new MagicForestBiome();

    @Override
    public void registerBlocks() {
        Block.registerBlock(new ResourceLocation(MOD_ID, "mana_grass_block"), MANA_GRASS);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_log"), MAGIC_OAK_LOG);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_planks"), MAGIC_OAK_PLANKS);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_leaves"), MAGIC_OAK_LEAVES);
        Block.registerBlock(new ResourceLocation(MOD_ID, "mana_crystal_ore"), MANA_CRYSTAL_ORE);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_stairs"), MAGIC_OAK_STAIRS);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_trapdoor"), MAGIC_OAK_TRAPDOOR);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_door"), MAGIC_OAK_DOOR);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_pressure_plate"), MAGIC_OAK_PRESSURE_PLATE);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_fence"), MAGIC_OAK_FENCE);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_fence_gate"), MAGIC_OAK_FENCE_GATE);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_button"), MAGIC_OAK_BUTTON);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_slab"), MAGIC_OAK_SLAB);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_sapling"), MAGIC_OAK_SAPLING);


    }

    @Override
    public void registerItems() {
        Item.registerItemBlock(MANA_GRASS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LOG, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_PLANKS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LEAVES, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MANA_CRYSTAL_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_STAIRS, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MAGIC_OAK_TRAPDOOR, ItemGroup.REDSTONE);
        Item.registerItemBlock(MAGIC_OAK_DOOR, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MAGIC_OAK_PRESSURE_PLATE, ItemGroup.REDSTONE);
        Item.registerItemBlock(MAGIC_OAK_FENCE, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MAGIC_OAK_FENCE_GATE, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MAGIC_OAK_BUTTON, ItemGroup.REDSTONE);
        Item.registerItemBlock(MAGIC_OAK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_SAPLING, ItemGroup.DECORATIONS);

        Item.registerItem(new ResourceLocation(MOD_ID, "mana_crystal_dust"), MANA_CRYSTAL_DUST);
    }

    @Override
    public void registerBiomes() {
        Biome.registerBiome(Biome.REGISTRY.getKeys().size() + 1,
                MOD_ID + ":magic_forest",
                MAGIC_FOREST_BIOME);
    }

    @Override
    public Collection<Biome> getOverworldBiomes() {
        return Arrays.asList(MAGIC_FOREST_BIOME);
    }
}
