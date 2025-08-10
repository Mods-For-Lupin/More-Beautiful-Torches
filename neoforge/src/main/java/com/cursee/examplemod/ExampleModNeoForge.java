package com.cursee.examplemod;

import com.cursee.examplemod.platform.Services;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Constants.MOD_ID)
public class ExampleModNeoForge {

    public static IEventBus EVENT_BUS;

    public ExampleModNeoForge(final FMLModContainer container) {
        ExampleMod.init();
        EVENT_BUS = container.getEventBus();
        if (FMLEnvironment.dist == Dist.CLIENT) new ExampleModClientNeoForge();
        NeoForge.EVENT_BUS.addListener(ExampleModServerNeoForge::new);
        NeoForge.EVENT_BUS.addListener(ExampleModServerNeoForge::handleServerStarted);

        if (Services.PLATFORM.isDevelopmentEnvironment() && Items.WATER_BUCKET.craftingRemainingItem != null) {
            Constants.LOG.info(String.valueOf(Items.WATER_BUCKET.craftingRemainingItem));
        }
    }
}