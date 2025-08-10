package com.cursee.more_beautiful_torches;

import com.cursee.more_beautiful_torches.platform.Services;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Constants.MOD_ID)
public class MoreBeautifulTorchesNeoForge {

    public static IEventBus EVENT_BUS;

    public MoreBeautifulTorchesNeoForge(final FMLModContainer container) {
        MoreBeautifulTorches.init();
        EVENT_BUS = container.getEventBus();
        if (FMLEnvironment.dist == Dist.CLIENT) new MoreBeautifulTorchesClientNeoForge();
        NeoForge.EVENT_BUS.addListener(MoreBeautifulTorchesServerNeoForge::new);
        NeoForge.EVENT_BUS.addListener(MoreBeautifulTorchesServerNeoForge::handleServerStarted);

        if (Services.PLATFORM.isDevelopmentEnvironment() && Items.WATER_BUCKET.craftingRemainingItem != null) {
            Constants.LOG.info(String.valueOf(Items.WATER_BUCKET.craftingRemainingItem));
        }
    }
}