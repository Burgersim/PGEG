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
    public final static Item SLIME_PIE = new ItemFood(4, 0.6F, false, new Item.Builder().group(ItemGroup.FOOD)).setPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST), 0.1F);

    @Override
    public void registerItems(){

        /*Item Blocks */

        Item.register(MANA_GRASS, ItemGroup.BUILDING_BLOCKS);
        Item.register(MAGIC_OAK_LOG, ItemGroup.BUILDING_BLOCKS);
        Item.register(MAGIC_OAK_PLANKS, ItemGroup.BUILDING_BLOCKS);
        Item.register(MAGIC_OAK_LEAVES, ItemGroup.DECORATIONS);
        Item.register(MANA_CRYSTAL_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.register(ORICHALCUM_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.register(BRIMSTONE_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.register(SATURNIUM_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.register(METEORITE_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.register(MITHRIL_ORE, ItemGroup.BUILDING_BLOCKS);
        Item.register(MAGIC_OAK_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(MAGIC_OAK_TRAPDOOR, ItemGroup.REDSTONE);
        Item.register(MAGIC_OAK_DOOR, ItemGroup.REDSTONE);
        Item.register(MAGIC_OAK_PRESSURE_PLATE, ItemGroup.REDSTONE);
        Item.register(MAGIC_OAK_FENCE, ItemGroup.DECORATIONS);
        Item.register(MAGIC_OAK_FENCE_GATE, ItemGroup.REDSTONE);
        Item.register(MAGIC_OAK_BUTTON, ItemGroup.REDSTONE);
        Item.register(MAGIC_OAK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(MAGIC_OAK_SAPLING, ItemGroup.DECORATIONS);
        Item.register(QUARTZ_PILLAR, ItemGroup.DECORATIONS);
        Item.register(MANA_FERN, ItemGroup.DECORATIONS);
        Item.register(MANA_TALLGRASS, ItemGroup.DECORATIONS);
        Item.register(SPELL_CAULDRON, ItemGroup.DECORATIONS);
        Item.register(GLOWSHROOM, ItemGroup.DECORATIONS);
        Item.register(SNOWBELL, ItemGroup.DECORATIONS);
        Item.register(BLOODROSE, ItemGroup.DECORATIONS);
        Item.register(RUNE_PEDESTAL_STONE, ItemGroup.DECORATIONS);
        Item.register(RUNE_PEDESTAL_QUARTZ, ItemGroup.DECORATIONS);
        Item.register(RUNE_PEDESTAL_PURPUR, ItemGroup.DECORATIONS);

        /*Magic Items*/

        Item.register(new ResourceLocation(MOD_ID, "mana_crystal_dust"), MANA_CRYSTAL_DUST);
        Item.register(new ResourceLocation(MOD_ID, "mana_cake"), MANA_CAKE);
        Item.register(new ResourceLocation(MOD_ID, "wand"), WAND);
        Item.register(new ResourceLocation(MOD_ID, "compendium"), COMPENDIUM);

        /*Food Items*/

        Item.register(new ResourceLocation(MOD_ID, "brownie"), BROWNIE);
        Item.register(new ResourceLocation(MOD_ID, "burrito_beef"), BURRITO_BEEF);
        Item.register(new ResourceLocation(MOD_ID, "burrito_fish"), BURRITO_FISH);
        Item.register(new ResourceLocation(MOD_ID, "burrito_veggie"), BURRITO_VEGGIE);
        Item.register(new ResourceLocation(MOD_ID, "caramel"), CARAMEL);
        Item.register(new ResourceLocation(MOD_ID, "caramel_apple"), CARAMEL_APPLE);
        Item.register(new ResourceLocation(MOD_ID, "cookie_cat"), COOKIE_CAT);
        Item.register(new ResourceLocation(MOD_ID, "cream_cookie"), CREAM_COOKIE);
        Item.register(new ResourceLocation(MOD_ID, "caramel_donut"), CARAMEL_DONUT);
        Item.register(new ResourceLocation(MOD_ID, "sugar_donut"), SUGAR_DONUT);
        Item.register(new ResourceLocation(MOD_ID, "cheese"), CHEESE);
        Item.register(new ResourceLocation(MOD_ID, "cheese_fries"), CHEESE_FRIES);
        Item.register(new ResourceLocation(MOD_ID, "berry_jelly"), BERRY_JELLY);
        Item.register(new ResourceLocation(MOD_ID, "lion_licker"), LION_LICKER);
        Item.register(new ResourceLocation(MOD_ID, "berry"), BERRY);
        Item.register(new ResourceLocation(MOD_ID, "nigiri_cod"), NIGIRI_COD);
        Item.register(new ResourceLocation(MOD_ID, "nigiri_salmon"), NIGIRI_SALMON);
        Item.register(new ResourceLocation(MOD_ID, "nigiri_squid"), NIGIRI_SQUID);
        Item.register(new ResourceLocation(MOD_ID, "onigiri"), ONIGIRI);
        Item.register(new ResourceLocation(MOD_ID, "apple_pie"), APPLE_PIE);
        Item.register(new ResourceLocation(MOD_ID, "chocolate_pie"), CHOCOLATE_PIE);
        Item.register(new ResourceLocation(MOD_ID, "berry_pie"), BERRY_PIE);
        Item.register(new ResourceLocation(MOD_ID, "slime_pie"), SLIME_PIE);
        Item.register(new ResourceLocation(MOD_ID, "squid_raw"), SQUID_RAW);
        Item.register(new ResourceLocation(MOD_ID, "squid_cooked"), SQUID_COOKED);
        Item.register(new ResourceLocation(MOD_ID, "tomato"), TOMATO);
        Item.register(new ResourceLocation(MOD_ID, "rice"), RICE);
        Item.register(new ResourceLocation(MOD_ID, "dough"), DOUGH);
        Item.register(new ResourceLocation(MOD_ID, "nigiri_tropical"), NIGIRI_TROPICAL);
        Item.register(new ResourceLocation(MOD_ID, "roll_sea_pickle"), ROLL_SEA_PICKLE);

        Item.register(new ResourceLocation(MOD_ID, "tomato_seeds"), TOMATO_SEEDS);

        /*Other Items*/
        Item.register(new ResourceLocation(MOD_ID, "plant_treat"), PLANT_TREAT);

        /*Ingots*/
        Item.register(new ResourceLocation(MOD_ID, "orichalcum_ingot"), ORICHALCUM_INGOT);
        Item.register(new ResourceLocation(MOD_ID, "saturnium_ingot"), SATURNIUM_INGOT);
        Item.register(new ResourceLocation(MOD_ID, "brimstone_ingot"), BRIMSTONE_INGOT);
        Item.register(new ResourceLocation(MOD_ID, "meteorite_ingot"), METEORITE_INGOT);
        Item.register(new ResourceLocation(MOD_ID, "mithril_ingot"), MITHRIL_INGOT);

        /*Tools*/
        Item.register(new ResourceLocation(MOD_ID, "orichalcum_pickaxe"), ORICHALCUM_PICKAXE);
        Item.register(new ResourceLocation(MOD_ID, "mithril_pickaxe"), ORICHALCUM_PICKAXE);
        Item.register(new ResourceLocation(MOD_ID, "brimstone_pickaxe"), ORICHALCUM_PICKAXE);
        Item.register(new ResourceLocation(MOD_ID, "saturnium_pickaxe"), ORICHALCUM_PICKAXE);
        Item.register(new ResourceLocation(MOD_ID, "meteorite_pickaxe"), ORICHALCUM_PICKAXE);

        /*Weapons*/

    }
}
