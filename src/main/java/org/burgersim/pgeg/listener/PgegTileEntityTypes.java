package org.burgersim.pgeg.listener;

import net.minecraft.tileentity.TileEntityType;
import org.burgersim.pgeg.tileentity.TileEntityQuartzStand;
import org.burgersim.pgeg.tileentity.TileEntitySpellCauldron;
import org.dimdev.rift.listener.TileEntityTypeAdder;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegTileEntityTypes implements TileEntityTypeAdder {
    public static TileEntityType QUARTZ_STAND;
    public static TileEntityType SPELL_CAULDRON;
    @Override
    public void registerTileEntityTypes() {
        QUARTZ_STAND = TileEntityType.registerTileEntityType(MOD_ID + ":quartz_stand",
                TileEntityType.Builder.create(TileEntityQuartzStand::new));
        SPELL_CAULDRON = TileEntityType.registerTileEntityType(MOD_ID + ":spell_cauldron",
                TileEntityType.Builder.create(TileEntitySpellCauldron::new));
    }
}
