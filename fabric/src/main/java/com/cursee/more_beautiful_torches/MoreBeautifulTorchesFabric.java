package com.cursee.more_beautiful_torches;

import com.cursee.more_beautiful_torches.core.registry.ModBlocks;
import com.cursee.more_beautiful_torches.core.registry.ModItems;
import com.cursee.more_beautiful_torches.core.registry.ModTabs;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class MoreBeautifulTorchesFabric implements ModInitializer {

  public static <T> void bind(Registry<T> registry,
      Consumer<BiConsumer<T, ResourceLocation>> source) {
    source.accept((t, rl) -> Registry.register(registry, rl, t));
  }

  @Override
  public void onInitialize() {

    // register all game content first
    bind(BuiltInRegistries.BLOCK, ModBlocks::register);
    bind(BuiltInRegistries.ITEM, ModItems::register);
    bind(BuiltInRegistries.CREATIVE_MODE_TAB, ModTabs::register);

    MoreBeautifulTorches.init();

    ServerLifecycleEvents.SERVER_STARTING.register(MoreBeautifulTorchesServerFabric::new);
    ServerLifecycleEvents.SERVER_STARTED.register(
        MoreBeautifulTorchesServerFabric::handleServerStarted);
  }
}
