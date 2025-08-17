package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.more_beautiful_torches.Constants;
import com.cursee.monolib.core.registry.DeferredRegistryObject;
import com.cursee.monolib.platform.Services;
import com.cursee.more_beautiful_torches.core.world.item.CustomItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModItems {

    // public static final DeferredRegistryObject<Item> CUSTOM = registerItem("custom", CustomItem::new, new Item.Properties().stacksTo(1));
    public static final DeferredRegistryObject<Item> CUSTOM;

    private static Function<Item.Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return (properties) -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

    private static ResourceKey<Item> modItemID(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }

    private static ResourceKey<Item> blockIdToItemId(ResourceKey<Block> blockId) {
        return ResourceKey.create(Registries.ITEM, blockId.location());
    }

    public static DeferredRegistryObject<Item> registerBlock(Block block) {
        return registerBlock(block, BlockItem::new);
    }

    public static DeferredRegistryObject<Item> registerBlock(Block block, Item.Properties properties) {
        return registerBlock(block, BlockItem::new, properties);
    }

    public static DeferredRegistryObject<Item> registerBlock(Block block, UnaryOperator<Item.Properties> propertiesModifier) {
        return registerBlock(block, ((suppliedBlock, properties) -> new BlockItem(suppliedBlock, propertiesModifier.apply(properties))));
    }

    public static DeferredRegistryObject<Item> registerBlock(Block p_block, Block... others) {
        DeferredRegistryObject<Item> item = registerBlock(p_block);

        for(Block block : others) {
            Item.BY_BLOCK.put(block, item.get());
        }

        return item;
    }

    public static DeferredRegistryObject<Item> registerBlock(Block block, BiFunction<Block, Item.Properties, Item> factory) {
        return registerBlock(block, factory, new Item.Properties());
    }

    @SuppressWarnings("deprecation")
    public static DeferredRegistryObject<Item> registerBlock(Block block, BiFunction<Block, Item.Properties, Item> factory, Item.Properties properties) {
        return registerItem(blockIdToItemId(block.builtInRegistryHolder().key()), (p_370785_) -> factory.apply(block, p_370785_), properties.useBlockDescriptionPrefix());
    }

    public static DeferredRegistryObject<Item> registerItem(String name, Function<Item.Properties, Item> factory) {
        return registerItem(modItemID(name), factory, new Item.Properties());
    }

    public static DeferredRegistryObject<Item> registerItem(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
        return registerItem(modItemID(name), factory, properties);
    }

    public static DeferredRegistryObject<Item> registerItem(String name, Item.Properties properties) {
        return registerItem(modItemID(name), Item::new, properties);
    }

    public static DeferredRegistryObject<Item> registerItem(String name) {
        return registerItem(modItemID(name), Item::new, new Item.Properties());
    }

    public static DeferredRegistryObject<Item> registerItem(ResourceKey<Item> key, Function<Item.Properties, Item> factory) {
        return registerItem(key, factory, new Item.Properties());
    }

    public static DeferredRegistryObject<Item> registerItem(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties properties) {
        return Services.PLATFORM.register(BuiltInRegistries.ITEM, Constants.MOD_ID, key.location().getPath(), () -> factory.apply(properties.setId(key)));
    }

    public static void declare() {}

    static {
        CUSTOM = registerItem("custom", CustomItem::new, new Item.Properties().stacksTo(1));
    }
}
