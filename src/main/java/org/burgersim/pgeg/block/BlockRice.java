package org.burgersim.pgeg.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.init.Items;
import net.minecraft.util.IItemProvider;

import static org.burgersim.pgeg.listener.PgegItems.RICE_SEEDS;

public class BlockRice extends BlockCrops {
    public BlockRice(Builder builder) {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem(){
        return Items.RICE_SEEDS;
    }

    @Override
    protected IItemProvider getCropsItem() {
        return Items.RICE;
    }
}
