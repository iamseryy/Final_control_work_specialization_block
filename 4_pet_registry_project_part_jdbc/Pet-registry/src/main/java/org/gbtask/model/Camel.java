package org.gbtask.model;

import org.gbtask.model.base.Pac;

import java.util.Calendar;
import java.util.HashSet;

public class Camel extends Pac {
    private int milkValue;

    public Camel(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
                 int loadCapacity, int milkValue) {
        super(height, weight, birthDate, name, breed, commands, loadCapacity);
        this.milkValue = milkValue;
    }
}
