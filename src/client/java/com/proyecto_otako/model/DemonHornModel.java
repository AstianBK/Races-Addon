package com.proyecto_otako.model;

import fabric.net.mca.entity.VillagerEntityMCA;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class DemonHornModel extends EntityModel<VillagerEntityMCA> {
	public final ModelPart head;
	public DemonHornModel(ModelPart root) {
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Horn4_r1 = Head.addChild("Horn4_r1", ModelPartBuilder.create().uv(35, 1).mirrored().cuboid(-1.0F, -2.95F, -1.3F, 2.0F, 4.0F, 2.0F, new Dilation(-0.35F)).mirrored(false)
		.uv(35, 1).cuboid(-7.0F, -2.95F, -1.3F, 2.0F, 4.0F, 2.0F, new Dilation(-0.35F)), ModelTransform.of(3.0F, -9.1502F, -5.0356F, 0.1745F, 0.0F, 0.0F));

		ModelPartData Horn3_r1 = Head.addChild("Horn3_r1", ModelPartBuilder.create().uv(26, 2).mirrored().cuboid(-1.0F, -2.55F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(-0.15F)).mirrored(false)
		.uv(26, 2).cuboid(-7.0F, -2.55F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(-0.15F)), ModelTransform.of(3.0F, -7.2F, -3.625F, 0.829F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(VillagerEntityMCA entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}