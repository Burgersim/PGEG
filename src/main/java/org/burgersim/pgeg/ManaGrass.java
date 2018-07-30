package org.burgersim.pgeg;

import net.minecraft.block.BlockGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.minecraft.init.Blocks.DIRT;

public class ManaGrass extends BlockGrass {

	private static Builder getBuilder(){
		Builder b = BlockGrass.Builder.create(Material.GRASS, MapColor.LIGHT_BLUE);
		b.hardnessAndResistance(0.6f,1).soundType(SoundType.GROUND);
		return b;
	}

	public ManaGrass() {
		super(getBuilder());
	}

	public IItemProvider getItemProvider(IBlockState p_getItemProvider_1_, World p_getItemProvider_2_, BlockPos p_getItemProvider_3_, int p_getItemProvider_4_) {
		return DIRT;
	}
}