package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.matyrobbrt.registrationutils.RegistrationProvider;
import com.cursee.matyrobbrt.registrationutils.RegistryObject;
import com.cursee.monolib.platform.Services;
import com.cursee.more_beautiful_torches.Constants;
import com.cursee.more_beautiful_torches.MoreBeautifulTorches;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModBlocks {

    public static final LinkedList<RegistryObject<Block, Block>> REGISTERED = new LinkedList<>();

    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, Constants.MOD_ID);

    public static RegistryObject<Block, Block> register(String name, Supplier<Block> supplier) {
        var block = BLOCKS.register(name, supplier);
        REGISTERED.add(block);
        return block;
    }

    public static void declare() {
        List<String> lines = new ArrayList<>();
        try (InputStream input = MoreBeautifulTorches.class.getResourceAsStream("/blocks.txt")) {

            if (input == null) throw new IOException("Failed to create InputStream from " + "/blocks.txt");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        }
        catch (IOException e) {
            Constants.LOG.info("Failed to load a resource: {}", e.getMessage());
        }

        lines.forEach(line -> {
            var torch = line + "_torch";
            var key1 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(torch));
            var block1 = register(torch, () -> new TorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).setId(key1)));
//            REGISTERED.put(torch, block1);

            var wallTorch = line + "_wall_torch";
            var key2 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(wallTorch));
            var block2 = register(wallTorch, () -> new WallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).overrideLootTable(block1.get().getLootTable()).overrideDescription(block1.get().getDescriptionId()).setId(key2)));
//            REGISTERED.put(wallTorch, block2);

            var redstoneTorch = line + "_redstone_torch";
            var key3 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(redstoneTorch));
            var block3 = register(redstoneTorch, () -> new RedstoneTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_TORCH).setId(key3)));
//            REGISTERED.put(redstoneTorch, block3);

            var redstoneWallTorch = line + "_redstone_wall_torch";
            var key4 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(redstoneWallTorch));
            var block4 = register(redstoneWallTorch, () -> new RedstoneWallTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WALL_TORCH).overrideLootTable(block3.get().getLootTable()).overrideDescription(block3.get().getDescriptionId()).setId(key4)));
//            REGISTERED.put(redstoneWallTorch, block4);

            var soulTorch = line + "_soul_torch";
            var key5 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(soulTorch));
            var block5 = register(soulTorch, () -> new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_TORCH).setId(key5)));
//            REGISTERED.put(soulTorch, block5);

            var soulWallTorch = line + "_soul_wall_torch";
            var key6 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(soulWallTorch));
            var block6 = register(soulWallTorch, () -> new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_WALL_TORCH).overrideLootTable(block5.get().getLootTable()).overrideDescription(block5.get().getDescriptionId()).setId(key6)));
//            REGISTERED.put(soulWallTorch, block6);
        });
    }

//    public static final Map<ResourceLocation, Block> REGISTERED = new LinkedHashMap<>();
//
//    public static void register(BiConsumer<Block, ResourceLocation> consumer) {
//
//        List<String> lines = new ArrayList<>();
//        try (InputStream input = MoreBeautifulTorches.class.getResourceAsStream("/blocks.txt")) {
//
//            if (input == null) throw new IOException("Failed to create InputStream from " + "/blocks.txt");
//
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    lines.add(line);
//                }
//            }
//        }
//        catch (IOException e) {
//            Constants.LOG.info("Failed to load a resource: {}", e.getMessage());
//        }
//
//        lines.forEach(line -> {
//
//            var torchRL = MoreBeautifulTorches.identifier(line + "_torch");
//            var torchBlock = new TorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).setId(ResourceKey.create(Registries.BLOCK, torchRL)));
//            register(torchRL, torchBlock, consumer);
//
//            var wallTorchRL = MoreBeautifulTorches.identifier(line + "_wall_torch");
//            var wallTorchBlock = new WallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).setId(ResourceKey.create(Registries.BLOCK, wallTorchRL)));
//            register(wallTorchRL, wallTorchBlock, consumer);
//            // REGISTERED.put(torchRL, torchBlock);
//            // consumer.accept(torchRL, torchBlock);
//        });
//    }
//
//    public static void register(ResourceLocation rl, Block block, BiConsumer<Block, ResourceLocation> consumer) {
//        REGISTERED.put(rl, block);
//        consumer.accept(block, rl);
//
//    }

    // public static final Map<String, DeferredRegistryObject<Block>> REGISTERED = new LinkedHashMap<>();

//    public static final String line = "acacia_log";
//
//    public static final String torch = line + "_torch";
//    public static final ResourceKey<Block> key1 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(torch));
//    public static final DeferredRegistryObject<Block> block1 = register(torch, () -> new TorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).setId(key1)));
//
//    public static final String wallTorch = line + "_wall_torch";
//    public static final ResourceKey<Block> key2 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(wallTorch));
//    public static final DeferredRegistryObject<Block> block2 = register(wallTorch, () -> new WallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).overrideLootTable(block1.get().getLootTable()).overrideDescription(block1.get().getDescriptionId()).setId(key2)));
//
//
//
//    public static void declare() {
////        try (InputStream input = MoreBeautifulTorches.class.getResourceAsStream("/blocks.txt")) {
////
////            if (input == null) {
////                throw new IllegalStateException("Resource not found: blocks.txt");
////            }
////
////            try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
////                String line;
////                while ((line = reader.readLine()) != null) {
////
////                    var torch = line + "_torch";
////                    var key1 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(torch));
////                    var block1 = register(torch, () -> new TorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).setId(key1)));
////                    REGISTERED.put(torch, block1);
////
////                    var wallTorch = line + "_wall_torch";
////                    var key2 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(wallTorch));
////                    var block2 = register(wallTorch, () -> new WallTorchBlock(ParticleTypes.FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH).overrideLootTable(block1.get().getLootTable()).overrideDescription(block1.get().getDescriptionId()).setId(key2)));
////                    REGISTERED.put(wallTorch, block2);
////
////                    var redstoneTorch = line + "_redstone_torch";
////                    var key3 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(redstoneTorch));
////                    var block3 = register(redstoneTorch, () -> new RedstoneTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_TORCH).setId(key3)));
////                    REGISTERED.put(redstoneTorch, block3);
////
////                    var redstoneWallTorch = line + "_redstone_wall_torch";
////                    var key4 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(redstoneWallTorch));
////                    var block4 = register(redstoneWallTorch, () -> new RedstoneWallTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WALL_TORCH).overrideLootTable(block3.get().getLootTable()).overrideDescription(block3.get().getDescriptionId()).setId(key4)));
////                    REGISTERED.put(redstoneWallTorch, block4);
////
////                    var soulTorch = line + "_soul_torch";
////                    var key5 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(soulTorch));
////                    var block5 = register(soulTorch, () -> new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_TORCH).setId(key5)));
////                    REGISTERED.put(soulTorch, block5);
////
////                    var soulWallTorch = line + "_soul_wall_torch";
////                    var key6 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(soulWallTorch));
////                    var block6 = register(soulWallTorch, () -> new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME, BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_WALL_TORCH).overrideLootTable(block5.get().getLootTable()).overrideDescription(block5.get().getDescriptionId()).setId(key6)));
////                    REGISTERED.put(soulWallTorch, block6);
////                }
////            }
////        }
////        catch (IOException e) {
////            Constants.LOG.info("Failed to load a resource: {}", e.getMessage());
////        }
//    }
//
//    public static DeferredRegistryObject<Block> register(String name, Supplier<Block> supplier) {
//
//        if (Services.PLATFORM.isDevelopmentEnvironment()) Constants.LOG.info("Registering Block with ID: {}", name);
//
//        return Services.PLATFORM.register(BuiltInRegistries.BLOCK, Constants.MOD_ID, name, supplier);
//    }
}
