package com.github.jarva.arsmeta;

import com.github.jarva.arsmeta.registry.ModRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ArsMeta.MODID)
public class ArsMeta {
    public static final String MODID = "arsmeta";
    public static final Logger LOGGER = LogManager.getLogger();

    public ArsMeta() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        ModRegistry.registerRegistries(modbus);
        ArsNouveauRegistry.registerGlyphs();
        modbus.addListener(this::common);
        modbus.addListener(this::client);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation prefix(String path){
        return new ResourceLocation(MODID, path);
    }

    private void common(final FMLCommonSetupEvent event)
    {

    }

    private void client(final FMLClientSetupEvent event) {

    }
}
