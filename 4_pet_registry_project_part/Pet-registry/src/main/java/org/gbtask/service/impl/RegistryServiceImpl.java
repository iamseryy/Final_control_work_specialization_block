package org.gbtask.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.gbtask.exception.DataBaseException;
import org.gbtask.exception.PetRegistryException;
import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;
import org.gbtask.repository.RegistryRepo;
import org.gbtask.repository.impl.RegistryRepoImpl;
import org.gbtask.service.RegistryService;

import java.util.HashMap;
import java.util.HashSet;

public class RegistryServiceImpl implements RegistryService {
    private static RegistryRepo registry = RegistryRepoImpl.getInstance();

    @Override
    public void add(Animal animal) throws PetRegistryException {
        this.registry.add(animal);
    }

    @Override
    public HashMap<Integer, Registry> findAll() {
        return this.registry.findAll();
    }
}
