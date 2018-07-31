package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;


public class BlockModPressurePlate extends BlockPressurePlate {

    public BlockModPressurePlate(String name) {
        super(BlockPressurePlate.Sensitivity.EVERYTHING, Builder.create(new BlockModPressurePlate(name)));
        Block.registerBlock(new ResourceLocation("pgeg", name), this);
        Item.registerItemBlock(this, ItemGroup.REDSTONE);
    }

}
