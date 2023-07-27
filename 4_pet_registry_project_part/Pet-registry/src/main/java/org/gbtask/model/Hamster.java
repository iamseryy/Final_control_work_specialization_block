package org.gbtask.model;

import org.gbtask.model.base.Pet;

import java.util.Calendar;
import java.util.HashSet;

public class Hamster extends Pet {
    public Hamster(int height, int weight, String сolor, String name, String breed, Calendar birthDate,
                   boolean isVaccinated, HashSet<String> commands) {
        super(height, weight, сolor, name, breed, birthDate, isVaccinated, commands);
    }
}
