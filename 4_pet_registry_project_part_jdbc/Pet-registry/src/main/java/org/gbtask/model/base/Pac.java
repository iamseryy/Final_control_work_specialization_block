package org.gbtask.model.base;

import java.util.Calendar;
import java.util.HashSet;

public abstract class Pac extends Animal{
    private String name;
    private String breed;
    private HashSet<String> commands;
    private int loadCapacity;

    public Pac(int height, int weight, Calendar birthDate, String name, String breed,
               HashSet<String> commands, int loadCapacity) {
        super(height, weight, birthDate);
        this.name = name;
        this.breed = breed;
        this.commands = commands;
        this.loadCapacity = loadCapacity;
    }
}
