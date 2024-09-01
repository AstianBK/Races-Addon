package com.proyecto_otako.mixin.client;

import com.proyecto_otako.layers.SpeciePartLayer;
import fabric.net.mca.client.render.VillagerEntityMCARenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VillagerEntityMCARenderer.class)
public class VillagerMCARendererMixin {
    @Inject(at = @At("TAIL"), method = "<init>")
    private void init$(EntityRendererFactory.Context ctx, CallbackInfo ci) {
        if(((Object) this) instanceof VillagerMCARendererAccessor renderer) {
            renderer.add$Feacture(new SpeciePartLayer<>(((VillagerEntityMCARenderer)((Object)this))));
        }
    }
}
