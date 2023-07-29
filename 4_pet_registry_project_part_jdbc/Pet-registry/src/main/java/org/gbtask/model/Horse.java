package org.gbtask.model;

import org.gbtask.model.base.Pac;

import java.util.Calendar;
import java.util.HashSet;


public class Horse extends Pac {
    private boolean isBreak;

    public Horse(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
                 int loadCapacity, boolean isBreak) {
        super(height, weight, birthDate, name, breed, commands, loadCapacity);
        this.isBreak = isBreak;
    }
}
