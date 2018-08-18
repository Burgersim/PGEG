package org.burgersim.pgeg.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class ItemSpellBook extends Item {

    public ItemSpellBook() {
        super(new Item.Builder().maxStackSize(1).rarity(EnumRarity.UNCOMMON).group(ItemGroup.MISC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack heldItem = player.getHeldItem(hand);
        NBTTagCompound compound;
        if (heldItem.hasTagCompound()) {
            compound = player.getHeldItem(hand).getTagCompound();
        } else {
            compound = new NBTTagCompound();
        }
        if (!compound.hasKey(MOD_ID + ":owner")) {
            compound.setString(MOD_ID + ":owner", player.getDisplayName().getFormattedText());
        }

        heldItem.setTagCompound(compound);
        return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> textComponents, ITooltipFlag tooltipFlag) {
        if (stack.hasTagCompound()) {
            NBTTagCompound compound = stack.getTagCompound();
            if (compound.hasKey(MOD_ID + ":owner")) {
                String owner = compound.getString(MOD_ID + ":owner");
                textComponents.add(new TextComponentString("Owner: " + owner));
            }
        }
    }
}