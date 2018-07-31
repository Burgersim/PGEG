package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class BlockModFenceGate extends BlockFenceGate {

    public BlockModFenceGate(String name) {
        super(Builder.create(new BlockModFenceGate(name)));
        Block.registerBlock(new ResourceLocation("pgeg", name), this);
        Item.registerItemBlock(this, ItemGroup.REDSTONE);
    }

}
