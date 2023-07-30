package org.gbtask.service.impl;

import org.gbtask.exception.DataBaseException;
import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;
import org.gbtask.repository.RegistryRepo;
import org.gbtask.repository.impl.RegistryRepoImpl;
import org.gbtask.service.RegistryService;

import java.util.HashMap;
import java.util.Optional;

public class RegistryServiceImpl implements RegistryService {
    private static RegistryRepo registry = RegistryRepoImpl.getInstance();

    @Override
    public int add(Animal animal, String note) throws DataBaseException {
        return this.registry.add(animal, note);
    }

    @Override
    public HashMap<Integer, Registry> findAll() throws DataBaseException {
        return this.registry.findAll();
    }

    @Override
    public Optional<Animal> findAnimalByRegistryId(int registryId) throws DataBaseException {
        return registry.findByRegistryId(registryId);
    }
}
