package com.cursee.more_beautiful_torches;

import com.cursee.more_beautiful_torches.platform.Services;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Constants.MOD_ID)
public class MoreBeautifulTorchesForge {

    public static BusGroup BUS_GROUP;

    public MoreBeautifulTorchesForge(final FMLJavaModLoadingContext context) {
        MoreBeautifulTorches.init();
        BUS_GROUP = context.getModBusGroup();
        if (FMLEnvironment.dist == Dist.CLIENT) new MoreBeautifulTorchesClientForge();
        ServerStartingEvent.BUS.addListener(MoreBeautifulTorchesServerForge::new);
        ServerStartedEvent.BUS.addListener(MoreBeautifulTorchesServerForge::handleServerStarted);

        if (Services.PLATFORM.isDevelopmentEnvironment() && Items.WATER_BUCKET.craftingRemainingItem != null) {
            Constants.LOG.info(String.valueOf(Items.WATER_BUCKET.craftingRemainingItem));
        }
    }
}