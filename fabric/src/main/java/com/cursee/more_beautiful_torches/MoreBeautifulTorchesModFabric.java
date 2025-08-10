package com.cursee.more_beautiful_torches;

import com.cursee.more_beautiful_torches.platform.Services;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.world.item.Items;

public class MoreBeautifulTorchesModFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        MoreBeautifulTorches.init();

        ServerLifecycleEvents.SERVER_STARTING.register(MoreBeautifulTorchesServerFabric::new);
        ServerLifecycleEvents.SERVER_STARTED.register(MoreBeautifulTorchesServerFabric::handleServerStarted);

        if (Services.PLATFORM.isDevelopmentEnvironment() && Items.WATER_BUCKET.craftingRemainingItem != null) {
            Constants.LOG.info(String.valueOf(Items.WATER_BUCKET.craftingRemainingItem));
        }
    }
}
