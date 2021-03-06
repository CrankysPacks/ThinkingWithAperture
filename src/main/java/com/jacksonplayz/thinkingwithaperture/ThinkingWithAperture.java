package com.jacksonplayz.thinkingwithaperture;

import org.apache.logging.log4j.Logger;

import com.jacksonplayz.thinkingwithaperture.client.Tab;
import com.jacksonplayz.thinkingwithaperture.client.gui.ThinkingWithApertureGuiHandler;
import com.jacksonplayz.thinkingwithaperture.common.CommonEvents;
import com.jacksonplayz.thinkingwithaperture.init.ModEntities;
import com.jacksonplayz.thinkingwithaperture.init.RegistrationHandler;
import com.jacksonplayz.thinkingwithaperture.net.NetworkHandler;
import com.jacksonplayz.thinkingwithaperture.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = ThinkingWithAperture.MODID, name = ThinkingWithAperture.NAME, version = ThinkingWithAperture.VERSION)
public class ThinkingWithAperture
{
    public static final String MODID = "twa";
    public static final String NAME = "Thinking With Aperture";
    public static final String VERSION = "0.1";

    public static final CreativeTabs TAB = new Tab();

    @Mod.Instance
    public static ThinkingWithAperture instance;

    @SidedProxy(clientSide = "com.jacksonplayz.thinkingwithaperture.proxy.ClientProxy", serverSide = "com.jacksonplayz.thinkingwithaperture.proxy.ServerProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(new RegistrationHandler());
        MinecraftForge.EVENT_BUS.register(new CommonEvents());
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ThinkingWithApertureGuiHandler());
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModEntities.register();
        NetworkHandler.init();
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    public static Logger logger()
    {
        return logger;
    }
}
