package org.gbtask.model;

import org.gbtask.model.base.Pac;

import java.util.Calendar;
import java.util.HashSet;

public class Horse extends Pac {
    private boolean isBreak;

    public Horse(int height, int weight, String сolor, String name, String breed, Calendar birthDate, HashSet<String> commands, int loadCapacity, int speed, boolean isBreak) {
        super(height, weight, сolor, name, breed, birthDate, commands, loadCapacity, speed);
        this.isBreak = isBreak;
    }
}
