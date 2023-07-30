package org.gbtask.view.template.impl;

import org.gbtask.config.AppConfig;
import org.gbtask.exception.DataBaseException;
import org.gbtask.model.*;
import org.gbtask.model.base.Animal;
import org.gbtask.view.template.Execute;
import org.gbtask.view.template.Template;

import java.util.Optional;
import java.util.logging.Level;

public class FindAnimalTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nFind animal");
        Optional<Integer> id = ui.input("Enter animal registry ID or enter an empty string to cancel: ", Integer::parseInt);

        if (!id.isEmpty()) {
            outputAnimalInfo(id.get());
        } else {
            ui.output("\nCancelled\n");
        }

        ui.pressEnterToContinue();
    }

    private void outputAnimalInfo(int id) {
        try {
            var animal = registryService.findAnimalByRegistryId(id);

            if (animal.isEmpty()) {
                ui.output("\nAnimal not found\n");
                return;
            }

            identifyAnimalAndExecute(animal.get(), (animalExecute) -> System.out.println(animalExecute.toString()));

        } catch (DataBaseException e) {
            AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
            System.out.println(e.toString());
        }
    }

    private void identifyAnimalAndExecute(Animal animal, Execute execute) {
        if (animal instanceof Cat) {
            execute.AnimalExecute(((Cat) animal));
        } else if (animal instanceof Dog) {
            execute.AnimalExecute(((Dog) animal));
        } else if (animal instanceof Camel) {
            execute.AnimalExecute(((Camel) animal));
        } else if (animal instanceof Donkey) {
            execute.AnimalExecute(((Donkey) animal));
        } else if (animal instanceof Hamster) {
            execute.AnimalExecute(((Hamster) animal));
        } else if (animal instanceof Horse) {
            execute.AnimalExecute(((Horse) animal));
        }
    }
}