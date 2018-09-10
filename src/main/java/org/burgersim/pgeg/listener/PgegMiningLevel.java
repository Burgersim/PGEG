package org.burgersim.pgeg.listener;

import com.github.ondee.snowflake.listener.MiningLevelAdder;
import net.minecraft.block.Block;
import java.util.Map;

import static net.minecraft.init.Blocks.DIAMOND_ORE;
import static net.minecraft.init.Blocks.OBSIDIAN;


public class PgegMiningLevel implements MiningLevelAdder {
    @Override
    public void addMiningLevel(Map<Block, Integer> map) {
        map.put(PgegRegistry.MANA_CRYSTAL_ORE, 2);
        map.put(PgegRegistry.BRIMSTONE_ORE, 4);
        map.put(PgegRegistry.MITHRIL_ORE, 4);
        map.put(PgegRegistry.SATURNIUM_ORE, 5);
        map.put(PgegRegistry.METEORITE_ORE, 6);
        map.put(PgegRegistry.ORICHALCUM_ORE, 3);
        map.put(OBSIDIAN, 3);
    }
}
