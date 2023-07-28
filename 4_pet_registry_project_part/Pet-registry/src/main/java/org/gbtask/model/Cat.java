package org.gbtask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.gbtask.model.base.Pet;

import java.util.Calendar;
import java.util.HashSet;


@JacksonXmlRootElement(localName = "animal")
public class Cat extends Pet {
    private int mustacheLength;

    public Cat(@JsonProperty("height") int height,
               @JsonProperty("weight") int weight,
               @JsonProperty("сolor")String сolor,
               @JsonProperty("name") String name,
               @JsonProperty("breed") String breed,
               @JsonProperty("birthDate") Calendar birthDate,
               @JsonProperty("isVaccinated") boolean isVaccinated,
               @JsonProperty("commands") HashSet<String> commands,
               @JsonProperty("mustacheLength") int mustacheLength) {
        super(height, weight, сolor, name, breed, birthDate, isVaccinated, commands);
        this.mustacheLength = mustacheLength;
    }

    public int getMustacheLength() {
        return mustacheLength;
    }

    public void setMustacheLength(int mustacheLength) {
        this.mustacheLength = mustacheLength;
    }
}
