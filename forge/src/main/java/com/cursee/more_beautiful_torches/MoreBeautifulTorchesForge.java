package com.cursee.more_beautiful_torches;

import com.cursee.more_beautiful_torches.core.registry.ModBlocks;
import com.cursee.more_beautiful_torches.core.registry.ModItems;
import com.cursee.more_beautiful_torches.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Mod(Constants.MOD_ID)
public class MoreBeautifulTorchesForge {

    public static BusGroup BUS_GROUP;

    public MoreBeautifulTorchesForge(final FMLJavaModLoadingContext context) {
        MoreBeautifulTorches.init();
        BUS_GROUP = context.getModBusGroup();
        if (FMLEnvironment.dist == Dist.CLIENT) new MoreBeautifulTorchesClientForge();
        ServerStartingEvent.BUS.addListener(MoreBeautifulTorchesServerForge::new);
        ServerStartedEvent.BUS.addListener(MoreBeautifulTorchesServerForge::handleServerStarted);
    }
}