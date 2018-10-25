package org.burgersim.pgeg.listener;

import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import org.burgersim.pgeg.block.*;
import org.burgersim.pgeg.block.base.*;
import org.burgersim.pgeg.block.flower.BlockBloodrose;
import org.burgersim.pgeg.block.flower.BlockGlowshroom;
import org.burgersim.pgeg.block.flower.BlockSnowbell;
import org.burgersim.pgeg.block.tree.MagicOakTree;
import org.burgersim.pgeg.item.*;
import org.dimdev.rift.util.ItemTierImpl;

import static net.minecraft.block.material.Material.IRON;
import static net.minecraft.init.Blocks.*;

public class PgegRegistry {

    /*Magic Items*/

    public final static Item MANA_CRYSTAL_DUST = new ItemManaDust(new Item.Builder().group(ItemGroup.MISC));
    public final static Item MANA_CAKE = new ManaFood(1, 0.2F, 20.0F, false
            , new Item.Builder().group(ItemGroup.FOOD));
    public final static Item WAND = new ItemWand();
    public final static Item COMPENDIUM = new ItemCompendium(new Item.Builder().maxStackSize(1).group(ItemGroup.MISC).rarity(EnumRarity.EPIC));
    /*Food Items*/
    public final static Item BROWNIE = new ItemFood(2, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item BURRITO_BEEF = new ItemFood(12, 2, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item BURRITO_FISH = new ItemFood(10, 2, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item BURRITO_VEGGIE = new ItemFood(6, 1.6F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item CARAMEL = new ItemFood(1, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item CARAMEL_APPLE = new ItemFood(5, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item COOKIE_CAT = new ItemFood(4, 0.4F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item CREAM_COOKIE = new ItemFood(3, 0.3F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item CARAMEL_DONUT = new ItemFood(3, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item SUGAR_DONUT = new ItemFood(2, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item CHEESE = new ItemFood(2, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item CHEESE_FRIES = new ItemFood(7, 1.7F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item BERRY_JELLY = new ItemFood(3, 0.3F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item LION_LICKER = new ItemFood(2, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item BERRY = new ItemFood(1, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item NIGIRI_COD = new ItemFood(5, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item NIGIRI_SALMON = new ItemFood(5, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item NIGIRI_SQUID = new ItemFood(5, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item ONIGIRI = new ItemFood(3, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item APPLE_PIE = new ItemFood(8, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item BERRY_PIE = new ItemFood(4, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item CHOCOLATE_PIE = new ItemFood(8, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD));
    /*add bounce/fall resistance chance 20-30%*/


    public final static Item SQUID_RAW = new ItemFood(2, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item SQUID_COOKED = new ItemFood(6, 1.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item TOMATO = new ItemFood(2, 6.0F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item DOUGH = new ItemFood(2, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item NIGIRI_TROPICAL = new ItemFood(5, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));
    public final static Item ROLL_SEA_PICKLE = new ItemFood(5, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));


    public final static Block TOMATO_CROP = new BlockTomato(Block.Builder.from(Blocks.CARROTS));
    public final static Block RICE_CROP = new BlockRice(Block.Builder.from(Blocks.CARROTS));

    public final static Item TOMATO_SEEDS = new ItemSeeds(PgegRegistry.TOMATO_CROP, new Item.Builder().group(ItemGroup.MATERIALS));
    public final static Item RICE = new ItemRice(2, 0.8F, PgegRegistry.RICE_CROP, new Item.Builder().group(ItemGroup.MATERIALS));

    /*Other Items*/
    public final static Item PLANT_TREAT = new ItemBoneMeal(EnumDyeColor.BROWN, new Item.Builder().group(ItemGroup.MATERIALS));

    /*Ingots*/
    public final static Item ORICHALCUM_INGOT = new Item(new Item.Builder().group(ItemGroup.MATERIALS));
    public final static Item SATURNIUM_INGOT = new Item(new Item.Builder().group(ItemGroup.MATERIALS));
    public final static Item BRIMSTONE_INGOT = new Item(new Item.Builder().group(ItemGroup.MATERIALS));
    public final static Item METEORITE_INGOT = new Item(new Item.Builder().group(ItemGroup.MATERIALS));
    public final static Item MITHRIL_INGOT = new Item(new Item.Builder().group(ItemGroup.MATERIALS));

    /*Item Tiers*/
    public final static IItemTier ORICHALCUM = new ItemTierImpl(3, 1561, 8.0F, 3.0F, 10, () -> Ingredient.fromItems(PgegRegistry.ORICHALCUM_INGOT));
    public final static IItemTier SATURNIUM = new ItemTierImpl(5, 1561, 8.0F, 3.0F, 10, () -> Ingredient.fromItems(PgegRegistry.SATURNIUM_INGOT));
    public final static IItemTier BRIMSTONE = new ItemTierImpl(4, 1561, 8.0F, 3.0F, 10, () -> Ingredient.fromItems(PgegRegistry.BRIMSTONE_INGOT));
    public final static IItemTier METEORITE = new ItemTierImpl(6, 1561, 8.0F, 3.0F, 10, () -> Ingredient.fromItems(PgegRegistry.METEORITE_INGOT));
    public final static IItemTier MITHRIL = new ItemTierImpl(4, 1561, 8.0F, 3.0F, 10, () -> Ingredient.fromItems(PgegRegistry.MITHRIL_INGOT));


    /*Tools*/
    public final static Item ORICHALCUM_PICKAXE = new ItemModPickaxe(ORICHALCUM, 1, -2.8F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item SATURNIUM_PICKAXE = new SaturniumPickaxe(SATURNIUM, 1, -2.8F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item BRIMSTONE_PICKAXE = new ItemModPickaxe(BRIMSTONE, 1, -2.8F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item METEORITE_PICKAXE = new ItemModPickaxe(METEORITE, 1, -2.8F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item MITHRIL_PICKAXE = new ItemModPickaxe(MITHRIL, 1, -2.8F, new Item.Builder().group(ItemGroup.TOOLS));

    public final static Item ORICHALCUM_SHOVEL = new ItemModShovel(ORICHALCUM, 1.5f, -3F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item SATURNIUM_SHOVEL = new SaturniumShovel(SATURNIUM, 1.5f, -3F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item BRIMSTONE_SHOVEL = new ItemModShovel(BRIMSTONE, 1.5f, -3F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item METEORITE_SHOVEL = new ItemModShovel(METEORITE, 1.5f, -3F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item MITHRIL_SHOVEL = new ItemModShovel(MITHRIL, 1.5f, -3F, new Item.Builder().group(ItemGroup.TOOLS));

    public final static Item ORICHALCUM_HOE = new ItemModHoe(ORICHALCUM, 0f, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item SATURNIUM_HOE = new SaturniumHoe(SATURNIUM, 2f, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item BRIMSTONE_HOE = new ItemModHoe(BRIMSTONE, 1f, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item METEORITE_HOE = new ItemModHoe(METEORITE, 3f, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item MITHRIL_HOE = new ItemModHoe(MITHRIL, 1f, new Item.Builder().group(ItemGroup.TOOLS));

    public final static Item ORICHALCUM_AXE = new ItemModAxe(ORICHALCUM, 5.0f, -3F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item SATURNIUM_AXE = new SaturniumAxe(SATURNIUM, 6.0f, -3F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item BRIMSTONE_AXE = new ItemModAxe(BRIMSTONE, 5.5f, -3F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item METEORITE_AXE = new ItemModAxe(METEORITE, 6.5f, -3F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item MITHRIL_AXE = new ItemModAxe(MITHRIL, 5.5f, -3F, new Item.Builder().group(ItemGroup.TOOLS));

    public final static Item ORICHALCUM_SHEARS = new ItemModShears(new Item.Builder().maxDamage(357).group(ItemGroup.TOOLS));
    public final static Item SATURNIUM_SHEARS = new SaturniumShears(new Item.Builder().maxDamage(595).group(ItemGroup.TOOLS));
    public final static Item BRIMSTONE_SHEARS = new ItemModShears(new Item.Builder().maxDamage(476).group(ItemGroup.TOOLS));
    public final static Item METEORITE_SHEARS = new ItemModShears(new Item.Builder().maxDamage(714).group(ItemGroup.TOOLS));
    public final static Item MITHRIL_SHEARS = new ItemModShears(new Item.Builder().maxDamage(595).group(ItemGroup.TOOLS));

    public final static Item ORICHALCUM_SWORD = new ItemModSword(ORICHALCUM, 3, -2.4F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item SATURNIUM_SWORD = new SaturniumSword(SATURNIUM, 3, -2.4F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item BRIMSTONE_SWORD = new ItemModSword(BRIMSTONE, 3, -2.4F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item METEORITE_SWORD = new ItemModSword(METEORITE, 3, -2.4F, new Item.Builder().group(ItemGroup.TOOLS));
    public final static Item MITHRIL_SWORD = new ItemModSword(MITHRIL, 3, -2.4F, new Item.Builder().group(ItemGroup.TOOLS));

    /*Blocks*/
    public final static Block MANA_GRASS = new BlockGrass(Block.Builder.create(Material.GRASS, MapColor.LIGHT_BLUE)
            .hardnessAndResistance(0.6f, 1).sound(SoundType.GROUND).needsRandomTick());
    public final static Block MAGIC_OAK_LOG = new BlockLog(MapColor.BLUE, Block.Builder.create(Material.WOOD, MapColor.BLUE)
            .hardnessAndResistance(2.0F, 2.0F)
            .sound(SoundType.WOOD));
    public final static Block MAGIC_OAK_PLANKS = new Block(Block.Builder.create(Material.WOOD, MapColor.LIGHT_BLUE)
            .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD));

    public final static Block MAGIC_OAK_SAPLING = new BlockModSapling(new MagicOakTree(),
            Block.Builder.create(Material.PLANTS, MapColor.LIGHT_BLUE).needsRandomTick());
    public final static Block MAGIC_OAK_LEAVES = new BlockModLeaves(Block.Builder.create(Material.LEAVES, MapColor.GOLD)
            .hardnessAndResistance(0.2f, 0.2f).sound(SoundType.PLANT)
            , MAGIC_OAK_SAPLING);
    public final static Block MAGIC_OAK_STAIRS = new BlockModStair(MAGIC_OAK_PLANKS, Block.Builder.from(MAGIC_OAK_PLANKS));
    public final static Block MAGIC_OAK_TRAPDOOR = new BlockModTrapDoor(Block.Builder.from(MAGIC_OAK_PLANKS));
    public final static Block MAGIC_OAK_DOOR = new BlockModDoor(Block.Builder.from(MAGIC_OAK_PLANKS));
    public final static Block MAGIC_OAK_PRESSURE_PLATE = new BlockModPressurePlate(BlockPressurePlate.Sensitivity.EVERYTHING,
            Block.Builder.from(MAGIC_OAK_PLANKS));
    public final static Block MAGIC_OAK_FENCE = new BlockModFence(Block.Builder.from(MAGIC_OAK_PLANKS));
    public final static Block MAGIC_OAK_FENCE_GATE = new BlockModFenceGate(Block.Builder.from(MAGIC_OAK_PLANKS));
    public final static Block MAGIC_OAK_BUTTON = new BlockModButtonWood(Block.Builder.from(MAGIC_OAK_PLANKS));
    public final static Block MAGIC_OAK_SLAB = new BlockSlab(Block.Builder.from(MAGIC_OAK_PLANKS));

    /*Ores*/
    public final static Block MANA_CRYSTAL_ORE = new BlockModOre(Block.Builder.create(Material.ROCK, MapColor.STONE)
            .hardnessAndResistance(3.0f, 15F)
            .sound(SoundType.STONE), PgegRegistry.MANA_CRYSTAL_DUST, 3, 7);
    public final static Block ORICHALCUM_ORE = new BlockOre(Block.Builder.from(DIAMOND_ORE));
    public final static Block SATURNIUM_ORE = new BlockOre(Block.Builder.from(DIAMOND_ORE)
            .hardnessAndResistance(5.0F, 5.0F));
    public final static Block BRIMSTONE_ORE = new BlockOre(Block.Builder.from(DIAMOND_ORE)
            .hardnessAndResistance(4.0F, 4.0F));
    public final static Block MITHRIL_ORE = new BlockOre(Block.Builder.from(DIAMOND_ORE)
            .hardnessAndResistance(4.0F, 4.0F));
    public final static Block METEORITE_ORE = new BlockOre(Block.Builder.from(DIAMOND_ORE)
            .hardnessAndResistance(6.0F, 6.0F));

    /*OreBlocks*/
    public final static Block MANA_DUST_BLOCK = new Block(Block.Builder.create(Material.SAND, MapColor.LIGHT_BLUE).hardnessAndResistance(0.5F, 0.5F));
    public final static Block ORICHALCUM_BLOCK = new Block(Block.Builder.create(IRON, MapColor.PURPLE).hardnessAndResistance(2.0F, 2.0F));
    public final static Block SATURNIUM_BLOCK = new Block(Block.Builder.create(Material.ROCK, MapColor.OBSIDIAN).hardnessAndResistance(5.0F, 5.0F));
    public final static Block BRIMSTONE_BLOCK = new Block(Block.Builder.create(Material.ROCK, MapColor.NETHERRACK).hardnessAndResistance(4.0F, 4.0F));
    public final static Block METEORITE_BLOCK = new Block(Block.Builder.create(Material.ROCK, MapColor.OBSIDIAN).hardnessAndResistance(6.0F, 6.0F));
    public final static Block MITHRIL_BLOCK = new Block(Block.Builder.from(DIAMOND_BLOCK).sound(SoundType.METAL));

    public final static Block QUARTZ_PILLAR = new BlockQuartzStand();
    public final static Block SPELL_CAULDRON = new BlockSpellCauldron(Block.Builder.from(Blocks.CAULDRON).needsRandomTick());
    public final static Block MANA_FERN = new BlockModTallGrass(Block.Builder.from(Blocks.FERN));
    public final static Block MANA_TALLGRASS = new BlockModTallGrass(Block.Builder.from(Blocks.TALL_GRASS));
    public final static Block MANA_DUST_WIRE = new BlockManaDustWire(Block.Builder.from(Blocks.REDSTONE_WIRE));

    public final static Block GLOWSHROOM = new BlockGlowshroom(FLOWER_POT ,Block.Builder.create(Material.CIRCUITS).zeroHardnessAndResistance());
    public final static Block SNOWBELL = new BlockSnowbell(FLOWER_POT ,Block.Builder.create(Material.CIRCUITS).zeroHardnessAndResistance());
    public final static Block BLOODROSE = new BlockBloodrose(FLOWER_POT ,Block.Builder.create(Material.CIRCUITS).zeroHardnessAndResistance());

    public final static Block RUNE_PEDESTAL_STONE = new BlockRunePedestal(Block.Builder.from(Blocks.STONE_SLAB).doesNotBlockMovement(), 1);
    public final static Block RUNE_PEDESTAL_QUARTZ = new BlockRunePedestal(Block.Builder.from(Blocks.QUARTZ_SLAB).doesNotBlockMovement(), 2);
    public final static Block RUNE_PEDESTAL_PURPUR = new BlockRunePedestal(Block.Builder.from(Blocks.PURPUR_SLAB).doesNotBlockMovement(), 3);
}