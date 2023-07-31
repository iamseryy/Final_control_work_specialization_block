package org.gbtask.view.template.impl;

import org.gbtask.config.AppConfig;
import org.gbtask.exception.DataBaseException;
import org.gbtask.model.*;
import org.gbtask.model.base.Animal;
import org.gbtask.view.template.Execute;
import org.gbtask.view.template.Template;

import java.util.HashSet;
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

        HashSet<String> commandsExisting = null;

        if (animal instanceof Cat) {
                commandsExisting = ((Cat) animal).getCommands();
        } else if (animal instanceof Dog) {
            commandsExisting = ((Dog) animal).getCommands();
        } else if (animal instanceof Camel) {
            commandsExisting = ((Camel) animal).getCommands();
        } else if (animal instanceof Donkey) {
            commandsExisting = ((Donkey) animal).getCommands();
        } else if (animal instanceof Hamster) {
            commandsExisting = ((Hamster) animal).getCommands();
        } else if (animal instanceof Horse) {
            commandsExisting = ((Horse) animal).getCommands();
        }

        var newCommands = getNewCommands(commandsExisting);
        if(!newCommands.isEmpty()){
            registryService.addCommandsByRegistryId(id, newCommands);
            ui.output("\nCommands added");
        }

        ui.pressEnterToContinue();
    }

    private static HashSet<String> getNewCommands(HashSet<String> commandsExisting){
        var commands = new HashSet<String>();

        while (true){
            Optional<String> command =  ui.input("Command: ", String::toString);
            if(command.isEmpty()){
                ui.output("\nCancelled\n");
                commands.clear();
                return commands;
            }

            if(commandsExisting.contains(command.get())){
                ui.output("\nThis command already exists\n");
            }else {
                commands.add(command.get());
            }

            Optional<Integer> choice;
            while (true) {
                choice = ui.input("Does the animal know another command?? (1 yes/ 2 no)?: ", Integer::parseInt);
                if (choice.isEmpty() || choice.get() < 1 || choice.get() > 2) {
                    ui.output("Invalid input data! Try Again");
                    continue;
                }

                if(choice.get() == 2){
                    return commands;
                }

                break;
            }
        }
    }
}
