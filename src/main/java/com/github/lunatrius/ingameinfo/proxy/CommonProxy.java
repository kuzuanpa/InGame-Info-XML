package com.github.lunatrius.ingameinfo.proxy;

import com.github.lunatrius.core.version.VersionChecker;
import com.github.lunatrius.ingameinfo.handler.ConfigurationHandler;
import com.github.lunatrius.ingameinfo.network.PacketHandler;
import com.github.lunatrius.ingameinfo.reference.Reference;
import cpw.mods.fml.common.event.*;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        Reference.logger = event.getModLog();
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        VersionChecker.registerMod(event.getModMetadata(), Reference.FORGE);
    }

    public void init(FMLInitializationEvent event) {
        PacketHandler.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    public void serverStarting(FMLServerStartingEvent event) {
    }

    public void serverStopping(FMLServerStoppingEvent event) {
    }
}
