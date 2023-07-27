package org.gbtask.view.template;

import org.gbtask.model.Registry;
import org.gbtask.service.RegistryService;
import org.gbtask.service.impl.RegistryServiceImpl;

import java.util.HashSet;

public interface Template<T> {
    void output();
    RegistryService registryService = new RegistryServiceImpl();
}