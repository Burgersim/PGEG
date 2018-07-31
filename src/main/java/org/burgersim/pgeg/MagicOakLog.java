package org.burgersim.pgeg;

import net.minecraft.block.SoundType;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MagicOakLog extends BlockLog {

    private static Builder getBuilder(){
        Builder l = BlockLog.Builder.create(Material.WOOD, MapColor.BLUE);
        l.soundType(SoundType.WOOD);
        return l;
    }

public MagicOakLog(){
        super(MapColor.BLUE, getBuilder());

}

}
