package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.monolib.core.registry.DeferredRegistryObject;
import com.cursee.monolib.platform.Services;
import com.cursee.more_beautiful_torches.Constants;
import com.cursee.more_beautiful_torches.MoreBeautifulTorches;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {

    public static final Map<String, DeferredRegistryObject<Block>> REGISTERED = new HashMap<>();

    public static void declare() {
        try (InputStream input = MoreBeautifulTorches.class.getResourceAsStream("/blocks.txt")) {

            if (input == null) {

                throw new IllegalStateException("Resource not found: blocks.txt");
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    // acacia_log
                    var key = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(line));
                    var block = register(line, () -> new Block(BlockBehaviour.Properties.of().setId(key)));
                    REGISTERED.put(line, block);

                    // acacia_log_redstone
                    var line1 = line + "_redstone";
                    var key1 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(line1));
                    var block1 = register(line1, () -> new Block(BlockBehaviour.Properties.of().setId(key1)));
                    REGISTERED.put(line1, block1);

                    // acacia_log_soul
                    var line2 = line + "_soul";
                    var key2 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(line2));
                    var block2 = register(line2, () -> new Block(BlockBehaviour.Properties.of().setId(key2)));
                    REGISTERED.put(line2, block2);
                }
            }
        }
        catch (IOException e) {
            Constants.LOG.info("Failed to load a resource: {}", e.getMessage());
        }
    }

    public static DeferredRegistryObject<Block> register(String name, Supplier<Block> supplier) {
        // acacia_log_torch
        // acacia_log_redstone_torch
        // acacia_log_soul_torch

        name = name + "_torch";
        if (Services.PLATFORM.isDevelopmentEnvironment()) Constants.LOG.info("Registering Block with ID: {}", name);
        return Services.PLATFORM.register(BuiltInRegistries.BLOCK, Constants.MOD_ID, name, supplier);
    }
}
