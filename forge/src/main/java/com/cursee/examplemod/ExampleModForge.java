package com.cursee.examplemod;

import com.cursee.examplemod.platform.Services;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Constants.MOD_ID)
public class ExampleModForge {

    public static BusGroup BUS_GROUP;

    public ExampleModForge(final FMLJavaModLoadingContext context) {
        ExampleMod.init();
        BUS_GROUP = context.getModBusGroup();
        if (FMLEnvironment.dist == Dist.CLIENT) new ExampleModClientForge();
        ServerStartingEvent.BUS.addListener(ExampleModServerForge::new);
        ServerStartedEvent.BUS.addListener(ExampleModServerForge::handleServerStarted);

        if (Services.PLATFORM.isDevelopmentEnvironment() && Items.WATER_BUCKET.craftingRemainingItem != null) {
            Constants.LOG.info(String.valueOf(Items.WATER_BUCKET.craftingRemainingItem));
        }
    }
}