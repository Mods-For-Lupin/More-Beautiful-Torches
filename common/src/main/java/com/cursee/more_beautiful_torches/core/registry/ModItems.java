package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.matyrobbrt.registrationutils.RegistrationProvider;
import com.cursee.matyrobbrt.registrationutils.RegistryObject;
import com.cursee.monolib.platform.Services;
import com.cursee.more_beautiful_torches.Constants;
import com.cursee.more_beautiful_torches.MoreBeautifulTorches;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ModItems {

    public static final LinkedList<RegistryObject<Item, Item>> REGISTERED = new LinkedList<>();

    public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MOD_ID);

    public static RegistryObject<Item, Item> register(String name, Supplier<Item> supplier) {
        var block = ITEMS.register(name, supplier);
        REGISTERED.add(block);
        return block;
    }

//    public static void register(BiConsumer<Item, ResourceLocation> consumer) {
//        var it = ModBlocks.REGISTERED.entrySet().iterator();
//
//        while (it.hasNext()) {
//
//            var b1 = it.next();
//            var b2 = it.next();
//
//            consumer.accept(new StandingAndWallBlockItem(b1.getValue(), b2.getValue(), Direction.DOWN, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, b1.getKey()))), b1.getKey());
//        }
//    }

    public static void declare() {
        // var it = ModBlocks.BLOCKS.getEntries().iterator();
        var it = ModBlocks.REGISTERED.iterator();

        while (it.hasNext()) {

            var b1 = it.next();
            var b2 = it.next();

            // System.out.println(b1.getId().toString());

            register(b1.getId().getPath(), () -> new StandingAndWallBlockItem(b1.get(), b2.get(), Direction.DOWN, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, b1.getId()))));
        }
    }
}
