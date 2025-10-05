package com.cursee.more_beautiful_torches.core.registry;

import java.util.LinkedList;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;

import java.util.function.BiConsumer;
import net.minecraft.world.level.block.Block;

public class ModItems {

    public static final LinkedList<Item> REGISTERED = new LinkedList<>();

    public static void register(BiConsumer<Item, ResourceLocation> consumer) {
        var it = ModBlocks.REGISTERED.iterator();

        while (it.hasNext()) {

            var b1 = it.next();
            var b2 = it.next();

            var item = new StandingAndWallBlockItem(b1, b2, Direction.DOWN, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, BuiltInRegistries.BLOCK.getKey(b1))));
            consumer.accept(item, BuiltInRegistries.BLOCK.getKey(b1));
            REGISTERED.add(item);
        }
    }
}
