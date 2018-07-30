package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;

public class Listener implements BlockAdder, ItemAdder {
    ManaGrass MANA_GRASS= new ManaGrass();
    MagicOakLog MAGIC_OAK_LOG = new MagicOakLog();
    MagicOakPlanks MAGIC_OAK_PLANKS = new MagicOakPlanks();
    MagicOakLeaves MAGIC_OAK_LEAVES = new MagicOakLeaves();
    ManaCrystalOre MANA_CRYSTAL_ORE = new ManaCrystalOre(){};

    Item MANA_CRYSTAL_DUST = new Item(new Item.Builder().group(ItemGroup.MISC));

    @Override
    public void registerBlocks() {
        Block.registerBlock(new ResourceLocation("pgeg:mana_grass_block"), MANA_GRASS);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_log"), MAGIC_OAK_LOG);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_planks"), MAGIC_OAK_PLANKS);
        Block.registerBlock(new ResourceLocation("pgeg:magic_oak_leaves"), MAGIC_OAK_LEAVES);
        Block.registerBlock(new ResourceLocation("pgeg:mana_crystal_ore"), MANA_CRYSTAL_ORE);

    }

    @Override
    public void registerItems() {
        Item.registerItemBlock(MANA_GRASS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LOG, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_PLANKS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LEAVES, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MANA_CRYSTAL_ORE, ItemGroup.BUILDING_BLOCKS);


        Item.registerItem("pgeg:mana_crystal_dust", MANA_CRYSTAL_DUST);
    }
}
