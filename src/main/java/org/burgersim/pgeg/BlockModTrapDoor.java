package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class BlockModTrapDoor extends BlockTrapDoor {

    public BlockModTrapDoor(String name) {
        super(BlockTrapDoor.Builder.create(new BlockModTrapDoor(name)));
        Block.registerBlock(new ResourceLocation("pgeg", name), this);
        Item.registerItemBlock(this, ItemGroup.REDSTONE);
    }

}
