package org.gbtask.model.base;

import java.io.Serializable;
import java.util.Calendar;

public abstract class Animal implements Serializable {
    private int height;
    private int weight;
    private String сolor;

    public Animal(int height, int weight, String сolor) {
        this.height = height;
        this.weight = weight;
        this.сolor = сolor;
    }
}

