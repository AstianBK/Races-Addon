package com.proyecto_otako.model;

import fabric.net.mca.entity.VillagerEntityMCA;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ElfEarsModel extends EntityModel<VillagerEntityMCA> {
	public final ModelPart head;
	public ElfEarsModel(ModelPart root) {
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		ModelPartData Ear2_r1 = Head.addChild("Ear2_r1", ModelPartBuilder.create().uv(0, -8).mirrored().cuboid(0.0F, -4.0F, -4.0F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, -4.75F, 1.25F, 0.1745F, -0.6109F, 0.0F));
		ModelPartData Ear1_r1 = Head.addChild("Ear1_r1", ModelPartBuilder.create().uv(0, -8).cuboid(0.0F, -4.0F, -4.0F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -4.75F, 1.25F, 0.1745F, 0.6109F, 0.0F));
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