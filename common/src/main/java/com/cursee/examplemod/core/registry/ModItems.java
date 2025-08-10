package com.cursee.examplemod.core.registry;

import com.cursee.examplemod.Constants;
import com.cursee.examplemod.ExampleMod;
import com.cursee.monolib.core.registry.DeferredRegistryObject;
import com.cursee.monolib.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegistryObject<Item> TEST_ITEM = register("test_item", () -> new Item(new Item.Properties().setId(resourceKey("test_item"))));
    public static final DeferredRegistryObject<Item> ALTERNATE_ITEM = register("alternate_item", () -> new Item(new Item.Properties().setId(resourceKey("alternate_item"))));

    public static void declare() {}

    public static DeferredRegistryObject<Item> register(String name, Supplier<Item> supplier) {
        return Services.PLATFORM.register(
                BuiltInRegistries.ITEM, Constants.MOD_ID, name, supplier
        );
    }

    private static ResourceKey<Item> resourceKey(String name) {
        return ResourceKey.create(BuiltInRegistries.ITEM.key(), ExampleMod.identifier(name));
    }
}
