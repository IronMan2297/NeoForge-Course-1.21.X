package de.ironman.mccourse.worldgen.tree;

import de.ironman.mccourse.MCCourseMod;
import de.ironman.mccourse.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower EBONY = new TreeGrower(MCCourseMod.MOD_ID + ":ebony",
            Optional.empty(), Optional.of(ModConfiguredFeatures.EBONY_KEY), Optional.empty());
}
