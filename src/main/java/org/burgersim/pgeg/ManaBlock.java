package org.burgersim.pgeg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;

public class ManaBlock implements BlockAdder, ItemAdder {
	Block MANA_CRYSTAL_ORE = new BlockOre(Block.Builder.create(Material.ROCK, MapColor.STONE).hardnessAndResistance(3.0F, 4).soundType(SoundType.STONE)) {
		public IItemProvider getItemProvider(IBlockState p_getItemProvider_1_, World p_getItemProvider_2_, BlockPos p_getItemProvider_3_, int p_getItemProvider_4_) {
			return MANA_CRYSTAL_DUST;
		}
	};

	Item MANA_CRYSTAL_DUST = new Item(new Item.Builder().group(ItemGroup.MISC));

	@Override
	public void registerBlocks() {
		Block.registerBlock(new ResourceLocation("pgeg:mana_crystal_ore"), MANA_CRYSTAL_ORE);

	}

	@Override
	public void registerItems() {
		Item.registerItemBlock(MANA_CRYSTAL_ORE, ItemGroup.BUILDING_BLOCKS);
		Item.registerItem("pgeg:mana_crystal_dust", MANA_CRYSTAL_DUST);
	}
}