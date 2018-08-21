package org.burgersim.pgeg.listener;

import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.item.ItemSpellBook;
import org.burgersim.pgeg.item.ItemWand;
import org.burgersim.pgeg.item.ManaDebugItem;
import org.burgersim.pgeg.item.ManaFood;
import org.burgersim.pgeg.recipe.ModRecipes;
import org.dimdev.rift.listener.ItemAdder;

import static org.burgersim.pgeg.listener.PgegBlocks.*;
import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegItems implements ItemAdder {

    /*Magic Items*/

    public static Item MANA_CRYSTAL_DUST = new Item(new Item.Builder().group(ItemGroup.MISC));
    public static Item MANA_CAKE = new ManaFood(1,0.2F, 20.0F , false
            ,new Item.Builder().group(ItemGroup.FOOD));
    public static Item WAND = new ItemWand(1);
    public static Item SPELL_BOOK = new ItemSpellBook();
    private static Item MANA_DEBUG = new ManaDebugItem();
    private static final ModRecipes recipes = new ModRecipes();

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


    /*Other Items*/
    public static Item PLANT_TREAT = new ItemBoneMeal(EnumDyeColor.BROWN, new Item.Builder().group(ItemGroup.MATERIALS));

    @Override
    public void registerItems() {

        /*Item Blocks */

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
        Item.registerItemBlock(MANA_FERN, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MANA_TALLGRASS, ItemGroup.DECORATIONS);

        /*Magic Items*/

        Item.registerItem(new ResourceLocation(MOD_ID, "mana_crystal_dust"), MANA_CRYSTAL_DUST);
        Item.registerItem(new ResourceLocation(MOD_ID, "mana_cake"), MANA_CAKE);
        Item.registerItem(new ResourceLocation(MOD_ID, "wand"), WAND);
        Item.registerItem(new ResourceLocation(MOD_ID, "spell_book"), SPELL_BOOK);
        Item.registerItem(new ResourceLocation(MOD_ID, "mana_debug"), MANA_DEBUG);

        /*Food Items*/

        Item.registerItem(new ResourceLocation(MOD_ID, "brownie"), BROWNIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "burrito_beef"), BURRITO_BEEF);
        Item.registerItem(new ResourceLocation(MOD_ID, "burrito_fish"), BURRITO_FISH);
        Item.registerItem(new ResourceLocation(MOD_ID, "burrito_veggie"), BURRITO_VEGGIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "CARAMEL"), CARAMEL);
        Item.registerItem(new ResourceLocation(MOD_ID, "caramel_apple"), CARAMEL_APPLE);
        Item.registerItem(new ResourceLocation(MOD_ID, "cookie_cat"), COOKIE_CAT);
        Item.registerItem(new ResourceLocation(MOD_ID, "cream_cookie"), CREAM_COOKIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "caramel_donut"), CARAMEL_DONUT);
        Item.registerItem(new ResourceLocation(MOD_ID, "sugar_donut"), SUGAR_DONUT);
        Item.registerItem(new ResourceLocation(MOD_ID, "cheese"), CHEESE);
        Item.registerItem(new ResourceLocation(MOD_ID, "cheese_fries"), CHEESE_FRIES);
        Item.registerItem(new ResourceLocation(MOD_ID, "berry_jelly"), BERRY_JELLY);
        Item.registerItem(new ResourceLocation(MOD_ID, "lion_licker"), LION_LICKER);
        Item.registerItem(new ResourceLocation(MOD_ID, "berry"), BERRY);
        Item.registerItem(new ResourceLocation(MOD_ID, "nigiri_cod"), NIGIRI_COD);
        Item.registerItem(new ResourceLocation(MOD_ID, "nigiri_salmon"), NIGIRI_SALMON);
        Item.registerItem(new ResourceLocation(MOD_ID, "nigiri_squid"), NIGIRI_SQUID);
        Item.registerItem(new ResourceLocation(MOD_ID, "onigiri"), ONIGIRI);
        Item.registerItem(new ResourceLocation(MOD_ID, "apple_pie"), APPLE_PIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "chocolate_pie"), CHOCOLATE_PIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "berry_pie"), BERRY_PIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "slme_pie"), SLIME_PIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "squid_raw"), SQUID_RAW);
        Item.registerItem(new ResourceLocation(MOD_ID, "squid_cooked"), SQUID_COOKED);
        Item.registerItem(new ResourceLocation(MOD_ID, "tomato"), TOMATO);
        Item.registerItem(new ResourceLocation(MOD_ID, "rice"), RICE);

        /*Other Items*/
        Item.registerItem(new ResourceLocation(MOD_ID, "plant_treat"), PLANT_TREAT);

    }
}
