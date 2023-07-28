package org.gbtask.repository;

import org.gbtask.exception.PetRegistryException;
import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;

import java.util.HashMap;
import java.util.Optional;

public interface RegistryRepo {
    int add(Animal animal) throws PetRegistryException;
    Optional<Animal> findById(int id);
    void deleteById(int id);
    HashMap<Integer, Registry> findAll();
}
