package org.gbtask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.gbtask.model.base.Pet;

import java.util.Calendar;
import java.util.HashSet;


@JacksonXmlRootElement(localName = "animal")
public class Hamster extends Pet {
    public Hamster(@JsonProperty("height") int height,
                   @JsonProperty("weight") int weight,
                   @JsonProperty("birthDate") Calendar birthDate,
                   @JsonProperty("name") String name,
                   @JsonProperty("breed") String breed,
                   @JsonProperty("isVaccinated") boolean isVaccinated,
                   @JsonProperty("commands") HashSet<String> commands) {
        super(height, weight, birthDate, name, breed, isVaccinated, commands);
    }
}
