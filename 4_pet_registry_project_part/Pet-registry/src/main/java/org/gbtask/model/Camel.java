package org.gbtask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.gbtask.model.base.Pac;

import java.util.Calendar;
import java.util.HashSet;


@JacksonXmlRootElement(localName = "animal")
public class Camel extends Pac {
    private int milkValue;

    public Camel(@JsonProperty("height") int height,
                 @JsonProperty("weight") int weight,
                 @JsonProperty("сolor") String сolor,
                 @JsonProperty("name") String name,
                 @JsonProperty("breed") String breed,
                 @JsonProperty("birthDate") Calendar birthDate,
                 @JsonProperty("commands") HashSet<String> commands,
                 @JsonProperty("loadCapacity") int loadCapacity,
                 @JsonProperty("speed") int speed,
                 @JsonProperty("milkValue") int milkValue) {
        super(height, weight, сolor, name, breed, birthDate, commands, loadCapacity, speed);
        this.milkValue = milkValue;
    }
}
