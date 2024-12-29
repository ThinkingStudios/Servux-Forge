package org.thinkingstudio.sevuxforged.loader;

import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.loading.moddiscovery.ModInfo;

import java.nio.file.Path;

public final class FoxifiedLoader {
    public static boolean isModLoaded(String modId) {
        return FMLLoader.getLoadingModList().getModFileById(modId) != null;
    }

    public static Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }

    public static Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static String getModVersion(String modId) {
        for(ModInfo modInfo: FMLLoader.getLoadingModList().getMods()) {
            if(modInfo.getModId().equals(modId)) {
                return modInfo.getVersion().toString();
            }
        }

        return "?";
    }
}
