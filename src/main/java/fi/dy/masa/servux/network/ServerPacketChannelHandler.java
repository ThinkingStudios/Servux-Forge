package fi.dy.masa.servux.network;

import java.util.HashMap;

import lol.bai.badpackets.api.play.PlayPackets;
//import net.fabricmc.fabric.api.networking.v1.S2CPlayChannelEvents;
//import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import lol.bai.badpackets.impl.registry.ChannelRegistry;
import net.minecraft.util.Identifier;

public class ServerPacketChannelHandler
{
    public static final ServerPacketChannelHandler INSTANCE = new ServerPacketChannelHandler();

    private final HashMap<Identifier, IPluginChannelHandler> handlers = new HashMap<>();

    private ServerPacketChannelHandler()
    {
    }

    public void registerServerChannelHandler(IPluginChannelHandler handler)
    {
        synchronized (this.handlers)
        {
            Identifier channel = handler.getChannel();

            if (this.handlers.containsKey(channel) == false)
            {
                this.handlers.put(channel, handler);

                if (handler.isSubscribable())
                {
                    PlayPackets.registerServerReadyCallback((net, sender, server) -> {
                        var channels = ChannelRegistry.PLAY_S2C.getChannels();

                        if (channels.contains(channel))
                        {
                            handler.subscribe(net);
                        }
                    });

                    PlayPackets.registerServerReadyCallback((net, sender, server) -> {
                        var channels = ChannelRegistry.PLAY_S2C.getChannels();

                        if (channels.contains(channel))
                        {
                            handler.unsubscribe(net);
                        }
                    });
//                    S2CPlayChannelEvents.REGISTER.register((net, server, sender, channels) -> {
//                        if (channels.contains(channel))
//                        {
//                            handler.subscribe(net);
//                        }
//                    });
//                    S2CPlayChannelEvents.UNREGISTER.register((net, server, sender, channels) -> {
//                        if (channels.contains(channel))
//                        {
//                            handler.unsubscribe(net);
//                        }
//                    });
                    PlayPackets.registerServerReceiver(channel, handler.getServerPacketHandler());
                    //ServerPlayNetworking.registerGlobalReceiver(channel, handler.getServerPacketHandler());
                }
            }
        }
    }

    public void unregisterServerChannelHandler(IPluginChannelHandler handler)
    {
        synchronized (this.handlers)
        {
            Identifier channel = handler.getChannel();

            if (this.handlers.remove(channel, handler))
            {
                ChannelRegistry.PLAY_S2C.getChannels().remove(channel);
                //ServerPlayNetworking.unregisterGlobalReceiver(channel);
            }
        }
    }
}
