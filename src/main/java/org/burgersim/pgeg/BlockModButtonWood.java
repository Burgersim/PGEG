package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButtonWood;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class BlockModButtonWood extends BlockButtonWood {

    public BlockModButtonWood(String name) {
        super(Builder.create(new BlockModButtonWood(name)));
        Block.registerBlock(new ResourceLocation("pgeg", name), this);
        Item.registerItemBlock(this, ItemGroup.REDSTONE);
    }

}
