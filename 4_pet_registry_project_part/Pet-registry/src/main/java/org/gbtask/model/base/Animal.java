package org.gbtask.model.base;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.gbtask.model.*;

import java.util.Calendar;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Cat.class, name = "cat"),
        @JsonSubTypes.Type(value = Camel.class, name = "camel"),
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Donkey.class, name = "donkey"),
        @JsonSubTypes.Type(value = Hamster.class, name = "hamster"),
        @JsonSubTypes.Type(value = Horse.class, name = "horse")
})
public abstract class Animal{
    private int height;
    private int weight;
    private Calendar birthDate;

    public Animal(int height, int weight, Calendar birthDate) {
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
}

