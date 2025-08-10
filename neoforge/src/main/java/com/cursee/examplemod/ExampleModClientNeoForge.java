package com.cursee.examplemod;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Consumer;

public class ExampleModClientNeoForge {

    public ExampleModClientNeoForge() {
        ExampleModClient.init();

        ExampleModNeoForge.EVENT_BUS.addListener((Consumer<FMLClientSetupEvent>) event -> {
            event.enqueueWork(() -> {});
        });
    }
}
