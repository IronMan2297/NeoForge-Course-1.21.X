package de.ironman.mccourse.item.custom;

import de.ironman.mccourse.component.ModDataComponentTypes;
import de.ironman.mccourse.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

public class ChainsawItem extends Item {
    public ChainsawItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();

        if(!level.isClientSide()) {
            if(level.getBlockState(pContext.getClickedPos()).is(BlockTags.LOGS)) {
                level.destroyBlock(pContext.getClickedPos(), true, pContext.getPlayer());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());

                pContext.getLevel().playSound(null, pContext.getPlayer(), ModSounds.CHAINSAW_CUT.get(),
                        SoundSource.PLAYERS, 1f, 1f);

                // Server Particles (Via Server, Seen by all Players)
                ((ServerLevel) pContext.getLevel()).sendParticles(ParticleTypes.SMOKE, pContext.getClickedPos().getX() + 0.5f, pContext.getClickedPos().getY() + 1.0f,
                        pContext.getClickedPos().getZ() + 0.05f, 25, 0.0, 0.05, 0.0, 0.15f);
            } else {
                pContext.getLevel().playSound(null, pContext.getPlayer(), ModSounds.CHAINSAW_PULL.get(),
                        SoundSource.PLAYERS, 1f, 1f);
            }
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.mccourse.chainsaw.tooltip.1"));
            tooltipComponents.add(Component.translatable("tooltip.mccourse.chainsaw.tooltip.2"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.mccourse.chainsaw.tooltip.shift"));
        }

        if(stack.get(ModDataComponentTypes.COORDINATES.get()) != null) {
            tooltipComponents.add(Component.literal("Last Tree was chopped at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
