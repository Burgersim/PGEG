package org.burgersim.pgeg.feature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import org.burgersim.pgeg.listener.PgegRegistry;

import java.util.Random;
import java.util.Set;

public class MagicOakTreeFeature extends TreeFeature {
    private final IBlockState metaLeaves = PgegRegistry.MAGIC_OAK_LEAVES.getDefaultState();
    private final IBlockState metaWood = PgegRegistry.MAGIC_OAK_LOG.getDefaultState();

    public MagicOakTreeFeature() {
        super(true, 4, PgegRegistry.MAGIC_OAK_LOG.getDefaultState()
                , PgegRegistry.MAGIC_OAK_LEAVES.getDefaultState(), false);
    }

    @Override
    public boolean place(Set<BlockPos> p_208519_1_, IWorld world, Random random, BlockPos pos) {
        int height = this.func_208534_a(random);
        boolean lvt_6_1_ = true;
        if (pos.getY() >= 1 && pos.getY() + height + 1 <= 256) {
            int y;
            int lvt_11_2_;
            for (int lvt_7_1_ = pos.getY(); lvt_7_1_ <= pos.getY() + 1 + height; ++lvt_7_1_) {
                int lvt_8_1_ = 1;
                if (lvt_7_1_ == pos.getY()) {
                    lvt_8_1_ = 0;
                }

                if (lvt_7_1_ >= pos.getY() + 1 + height - 2) {
                    lvt_8_1_ = 2;
                }

                BlockPos.MutableBlockPos lvt_9_1_ = new BlockPos.MutableBlockPos();

                for (y = pos.getX() - lvt_8_1_; y <= pos.getX() + lvt_8_1_ && lvt_6_1_; ++y) {
                    for (lvt_11_2_ = pos.getZ() - lvt_8_1_; lvt_11_2_ <= pos.getZ() + lvt_8_1_ && lvt_6_1_; ++lvt_11_2_) {
                        if (lvt_7_1_ >= 0 && lvt_7_1_ < 256) {
                            if (!this.canGrowInto(world.getBlockState(lvt_9_1_.setPos(y, lvt_7_1_, lvt_11_2_)).getBlock())) {
                                lvt_6_1_ = false;
                            }
                        } else {
                            lvt_6_1_ = false;
                        }
                    }
                }
            }

            if (!lvt_6_1_) {
                return false;
            } else {
                Block block = world.getBlockState(pos.down()).getBlock();
                if ((block == Blocks.GRASS_BLOCK ||
                        Block.isDirt(block) ||
                        block == Blocks.FARMLAND ||
                        block == PgegRegistry.MANA_GRASS) && pos.getY() < 256 - height - 1) {
                    this.setDirtAt(world, pos.down());

                    int lvt_12_3_;
                    int lvt_14_2_;
                    int z;
                    BlockPos blockPos;
                    for (y = pos.getY() - 3 + height; y <= pos.getY() + height; ++y) {
                        lvt_11_2_ = y - (pos.getY() + height);
                        lvt_12_3_ = 1 - lvt_11_2_ / 2;

                        for (int x = pos.getX() - lvt_12_3_; x <= pos.getX() + lvt_12_3_; ++x) {
                            lvt_14_2_ = x - pos.getX();

                            for (z = pos.getZ() - lvt_12_3_; z <= pos.getZ() + lvt_12_3_; ++z) {
                                int lvt_16_1_ = z - pos.getZ();
                                if (Math.abs(lvt_14_2_) != lvt_12_3_ || Math.abs(lvt_16_1_) != lvt_12_3_ || random.nextInt(2) != 0 && lvt_11_2_ != 0) {
                                    blockPos = new BlockPos(x, y, z);
                                    IBlockState blockState = world.getBlockState(blockPos);
                                    Material material = blockState.getMaterial();
                                    if (blockState.isAir() || blockState.isIn(BlockTags.LEAVES) || material == Material.VINE) {
                                        this.setBlockState(world, blockPos, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (y = 0; y < height; ++y) {
                        IBlockState blockState = world.getBlockState(pos.up(y));
                        Material material = blockState.getMaterial();
                        if (blockState.isAir() || blockState.isIn(BlockTags.LEAVES) || material == Material.VINE) {
                            this.func_208520_a(p_208519_1_, world, pos.up(y), this.metaWood);
                        }
                    }

                    {
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}