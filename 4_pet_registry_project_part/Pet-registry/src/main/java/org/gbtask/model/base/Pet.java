package org.gbtask.model.base;

import java.util.Calendar;
import java.util.HashSet;


public abstract class Pet extends Animal{
    private String name;
    private String breed;
    private boolean isVaccinated;
    private HashSet<String> commands;

    public Pet(int height, int weight, Calendar birthDate, String name, String breed,
               boolean isVaccinated, HashSet<String> commands) {
        super(height, weight, birthDate);
        this.name = name;
        this.breed = breed;
        this.isVaccinated = isVaccinated;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public HashSet<String> getCommands() {
        return commands;
    }

    public void setCommands(HashSet<String> commands) {
        this.commands = commands;
    }
}

