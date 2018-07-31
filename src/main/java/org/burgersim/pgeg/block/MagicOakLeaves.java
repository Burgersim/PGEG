package org.burgersim.pgeg.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.burgersim.pgeg.listener.Listener;

public class MagicOakLeaves extends BlockLeaves {


    private static Builder getBuilder(){
        Builder l = BlockLeaves.Builder.create(Material.LEAVES, MapColor.GOLD);
        l.hardnessAndResistance(0.2F,0.2F).soundType(SoundType.PLANT);
        return l;
    }
    public MagicOakLeaves(){
        super(getBuilder());
    }

    @Override
    public IItemProvider getItemProvider(IBlockState p_getItemProvider_1_, World p_getItemProvider_2_, BlockPos p_getItemProvider_3_, int p_getItemProvider_4_) {
        return Listener.MAGIC_OAK_SAPLING;
    }
}
