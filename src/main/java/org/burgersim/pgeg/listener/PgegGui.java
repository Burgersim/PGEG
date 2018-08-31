package org.burgersim.pgeg.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.IInteractionObject;
import org.burgersim.pgeg.client.gui.GuiCompendium;
import org.burgersim.pgeg.item.ItemCompendium;
import org.dimdev.rift.listener.client.GameGuiAdder;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegGui implements GameGuiAdder {
    @Override
    public void displayGui(EntityPlayerSP player, String id, IInteractionObject interactionObject) {
        if (id.equals(MOD_ID + ":rune")) {
            if (interactionObject instanceof ItemCompendium.LexiconInteractionObject) {
                Minecraft.getMinecraft().displayGuiScreen(new GuiCompendium((ItemCompendium.LexiconInteractionObject) interactionObject, player));
            }
        }
    }

    @Override
    public void displayContainerGui(EntityPlayerSP player, String id, IInventory inventory) {

    }
}
