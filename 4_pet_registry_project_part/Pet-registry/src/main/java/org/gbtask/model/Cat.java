package org.gbtask.model;

import org.gbtask.model.base.Pet;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;

public class Cat extends Pet implements Serializable {
    private int mustacheLength;

    public Cat(int height, int weight, String сolor, String name, String breed, Calendar birthDate,
               boolean isVaccinated, HashSet<String> commands, int mustacheLength) {
        super(height, weight, сolor, name, breed, birthDate, isVaccinated, commands);
        this.mustacheLength = mustacheLength;
    }
}
