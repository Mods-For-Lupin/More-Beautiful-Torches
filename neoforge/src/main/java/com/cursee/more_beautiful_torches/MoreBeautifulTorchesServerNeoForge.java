package com.cursee.more_beautiful_torches;

import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

public class MoreBeautifulTorchesServerNeoForge {

    public static MoreBeautifulTorchesServerNeoForge instance;

    public MoreBeautifulTorchesServerNeoForge(final ServerStartingEvent event) {
        MoreBeautifulTorchesServer.init();
        instance = this;
    }

    public static void handleServerStarted(final ServerStartedEvent event) {}
}
