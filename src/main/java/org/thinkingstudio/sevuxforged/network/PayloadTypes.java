package org.thinkingstudio.sevuxforged.network;

import lol.bai.badpackets.api.play.PlayPackets;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public class PayloadTypes {
    public static <P extends CustomPayload> void registerPlayC2S(CustomPayload.Id<P> type, PacketCodec<? super RegistryByteBuf, P> codec) {
        PlayPackets.registerServerChannel(type, codec);
    }

    public static <P extends CustomPayload> void registerPlayS2C(CustomPayload.Id<P> type, PacketCodec<? super RegistryByteBuf, P> codec) {
        PlayPackets.registerClientChannel(type, codec);
    }
}
