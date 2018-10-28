package org.burgersim.pgeg.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.util.EnumHand;

import java.io.IOException;

public class CPacketSetLexiconRune implements Packet<INetHandlerPlayServer> {
    private boolean isMainHand;
    private String rune;

    public CPacketSetLexiconRune() {
    }

    public CPacketSetLexiconRune(boolean isMainHand, String rune) {
        this.isMainHand = isMainHand;
        this.rune = rune;
    }

    @Override
    public void readPacketData(PacketBuffer packetBuffer) {
        this.isMainHand = packetBuffer.readBoolean();
        this.rune = packetBuffer.readString(32767);
    }

    @Override
    public void writePacketData(PacketBuffer packetBuffer) {
        packetBuffer.writeBoolean(isMainHand);
        packetBuffer.writeString(rune);
    }

    @Override
    public void processPacket(INetHandlerPlayServer iNetHandlerPlayServer) {
        EntityPlayerMP playerMP = ((NetHandlerPlayServer) iNetHandlerPlayServer).player;
        ItemStack stack = playerMP.getHeldItem(isMainHand ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND);
        NBTTagCompound compound = stack.getTag();
        if (compound == null) {
            compound = new NBTTagCompound();
        }
        compound.setString("rune", rune);
        stack.setTag(compound);
        playerMP.connection.sendPacket(new SPacketGetLexiconRune(isMainHand, rune));
    }
}
