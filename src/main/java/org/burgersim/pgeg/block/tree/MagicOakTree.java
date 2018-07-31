package org.burgersim.pgeg.block.tree;

import net.minecraft.block.trees.OakTree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BigTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import org.burgersim.pgeg.feature.MagicOakTreeFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class MagicOakTree extends OakTree {
    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random p_getTreeFeature_1_) {
        return (AbstractTreeFeature) new MagicOakTreeFeature();
    }
}
