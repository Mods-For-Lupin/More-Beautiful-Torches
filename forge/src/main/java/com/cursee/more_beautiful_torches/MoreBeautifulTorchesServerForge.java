package com.cursee.more_beautiful_torches;

import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;

public class MoreBeautifulTorchesServerForge {

    public static MoreBeautifulTorchesServerForge instance;

    public MoreBeautifulTorchesServerForge(final ServerStartingEvent event) {
        MoreBeautifulTorchesServer.init();
        instance = this;
    }

    public static void handleServerStarted(final ServerStartedEvent event) {}
}
