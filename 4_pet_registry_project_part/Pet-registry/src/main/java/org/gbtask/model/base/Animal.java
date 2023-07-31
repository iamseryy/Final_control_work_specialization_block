package org.gbtask.model.base;

import java.util.Calendar;

public abstract class Animal{
    private int height;
    private int weight;
    private Calendar birthDate;

    public Animal(int height, int weight, Calendar birthDate) {
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
}

