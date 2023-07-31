package org.gbtask.view.template.impl;

import org.gbtask.config.AppConfig;
import org.gbtask.exception.DataBaseException;
import org.gbtask.model.*;
import org.gbtask.model.base.Animal;
import org.gbtask.view.template.Execute;
import org.gbtask.view.template.Template;

import java.util.Optional;
import java.util.logging.Level;

public class AddCommandTemplate  implements Template {
    @Override
    public void output() {
        ui.output("\nAdd Command");
        Optional<Integer> id = ui.input("Enter animal registry ID or enter an empty string to cancel: ", Integer::parseInt);

        if (!id.isEmpty()) {
            try {
                identifyAnimalAndExecute(id.get());
            } catch (DataBaseException e) {
                AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
                ui.output(e.toString());
            }
        } else {
            ui.output("\nCancelled\n");
        }

        ui.pressEnterToContinue();
    }

    private void identifyAnimalAndExecute(int id) throws DataBaseException {
        var animalOpt = registryService.findAnimalByRegistryId(id);

        if (animalOpt.isEmpty()) {
            ui.output("\nAnimal not found\n");
            return;
        }

        var animal = animalOpt.get();

        if (animal instanceof Cat) {
            registryService.addCommandsByRegistryId(id, ((Cat) animal).getCommands());
        } else if (animal instanceof Dog) {
            registryService.addCommandsByRegistryId(id, ((Dog) animal).getCommands());
        } else if (animal instanceof Camel) {
            registryService.addCommandsByRegistryId(id, ((Camel) animal).getCommands());
        } else if (animal instanceof Donkey) {
            registryService.addCommandsByRegistryId(id, ((Donkey) animal).getCommands());
        } else if (animal instanceof Hamster) {
            registryService.addCommandsByRegistryId(id, ((Hamster) animal).getCommands());
        } else if (animal instanceof Horse) {
            registryService.addCommandsByRegistryId(id, ((Horse) animal).getCommands());
        }
    }
}
