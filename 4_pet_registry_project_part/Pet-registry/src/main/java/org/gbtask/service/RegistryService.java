package org.gbtask.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.gbtask.exception.DataBaseException;
import org.gbtask.exception.PetRegistryException;
import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;

import java.util.HashMap;
import java.util.HashSet;

public interface RegistryService {
    void add(Animal animal) throws PetRegistryException;
    HashMap<Integer, Registry> findAll();
}
