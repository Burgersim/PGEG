package org.burgersim.pgeg.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.util.IItemProvider;
import org.burgersim.pgeg.listener.PgegItems;

public class BlockRice extends BlockCrops {
    public BlockRice(Builder builder) {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem(){
        return PgegItems.RICE_SEEDS;
    }

    @Override
    protected IItemProvider getCropsItem() {
        return PgegItems.RICE;
    }
}