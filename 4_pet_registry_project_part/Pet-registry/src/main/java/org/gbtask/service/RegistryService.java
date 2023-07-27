package org.gbtask.service;

import org.gbtask.model.Registry;

import java.util.HashSet;

public interface RegistryService {
    void add(Registry registry);
    HashSet<Registry> findAll();
}
