package org.burgersim.pgeg.listener;

import com.github.ondee.snowflake.listener.GrassSeedAdder;
import net.minecraft.item.Item;

import java.util.List;

public class PgegGrassSeeds implements GrassSeedAdder {
    @Override
    public void addSeed(List<Item> seeds) {
        seeds.add(PgegRegistry.TOMATO_SEEDS);
        seeds.add(PgegRegistry.RICE);
    }
}
