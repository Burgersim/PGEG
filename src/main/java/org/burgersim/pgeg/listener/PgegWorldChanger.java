package org.burgersim.pgeg.listener;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import org.dimdev.rift.listener.WorldChanger;

import static net.minecraft.world.biome.Biome.COUNT_RANGE;

public class PgegWorldChanger implements WorldChanger {
    @Override
    public void modifyBiome(int biomeId, String biomeName, Biome biome) {
        biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Biome.createCompositeFeature(
                        Feature.MINABLE,
                        new MinableConfig(
                                MinableConfig.IS_ROCK,
                                PgegRegistry.MANA_CRYSTAL_ORE.getDefaultState(),
                                9),
                        COUNT_RANGE,
                        new CountRangeConfig(
                                10,
                                0,
                                0,
                                64)
                )
        );
        biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Biome.createCompositeFeature(
                        Feature.MINABLE,
                        new MinableConfig(
                                MinableConfig.IS_ROCK,
                                PgegRegistry.MITHRIL_ORE.getDefaultState(),
                                8),
                        COUNT_RANGE,
                        new CountRangeConfig(
                                2,
                                0,
                                0,
                                8)
                )
        );
        biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Biome.createCompositeFeature(
                        Feature.MINABLE,
                        new MinableConfig(
                                (state) -> {
                                    Block block = state.getBlock();
                                    return block == Blocks.END_STONE;
                                },
                                PgegRegistry.SATURNIUM_ORE.getDefaultState(),
                                8
                        ),
                        COUNT_RANGE,
                        new CountRangeConfig(4,
                                0,
                                0,
                                128)
                )
        );
        biome.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Biome.createCompositeFeature(
                        Feature.MINABLE,
                        new MinableConfig(
                                (state) -> {
                                    Block block = state.getBlock();
                                    return block == Blocks.NETHERRACK;
                                },
                                PgegRegistry.BRIMSTONE_ORE.getDefaultState(),
                                8
                        ),
                        COUNT_RANGE,
                        new CountRangeConfig(4,
                                0,
                                0,
                                128)
                )
        );
        if ("deep_ocean".equals(biomeName) ||
                "deep_warm_ocean".equals(biomeName) ||
                "deep_lukewarm_ocean".equals(biomeName) ||
                "deep_cold_ocean".equals(biomeName) ||
                "deep_frozen_ocean".equals(biomeName)) {
            biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createCompositeFeature(
                            Feature.MINABLE,
                            new MinableConfig(
                                    MinableConfig.IS_ROCK,
                                    PgegRegistry.ORICHALCUM_ORE.getDefaultState(),
                                    8
                            ),
                            COUNT_RANGE,
                            new CountRangeConfig(
                                    1,
                                    0,
                                    0,
                                    16
                            )
                    )
            );
        }
    }
}
