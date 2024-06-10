package fi.dy.masa.servux;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fi.dy.masa.servux.dataproviders.DataProviderManager;
import fi.dy.masa.servux.dataproviders.StructureDataProvider;
import fi.dy.masa.servux.event.PlayerHandler;
import fi.dy.masa.servux.event.PlayerListener;
import fi.dy.masa.servux.event.ServerHandler;
import fi.dy.masa.servux.event.ServerListener;

public class Servux
{
    public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);

    public static void onInitialize()
    {
        DataProviderManager.INSTANCE.registerDataProvider(StructureDataProvider.INSTANCE);

        ServerListener serverListener = new ServerListener();
        ServerHandler.getInstance().registerServerHandler(serverListener);

        PlayerListener playerListener = new PlayerListener();
        PlayerHandler.getInstance().registerPlayerHandler(playerListener);
    }
}
