package com.proyecto_otako.mixin;

import com.proyecto_otako.Species;
import com.proyecto_otako.api.ISpecies;
import fabric.net.mca.entity.VillagerEntityMCA;
import fabric.net.mca.entity.ai.Genetics;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(VillagerEntityMCA.class)
public abstract class VillagerMCAMixin implements ISpecies {
    @Shadow public abstract Genetics getGenetics();

    private static final TrackedData<Integer> SPECIES = DataTracker.registerData(VillagerEntityMCA .class, TrackedDataHandlerRegistry.INTEGER);

    @Inject(at = @At("HEAD"), method = "initDataTracker", cancellable = true)
    private void syncData(CallbackInfo ci) {
        if(((Object)this) instanceof VillagerMCAAccessor villagerMCAAccessor){
            villagerMCAAccessor.getDataTracker().startTracking(SPECIES,0);
        }
    }

    @Inject(at = @At("TAIL"), method = "initialize", cancellable = true)
    private void initialize$(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, NbtCompound entityNbt, CallbackInfoReturnable<EntityData> cir) {
        if(((Object)this) instanceof VillagerMCAAccessor villagerMCAAccessor){
            Random random=new Random();
            int species=random.nextInt(0,3);
            this.setForSpecies(species,villagerMCAAccessor);
            if(species==1){
                this.getGenetics().setGene(Genetics.MELANIN,0.0F);
                this.getGenetics().setGene(Genetics.HEMOGLOBIN,0.0F);
                this.getGenetics().setGene(Genetics.SIZE,1.0F);
            }
        }
    }
    @Override
    public Species getSpecie(VillagerMCAAccessor accessor) {
        return Species.byId(this.getIdSpecie(accessor) & 255);
    }

    @Override
    public void setForSpecies(int id, VillagerMCAAccessor accessor) {
        accessor.getDataTracker().set(SPECIES,id);
    }

    @Override
    public int getIdSpecie(VillagerMCAAccessor accessor) {
        return accessor.getDataTracker().get(SPECIES);
    }
}
