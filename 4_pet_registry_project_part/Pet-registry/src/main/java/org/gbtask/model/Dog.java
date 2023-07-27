package org.gbtask.model;

import org.gbtask.model.base.Pet;

import java.util.Calendar;
import java.util.HashSet;

public class Dog extends Pet {
    private int powerSenseSmell;

    public Dog(int height, int weight, String сolor, String name, String breed, Calendar birthDate, boolean isVaccinated, HashSet<String> commands, int powerSenseSmell) {
        super(height, weight, сolor, name, breed, birthDate, isVaccinated, commands);
        this.powerSenseSmell = powerSenseSmell;
    }
}
