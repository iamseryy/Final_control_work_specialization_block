package org.gbtask.repository;

import org.gbtask.model.base.Animal;

import java.util.HashMap;
import java.util.Optional;

public interface RegistryRepo {
    int add(Animal animal);
    Optional<Animal> findById(int id);
    void deleteById(int id);
    Optional<HashMap<Integer, Animal>> findAll();
}
