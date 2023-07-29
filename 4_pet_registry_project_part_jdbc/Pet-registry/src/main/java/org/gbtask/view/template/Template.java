package org.gbtask.view.template;

import org.gbtask.service.RegistryService;
import org.gbtask.service.impl.RegistryServiceImpl;
import org.gbtask.view.ui.UserInterface;
import org.gbtask.view.ui.impl.UserInterfaceImpl;

public interface Template<T> {
    void output();

    RegistryService registryService = new RegistryServiceImpl();
    UserInterface ui = new UserInterfaceImpl();
}