package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class BlockModDoor extends BlockDoor {

    public BlockModDoor(String name) {
        super(BlockDoor.Builder.create(new BlockModDoor(name)));
 //       Block.registerBlock(new ResourceLocation("pgeg", name), this);
  //      Item.registerItemBlock(this, ItemGroup.DECORATIONS);
    }

}
