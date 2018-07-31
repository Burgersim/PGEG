package org.burgersim.pgeg;

import net.minecraft.block.BlockGrass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class ManaGrass extends BlockGrass {

	private static Builder getBuilder(){
		Builder b = BlockGrass.Builder.create(Material.GRASS, MapColor.LIGHT_BLUE);
		b.hardnessAndResistance(0.6f,1).soundType(SoundType.GROUND);
		b.needsRandomTick();
		return b;
	}

	public ManaGrass() {
		super(getBuilder());
	}
}