package org.gbtask.model.base;

import java.util.Calendar;
import java.util.HashSet;

public abstract class Pet extends Animal{
    private String name;
    private String breed;
    private Calendar birthDate;
    private boolean isVaccinated;
    private HashSet<String> commands;

}
