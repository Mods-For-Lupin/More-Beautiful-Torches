package com.cursee.more_beautiful_torches;

import net.minecraft.server.MinecraftServer;

public class MoreBeautifulTorchesServerFabric {

    public static MoreBeautifulTorchesServerFabric instance;

    public MoreBeautifulTorchesServerFabric(final MinecraftServer server) {
        MoreBeautifulTorchesServer.init();
        instance = this;
    }

    public static void handleServerStarted(final MinecraftServer server) {}
}
