package org.burgersim.pgeg.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import org.burgersim.pgeg.client.gui.RuneLexiconGui;
import org.burgersim.pgeg.rune.Rune;

import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("NoTranslation")
public class ItemRuneLexicon extends Item {
    public ItemRuneLexicon(Builder builder) {
        super(builder);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        Minecraft.getMinecraft().displayGuiScreen(new RuneLexiconGui(stack, world));
        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> iTextComponents, ITooltipFlag flag) {
        NBTTagCompound tagCompound = stack.getTagCompound();
        if (tagCompound != null && tagCompound.hasKey("rune")) {
            String rune = tagCompound.getString("rune");
            iTextComponents.add(new TextComponentString(I18n.format("item.pgeg.runic_lexicon.tooltip", I18n.format(Rune.getRune(new ResourceLocation(rune)).getNameKey()))));

        }
    }
}
