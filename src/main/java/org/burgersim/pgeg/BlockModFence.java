package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class BlockModFence extends BlockFence {

    public BlockModFence(String name) {
        super(Builder.create(new BlockModFence(name)));
 //       Block.registerBlock(new ResourceLocation("pgeg", name), this);
  //      Item.registerItemBlock(this, ItemGroup.DECORATIONS);
    }

}
