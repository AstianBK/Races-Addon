package com.proyecto_otako.layers;

import com.proyecto_otako.ProyectoOtako;
import com.proyecto_otako.Species;
import com.proyecto_otako.api.ISpecies;
import com.proyecto_otako.mixin.VillagerMCAAccessor;
import com.proyecto_otako.model.DemonHornModel;
import com.proyecto_otako.model.ElfEarsModel;
import fabric.net.mca.client.model.CommonVillagerModel;
import fabric.net.mca.client.render.layer.VillagerLayer;
import fabric.net.mca.client.resources.ColorPalette;
import fabric.net.mca.entity.VillagerEntityMCA;
import fabric.net.mca.entity.ai.Genetics;
import fabric.net.mca.entity.ai.Traits;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class SpeciePartLayer <T extends LivingEntity, M extends BipedEntityModel<T>> extends FeatureRenderer<T,M> {
    public EntityModel<T> model;
    public final M originModel;
    private static final float[] DEFAULT_COLOR = new float[]{1.0F, 1.0F, 1.0F};
    public SpeciePartLayer(FeatureRendererContext<T, M> renderer) {
        super(renderer);
        this.originModel= renderer.getModel();
    }

    @Override
    public void render(MatrixStack transform, VertexConsumerProvider provider, int light, T villager, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if(villager instanceof ISpecies species && villager instanceof VillagerMCAAccessor && species.getIdSpecie(((VillagerMCAAccessor)villager))>0){
            renderForSpecies(species.getSpecie(((VillagerMCAAccessor)villager)),transform,provider,light,villager,tickDelta);
        }
    }
    public float[] getColor(T villager, float tickDelta) {
        float albinism = CommonVillagerModel.getVillager(villager).getTraits().hasTrait(Traits.Trait.ALBINISM) ? 0.1F : 1.0F;
        return ColorPalette.SKIN.getColor(CommonVillagerModel.getVillager(villager).getGenetics().getGene(Genetics.MELANIN) * albinism, CommonVillagerModel.getVillager(villager).getGenetics().getGene(Genetics.HEMOGLOBIN) * albinism, CommonVillagerModel.getVillager(villager).getInfectionProgress());
    }

    public void renderForSpecies(Species species,MatrixStack transform, VertexConsumerProvider provider, int light, T villager, float tickDelta){
        switch (species){
            case ELF -> {
                if(this.model==null || !(this.model instanceof ElfEarsModel)){
                    this.model= (EntityModel<T>) new ElfEarsModel(ElfEarsModel.getTexturedModelData().createModel());
                }
                float[] color=this.getColor(villager,tickDelta);
                RenderLayer render=RenderLayer.getEntityCutoutNoCull(new Identifier(ProyectoOtako.MOD_ID,"textures/skin/elf/0.png"));
                ((ElfEarsModel)this.model).head.copyTransform(this.originModel.head);
                this.model.render(transform, provider.getBuffer(render),light, OverlayTexture.DEFAULT_UV,color[0],color[1],color[2],1.0F);
            }
            case DEMON -> {
                if(this.model==null|| !(this.model instanceof DemonHornModel)){
                    this.model= (EntityModel<T>) new DemonHornModel(DemonHornModel.getTexturedModelData().createModel());
                }
                float[] color=this.getColor(villager,tickDelta);
                RenderLayer render=RenderLayer.getEntityCutoutNoCull(new Identifier(ProyectoOtako.MOD_ID,"textures/skin/demon/0.png"));
                ((DemonHornModel)this.model).head.copyTransform(this.originModel.head);
                this.model.render(transform, provider.getBuffer(render),light, OverlayTexture.DEFAULT_UV,color[0],color[1],color[2],1.0F);
            }
        }
    }
}
