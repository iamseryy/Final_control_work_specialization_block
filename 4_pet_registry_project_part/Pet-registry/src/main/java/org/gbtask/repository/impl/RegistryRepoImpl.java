package org.gbtask.repository.impl;

import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;
import org.gbtask.repository.RegistryRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public class RegistryRepoImpl implements RegistryRepo {
    private static HashSet<Registry> registry = initRegistry();

    private static RegistryRepoImpl instance;

    public static RegistryRepoImpl getInstance() {
        if (instance == null) {
            instance = new RegistryRepoImpl();
        }
        return instance;
    }

    @Override
    public void add(Registry registry) {

        if(this.registry.contains(registry)){
            return;
        }

        this.registry.add(registry);
    }

    @Override
    public Optional<Animal> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
     public HashSet<Registry> findAll() {

        return this.registry;
    }

    private static HashSet<Registry> initRegistry() {
        var registry = new HashSet<Registry>();
       /*
        ArrayList<String> data = FileUtils.readFiles(AppConfig.getPath("path.database"));

        for (String line: data) {
            String[] values = line.split("><");
            people.add(new Person(values[1], values[0].replace("<", ""), values[2],
                    values[3].replace(">", "")));
        }
*/
        return registry;
    }
}
