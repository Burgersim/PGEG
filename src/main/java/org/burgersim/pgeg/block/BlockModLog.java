package org.burgersim.pgeg.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;

public class BlockModLog extends BlockLog {

    public BlockModLog(Builder builder, MapColor mapColor) {
        super(mapColor, builder);
    }

    @Override
    public boolean isTagged(Tag<Block> tag) {
        return super.isTagged(tag) || tag == BlockTags.LOGS;
    }
}
