package de.ironman.mccourse.datagen;

import de.ironman.mccourse.MCCourseMod;
import de.ironman.mccourse.item.ModItems;
import de.ironman.mccourse.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, MCCourseMod.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("tomato_seeds_to_short_grass",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.TOMATO_SEEDS.get()));

        this.add("tomato_seeds_to_tall_grass",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build()}, ModItems.TOMATO_SEEDS.get()));

        this.add("metal_detector_from_jungle_temple",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
                }, ModItems.METAL_DETECTOR.get()));
    }
}
