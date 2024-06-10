package fi.dy.masa.servux.util;

import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.moddiscovery.ModInfo;

public class StringUtils
{
    public static String getModVersionString(String modId) {
        for(ModInfo modInfo: FMLLoader.getLoadingModList().getMods()) {
            if(modInfo.getModId().equals(modId)) {
                return modInfo.getVersion().toString();
            }
        }

        return "?";
    }
}
