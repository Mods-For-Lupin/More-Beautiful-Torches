package com.cursee.more_beautiful_torches;

import com.cursee.more_beautiful_torches.core.registry.ModBlocks;
import com.cursee.more_beautiful_torches.core.registry.ModItems;
import com.cursee.more_beautiful_torches.platform.Services;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MoreBeautifulTorchesModFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        MoreBeautifulTorches.init();

        ServerLifecycleEvents.SERVER_STARTING.register(MoreBeautifulTorchesServerFabric::new);
        ServerLifecycleEvents.SERVER_STARTED.register(MoreBeautifulTorchesServerFabric::handleServerStarted);
    }
}
