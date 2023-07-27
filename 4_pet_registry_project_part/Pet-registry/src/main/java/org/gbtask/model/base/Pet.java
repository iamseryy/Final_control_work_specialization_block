package org.gbtask.model.base;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;

public abstract class Pet extends Animal implements Serializable {
    private String name;
    private String breed;
    private Calendar birthDate;
    private boolean isVaccinated;
    private HashSet<String> commands;

    public Pet(int height, int weight, String сolor, String name, String breed, Calendar birthDate,
               boolean isVaccinated, HashSet<String> commands) {
        super(height, weight, сolor);
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
        this.isVaccinated = isVaccinated;
        this.commands = commands;
    }
}

