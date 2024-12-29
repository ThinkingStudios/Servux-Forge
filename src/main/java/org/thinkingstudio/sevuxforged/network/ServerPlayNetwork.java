package org.thinkingstudio.sevuxforged.network;

import lol.bai.badpackets.api.PacketReceiver;
import lol.bai.badpackets.api.PacketSender;
import lol.bai.badpackets.api.play.PlayPackets;
import lol.bai.badpackets.api.play.ServerPlayContext;
import lol.bai.badpackets.impl.registry.ChannelRegistry;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ServerPlayNetwork {
    public static boolean canSend(ServerPlayerEntity player, CustomPayload.Id<?> type) {
        return PacketSender.s2c(player).canSend(type);
    }

    public static void send(ServerPlayerEntity player, CustomPayload payload) {
        PacketSender.s2c(player).send(payload);
    }

    public static void removeChannel(Identifier channel) {
        ChannelRegistry.PLAY_S2C.getChannels().remove(channel);
    }

    public static <P extends CustomPayload> void registerGlobalReceiver(CustomPayload.Id<P> id, PlayPayloadHandler<P> handler) {
        PlayPackets.registerServerReceiver(id, handler);
    }

    public interface PlayPayloadHandler<T extends CustomPayload> extends PacketReceiver<ServerPlayContext, T> {
    }
}
