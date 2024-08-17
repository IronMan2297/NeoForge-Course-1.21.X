package de.ironman.mccourse.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import de.ironman.mccourse.MCCourseMod;
import de.ironman.mccourse.entity.custom.PenguinEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel> {
    public PenguinRenderer(EntityRendererProvider.Context context) {
        super(context, new PenguinModel(context.bakeLayer(ModModelLayers.PENGUIN)),0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(PenguinEntity penguinEntity) {
        return ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "textures/entity/penguin/penguin.png");
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
