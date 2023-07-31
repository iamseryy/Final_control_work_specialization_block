package org.gbtask.service;

import org.gbtask.exception.DataBaseException;
import org.gbtask.exception.PetRegistryException;
import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public interface RegistryService {
    int add(Animal animal, String note) throws DataBaseException;
    HashMap<Integer, Registry> findAll() throws DataBaseException;
    Optional<Animal> findAnimalByRegistryId(int registryId) throws DataBaseException;
    HashSet<String> findCommandsByRegistryId(int registryId) throws DataBaseException;
    void addCommandsByRegistryId(int registryId, HashSet<String> commands) throws DataBaseException;
}
