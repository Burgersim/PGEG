package org.burgersim.pgeg.listener;

import net.minecraft.network.EnumPacketDirection;
import org.burgersim.pgeg.network.CPacketSetLexiconRune;
import org.burgersim.pgeg.network.SPacketGetLexiconRune;
import org.dimdev.rift.listener.PacketAdder;

public class PgegPackets implements PacketAdder {
    @Override
    public void registerHandshakingPackets(PacketRegistrationReceiver receiver) {

    }

    @Override
    public void registerPlayPackets(PacketRegistrationReceiver receiver) {
        receiver.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketSetLexiconRune.class);
        receiver.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketGetLexiconRune.class);
    }

    @Override
    public void registerStatusPackets(PacketRegistrationReceiver receiver) {

    }

    @Override
    public void registerLoginPackets(PacketRegistrationReceiver receiver) {

    }
}
