package org.burgersim.pgeg.rune;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;


public class Rune {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final ResourceLocation BROKEN_ID = new ResourceLocation("broken");
    public static final RegistryNamespacedDefaultedByKey<ResourceLocation, Rune> REGISTRY;

    private final RuneType runeType;
    private final int workSpeed;
    private final float workChance;
    private final int color;
    private final ResourceLocation textureLocation;

    public Rune(RuneType runeType, int workSpeed, float workChance, int color, ResourceLocation textureLocation) {
        this.runeType = runeType;
        this.workSpeed = workSpeed;
        this.workChance = workChance;
        this.color = color;
        this.textureLocation = textureLocation;
    }

    public void onColide(World world, Entity entity, BlockPos runePos, int levelModifier) {

    }

    public void processBlock(BlockPos blockPos, BlockPos runePos, int levelModifier) {

    }

    public void processEntity(Entity entity, BlockPos runePos, int levelModifier) {

    }

    public static void register(ResourceLocation location, Rune rune) {
        if (REGISTRY.containsKey(location)) {
            LOGGER.info("Duplicated rune entry :" + location);
        } else {
            REGISTRY.putObject(location, rune);
        }
    }

    public static Rune getRune(ResourceLocation location) {
        return REGISTRY.getObject(location);
    }

    public static void registerRunes() {
        register(new ResourceLocation(MOD_ID, "butchery"), new RuneButchery());
    }

    public RuneType getRuneType() {
        return runeType;
    }

    public int getWorkSpeed() {
        return workSpeed;
    }

    public float getWorkChance() {
        return workChance;
    }

    public int getColor() {
        return color;
    }

    public ResourceLocation getTextureLocation() {
        return textureLocation;
    }

    static {
        REGISTRY = new RegistryNamespacedDefaultedByKey(BROKEN_ID);
    }
}
