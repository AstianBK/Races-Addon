package com.proyecto_otako.mixin;

import fabric.net.mca.entity.VillagerEntityMCA;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public interface VillagerMCAAccessor {
    @Accessor("dataTracker")
    DataTracker getDataTracker();
}
