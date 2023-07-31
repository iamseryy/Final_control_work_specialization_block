package org.gbtask.view.template.impl;

import org.gbtask.config.AppConfig;
import org.gbtask.exception.DataBaseException;
import org.gbtask.model.*;
import org.gbtask.view.template.Template;

import java.util.HashSet;
import java.util.Optional;
import java.util.logging.Level;

public class AnimalCommandListTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nAnimal command list");
        Optional<Integer> id = ui.input("Enter animal registry ID or enter an empty string to cancel: ", Integer::parseInt);

        if (!id.isEmpty()) {
            outputCommandList(id.get());
        } else {
            ui.output("\nCancelled\n");
        }

        ui.pressEnterToContinue();
    }

    private void outputCommandList(int id) {
        try {
            var animalOpt = registryService.findAnimalByRegistryId(id);

            if (animalOpt.isEmpty()) {
                ui.output("\nAnimal not found\n");
                return;
            }

            String commands = "";

            var animal = animalOpt.get();

            if (animal instanceof Cat) {
                commands = getCommandsList(((Cat) animal).getCommands());
            } else if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                commands = getCommandsList(((Dog) animal).getCommands());
            } else if (animal instanceof Camel) {
                commands = getCommandsList(((Camel) animal).getCommands());
            } else if (animal instanceof Donkey) {
                commands = getCommandsList(((Donkey) animal).getCommands());
            } else if (animal instanceof Hamster) {
                commands = getCommandsList(((Hamster) animal).getCommands());
            } else if (animal instanceof Horse) {
                commands = getCommandsList(((Horse) animal).getCommands());
            }


            ui.output("Commands: " + commands);
        } catch (DataBaseException e) {
            AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
            System.out.println(e.toString());
        }
    }

    private String getCommandsList(HashSet<String> commands) {

        var commandsBuilder = new StringBuilder();
        String commandsList = "";
        if (!commands.isEmpty()) {
            commands.stream().forEach(command -> commandsBuilder.append(command + "; "));
            commandsList = " " + commandsBuilder.toString();
        } else {
            commandsList = "It is not trained";
        }

        return commandsList;
    }
}
