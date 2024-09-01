package com.proyecto_otako;

import java.util.Arrays;
import java.util.Comparator;

public enum Species {
    HUMAN(0,""),
    ELF(1,"elf"),
    DEMON(2,"demon");

    private static final Species[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(Species::getId)).toArray(Species[]::new);

    private final int id;
    private final String name;
    Species(int id,String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Species byId(int p_30987_) {
        return BY_ID[p_30987_ % BY_ID.length];
    }
    
    
}
