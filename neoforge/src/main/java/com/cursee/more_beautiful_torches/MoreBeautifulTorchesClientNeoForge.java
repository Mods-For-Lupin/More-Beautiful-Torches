package com.cursee.more_beautiful_torches;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Consumer;

public class MoreBeautifulTorchesClientNeoForge {

    public MoreBeautifulTorchesClientNeoForge() {
        MoreBeautifulTorchesClient.init();

        MoreBeautifulTorchesNeoForge.EVENT_BUS.addListener((Consumer<FMLClientSetupEvent>) event -> {
            event.enqueueWork(() -> {});
        });
    }
}
