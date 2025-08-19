package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.monolib.core.registry.DeferredRegistryObject;
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
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {

    public static final Map<String, DeferredRegistryObject<Item>> REGISTERED = new LinkedHashMap<>();

    public static void declare() {

        Iterator<Map.Entry<String, DeferredRegistryObject<Block>>> it = ModBlocks.REGISTERED.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, DeferredRegistryObject<Block>> torch = it.next();
            Map.Entry<String, DeferredRegistryObject<Block>> wallTorch = it.next();

            // String s = BuiltInRegistries.BLOCK.getKey(torch.getValue().get()).getPath();


            String s = torch.getKey();

            var key = ResourceKey.create(Registries.ITEM, MoreBeautifulTorches.identifier(s));
            DeferredRegistryObject<Item> torchItem = register(s, () -> new StandingAndWallBlockItem(torch.getValue().get(), wallTorch.getValue().get(), Direction.DOWN, new Item.Properties().setId(key)));
            REGISTERED.put(s, torchItem);
        }
    }

    public static DeferredRegistryObject<Item> register(String name, Supplier<Item> supplier) {
        return Services.PLATFORM.register(BuiltInRegistries.ITEM, Constants.MOD_ID, name, supplier);
    }
}
