package fi.dy.masa.servux.util;

import net.minecraft.world.World;

public class WorldUtils
{
    public static boolean shouldPreventBlockUpdates(World world)
    {
        return ((IWorldUpdateSuppressor) world).servux_getShouldPreventBlockUpdates();
    }

    public static void setShouldPreventBlockUpdates(World world, boolean preventUpdates)
    {
        ((IWorldUpdateSuppressor) world).servux_setShouldPreventBlockUpdates(preventUpdates);
    }
}
