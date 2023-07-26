package org.gbtask.repository.impl;

import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;
import org.gbtask.repository.RegistryRepo;

import java.util.HashMap;
import java.util.Optional;

public class RegistryRepoImpl implements RegistryRepo {
    private static Registry registry = new Registry(new HashMap<>());

    private static RegistryRepoImpl instance;

    public static RegistryRepoImpl getInstance() {
        if (instance == null) {
            instance = new RegistryRepoImpl();
        }
        return instance;
    }

    @Override
    public int add(Animal animal) {
        return 0;
    }

    @Override
    public Optional<Animal> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Optional<HashMap<Integer, Animal>> findAll() {
        return Optional.empty();
    }
}
