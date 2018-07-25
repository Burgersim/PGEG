package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;

import static net.minecraft.init.Blocks.DIRT;

public class ManaGrass implements BlockAdder, ItemAdder {
	Block MANA_GRASS_BLOCK = new BlockGrass(Block.Builder.create(Material.GRASS, MapColor.GRASS).hardnessAndResistance(0.6F, 1).soundType(SoundType.GROUND)) {
		public IItemProvider getItemProvider(IBlockState p_getItemProvider_1_, World p_getItemProvider_2_, BlockPos p_getItemProvider_3_, int p_getItemProvider_4_) {
			return DIRT;
		}

		@Override
		public boolean canGrow(IBlockReader p_canGrow_1_, BlockPos p_canGrow_2_, IBlockState p_canGrow_3_, boolean p_canGrow_4_) {
			return super.canGrow(p_canGrow_1_, p_canGrow_2_, p_canGrow_3_, p_canGrow_4_);
		}
	};

	@Override
	public void registerBlocks() {
		Block.registerBlock(new ResourceLocation("pgeg:mana_grass_block"), MANA_GRASS_BLOCK);

	}

	@Override
	public void registerItems() {
		Item.registerItemBlock(MANA_GRASS_BLOCK, ItemGroup.BUILDING_BLOCKS);
	}
}