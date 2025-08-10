package com.cursee.examplemod;

import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;

public class ExampleModServerForge {

    public static ExampleModServerForge instance;

    public ExampleModServerForge(final ServerStartingEvent event) {
        ExampleModServer.init();
        instance = this;
    }

    public static void handleServerStarted(final ServerStartedEvent event) {}
}
