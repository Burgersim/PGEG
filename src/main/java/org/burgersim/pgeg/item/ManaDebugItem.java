package org.burgersim.pgeg.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import org.burgersim.pgeg.mana.IManaHandler;

public class ManaDebugItem extends Item {
    public ManaDebugItem() {
        super(new Item.Builder());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        IManaHandler handler = (IManaHandler) player;
        player.sendStatusMessage(new TextComponentString("Mana: " + handler.getMana() + "\\" + handler.getMaxMana()), true);
        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
