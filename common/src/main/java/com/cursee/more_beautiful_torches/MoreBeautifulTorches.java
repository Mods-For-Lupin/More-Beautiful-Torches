package com.cursee.more_beautiful_torches;

import com.cursee.more_beautiful_torches.core.registry.ModRegistration;
import com.cursee.monolib.core.sailing.Sailing;
import net.minecraft.resources.ResourceLocation;

public class MoreBeautifulTorches {

    public static void init() {
        Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION, Constants.MOD_PUBLISHER, Constants.MOD_URL);
        ModRegistration.declareAll();
    }

    public static ResourceLocation identifier(String path) {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
    }
}