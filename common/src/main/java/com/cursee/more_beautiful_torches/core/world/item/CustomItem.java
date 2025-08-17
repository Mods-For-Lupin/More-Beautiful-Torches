package com.cursee.more_beautiful_torches.core.world.item;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class CustomItem extends Item {

    public CustomItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if (level.isClientSide()) {
            ((LocalPlayer) player).displayClientMessage(Component.literal("used custom item without failure"), false);
        }

        return super.use(level, player, hand);
    }
}
