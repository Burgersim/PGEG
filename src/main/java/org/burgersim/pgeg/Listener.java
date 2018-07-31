package org.burgersim.pgeg;

import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;
import net.minecraft.block.Block.Builder;
import org.burgersim.pgeg.BlockModStair;

public class Listener implements BlockAdder, ItemAdder {
    ManaGrass MANA_GRASS = new ManaGrass();
    MagicOakLog MAGIC_OAK_LOG = new MagicOakLog();
    MagicOakPlanks MAGIC_OAK_PLANKS = new MagicOakPlanks();
    MagicOakLeaves MAGIC_OAK_LEAVES = new MagicOakLeaves();
    ManaCrystalOre MANA_CRYSTAL_ORE = new ManaCrystalOre();
//    MagicOakSapling MAGIC_OAK_SAPLING = new MagicOakSapling();

    public static BlockModStair MAGIC_OAK_STAIRS;
    public static BlockModTrapDoor MAGIC_OAK_TRAPDOOR;
    public static BlockModDoor MAGIC_OAK_DOOR;
    public static BlockModPressurePlate MAGIC_OAK_PRESSURE_PLATE;
    public static BlockModFence MAGIC_OAK_FENCE;
    public static BlockModFenceGate MAGIC_OAK_FENCE_GATE;
    public static BlockModButtonWood MAGIC_OAK_BUTTON;
    public static BlockModSlab MAGIC_OAK_SLAB;


    Item MANA_CRYSTAL_DUST = new Item(new Item.Builder().group(ItemGroup.MISC));

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
        Item.registerItemBlock(MAGIC_OAK_SLAB, ItemGroup.BUILDING_BLOCKS);

        Item.registerItem("pgeg:mana_crystal_dust", MANA_CRYSTAL_DUST);
    }
}
