package org.burgersim.pgeg.listener;

import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import org.burgersim.pgeg.block.*;
import org.burgersim.pgeg.block.tree.MagicOakTree;
import org.dimdev.rift.listener.BlockAdder;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegBlocks implements BlockAdder {
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
            .sound(SoundType.STONE), PgegItems.MANA_CRYSTAL_DUST, 3, 7);

    public static Block QUARTZ_PILLAR = new BlockQuartzStand();
    public static Block MANA_FERN = new BlockModTallGrass(BlockTallGrass.Builder.create(Material.VINE).zeroHardnessAndResistance().doesNotBlockMovement().sound(SoundType.PLANT));
    public static Block MANA_TALLGRASS = new BlockModTallGrass(BlockTallGrass.Builder.create(Material.VINE).zeroHardnessAndResistance().doesNotBlockMovement().sound(SoundType.PLANT));

    public static Block TOMATO_CROP = new BlockTomato(BlockCrops.Builder.create(Material.GRASS).doesNotBlockMovement().needsRandomTick());
    public static Block RICE_CROP = new BlockRice(BlockCrops.Builder.create(Material.GRASS).doesNotBlockMovement().needsRandomTick());

    @Override
    public void registerBlocks() {
        Block.register(new ResourceLocation(MOD_ID, "mana_grass_block"), MANA_GRASS);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_log"), MAGIC_OAK_LOG);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_planks"), MAGIC_OAK_PLANKS);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_leaves"), MAGIC_OAK_LEAVES);
        Block.register(new ResourceLocation(MOD_ID, "mana_crystal_ore"), MANA_CRYSTAL_ORE);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_stairs"), MAGIC_OAK_STAIRS);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_trapdoor"), MAGIC_OAK_TRAPDOOR);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_door"), MAGIC_OAK_DOOR);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_pressure_plate"), MAGIC_OAK_PRESSURE_PLATE);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_fence"), MAGIC_OAK_FENCE);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_fence_gate"), MAGIC_OAK_FENCE_GATE);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_button"), MAGIC_OAK_BUTTON);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_slab"), MAGIC_OAK_SLAB);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_sapling"), MAGIC_OAK_SAPLING);
        Block.register(new ResourceLocation(MOD_ID, "quartz_stand"), QUARTZ_PILLAR);
        Block.register(new ResourceLocation(MOD_ID, "mana_fern"), MANA_FERN);
        Block.register(new ResourceLocation(MOD_ID, "mana_tallgrass"), MANA_TALLGRASS);
        Block.register(new ResourceLocation(MOD_ID, "tomato_crop"), TOMATO_CROP);
        Block.register(new ResourceLocation(MOD_ID, "rice_crop"), RICE_CROP);
    }
}
