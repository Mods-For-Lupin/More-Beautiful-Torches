package com.cursee.more_beautiful_torches;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MoreBeautifulTorchesClientForge {

    public MoreBeautifulTorchesClientForge() {
        MoreBeautifulTorchesClient.init();

        FMLClientSetupEvent.getBus(MoreBeautifulTorchesForge.BUS_GROUP).addListener(event -> {
            event.enqueueWork(() -> {});
        });
    }
}
