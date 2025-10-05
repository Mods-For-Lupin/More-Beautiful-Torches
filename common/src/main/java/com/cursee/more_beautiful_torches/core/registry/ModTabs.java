package com.cursee.more_beautiful_torches.core.registry;

import com.cursee.more_beautiful_torches.Constants;
import com.cursee.more_beautiful_torches.MoreBeautifulTorches;
import com.cursee.more_beautiful_torches.platform.Services;
import java.util.function.BiConsumer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {

//    public static final RegistrationProvider<CreativeModeTab> TABS = RegistrationProvider.get(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);
//
//    public static final RegistryObject<CreativeModeTab, CreativeModeTab> MBT_TAB = register(Constants.MOD_ID, () -> Services.PLATFORM.tabBuilder()
//            .icon(() -> new ItemStack(getItemLikeFromMod()))
//            .title(Component.translatable("itemGroup.moreBeautifulTorches"))
//            .displayItems((itemDisplayParameters, output) -> {
////                ModItems.ITEMS.getEntries().forEach(obj -> {
////                    output.accept(obj.get());
////                });
//                ModItems.REGISTERED.forEach(obj -> {
//                    output.accept(obj.get());
//                });
//            })
//            .build());
//
//    public static void declare() {}
//
//    public static RegistryObject<CreativeModeTab, CreativeModeTab> register(String name, Supplier<CreativeModeTab> supplier) {
//        return TABS.register(name, supplier);
//    }
//
//    public static ItemLike getItemLikeFromMod() {
//
//        return ModItems.REGISTERED.getFirst().get();
//    }

  public static final CreativeModeTab MBT_TAB = Services.PLATFORM.tabBuilder()
            .icon(() -> new ItemStack(ModBlocks.REGISTERED.getFirst()))
            .title(Component.translatable("itemGroup.moreBeautifulTorches"))
            .displayItems((itemDisplayParameters, output) -> {
                ModItems.REGISTERED.forEach(output::accept);
            })
            .build();

  public static void register(BiConsumer<CreativeModeTab, ResourceLocation> consumer) {
    consumer.accept(MBT_TAB, MoreBeautifulTorches.identifier(Constants.MOD_ID));
  }
}
