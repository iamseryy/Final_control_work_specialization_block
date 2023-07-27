package org.gbtask.view.template.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.gbtask.model.Cat;
import org.gbtask.model.Registry;
import org.gbtask.model.SimpleBean;
import org.gbtask.model.base.Animal;
import org.gbtask.view.template.Template;

import org.gbtask.config.AppConfig;

import java.io.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;

public class AddAnimalTemplate implements Template {
    @Override
    public void output() {

        Animal animal1 = new Cat(22, 33, "red", "Cat1", "xxx",
                Calendar.getInstance(), true,  new HashSet<String>(Arrays.asList(new String[]{"sleep", "eat"})),
                55);
        Animal animal2 = new Cat(44, 55, "red", "Cat2", "xxx",
                Calendar.getInstance(), true,  new HashSet<String>(Arrays.asList(new String[]{"sleep", "eat"})),
                55);

        registryService.add(new Registry(1, animal1));
        registryService.add(new Registry(2, animal2));


        var  registry = registryService.findAll();

        var registry1 = new Registry(1, animal1);
        var registry2 = new Registry(2, animal2);

//
//        System.out.println(registry.toString());
//
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AppConfig.getPath("path.database") + "/" + "test")))
//        {
//            oos.writeObject(registry);
//            System.out.println("File has been written");
//        }
//        catch(Exception ex){
//
//            System.out.println(ex.getMessage());
//        }
//
//        // десериализация в новый список
//        var newregistry= new  HashSet<Registry>();
//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(AppConfig.getPath("path.database") + "/" + "test")))
//        {
//
//            newregistry=((HashSet<Registry>)ois.readObject());
//        }
//        catch(Exception ex){
//
//            System.out.println(ex.getMessage());
//        }
//
//        System.out.println(newregistry.toString());
//
//
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AppConfig.getPath("path.database") + "/" + "test1")))
//        {
//            oos.writeObject(new Registry(1, animal1));
//            System.out.println("File has been written");
//        }
//        catch(Exception ex){
//
//            System.out.println(ex.getMessage());
//        }
//
//
//        Registry newregistry1;
//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(AppConfig.getPath("path.database") + "/" + "test1")))
//        {
//            newregistry1=((Registry)ois.readObject());
//
//            System.out.println(newregistry1.toString());
//        }
//        catch(Exception ex){
//
//            System.out.println(ex.getMessage());
//        }

        File file = new File(AppConfig.getPath("path.database") + "/" + "simple_bean.xml");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {

            String xml = xmlMapper.writeValueAsString(new SimpleBean());
            xmlMapper.writeValue(file, animal1);
            xmlMapper.writeValue(file, animal2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}