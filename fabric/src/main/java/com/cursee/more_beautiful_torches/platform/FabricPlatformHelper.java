package com.cursee.more_beautiful_torches.platform;

import com.cursee.more_beautiful_torches.platform.services.IPlatformHelper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public String getGameDirectory() {

        return FabricLoader.getInstance().getGameDir().toString();
    }

    @Override
    public CreativeModeTab.Builder tabBuilder() {
        return FabricItemGroup.builder();
    }
}
