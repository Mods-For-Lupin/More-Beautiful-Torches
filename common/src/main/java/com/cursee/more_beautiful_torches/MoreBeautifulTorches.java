package com.cursee.more_beautiful_torches;

import com.cursee.monolib.api.common.sailing.SailingApi;
import net.minecraft.resources.ResourceLocation;

public class MoreBeautifulTorches {

  public static void init() {
    SailingApi.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION,
        Constants.MOD_PUBLISHER, Constants.MOD_URL);
  }

  public static ResourceLocation identifier(String path) {
    return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
  }
}