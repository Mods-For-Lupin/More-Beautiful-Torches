package com.cursee.examplemod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ExampleModClientForge {

    public ExampleModClientForge() {
        ExampleModClient.init();

        FMLClientSetupEvent.getBus(ExampleModForge.BUS_GROUP).addListener(event -> {
            event.enqueueWork(() -> {});
        });
    }
}
