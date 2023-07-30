package org.gbtask.model;

import org.gbtask.model.base.Pac;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;


public class Horse extends Pac {
    private int speed;

    public Horse(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
                 int loadCapacity, int speed) {
        super(height, weight, birthDate, name, breed, commands, loadCapacity);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
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
                        "Load capacity: %d\n" +
                        "Speed: %d\n" +
                        "Commands: %s" ,
                "horse", super.getName(), super.getBreed(), super.getHeight(), super.getWeight(),
                sdf.format(super.getBirthDate().getTime()), super.getLoadCapacity(), this.speed, commandsList
        );
    }
}
