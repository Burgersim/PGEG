package org.burgersim.pgeg.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import org.burgersim.pgeg.rune.Rune;

import javax.annotation.Nullable;
import java.util.List;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

@SuppressWarnings("NoTranslation")
public class ItemCompendium extends Item {
    public ItemCompendium(Builder builder) {
        super(builder);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.displayGui(new LexiconInteractionObject(hand == EnumHand.MAIN_HAND));
        return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> iTextComponents, ITooltipFlag flag) {
        NBTTagCompound tagCompound = stack.getTag();
        if (tagCompound != null && tagCompound.hasKey("rune")) {
            String rune = tagCompound.getString("rune");
            iTextComponents.add(new TextComponentString(I18n.format("item.compendium.rune.tooltip", I18n.format(Rune.getRune(new ResourceLocation(rune)).getNameKey()))));

        }
    }

    public class LexiconInteractionObject implements IInteractionObject {
        private final boolean isMainHand;

        LexiconInteractionObject(boolean isMainHand) {
            this.isMainHand = isMainHand;
        }

        public boolean isMainHand() {
            return isMainHand;
        }

        @Override
        public Container createContainer(InventoryPlayer inventoryPlayer, EntityPlayer entityPlayer) {
            return new LexiconContainer();
        }

        @Override
        public String getGuiID() {
            return MOD_ID + ":rune";
        }

        @Override
        public ITextComponent getName() {
            return new TextComponentString("Runic Lexicon");
        }

        @Override
        public boolean hasCustomName() {
            return false;
        }

        @Nullable
        @Override
        public ITextComponent getCustomName() {
            return null;
        }

        public class LexiconContainer extends Container {

            @Override
            public boolean canInteractWith(EntityPlayer entityPlayer) {
                return true;
            }
        }
    }
}
