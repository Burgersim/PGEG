package org.burgersim.pgeg.listener;

import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.block.*;
import org.burgersim.pgeg.block.base.*;
import org.burgersim.pgeg.block.flower.BlockBloodrose;
import org.burgersim.pgeg.block.flower.BlockGlowshroom;
import org.burgersim.pgeg.block.flower.BlockSnowbell;
import org.burgersim.pgeg.block.tree.MagicOakTree;
import org.burgersim.pgeg.item.*;

import static net.minecraft.init.Blocks.DIAMOND_BLOCK;
import static net.minecraft.init.Blocks.DIAMOND_ORE;
import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegRegistry {

    /*Magic Items*/

    public final static Item MANA_CRYSTAL_DUST = new ItemManaDust(new Item.Builder().group(ItemGroup.MISC));
    public final static Item MANA_CAKE = new ManaFood(1, 0.2F, 20.0F, false
            , new Item.Builder().group(ItemGroup.FOOD));
    public final static Item WAND = new ItemWand();
    public final static Item SPELL_BOOK = new ItemSpellBook();
    public final static Item RUNE_LEXICON = new ItemRuneLexicon(new Item.Builder().maxStackSize(1).group(ItemGroup.MISC));
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

    /*Tools*/
    public final static Item ORICHALCUM_PICKAXE = new ItemModPickaxe(ModTiers.ORICHALCUM, 1, -2.8F, new Item.Builder().group(ItemGroup.TOOLS));

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
    public final static Block ORICHALCUM_BLOCK = new Block(Block.Builder.create(Material.IRON, MapColor.PURPLE).hardnessAndResistance(2.0F, 2.0F));
    public final static Block SATURNIUM_BLOCK = new Block(Block.Builder.create(Material.ROCK, MapColor.OBSIDIAN).hardnessAndResistance(5.0F, 5.0F));
    public final static Block BRIMSTONE_BLOCK = new Block(Block.Builder.create(Material.ROCK, MapColor.NETHERRACK).hardnessAndResistance(4.0F, 4.0F));
    public final static Block METEORITE_BLOCK = new Block(Block.Builder.create(Material.ROCK, MapColor.OBSIDIAN).hardnessAndResistance(6.0F, 6.0F));
    public final static Block MITHRIL_BLOCK = new Block(Block.Builder.from(DIAMOND_BLOCK).sound(SoundType.METAL));

    public final static Block QUARTZ_PILLAR = new BlockQuartzStand();
    public final static Block SPELL_CAULDRON = new BlockSpellCauldron(Block.Builder.from(Blocks.CAULDRON).needsRandomTick());
    public final static Block MANA_FERN = new BlockModTallGrass(Block.Builder.from(Blocks.FERN));
    public final static Block MANA_TALLGRASS = new BlockModTallGrass(Block.Builder.from(Blocks.TALL_GRASS));
    public final static Block MANA_DUST_WIRE = new BlockManaDustWire(Block.Builder.from(Blocks.REDSTONE_WIRE));

    public final static Block GLOWSHROOM = new BlockGlowshroom(Block.Builder.from(Blocks.BROWN_MUSHROOM));
    public final static Block SNOWBELL = new BlockSnowbell(Block.Builder.from(Blocks.POPPY));
    public final static Block BLOODROSE = new BlockBloodrose(Block.Builder.from(Blocks.POPPY));

    public final static Block RUNE_PEDESTAL = new BlockRunePedestal(Block.Builder.from(Blocks.QUARTZ_SLAB).doesNotBlockMovement(), 2);
}