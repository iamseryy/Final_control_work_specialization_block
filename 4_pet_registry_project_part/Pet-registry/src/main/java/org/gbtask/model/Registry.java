package org.gbtask.model;

import org.gbtask.model.base.Animal;

import java.io.Serializable;
import java.util.HashMap;

public record Registry(int id, Animal animal){
}
