package com.cursee.examplemod;

import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

public class ExampleModServerNeoForge {

    public static ExampleModServerNeoForge instance;

    public ExampleModServerNeoForge(final ServerStartingEvent event) {
        ExampleModServer.init();
        instance = this;
    }

    public static void handleServerStarted(final ServerStartedEvent event) {}
}
