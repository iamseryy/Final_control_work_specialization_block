package org.gbtask.model;

import org.gbtask.model.base.Pet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;


public class Dog extends Pet {
    private int powerSenseSmell;

    public Dog(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
               boolean isVaccinated, int powerSenseSmell) {
        super(height, weight, birthDate, name, breed, commands, isVaccinated);
        this.powerSenseSmell = powerSenseSmell;
    }

    public int getPowerSenseSmell() {
        return powerSenseSmell;
    }

    public void setPowerSenseSmell(int powerSenseSmell) {
        this.powerSenseSmell = powerSenseSmell;
    }

    public String toString() {
        var sdf = new SimpleDateFormat("dd.MM.yyyy");
        var commands = super.getCommands();
        var commandsBuilder = new StringBuilder();
        String commandsList;
        if(!commands.isEmpty()){
            commands.stream().forEach(command ->commandsBuilder.append(command + "; "));
            commandsList = " " + commandsBuilder.toString();
        } else {
            commandsList = "It is not trained";
        }
        return String.format("Animal: %s\n" +
                        "Name: %s\n" +
                        "Breed: %s\n" +
                        "Height: %d\n" +
                        "Weight: %d\n" +
                        "Birth date: %s\n" +
                        "Is vaccinated: %b\n" +
                        "Power sense smell: %d\n" +
                        "Commands: %s" ,
                "dog", super.getName(), super.getBreed(), super.getHeight(), super.getWeight(),
                sdf.format(super.getBirthDate().getTime()), super.isVaccinated(), this.powerSenseSmell, commandsList
        );
    }
}
