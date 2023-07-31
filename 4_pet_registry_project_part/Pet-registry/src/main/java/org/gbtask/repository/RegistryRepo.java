package org.gbtask.repository;

import org.gbtask.exception.DataBaseException;
import org.gbtask.exception.PetRegistryException;
import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public interface RegistryRepo {
    int add(Animal animal, String note) throws DataBaseException;
    void deleteById(int id);
    HashMap<Integer, Registry> findAll() throws DataBaseException;
    Optional<Animal> findByRegistryId(int registryId) throws DataBaseException;
    HashSet<String> findCommandsByRegistryId(int registryId) throws DataBaseException;
    void addCommandsByRegistryId(int registryId, HashSet<String> commands) throws DataBaseException;
}
