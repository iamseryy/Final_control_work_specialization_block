package org.gbtask.model.base;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.gbtask.model.*;


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
    private String сolor;

    public Animal(int height, int weight, String сolor) {
        this.height = height;
        this.weight = weight;
        this.сolor = сolor;
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

    public String getСolor() {
        return сolor;
    }

    public void setСolor(String сolor) {
        this.сolor = сolor;
    }
}

