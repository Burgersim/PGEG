package org.burgersim.pgeg.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.IInteractionObject;
import org.burgersim.pgeg.client.gui.RuneLexiconGui;
import org.burgersim.pgeg.item.ItemRuneLexicon;
import org.dimdev.rift.listener.client.GameGuiAdder;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class PgegGui implements GameGuiAdder {
    @Override
    public void displayGui(EntityPlayerSP player, String id, IInteractionObject interactionObject) {
        if (id.equals(MOD_ID + ":lexicon")) {
            Minecraft.getMinecraft().displayGuiScreen(new RuneLexiconGui((ItemRuneLexicon.LexiconInteractionObject) interactionObject, player.world));
        }
    }

    @Override
    public void displayContainerGui(EntityPlayerSP player, String id, IInventory inventory) {

    }
}
