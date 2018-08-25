package org.burgersim.pgeg.listener;


import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import org.dimdev.rift.listener.ItemAdder;

import static org.burgersim.pgeg.listener.PgegRegistry.*;
import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegItems implements ItemAdder {
    public static Item SLIME_PIE = new ItemFood(4, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD)).setPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST), 0.1F);

    @Override
    public void registerItems() {

        /*Item Blocks */

        Item.registerItemBlock(MANA_GRASS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LOG, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_PLANKS, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MAGIC_OAK_LEAVES, ItemGroup.DECORATIONS);
        Item.registerItemBlock(MANA_CRYSTAL_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(ORICHALCUM_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(BRIMSTONE_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(SATURNIUM_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(METEORITE_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.registerItemBlock(MITHRIL_ORE, ItemGroup.BUILDING_BLOCKS);
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
        Item.registerItemBlock(SPELL_CAULDRON, ItemGroup.DECORATIONS);
        Item.registerItemBlock(GLOWSHROOM, ItemGroup.DECORATIONS);
        Item.registerItemBlock(SNOWBELL, ItemGroup.DECORATIONS);
        Item.registerItemBlock(BLOODROSE, ItemGroup.DECORATIONS);
        Item.registerItemBlock(RUNE_PEDESTAL, ItemGroup.DECORATIONS);

        /*Magic Items*/

        Item.registerItem(new ResourceLocation(MOD_ID, "mana_crystal_dust"), MANA_CRYSTAL_DUST);
        Item.registerItem(new ResourceLocation(MOD_ID, "mana_cake"), MANA_CAKE);
        Item.registerItem(new ResourceLocation(MOD_ID, "wand"), WAND);
        Item.registerItem(new ResourceLocation(MOD_ID, "spell_book"), SPELL_BOOK);
        Item.registerItem(new ResourceLocation(MOD_ID, "rune_butchery"), RUNE_BUTCHERY);

        /*Food Items*/

        Item.registerItem(new ResourceLocation(MOD_ID, "brownie"), BROWNIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "burrito_beef"), BURRITO_BEEF);
        Item.registerItem(new ResourceLocation(MOD_ID, "burrito_fish"), BURRITO_FISH);
        Item.registerItem(new ResourceLocation(MOD_ID, "burrito_veggie"), BURRITO_VEGGIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "caramel"), CARAMEL);
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
        Item.registerItem(new ResourceLocation(MOD_ID, "slime_pie"), SLIME_PIE);
        Item.registerItem(new ResourceLocation(MOD_ID, "squid_raw"), SQUID_RAW);
        Item.registerItem(new ResourceLocation(MOD_ID, "squid_cooked"), SQUID_COOKED);
        Item.registerItem(new ResourceLocation(MOD_ID, "tomato"), TOMATO);
        Item.registerItem(new ResourceLocation(MOD_ID, "rice"), RICE);
        Item.registerItem(new ResourceLocation(MOD_ID, "dough"), DOUGH);
        Item.registerItem(new ResourceLocation(MOD_ID, "nigiri_tropical"), NIGIRI_TROPICAL);
        Item.registerItem(new ResourceLocation(MOD_ID, "roll_sea_pickle"), ROLL_SEA_PICKLE);

        Item.registerItem(new ResourceLocation(MOD_ID, "tomato_seeds"), TOMATO_SEEDS);

        /*Other Items*/
        Item.registerItem(new ResourceLocation(MOD_ID, "plant_treat"), PLANT_TREAT);

        /*Ingots*/
        Item.registerItem(new ResourceLocation(MOD_ID, "orichalcum_ingot"), ORICHALCUM_INGOT);
        Item.registerItem(new ResourceLocation(MOD_ID, "saturnium_ingot"), SATURNIUM_INGOT);
        Item.registerItem(new ResourceLocation(MOD_ID, "brimstone_ingot"), BRIMSTONE_INGOT);
        Item.registerItem(new ResourceLocation(MOD_ID, "meteorite_ingot"), METEORITE_INGOT);
        Item.registerItem(new ResourceLocation(MOD_ID, "mithril_ingot"), MITHRIL_INGOT);

        /*Tools*/
        Item.registerItem(new ResourceLocation(MOD_ID, "orichalcum_pickaxe"), ORICHALCUM_PICKAXE);

        /*Weapons*/

    }
}
