package org.gbtask.repository.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.gbtask.config.AppConfig;
import org.gbtask.exception.DataBaseException;
import org.gbtask.exception.PetRegistryException;
import org.gbtask.model.Registry;
import org.gbtask.model.base.Animal;
import org.gbtask.repository.RegistryRepo;
import org.gbtask.util.FileUtils;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.Optional;
import java.util.logging.Level;

public class RegistryRepoImpl implements RegistryRepo {
    private static HashMap<Integer, Registry> registry = initRegistry();
    private static int id = 0;

    private static RegistryRepoImpl instance;

    public static RegistryRepoImpl getInstance() {
        if (instance == null) {
            instance = new RegistryRepoImpl();
        }
        return instance;
    }

    @Override
    public int add(Animal animal) throws DataBaseException, JsonProcessingException, PetRegistryException {
        if(animal == null){
            throw new PetRegistryException("Invalid registry entry");
        }

        Registry registryItem = new Registry(id, animal);
        String line = serializeToXml(registryItem);
        this.registry.put(this.id++, registryItem);
        FileUtils.writeFile(line, AppConfig.getProperty("file.registry"), true);

        return(this.id - 1);
    }

    @Override
    public Optional<Animal> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
     public HashMap<Integer, Registry> findAll() {

        return this.registry;
    }

    private static HashMap<Integer, Registry> initRegistry() {
        var registry = new HashMap<Integer, Registry>();
        ArrayList<String> data = FileUtils.readFile(AppConfig.getProperty("file.registry"));

        for (String line: data){
            try {
                var item = deserializeXml(line);
                registry.put(item.id(), item);
            } catch (JsonProcessingException | DataBaseException e) {
                AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
            }
        }

        return registry;
    }

    private static Registry deserializeXml(String data) throws JsonProcessingException, DataBaseException{
        if(data.isEmpty()){
            throw new DataBaseException("Database structure broken");
        }

        return new XmlMapper().readValue(data, Registry.class);
    }

    private static String serializeToXml(Registry registry) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(registry);
    }


}
//AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
//    File file = new File(AppConfig.getPath("path.database") + "/" + "simple_bean.xml");
//    XmlMapper xmlMapper = new XmlMapper();
//        xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//                try {
//
//                String xml = xmlMapper.writeValueAsString(new SimpleBean());
//                xmlMapper.writeValue(file, animal1);
//                xmlMapper.writeValue(file, animal2);
//                } catch (IOException e) {
//                throw new RuntimeException(e);
//                }