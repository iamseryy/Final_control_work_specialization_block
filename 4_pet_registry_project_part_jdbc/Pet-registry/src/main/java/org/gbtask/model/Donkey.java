package org.gbtask.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.gbtask.model.base.Pac;

import java.util.Calendar;
import java.util.HashSet;


@JacksonXmlRootElement(localName = "animal")
public class Donkey extends Pac {
    private int stubbornness;

    public Donkey(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
                  int loadCapacity, int stubbornness) {
        super(height, weight, birthDate, name, breed, commands, loadCapacity);
        this.stubbornness = stubbornness;
    }
}
