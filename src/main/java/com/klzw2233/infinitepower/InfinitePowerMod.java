package com.klzw2233.infinitepower;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.klzw2233.infinitepower.core.ModConstants;
import com.klzw2233.infinitepower.loaders.Loader_MultiTileEntities;
import com.klzw2233.infinitepower.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(
    modid = InfinitePowerMod.MODID,
    version = Tags.VERSION,
    name = InfinitePowerMod.MODNAME,
    acceptedMinecraftVersions = "[1.7.10]")
public class InfinitePowerMod {

    public static final String MODID = "infinitepower";
    public static final String MODNAME = "Infinite Power";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = ModConstants.CLIENT_PROXY, serverSide = ModConstants.COMMON_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {

        proxy.init(event);

        new Loader_MultiTileEntities().run();
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
