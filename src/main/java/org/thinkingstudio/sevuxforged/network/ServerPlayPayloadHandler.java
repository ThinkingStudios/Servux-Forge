package org.thinkingstudio.sevuxforged.network;

import lol.bai.badpackets.api.PacketReceiver;
import lol.bai.badpackets.api.play.ServerPlayContext;
import net.minecraft.network.packet.CustomPayload;

public interface ServerPlayPayloadHandler<P extends CustomPayload> extends PacketReceiver<ServerPlayContext, P> {
}
