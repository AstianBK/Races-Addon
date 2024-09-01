package com.proyecto_otako.api;

import com.proyecto_otako.Species;
import com.proyecto_otako.mixin.VillagerMCAAccessor;

public interface ISpecies {
    Species getSpecie(VillagerMCAAccessor accessor);
    void setForSpecies(int id, VillagerMCAAccessor accessor);
    int getIdSpecie(VillagerMCAAccessor accessor);
}
