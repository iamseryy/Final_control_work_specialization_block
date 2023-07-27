package org.gbtask.model;

import org.gbtask.model.base.Animal;

import java.io.Serializable;
import java.util.HashMap;

public class Registry implements Serializable {
    private int id;
    private Animal animal;

    public Registry(int id, Animal animal) {
        this.id = id;
        this.animal = animal;
    }
}
