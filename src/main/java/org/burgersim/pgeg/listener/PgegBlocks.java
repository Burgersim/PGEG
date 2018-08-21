package org.burgersim.pgeg.listener;

import static org.burgersim.pgeg.listener.PgegRegistry;
import static org.burgersim.pgeg.utils.Reference.*;

@Override
    public void registerBlocks() {
        Block.register(new ResourceLocation(MOD_ID, "mana_grass_block"), MANA_GRASS);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_log"), MAGIC_OAK_LOG);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_planks"), MAGIC_OAK_PLANKS);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_leaves"), MAGIC_OAK_LEAVES);
        Block.register(new ResourceLocation(MOD_ID, "mana_crystal_ore"), MANA_CRYSTAL_ORE);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_stairs"), MAGIC_OAK_STAIRS);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_trapdoor"), MAGIC_OAK_TRAPDOOR);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_door"), MAGIC_OAK_DOOR);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_pressure_plate"), MAGIC_OAK_PRESSURE_PLATE);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_fence"), MAGIC_OAK_FENCE);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_fence_gate"), MAGIC_OAK_FENCE_GATE);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_button"), MAGIC_OAK_BUTTON);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_slab"), MAGIC_OAK_SLAB);
        Block.register(new ResourceLocation(MOD_ID, "magic_oak_sapling"), MAGIC_OAK_SAPLING);
        Block.register(new ResourceLocation(MOD_ID, "quartz_stand"), QUARTZ_PILLAR);
        Block.register(new ResourceLocation(MOD_ID, "mana_fern"), MANA_FERN);
        Block.register(new ResourceLocation(MOD_ID, "mana_tallgrass"), MANA_TALLGRASS);
        Block.register(new ResourceLocation(MOD_ID, "tomato_crop"), TOMATO_CROP);
        Block.register(new ResourceLocation(MOD_ID, "rice_crop"), RICE_CROP);
    }
}
