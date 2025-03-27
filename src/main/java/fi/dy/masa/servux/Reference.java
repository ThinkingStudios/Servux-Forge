package fi.dy.masa.servux;

import java.nio.file.Path;

import net.minecraft.MinecraftVersion;

import fi.dy.masa.servux.util.StringUtils;
import org.thinkingstudio.sevuxforged.loader.FoxifiedLoader;

public class Reference
{
    public static final String MOD_ID = "servux";
    public static final String MOD_NAME = "ServuxForged";
    public static final String MOD_VERSION = StringUtils.getModVersionString(MOD_ID);
    public static final String MC_VERSION = MinecraftVersion.CURRENT.getName();
    public static final String MOD_TYPE = "fabric";
    public static final String MOD_STRING = MOD_ID + "-" + MOD_TYPE + "-" + MC_VERSION + "-" + MOD_VERSION;
    public static final boolean DEV_DEBUG = false;

    public static final Path DEFAULT_RUN_DIR = FoxifiedLoader.getGameDir();
    public static final Path DEFAULT_CONFIG_DIR = FoxifiedLoader.getConfigDir();
}
