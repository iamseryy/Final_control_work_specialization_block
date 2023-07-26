package org.gbtask.model;

import org.gbtask.model.base.Animal;

import java.util.HashMap;

public class Registry {
    private HashMap<Integer, Animal> animals;

    public Registry(HashMap<Integer, Animal> animals) {
        this.animals = animals;
    }


}
