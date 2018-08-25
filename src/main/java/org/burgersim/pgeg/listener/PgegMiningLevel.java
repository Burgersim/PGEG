package org.burgersim.pgeg.listener;

import com.github.ondee.snowflake.listener.MiningLevelAdder;
import net.minecraft.block.Block;

import java.util.Map;

public class PgegMiningLevel implements MiningLevelAdder {
    @Override
    public void addMiningLevel(Map<Block, Integer> map) {
        map.put(PgegRegistry.MANA_CRYSTAL_ORE, 2);
    }
}
