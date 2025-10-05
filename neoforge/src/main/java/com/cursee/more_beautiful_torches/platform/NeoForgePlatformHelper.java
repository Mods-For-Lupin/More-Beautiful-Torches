package com.cursee.more_beautiful_torches.platform;

import com.cursee.more_beautiful_torches.Constants;
import com.cursee.more_beautiful_torches.platform.services.IPlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;

import java.util.concurrent.atomic.AtomicReference;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        // return !FMLLoader.isProduction();
        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public String getGameDirectory() {

        return FMLPaths.GAMEDIR.get().toString();
    }

    @Override
    public CreativeModeTab.Builder tabBuilder() {
        return CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.SPAWN_EGGS);
    }
}