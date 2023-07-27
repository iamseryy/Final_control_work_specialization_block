package org.gbtask.model;

import org.gbtask.model.base.Pac;

import java.util.Calendar;
import java.util.HashSet;

public class Donkey  extends Pac {
    private int stubbornness;

    public Donkey(int height, int weight, String сolor, String name, String breed, Calendar birthDate, HashSet<String> commands, int loadCapacity, int speed, int stubbornness) {
        super(height, weight, сolor, name, breed, birthDate, commands, loadCapacity, speed);
        this.stubbornness = stubbornness;
    }
}
