package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.more_beautiful_torches.Constants;
import com.cursee.more_beautiful_torches.MoreBeautifulTorches;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.RedstoneWallTorchBlock;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {

  public static final LinkedList<Block> REGISTERED = new LinkedList<>();

  public static void register(BiConsumer<Block, ResourceLocation> consumer) {
    List<String> lines = new ArrayList<>();
    try (InputStream input = MoreBeautifulTorches.class.getResourceAsStream("/blocks.txt")) {

      if (input == null) {
        throw new IOException("Failed to create InputStream from " + "/blocks.txt");
      }

      try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
        String line;
        while ((line = reader.readLine()) != null) {
          lines.add(line);
        }
      }
    } catch (IOException e) {
      Constants.LOG.info("Failed to load a resource: {}", e.getMessage());
    }

    lines.forEach(line -> {
      var torch = line + "_torch";
      var key1 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(torch));
      var block1 = new TorchBlock(ParticleTypes.FLAME,
          BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH).setId(key1));
      consumer.accept(block1, MoreBeautifulTorches.identifier(torch));
//            REGISTERED.put(torch, block1);

      var wallTorch = line + "_wall_torch";
      var key2 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(wallTorch));
      var block2 = new WallTorchBlock(ParticleTypes.FLAME,
          BlockBehaviour.Properties.ofFullCopy(Blocks.WALL_TORCH)
              .overrideLootTable(block1.getLootTable())
              .overrideDescription(block1.getDescriptionId()).setId(key2));
      consumer.accept(block2, MoreBeautifulTorches.identifier(wallTorch));
//            REGISTERED.put(wallTorch, block2);

      var redstoneTorch = line + "_redstone_torch";
      var key3 = ResourceKey.create(Registries.BLOCK,
          MoreBeautifulTorches.identifier(redstoneTorch));
      var block3 = new RedstoneTorchBlock(
          BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_TORCH).setId(key3));
      consumer.accept(block3, MoreBeautifulTorches.identifier(redstoneTorch));
//            REGISTERED.put(redstoneTorch, block3);

      var redstoneWallTorch = line + "_redstone_wall_torch";
      var key4 = ResourceKey.create(Registries.BLOCK,
          MoreBeautifulTorches.identifier(redstoneWallTorch));
      var block4 = new RedstoneWallTorchBlock(
          BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_WALL_TORCH)
              .overrideLootTable(block3.getLootTable())
              .overrideDescription(block3.getDescriptionId()).setId(key4));
      consumer.accept(block4, MoreBeautifulTorches.identifier(redstoneWallTorch));
//            REGISTERED.put(redstoneWallTorch, block4);

      var soulTorch = line + "_soul_torch";
      var key5 = ResourceKey.create(Registries.BLOCK, MoreBeautifulTorches.identifier(soulTorch));
      var block5 = new TorchBlock(ParticleTypes.SOUL_FIRE_FLAME,
          BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_TORCH).setId(key5));
      consumer.accept(block5, MoreBeautifulTorches.identifier(soulTorch));
//            REGISTERED.put(soulTorch, block5);

      var soulWallTorch = line + "_soul_wall_torch";
      var key6 = ResourceKey.create(Registries.BLOCK,
          MoreBeautifulTorches.identifier(soulWallTorch));
      var block6 = new WallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME,
          BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_WALL_TORCH)
              .overrideLootTable(block5.getLootTable())
              .overrideDescription(block5.getDescriptionId()).setId(key6));
      consumer.accept(block6, MoreBeautifulTorches.identifier(soulWallTorch));
//            REGISTERED.put(soulWallTorch, block6);


      REGISTERED.add(block1);
      REGISTERED.add(block2);
      REGISTERED.add(block3);
      REGISTERED.add(block4);
      REGISTERED.add(block5);
      REGISTERED.add(block6);
    });
  }
}
