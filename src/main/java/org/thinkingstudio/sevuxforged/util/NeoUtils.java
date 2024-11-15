package org.thinkingstudio.sevuxforged.util;

import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.moddiscovery.ModInfo;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;

public class NeoUtils {
    public static ArtifactVersion getModArtifactVersion(String modId) {
        for(ModInfo modInfo: FMLLoader.getLoadingModList().getMods()) {
            if(modInfo.getModId().equals(modId)) {
                return modInfo.getVersion();
            }
        }

        return new DefaultArtifactVersion("?");
    }
}
