package com.cursee.more_beautiful_torches;

import com.cursee.more_beautiful_torches.core.registry.ModBlocks;
import com.cursee.more_beautiful_torches.core.registry.ModItems;
import com.cursee.more_beautiful_torches.core.registry.ModTabs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
public class MoreBeautifulTorchesNeoForge {

    public static IEventBus modEventBus;

    public MoreBeautifulTorchesNeoForge(final FMLModContainer container) {

        // register all game content first
        bind(Registries.BLOCK, ModBlocks::register);
        bind(Registries.ITEM, ModItems::register);
        bind(Registries.CREATIVE_MODE_TAB, ModTabs::register);

        modEventBus = container.getEventBus();
        MoreBeautifulTorches.init();
        if (FMLEnvironment.getDist() == Dist.CLIENT) new MoreBeautifulTorchesClientNeoForge();
        NeoForge.EVENT_BUS.addListener(MoreBeautifulTorchesServerNeoForge::new);
        NeoForge.EVENT_BUS.addListener(MoreBeautifulTorchesServerNeoForge::handleServerStarted);
    }

    public static <T> void bind(ResourceKey<Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source) {
        modEventBus.addListener((Consumer<RegisterEvent>) event -> {
            if (registry.equals(event.getRegistryKey())) {
                source.accept((t, rl) -> event.register(registry, rl, () -> t));
            }
        });
    }
}