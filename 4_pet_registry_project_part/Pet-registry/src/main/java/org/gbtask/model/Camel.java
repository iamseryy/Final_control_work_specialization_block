package org.gbtask.model;

import org.gbtask.model.base.Pac;

import java.util.Calendar;
import java.util.HashSet;

public class Camel extends Pac {
    private int milkValue;

    public Camel(int height, int weight, String сolor, String name, String breed, Calendar birthDate,
                 HashSet<String> commands, int loadCapacity, int speed, int milkValue) {
        super(height, weight, сolor, name, breed, birthDate, commands, loadCapacity, speed);
        this.milkValue = milkValue;
    }
}
