package org.gbtask.view.template.impl;

import org.gbtask.config.AppConfig;
import org.gbtask.exception.DataBaseException;
import org.gbtask.model.*;
import org.gbtask.model.base.Animal;
import org.gbtask.view.template.Template;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;


public class PrintRegistryTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nAnimal list");
        try {
            var registry = registryService.findAll();
            registry.entrySet().stream().forEach(reg -> outputLine(reg.getValue()));
        } catch (DataBaseException e) {
            AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
            System.out.println(e.toString());
        }

        ui.pressEnterToContinue();
    }

    private void outputLine(Registry registry) {
        String animalType = "";
        String name = "";

        Animal animal = registry.animal();

        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            animalType = "cat";
            name = cat.getName();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            animalType = "dog";
            name = dog.getName();
        } else if (animal instanceof Camel) {
            Camel camel = (Camel) animal;
            animalType = "camel";
            name = camel.getName();
        } else if (animal instanceof Donkey) {
            Donkey donkey = (Donkey) animal;
            animalType = "donkey";
            name = donkey.getName();
        } else if (animal instanceof Hamster) {
            Hamster hamster = (Hamster) animal;
            animalType = "hamster";
            name = hamster.getName();
        } else if (animal instanceof Horse) {
            Horse horse = (Horse) animal;
            animalType = "horse";
            name = horse.getName();
        }

        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        ui.output("id: " + registry.id() +
                "; animal: " + animalType +
                "; name: " + name +
                "; note: " + registry.note() +
                "; created date: " + sdf.format(registry.createdDate().getTime())
        );
    }
}
