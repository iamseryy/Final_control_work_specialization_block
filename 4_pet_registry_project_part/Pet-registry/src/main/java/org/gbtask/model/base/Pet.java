package org.gbtask.model.base;

import java.util.Calendar;
import java.util.HashSet;


public abstract class Pet extends Animal{
    private String name;
    private String breed;
    private HashSet<String> commands;
    private boolean isVaccinated;

    public Pet(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
               boolean isVaccinated) {
        super(height, weight, birthDate);
        this.name = name;
        this.breed = breed;
        this.commands = commands;
        this.isVaccinated = isVaccinated;

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

