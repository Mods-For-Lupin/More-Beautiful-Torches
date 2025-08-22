package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.matyrobbrt.registrationutils.RegistrationProvider;
import com.cursee.matyrobbrt.registrationutils.RegistryObject;
import com.cursee.more_beautiful_torches.Constants;
import com.cursee.more_beautiful_torches.platform.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public class ModTabs {

    public static final RegistrationProvider<CreativeModeTab> TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final RegistryObject<CreativeModeTab, CreativeModeTab> MBT_TAB = register(Constants.MOD_ID, () -> Services.PLATFORM.tabBuilder()
            .icon(() -> new ItemStack(getItemLikeFromMod()))
            .title(Component.translatable("itemGroup.moreBeautifulTorches"))
            .displayItems((itemDisplayParameters, output) -> {
//                ModItems.ITEMS.getEntries().forEach(obj -> {
//                    output.accept(obj.get());
//                });
                ModItems.REGISTERED.forEach(obj -> {
                    output.accept(obj.get());
                });
            })
            .build());

    public static void declare() {}

    public static RegistryObject<CreativeModeTab, CreativeModeTab> register(String name, Supplier<CreativeModeTab> supplier) {
        return TABS.register(name, supplier);
    }

    public static ItemLike getItemLikeFromMod() {

        return ModItems.REGISTERED.getFirst().get();

//        var it = ModItems.REGISTERED.iterator();
//
//        if (it.hasNext()) return it.next().get();
//
//        return Items.TORCH; // default to a torch if registration gets screwy
    }
}
