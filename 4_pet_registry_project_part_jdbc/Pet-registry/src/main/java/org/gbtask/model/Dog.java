package org.gbtask.model;

import org.gbtask.model.base.Pet;

import java.util.Calendar;
import java.util.HashSet;


public class Dog extends Pet {
    private int powerSenseSmell;

    public Dog(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
               boolean isVaccinated, int powerSenseSmell) {
        super(height, weight, birthDate, name, breed, commands, isVaccinated);
        this.powerSenseSmell = powerSenseSmell;
    }
}
