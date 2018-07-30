package org.burgersim.pgeg;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ManaCrystalOre extends BlockOre {

    private static Builder getBuilder(){
        Builder o = BlockOre.Builder.create(Material.ROCK, MapColor.STONE);
        o.hardnessAndResistance(3.0f,4).soundType(SoundType.GROUND);
        return o;
    }

    public ManaCrystalOre() {
        super(getBuilder());
    }

 /*   public IItemProvider getItemProvider(IBlockState p_getItemProvider_1_, World p_getItemProvider_2_, BlockPos p_getItemProvider_3_, int p_getItemProvider_4_) {
        return ;
    }
*/
}
