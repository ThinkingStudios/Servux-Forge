package fi.dy.masa.servux;

import java.io.File;
import net.minecraft.MinecraftVersion;
import fi.dy.masa.servux.util.StringUtils;
import net.neoforged.fml.loading.FMLPaths;

public class Reference
{
    public static final String MOD_ID = "servux";
    public static final String MOD_NAME = "ServuxForged";
    public static final String MOD_VERSION = StringUtils.getModVersionString(MOD_ID);
    public static final String MC_VERSION = MinecraftVersion.CURRENT.getName();
    public static final String MOD_TYPE = "neoforge";
    public static final String MOD_STRING = MOD_ID + "-" + MOD_TYPE + "-" + MC_VERSION + "-" + MOD_VERSION;

    public static final File DEFAULT_RUN_DIR = FMLPaths.GAMEDIR.get().toFile();
    public static final File DEFAULT_CONFIG_DIR = FMLPaths.CONFIGDIR.get().toFile();
}
