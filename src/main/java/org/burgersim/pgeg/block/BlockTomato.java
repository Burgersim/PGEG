package org.burgersim.pgeg.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.init.Items;
import net.minecraft.util.IItemProvider;

public class BlockTomato extends BlockCrops {
    public BlockTomato(Builder builder) {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem(){
        return Items.TOMATO_SEEDS;
    }

    @Override
    protected IItemProvider getCropsItem() {
        return Items.TOMATO;
    }
}
