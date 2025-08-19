package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.monolib.core.registry.DeferredRegistryObject;
import com.cursee.monolib.platform.Services;
import com.cursee.more_beautiful_torches.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModTabs {

    public static final DeferredRegistryObject<CreativeModeTab> MBT_TAB = register(Constants.MOD_ID, () -> com.cursee.more_beautiful_torches.platform.Services.PLATFORM.tabBuilder()
            .icon(() -> new ItemStack(ModBlocks.REGISTERED.get("acacia_log_torch").get()))
            .title(Component.translatable("itemGroup.moreBeautifulTorches"))
            .displayItems((itemDisplayParameters, output) -> {
                ModItems.REGISTERED.forEach((s, o) -> output.accept(o.get()));
            })
            .build());

    public static void declare() {}

    public static DeferredRegistryObject<CreativeModeTab> register(String name, Supplier<CreativeModeTab> supplier) {
        return Services.PLATFORM.register(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.MOD_ID, name, supplier);
    }
}
