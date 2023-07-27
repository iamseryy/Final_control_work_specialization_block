package org.gbtask.service.impl;

import org.gbtask.model.Registry;
import org.gbtask.repository.RegistryRepo;
import org.gbtask.repository.impl.RegistryRepoImpl;
import org.gbtask.service.RegistryService;

import java.util.HashSet;

public class RegistryServiceImpl implements RegistryService {
    private static RegistryRepo registry = RegistryRepoImpl.getInstance();
    @Override
    public void add(Registry registry) {
        this.registry.add(registry);
    }

    @Override
    public HashSet<Registry> findAll() {
        return this.registry.findAll();
    }
}
