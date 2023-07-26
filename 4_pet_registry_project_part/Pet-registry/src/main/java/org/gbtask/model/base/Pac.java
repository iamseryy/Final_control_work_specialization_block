package org.gbtask.model.base;

import java.util.Calendar;
import java.util.HashSet;

public abstract class Pac extends Animal{
    private String name;
    private String breed;
    private Calendar birthDate;
    private HashSet<String> commands;
    private int loadCapacity;
    private int speed;
}
