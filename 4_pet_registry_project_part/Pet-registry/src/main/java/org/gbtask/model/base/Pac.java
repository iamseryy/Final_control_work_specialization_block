package org.gbtask.model.base;

import java.util.Calendar;
import java.util.HashSet;

public abstract class Pac extends Animal{
    private String name;
    private String breed;
    private Calendar birthDate;
    private HashSet<String> commands;
    private int loadCapacity;
    private int speed;

    public Pac(int height, int weight, String сolor, String name, String breed, Calendar birthDate,
               HashSet<String> commands, int loadCapacity, int speed) {
        super(height, weight, сolor);
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
        this.commands = commands;
        this.loadCapacity = loadCapacity;
        this.speed = speed;
    }
}
