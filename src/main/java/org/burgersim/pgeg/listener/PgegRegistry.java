package org.burgersim.pgeg.listener;

import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import org.burgersim.pgeg.block.*;
import org.burgersim.pgeg.block.tree.MagicOakTree;
import org.burgersim.pgeg.item.ItemSpellBook;
import org.burgersim.pgeg.item.ItemWand;
import org.burgersim.pgeg.item.ManaDebugItem;
import org.burgersim.pgeg.item.ManaFood;
import org.burgersim.pgeg.recipe.ModRecipes;

public class PgegRegistry  {

        /*Magic Items*/

        public static Item MANA_CRYSTAL_DUST = new Item(new Item.Builder().group(ItemGroup.MISC));
        public static Item MANA_CAKE = new ManaFood(1,0.2F, 20.0F , false
                ,new Item.Builder().group(ItemGroup.FOOD));
        public static Item WAND = new ItemWand(1);
        public static Item SPELL_BOOK = new ItemSpellBook();
        public static Item MANA_DEBUG = new ManaDebugItem();
        public static final ModRecipes recipes = new ModRecipes();

        /*Food Items*/
        public static Item BROWNIE = new ItemFood(2,0.2F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item BURRITO_BEEF = new ItemFood(12,2,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item BURRITO_FISH = new ItemFood(10,2,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item BURRITO_VEGGIE = new ItemFood(6, 1.6F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item CARAMEL = new ItemFood(1,0.2F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item CARAMEL_APPLE = new ItemFood(5,0.6F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item COOKIE_CAT = new ItemFood(4,0.4F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item CREAM_COOKIE = new ItemFood(3, 0.3F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item CARAMEL_DONUT = new ItemFood(3, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item SUGAR_DONUT = new ItemFood(2, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item CHEESE = new ItemFood(2,0.6F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item CHEESE_FRIES = new ItemFood(7, 1.7F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item BERRY_JELLY = new ItemFood(3, 0.3F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item LION_LICKER = new ItemFood(2, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item BERRY = new ItemFood(1,0.2F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item NIGIRI_COD = new ItemFood(5, 1.0F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item NIGIRI_SALMON = new ItemFood(5,1.0F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item NIGIRI_SQUID = new ItemFood(5, 1.0F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item ONIGIRI = new ItemFood(3, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item APPLE_PIE = new ItemFood(8, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item BERRY_PIE = new ItemFood(4,0.6F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item CHOCOLATE_PIE = new ItemFood(8, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD));
        /*add bounce/fall resistance chance 20-30%*/
        public static Item SLIME_PIE = new ItemFood(4,0.6F,false,new Item.Builder().group(ItemGroup.FOOD));

        public static Item SQUID_RAW = new ItemFood(2, 0.2F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item SQUID_COOKED = new ItemFood(6, 1.2F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item TOMATO = new ItemFood(2, 6.0F,false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item RICE = new ItemFood(2, 0.8F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item DOUGH = new ItemFood(2, 0.2F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item NIGIRI_TROPICAL = new ItemFood(5, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));
        public static Item ROLL_SEA_PICKLE = new ItemFood(5, 1.0F, false, new Item.Builder().group(ItemGroup.FOOD));


        public static Block TOMATO_CROP = new BlockTomato(BlockCrops.Builder.create(Material.GRASS).doesNotBlockMovement().needsRandomTick());
        public static Block RICE_CROP = new BlockRice(BlockCrops.Builder.create(Material.GRASS).doesNotBlockMovement().needsRandomTick());

        public static Item TOMATO_SEEDS = new ItemSeeds(PgegRegistry.TOMATO_CROP, new Item.Builder().group(ItemGroup.MATERIALS));
        public static Item RICE_SEEDS = new ItemSeeds(PgegRegistry.RICE_CROP, new Item.Builder().group(ItemGroup.MATERIALS));


        /*Other Items*/
        public static Item PLANT_TREAT = new ItemBoneMeal(EnumDyeColor.BROWN, new Item.Builder().group(ItemGroup.MATERIALS));


        /*Blocks*/
        public static Block MANA_GRASS = new BlockModGrass(BlockGrass.Builder.create(Material.GRASS, MapColor.LIGHT_BLUE)
                .hardnessAndResistance(0.6f, 1).sound(SoundType.GROUND));
    public static Block MAGIC_OAK_LOG = new BlockModLog(BlockLog.Builder.create(Material.WOOD, MapColor.BLUE)
            .hardnessAndResistance(2.0F, 2.0F)
            .sound(SoundType.WOOD), MapColor.BLUE);
    public static Block MAGIC_OAK_PLANKS = new BlockModPlanks(Block.Builder.create(Material.WOOD, MapColor.LIGHT_BLUE)
            .hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD));

    public static Block MAGIC_OAK_SAPLING = new BlockModSapling(new MagicOakTree(),
            BlockSapling.Builder.create(Material.PLANTS, MapColor.LIGHT_BLUE).needsRandomTick());
    public static Block MAGIC_OAK_LEAVES = new BlockModLeaves(BlockLeaves.Builder.create(Material.LEAVES, MapColor.GOLD)
            .hardnessAndResistance(0.2f, 0.2f).sound(SoundType.PLANT)
            , MAGIC_OAK_SAPLING);
    public static Block MAGIC_OAK_STAIRS = new BlockModStair(MAGIC_OAK_PLANKS, BlockStairs.Builder.from(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_TRAPDOOR = new BlockModTrapDoor(BlockTrapDoor.Builder.from(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_DOOR = new BlockModDoor(BlockDoor.Builder.from(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_PRESSURE_PLATE = new BlockModPressurePlate(BlockPressurePlate.Sensitivity.EVERYTHING,
            BlockPressurePlate.Builder.from(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_FENCE = new BlockModFence(BlockFence.Builder.from(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_FENCE_GATE = new BlockModFenceGate(BlockFenceGate.Builder.from(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_BUTTON = new BlockModButtonWood(BlockButtonWood.Builder.from(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_SLAB = new BlockModSlab(BlockSlab.Builder.from(MAGIC_OAK_PLANKS));
    public static Block MANA_CRYSTAL_ORE = new BlockModOre(BlockOre.Builder.create(Material.ROCK, MapColor.STONE)
            .hardnessAndResistance(3.0f, 4)
            .sound(SoundType.STONE), PgegRegistry.MANA_CRYSTAL_DUST, 3, 7);

    public static Block QUARTZ_PILLAR = new BlockQuartzStand();
    public static Block MANA_FERN = new BlockModTallGrass(BlockTallGrass.Builder.create(Material.VINE).zeroHardnessAndResistance().doesNotBlockMovement().sound(SoundType.PLANT));
    public static Block MANA_TALLGRASS = new BlockModTallGrass(BlockTallGrass.Builder.create(Material.VINE).zeroHardnessAndResistance().doesNotBlockMovement().sound(SoundType.PLANT));



    }