package de.ironman.mccourse.datagen;

import de.ironman.mccourse.MCCourseMod;
import de.ironman.mccourse.block.ModBlocks;
import de.ironman.mccourse.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLACK_OPAL_BLOCK.get())
                .add(ModBlocks.RAW_BLACK_OPAL_BLOCK.get())
                .add(ModBlocks.BLACK_OPAL_ORE.get())
                .add(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get())
                .add(ModBlocks.NETHER_BLACK_OPAL_ORE.get())
                .add(ModBlocks.END_BLACK_OPAL_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLACK_OPAL_ORE.get())
                .add(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_BLACK_OPAL_ORE.get())
                .add(ModBlocks.END_BLACK_OPAL_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.BLACK_OPAL_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BLACK_OPAL_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BLACK_OPAL_WALL.get());
        tag(ModTags.Blocks.NEEDS_BLACK_OPAL_TOOL).addTag(BlockTags.NEEDS_IRON_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_BLACK_OPAL_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL).remove(ModTags.Blocks.NEEDS_BLACK_OPAL_TOOL);

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EBONY_LOG.get())
                .add(ModBlocks.EBONY_WOOD.get())
                .add(ModBlocks.STRIPPED_EBONY_LOG.get())
                .add(ModBlocks.STRIPPED_EBONY_WOOD.get());
    }
}
