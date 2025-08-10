package com.cursee.examplemod;

import net.minecraft.server.MinecraftServer;

public class ExampleModServerFabric {

    public static ExampleModServerFabric instance;

    public ExampleModServerFabric(final MinecraftServer server) {
        ExampleModServer.init();
        instance = this;
    }

    public static void handleServerStarted(final MinecraftServer server) {}
}
