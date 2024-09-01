package com.proyecto_otako.mixin.client;

import com.proyecto_otako.ProyectoOtako;
import com.proyecto_otako.Species;
import com.proyecto_otako.api.ISpecies;
import com.proyecto_otako.mixin.VillagerMCAAccessor;
import fabric.net.mca.MCA;
import fabric.net.mca.client.render.layer.SkinLayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkinLayer.class)
public class SkinLayerMixin<T extends LivingEntity> {
	@Inject(at = @At("HEAD"), method = "getSkin", cancellable = true)
	private void get$Skin(T villager, CallbackInfoReturnable<Identifier> cir) {
		if(villager instanceof ISpecies species){
			if(species.getSpecie(((VillagerMCAAccessor)villager))==Species.DEMON){
				cir.setReturnValue(new Identifier(ProyectoOtako.MOD_ID,"textures/skin/demon/0.png"));
			}
		}
	}
}