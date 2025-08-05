package de.ironman.mccourse.util;

import de.ironman.mccourse.MCCourseMod;
import de.ironman.mccourse.component.ModDataComponentTypes;
import de.ironman.mccourse.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "on"),
                (pStack, pLevel, pEntity, pSeed) -> pStack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1 : 0f);
    }

}
