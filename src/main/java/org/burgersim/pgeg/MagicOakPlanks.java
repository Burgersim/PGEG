package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MagicOakPlanks extends Block {
    private static Builder getBuilder() {
        Builder x = Block.Builder.create(Material.WOOD, MapColor.LIGHT_BLUE);
        x.hardnessAndResistance(2.0F, 3.0F).soundType(SoundType.WOOD);
        return x;
    }

    public MagicOakPlanks() {
        super(getBuilder());
    }
}


