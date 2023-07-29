package org.gbtask.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.gbtask.model.base.Pet;

import java.util.Calendar;
import java.util.HashSet;


@JacksonXmlRootElement(localName = "animal")
public class Hamster extends Pet {
    public Hamster(int height, int weight, Calendar birthDate, String name, String breed, HashSet<String> commands,
                   boolean isVaccinated) {
        super(height, weight, birthDate, name, breed, commands, isVaccinated);
    }
}
