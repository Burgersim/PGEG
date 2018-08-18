package org.burgersim.pgeg.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.burgersim.pgeg.mana.IManaHandler;

public class ManaFood extends ItemFood {
    private float manaAmount;
    public ManaFood(int healAmount, float saturationModifier,float manaAmount, boolean isWolfsFavoriteMeat, Builder builder) {
        super(healAmount, saturationModifier, isWolfsFavoriteMeat, builder);
        this.setAlwaysEdible();
        this.manaAmount = manaAmount;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        IManaHandler handler = (IManaHandler)player;
        handler.regenMana(manaAmount);
    }
}
