package org.gbtask.model;

import org.gbtask.model.base.Pac;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;


public class Donkey extends Pac {
    private int stubbornness;

    public Donkey(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
                  int loadCapacity, int stubbornness) {
        super(height, weight, birthDate, name, breed, commands, loadCapacity);
        this.stubbornness = stubbornness;
    }

    public int getStubbornness() {
        return stubbornness;
    }

    public void setStubbornness(int stubbornness) {
        this.stubbornness = stubbornness;
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
                        "Stubbornness: %d\n" +
                        "Commands: %s" ,
                "donkey", super.getName(), super.getBreed(), super.getHeight(), super.getWeight(),
                sdf.format(super.getBirthDate().getTime()), super.getLoadCapacity(), this.stubbornness, commandsList
        );
    }
}
