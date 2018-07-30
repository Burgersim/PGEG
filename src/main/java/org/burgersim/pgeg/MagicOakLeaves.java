package org.burgersim.pgeg;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MagicOakLeaves extends BlockLeaves {


    private static Builder getBuilder(){
        Builder l = BlockLeaves.Builder.create(Material.LEAVES, MapColor.FOLIAGE);
        l.zeroHardnessAndResistance();
        return l;
    }
    public MagicOakLeaves(){
        super(getBuilder());
    }
}
