package de.ironman.mccourse.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import de.ironman.mccourse.MCCourseMod;
import de.ironman.mccourse.entity.custom.PenguinEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel> {
    private static final Map<PenguinVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PenguinVariant.class), map -> {
                map.put(PenguinVariant.DEFAULT,
                        ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/entity/penguin/penguin.png"));
                map.put(PenguinVariant.ALBINO,
                        ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/entity/penguin/penguin_albino.png"));
                map.put(PenguinVariant.CLUB,
                        ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/entity/penguin/penguin_club.png"));
            });

    public PenguinRenderer(EntityRendererProvider.Context context) {
        super(context, new PenguinModel(context.bakeLayer(ModModelLayers.PENGUIN)),0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(PenguinEntity penguinEntity) {
        return LOCATION_BY_VARIANT.get(penguinEntity.getVariant());
    }

    @Override
    public void render(PenguinEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
