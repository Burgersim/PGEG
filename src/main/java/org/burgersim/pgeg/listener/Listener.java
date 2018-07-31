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
    public static ManaGrass MANA_GRASS = new ManaGrass();
    public static MagicOakLog MAGIC_OAK_LOG = new MagicOakLog();
    MagicOakPlanks MAGIC_OAK_PLANKS = new MagicOakPlanks();
    public static MagicOakLeaves MAGIC_OAK_LEAVES = new MagicOakLeaves();
    public static ManaCrystalOre MANA_CRYSTAL_ORE = new ManaCrystalOre();
    public static BlockModSapling MAGIC_OAK_SAPLING = new BlockModSapling(new MagicOakTree(),
            BlockSapling.Builder.create(Material.PLANTS, MapColor.LIGHT_BLUE).needsRandomTick());

    BlockModStair MAGIC_OAK_STAIRS = new BlockModStair(MAGIC_OAK_PLANKS, BlockStairs.Builder.create(MAGIC_OAK_PLANKS));
    BlockModTrapDoor MAGIC_OAK_TRAPDOOR = new BlockModTrapDoor(BlockTrapDoor.Builder.create(MAGIC_OAK_PLANKS));
    BlockModDoor MAGIC_OAK_DOOR = new BlockModDoor(BlockDoor.Builder.create(MAGIC_OAK_PLANKS));
    BlockModPressurePlate MAGIC_OAK_PRESSURE_PLATE = new BlockModPressurePlate(BlockPressurePlate.Sensitivity.EVERYTHING,
            BlockPressurePlate.Builder.create(MAGIC_OAK_PLANKS));
    BlockModFence MAGIC_OAK_FENCE = new BlockModFence(BlockFence.Builder.create(MAGIC_OAK_PLANKS));
    BlockModFenceGate MAGIC_OAK_FENCE_GATE = new BlockModFenceGate(BlockFenceGate.Builder.create(MAGIC_OAK_PLANKS));
    BlockModButtonWood MAGIC_OAK_BUTTON = new BlockModButtonWood(BlockButtonWood.Builder.create(MAGIC_OAK_PLANKS));
    BlockModSlab MAGIC_OAK_SLAB = new BlockModSlab(BlockSlab.Builder.create(MAGIC_OAK_PLANKS));


    Item MANA_CRYSTAL_DUST = new Item(new Item.Builder().group(ItemGroup.MISC));

    MagicForestBiome MAGIC_FOREST_BIOME = new MagicForestBiome();

    @Override
    public void registerBlocks() {
        Block.registerBlock(new ResourceLocation("pgeg:mana_grass_block"), MANA_GRASS);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_log"), MAGIC_OAK_LOG);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_planks"), MAGIC_OAK_PLANKS);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_leaves"), MAGIC_OAK_LEAVES);
        Block.registerBlock(new ResourceLocation("pgeg:mana_crystal_ore"), MANA_CRYSTAL_ORE);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_stairs"), MAGIC_OAK_STAIRS);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_trapdoor"), MAGIC_OAK_TRAPDOOR);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_door"), MAGIC_OAK_DOOR);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_pressure_plate"), MAGIC_OAK_PRESSURE_PLATE);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_fence"), MAGIC_OAK_FENCE);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_fence_gate"), MAGIC_OAK_FENCE_GATE);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_button"), MAGIC_OAK_BUTTON);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_slab"), MAGIC_OAK_SLAB);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_sapling"), MAGIC_OAK_SAPLING);


    }

    @Override
    public void registerItems() {
        Item.registerItemBlock(MANA_GRASS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LOG, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_PLANKS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LEAVES, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MANA_CRYSTAL_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_TRAPDOOR, ItemGroup.REDSTONE);
        Item.registerItemBlock(MAGIC_OAK_DOOR, ItemGroup.REDSTONE);
        Item.registerItemBlock(MAGIC_OAK_PRESSURE_PLATE, ItemGroup.REDSTONE);
        Item.registerItemBlock(MAGIC_OAK_FENCE, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MAGIC_OAK_FENCE_GATE, ItemGroup.REDSTONE);
        Item.registerItemBlock(MAGIC_OAK_BUTTON, ItemGroup.REDSTONE);
        Item.registerItemBlock(MAGIC_OAK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_SAPLING, ItemGroup.DECORATIONS);

        Item.registerItem("pgeg:mana_crystal_dust", MANA_CRYSTAL_DUST);
    }

    @Override
    public void registerBiomes() {
        Biome.registerBiome(Biome.REGISTRY.getKeys().size() + 1, "magic_forest", MAGIC_FOREST_BIOME);
    }

    @Override
    public Collection<Biome> getOverworldBiomes() {
        return Arrays.asList(MAGIC_FOREST_BIOME);
    }
}
