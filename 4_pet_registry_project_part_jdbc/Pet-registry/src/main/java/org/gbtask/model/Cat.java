package org.gbtask.model;

import org.gbtask.model.base.Pet;

import java.util.Calendar;
import java.util.HashSet;


public class Cat extends Pet {
    private int mustacheLength;

    public Cat(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
               boolean isVaccinated, int mustacheLength) {
        super(height, weight, birthDate, name, breed, commands, isVaccinated);
        this.mustacheLength = mustacheLength;
    }

    public int getMustacheLength() {
        return mustacheLength;
    }

    public void setMustacheLength(int mustacheLength) {
        this.mustacheLength = mustacheLength;
    }
}
