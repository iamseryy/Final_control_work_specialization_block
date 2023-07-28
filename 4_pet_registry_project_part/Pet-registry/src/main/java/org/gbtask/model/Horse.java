package org.gbtask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.gbtask.model.base.Pac;
import java.util.Calendar;
import java.util.HashSet;


@JacksonXmlRootElement(localName = "animal")
public class Horse extends Pac {
    private boolean isBreak;

    public Horse(@JsonProperty("height") int height,
                 @JsonProperty("weight") int weight,
                 @JsonProperty("birthDate") Calendar birthDate,
                 @JsonProperty("name") String name,
                 @JsonProperty("breed") String breed,
                 @JsonProperty("commands") HashSet<String> commands,
                 @JsonProperty("loadCapacity") int loadCapacity,
                 @JsonProperty("speed") int speed,
                 @JsonProperty("isBreak") boolean isBreak) {
        super(height, weight, birthDate, name, breed, commands, loadCapacity, speed);
        this.isBreak = isBreak;
    }
}
