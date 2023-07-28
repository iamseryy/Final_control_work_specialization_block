package org.gbtask.view.template.impl;


import org.gbtask.exception.PetRegistryException;
import org.gbtask.model.Cat;
import org.gbtask.model.base.Animal;
import org.gbtask.view.template.Counter;
import org.gbtask.view.template.Template;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

public class AddAnimalTemplate implements Template {
    @Override
    public void output() {

        Counter counter = new Counter();
        counter.add();

        Animal animal1 = new Cat(22, 33, "red", "Cat1", "xxx",
                Calendar.getInstance(), true,  new HashSet<String>(Arrays.asList(new String[]{"sleep", "eat"})),
                55);
        Animal animal2 = new Cat(33, 55, "red", "Cat2", "xxx",
                Calendar.getInstance(), true,  new HashSet<String>(Arrays.asList(new String[]{"sleep", "eat"})),
                55);

        try {
            registryService.add(animal1);
            registryService.add(animal2);
        } catch (PetRegistryException e) {
            throw new RuntimeException(e);
        }





        var  registry = registryService.findAll();

        System.out.println(registry.toString());




    }
}