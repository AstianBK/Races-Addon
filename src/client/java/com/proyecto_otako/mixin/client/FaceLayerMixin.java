package com.proyecto_otako.mixin.client;

import fabric.net.mca.MCA;
import fabric.net.mca.client.render.layer.FaceLayer;
import fabric.net.mca.client.render.layer.HairLayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FaceLayer.class)
public class FaceLayerMixin<T extends LivingEntity> {
	@Inject(at = @At("HEAD"), method = "getSkin", cancellable = true)
	private void get$Skin(T villager, CallbackInfoReturnable<Identifier> cir) {
		//cir.setReturnValue(new Identifier(MCA.MOD_ID,"skins/face/zombie/male/0.png"));
	}
}