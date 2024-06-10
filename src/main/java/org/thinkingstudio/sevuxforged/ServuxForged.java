package org.thinkingstudio.sevuxforged;

import fi.dy.masa.servux.Reference;
import fi.dy.masa.servux.Servux;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;

@Mod(value = Reference.MOD_ID, dist = Dist.DEDICATED_SERVER)
public class ServuxForged {
    public ServuxForged() {
        if (FMLLoader.getDist().isDedicatedServer()) {
            Servux.onInitialize();
        }
    }
}
