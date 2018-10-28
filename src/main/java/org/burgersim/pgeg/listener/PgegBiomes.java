package org.burgersim.pgeg.listener;

import net.minecraft.world.biome.Biome;
import org.burgersim.pgeg.biome.MagicForestBiome;
import org.dimdev.rift.listener.BiomeAdder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegBiomes implements BiomeAdder {
    public final static Biome MAGIC_FOREST_BIOME = new MagicForestBiome();
    @Override
    public void registerBiomes() {
        Biome.registerBiome(Biome.REGISTRY.getKeys().size() + 1,
                MOD_ID + ":magic_forest",
                MAGIC_FOREST_BIOME);
    }

    @Override
    public Collection<Biome> getOverworldBiomes() {
        return Collections.singletonList(MAGIC_FOREST_BIOME);
    }
}
