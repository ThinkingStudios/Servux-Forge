package fi.dy.masa.servux;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import fi.dy.masa.servux.dataproviders.DataProviderManager;
import fi.dy.masa.servux.dataproviders.StructureDataProvider;

@Mod(Reference.MOD_ID)
public class Servux {
    public static final Logger logger = LogManager.getLogger(Reference.MOD_NAME);

    public Servux() {
        DataProviderManager.INSTANCE.registerDataProvider(StructureDataProvider.INSTANCE);
        DataProviderManager.INSTANCE.readFromConfig();
    }

    public static String getModVersionString(String modId) {
        for (ModInfo modInfo : FMLLoader.getLoadingModList().getMods()) {
            if (modInfo.getModId().equals(modId)) {
                return modInfo.getVersion().getQualifier();
            }
        }

        return "?";
    }
}
