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
            .hardnessAndResistance(0.6f,1).soundType(SoundType.GROUND));
    public static Block MAGIC_OAK_LOG = new BlockModLog(BlockLog.Builder.create(Material.WOOD, MapColor.BLUE)
            .hardnessAndResistance(2.0F, 2.0F)
            .soundType(SoundType.WOOD), MapColor.BLUE);
    public static Block MAGIC_OAK_PLANKS = new BlockModPlanks(Block.Builder.create(Material.WOOD, MapColor.LIGHT_BLUE)
            .hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD));

    public static Block MAGIC_OAK_SAPLING = new BlockModSapling(new MagicOakTree(),
            BlockSapling.Builder.create(Material.PLANTS, MapColor.LIGHT_BLUE).needsRandomTick());
    public static Block MAGIC_OAK_LEAVES = new BlockModLeaves(BlockLeaves.Builder.create(Material.LEAVES, MapColor.GOLD)
            .hardnessAndResistance(0.2f, 0.2f).soundType(SoundType.PLANT)
            , MAGIC_OAK_SAPLING);
    public static Block MAGIC_OAK_STAIRS = new BlockModStair(MAGIC_OAK_PLANKS, BlockStairs.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_TRAPDOOR = new BlockModTrapDoor(BlockTrapDoor.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_DOOR = new BlockModDoor(BlockDoor.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_PRESSURE_PLATE = new BlockModPressurePlate(BlockPressurePlate.Sensitivity.EVERYTHING,
            BlockPressurePlate.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_FENCE = new BlockModFence(BlockFence.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_FENCE_GATE = new BlockModFenceGate(BlockFenceGate.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_BUTTON = new BlockModButtonWood(BlockButtonWood.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MAGIC_OAK_SLAB = new BlockModSlab(BlockSlab.Builder.create(MAGIC_OAK_PLANKS));
    public static Block MANA_CRYSTAL_ORE = new BlockModOre(BlockOre.Builder.create(Material.ROCK, MapColor.STONE)
            .hardnessAndResistance(3.0f,4)
            .soundType(SoundType.STONE), PgegItems.MANA_CRYSTAL_DUST, 3, 7);

    public static Block QUARTZ_PILLAR = new BlockQuartzPillar();
    public static Block MANA_FERN = new BlockModFern(BlockTallGrass.Builder.create(Material.VINE).zeroHardnessAndResistance().doesNotBlockMovement().soundType(SoundType.PLANT));
    public static Block MANA_TALLGRASS = new BlockModFern(BlockTallGrass.Builder.create(Material.VINE).zeroHardnessAndResistance().doesNotBlockMovement().soundType(SoundType.PLANT));
    @Override
    public void registerBlocks() {
        Block.registerBlock(new ResourceLocation(MOD_ID, "mana_grass_block"), MANA_GRASS);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_log"), MAGIC_OAK_LOG);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_planks"), MAGIC_OAK_PLANKS);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_leaves"), MAGIC_OAK_LEAVES);
        Block.registerBlock(new ResourceLocation(MOD_ID, "mana_crystal_ore"), MANA_CRYSTAL_ORE);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_stairs"), MAGIC_OAK_STAIRS);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_trapdoor"), MAGIC_OAK_TRAPDOOR);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_door"), MAGIC_OAK_DOOR);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_pressure_plate"), MAGIC_OAK_PRESSURE_PLATE);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_fence"), MAGIC_OAK_FENCE);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_fence_gate"), MAGIC_OAK_FENCE_GATE);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_button"), MAGIC_OAK_BUTTON);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_slab"), MAGIC_OAK_SLAB);
        Block.registerBlock(new ResourceLocation(MOD_ID, "magic_oak_sapling"), MAGIC_OAK_SAPLING);
        Block.registerBlock(new ResourceLocation(MOD_ID, "quartz_stand"), QUARTZ_PILLAR);
        Block.registerBlock(new ResourceLocation(MOD_ID, "mana_fern"), MANA_FERN);
        Block.registerBlock(new ResourceLocation(MOD_ID, "mana_tallgrass"), MANA_TALLGRASS);
    }
}
