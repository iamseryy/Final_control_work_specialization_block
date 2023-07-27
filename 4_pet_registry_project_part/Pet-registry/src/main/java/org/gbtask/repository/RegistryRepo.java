package org.gbtask.repository;

import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public interface RegistryRepo {
    void add(Registry registry);
    Optional<Animal> findById(int id);
    void deleteById(int id);
    HashSet<Registry> findAll();
}
