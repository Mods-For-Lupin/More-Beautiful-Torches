package com.cursee.examplemod;

import com.cursee.examplemod.platform.Services;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.world.item.Items;

public class ExampleModFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ExampleMod.init();

        ServerLifecycleEvents.SERVER_STARTING.register(ExampleModServerFabric::new);
        ServerLifecycleEvents.SERVER_STARTED.register(ExampleModServerFabric::handleServerStarted);

        if (Services.PLATFORM.isDevelopmentEnvironment() && Items.WATER_BUCKET.craftingRemainingItem != null) {
            Constants.LOG.info(String.valueOf(Items.WATER_BUCKET.craftingRemainingItem));
        }
    }
}
