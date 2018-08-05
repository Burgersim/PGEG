package org.burgersim.pgeg.listener;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.item.ItemSpellBook;
import org.burgersim.pgeg.item.ItemWand;
import org.burgersim.pgeg.item.ManaDebugItem;
import org.burgersim.pgeg.item.ManaFood;
import org.dimdev.rift.listener.ItemAdder;

import static org.burgersim.pgeg.listener.PgegBlocks.*;
import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegItems implements ItemAdder {
    public static Item MANA_CRYSTAL_DUST = new Item(new Item.Builder().group(ItemGroup.MISC));
    public static Item MANA_CAKE = new ManaFood(1,0.2F, 20.0F , false
            ,new Item.Builder().group(ItemGroup.FOOD));
    public static Item WAND = new ItemWand();
    public static Item SPELL_BOOK = new ItemSpellBook();
    private static Item MANA_DEBUG = new ManaDebugItem();

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
        Item.registerItemBlock(QUARTZ_PILLAR, ItemGroup.DECORATIONS);

        Item.registerItem(new ResourceLocation(MOD_ID, "mana_crystal_dust"), MANA_CRYSTAL_DUST);
        Item.registerItem(new ResourceLocation(MOD_ID, "mana_cake"), MANA_CAKE);
        Item.registerItem(new ResourceLocation(MOD_ID, "wand"), WAND);
        Item.registerItem(new ResourceLocation(MOD_ID, "spell_book"), SPELL_BOOK);
        Item.registerItem(new ResourceLocation(MOD_ID, "mana_debug"), MANA_DEBUG);
    }
}
