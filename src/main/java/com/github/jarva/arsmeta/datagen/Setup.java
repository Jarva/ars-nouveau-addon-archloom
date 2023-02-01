package com.github.jarva.arsmeta.datagen;

import com.github.jarva.arsmeta.ArsMeta;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.jarva.arsmeta.ArsMeta.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Setup {

    //use runData configuration to generate stuff, event.includeServer() for data, event.includeClient() for assets
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        gen.addProvider(event.includeServer(), new ArsProviders.ImbuementProvider(gen));
        gen.addProvider(event.includeServer(), new ArsProviders.GlyphProvider(gen));
        gen.addProvider(event.includeServer(), new ArsProviders.EnchantingAppProvider(gen));

        gen.addProvider(event.includeServer(), new ArsProviders.PatchouliProvider(gen));
    }

}