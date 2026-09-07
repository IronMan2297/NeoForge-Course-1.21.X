package de.ironman.mccourse.event;

import de.ironman.mccourse.MCCourseMod;
import de.ironman.mccourse.block.entity.ModBlockEntities;
import de.ironman.mccourse.block.entity.custom.CrystallizerBlockEntity;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModBlockEntities.CRYSTALLIZER_BE.get(), CrystallizerBlockEntity::getItemHandler);
    }
}
