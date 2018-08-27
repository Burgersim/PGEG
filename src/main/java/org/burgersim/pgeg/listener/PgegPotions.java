package org.burgersim.pgeg.listener;

import com.github.ondee.snowflake.listener.PotionAdder;
import com.github.ondee.snowflake.potion.ModPotion;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegPotions implements PotionAdder {
    public static Potion HOVER;

    @Override
    public void addPotions() {
        HOVER = ModPotion.register(new ResourceLocation(MOD_ID, "hover"), new ModPotion(false, 0xffffff, new ResourceLocation(MOD_ID, "textures/rune/rune_air.png")));
        ModPotion.addBottle(new ResourceLocation(MOD_ID, "hover"), HOVER, 60 * 20);
    }
}
