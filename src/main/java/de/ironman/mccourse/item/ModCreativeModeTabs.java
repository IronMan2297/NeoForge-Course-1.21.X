package de.ironman.mccourse.item;

import de.ironman.mccourse.MCCourseMod;
import de.ironman.mccourse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLACK_OPAL);
                        pOutput.accept(ModItems.RAW_BLACK_OPAL);

                        pOutput.accept(ModItems.CHAINSAW);
                        pOutput.accept(ModItems.TOMATO);
                        pOutput.accept(ModItems.FROSTFIRE_ICE);

                        pOutput.accept(ModItems.BLACK_OPAL_SWORD);
                        pOutput.accept(ModItems.BLACK_OPAL_PICKAXE);
                        pOutput.accept(ModItems.BLACK_OPAL_SHOVEL);
                        pOutput.accept(ModItems.BLACK_OPAL_AXE);
                        pOutput.accept(ModItems.BLACK_OPAL_HOE);

                        pOutput.accept(ModItems.BLACK_OPAL_PAXEL);
                        pOutput.accept(ModItems.BLACK_OPAL_HAMMER);

                        pOutput.accept(ModItems.BLACK_OPAL_HELMET);
                        pOutput.accept(ModItems.BLACK_OPAL_CHESTPLATE);
                        pOutput.accept(ModItems.BLACK_OPAL_LEGGINGS);
                        pOutput.accept(ModItems.BLACK_OPAL_BOOTS);

                        pOutput.accept(ModItems.METAL_DETECTOR);
                        pOutput.accept(ModItems.DATA_TABLET);
                        pOutput.accept(ModItems.KAUPEN_BOW);

                        pOutput.accept(ModItems.TOMATO_SEEDS);

                        pOutput.accept(ModItems.BAR_BRAWL_MUSIC_DISC);
                        pOutput.accept(ModItems.RADIATION_STAFF);

                        pOutput.accept(ModItems.PENGUIN_SPAWN_EGG);

                    }).build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "black_opal_items_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.BLACK_OPAL_BLOCK);
                        pOutput.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);

                        pOutput.accept(ModBlocks.BLACK_OPAL_ORE);
                        pOutput.accept(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE);
                        pOutput.accept(ModBlocks.NETHER_BLACK_OPAL_ORE);
                        pOutput.accept(ModBlocks.END_BLACK_OPAL_ORE);

                        pOutput.accept(ModBlocks.MAGIC_BLOCK);

                        pOutput.accept(ModBlocks.BLACK_OPAL_STAIRS);
                        pOutput.accept(ModBlocks.BLACK_OPAL_SLAB);

                        pOutput.accept(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_BUTTON);

                        pOutput.accept(ModBlocks.BLACK_OPAL_FENCE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_FENCE_GATE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_WALL);

                        pOutput.accept(ModBlocks.BLACK_OPAL_DOOR);
                        pOutput.accept(ModBlocks.BLACK_OPAL_TRAPDOOR);

                        pOutput.accept(ModBlocks.BLACK_OPAL_LAMP);

                        pOutput.accept(ModBlocks.PETUNIA);
                        pOutput.accept(ModBlocks.COLORED_LEAVES);

                        pOutput.accept(ModBlocks.PEDESTAL);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
