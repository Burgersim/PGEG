package org.burgersim.pgeg.listener;

import net.minecraft.tileentity.TileEntityType;
import org.burgersim.pgeg.tileentity.TileEntityQuartzStand;
import org.burgersim.pgeg.tileentity.TileEntityRunePedestal;
import org.burgersim.pgeg.tileentity.TileEntitySpellCauldron;
import org.burgersim.pgeg.tileentity.flower.TileEntityBloodrose;
import org.burgersim.pgeg.tileentity.flower.TileEntitySnowbell;
import org.dimdev.rift.listener.TileEntityTypeAdder;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegTileEntityTypes implements TileEntityTypeAdder {
    public static TileEntityType QUARTZ_STAND;
    public static TileEntityType SPELL_CAULDRON;
    public static TileEntityType SNOWBELL;
    public static TileEntityType BLOODROSE;
    public static TileEntityType RUNE_PEDESTAL;
    @Override
    public void registerTileEntityTypes() {
        QUARTZ_STAND = TileEntityType.registerTileEntityType(MOD_ID + ":quartz_stand",
                TileEntityType.Builder.create(TileEntityQuartzStand::new));
        SPELL_CAULDRON = TileEntityType.registerTileEntityType(MOD_ID + ":spell_cauldron",
                TileEntityType.Builder.create(TileEntitySpellCauldron::new));
        SNOWBELL = TileEntityType.registerTileEntityType(MOD_ID + ":snowbell",
                TileEntityType.Builder.create(TileEntitySnowbell::new));
        BLOODROSE = TileEntityType.registerTileEntityType(MOD_ID + ":bloodrose",
                TileEntityType.Builder.create(TileEntityBloodrose::new));
        RUNE_PEDESTAL = TileEntityType.registerTileEntityType(MOD_ID + ":rune_pedestal",
                TileEntityType.Builder.create(TileEntityRunePedestal::new));
    }
}
