package org.gbtask.repository.impl;


import org.gbtask.config.AppConfig;
import org.gbtask.exception.DataBaseException;
import org.gbtask.model.*;
import org.gbtask.model.base.Animal;
import org.gbtask.repository.RegistryRepo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.logging.Level;

public class RegistryRepoImpl implements RegistryRepo {
    private final String DB_URL = AppConfig.getProperty("datasource.url");
    private final String DB_USERNAME = AppConfig.getProperty("datasource.username");
    private final String DB_PASSWORD = AppConfig.getProperty("datasource.password");
    private static final String SQL_PATH = AppConfig.getProperty("sql.path");


    private static RegistryRepoImpl instance;

    private RegistryRepoImpl() {
    }

    public static RegistryRepoImpl getInstance() {
        if (instance == null) {
            instance = new RegistryRepoImpl();
        }
        return instance;
    }

    @Override
    public Optional<Animal> findByRegistryId(int registryId) throws DataBaseException {
        var cats = findCat("select_by_id.sql", Optional.ofNullable(registryId));
        if (!cats.isEmpty()) {
            return Optional.ofNullable(cats.entrySet().stream().findFirst().get().getValue());
        }

        var dogs = findDog("select_by_id.sql", Optional.ofNullable(registryId));
        if (!dogs.isEmpty()) {
            return Optional.ofNullable(dogs.entrySet().stream().findFirst().get().getValue());
        }

        var camels = findCamel("select_by_id.sql", Optional.ofNullable(registryId));
        if (!camels.isEmpty()) {
            return Optional.ofNullable(camels.entrySet().stream().findFirst().get().getValue());
        }

        var donkeys = findDonkey("select_by_id.sql", Optional.ofNullable(registryId));
        if (!donkeys.isEmpty()) {
            return Optional.ofNullable(donkeys.entrySet().stream().findFirst().get().getValue());
        }

        var hamsters = findHamster("select_by_id.sql", Optional.ofNullable(registryId));
        if (!hamsters.isEmpty()) {
            return Optional.ofNullable(hamsters.entrySet().stream().findFirst().get().getValue());
        }

        var horses = findHorse("select_by_id.sql", Optional.ofNullable(registryId));
        if (!horses.isEmpty()) {
            return Optional.ofNullable(horses.entrySet().stream().findFirst().get().getValue());
        }

        return Optional.empty();
    }

    private HashMap<Integer, Cat> findCat(String query, Optional<Integer> registryId) throws DataBaseException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = String.format(getQuery(new File(SQL_PATH + query)), "cat");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if (registryId.isPresent()) {
                preparedStatement.setInt(1, registryId.get());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<Integer, Cat> cats = getCats(resultSet);

            resultSet.close();
            preparedStatement.close();

            return cats;

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }

    private HashMap<Integer, Dog> findDog(String query, Optional<Integer> registryId) throws DataBaseException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = String.format(getQuery(new File(SQL_PATH + query)), "dog");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if (registryId.isPresent()) {
                preparedStatement.setInt(1, registryId.get());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<Integer, Dog> dogs = getDogs(resultSet);

            resultSet.close();
            preparedStatement.close();

            return dogs;

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }

    private HashMap<Integer, Camel> findCamel(String query, Optional<Integer> registryId) throws DataBaseException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = String.format(getQuery(new File(SQL_PATH + query)), "camel");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if (registryId.isPresent()) {
                preparedStatement.setInt(1, registryId.get());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<Integer, Camel> camels = getCamels(resultSet);

            resultSet.close();
            preparedStatement.close();

            return camels;

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }
    private HashMap<Integer, Donkey> findDonkey(String query, Optional<Integer> registryId) throws DataBaseException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = String.format(getQuery(new File(SQL_PATH + query)), "donkey");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if (registryId.isPresent()) {
                preparedStatement.setInt(1, registryId.get());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<Integer, Donkey> donkeys = getDonkeys(resultSet);

            resultSet.close();
            preparedStatement.close();

            return donkeys;

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }
    private HashMap<Integer, Hamster> findHamster(String query, Optional<Integer> registryId) throws DataBaseException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = String.format(getQuery(new File(SQL_PATH + query)), "hamster");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if (registryId.isPresent()) {
                preparedStatement.setInt(1, registryId.get());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<Integer, Hamster> hamsters = getHamsters(resultSet);

            resultSet.close();
            preparedStatement.close();

            return hamsters;

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }
    private HashMap<Integer, Horse> findHorse(String query, Optional<Integer> registryId) throws DataBaseException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = String.format(getQuery(new File(SQL_PATH + query)), "horse");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if (registryId.isPresent()) {
                preparedStatement.setInt(1, registryId.get());
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            HashMap<Integer, Horse> horses = getHorses(resultSet);

            resultSet.close();
            preparedStatement.close();

            return horses;

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }

    private HashMap<Integer, Cat> getCats(ResultSet resultSet) throws SQLException, DataBaseException {
        var cats = new HashMap<Integer, Cat>();
        while (resultSet.next()) {
            int registryId = resultSet.getInt("registry_id");
            int height = resultSet.getInt("height");
            int weight = resultSet.getInt("weight");

            Date date = resultSet.getDate("birthdate");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(date);

            String name = resultSet.getString("name");
            String breed = resultSet.getString("breed");
            Boolean isVaccinated = resultSet.getBoolean("isvaccinated");
            int mustacheLength = resultSet.getInt("mustachelength");

            HashSet<String> commands = findCommandsByRegistryId(registryId);

            cats.put(registryId, new Cat(height, weight, birthDate, name, breed, commands, isVaccinated, mustacheLength));
        }
        return cats;
    }

    private HashMap<Integer, Dog> getDogs(ResultSet resultSet) throws SQLException, DataBaseException {
        var dogs = new HashMap<Integer, Dog>();
        while (resultSet.next()) {
            int registryId = resultSet.getInt("registry_id");
            int height = resultSet.getInt("height");
            int weight = resultSet.getInt("weight");

            Date date = resultSet.getDate("birthdate");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(date);

            String name = resultSet.getString("name");
            String breed = resultSet.getString("breed");
            Boolean isVaccinated = resultSet.getBoolean("isvaccinated");
            int powerSenseSmell = resultSet.getInt("powerSenseSmell");

            HashSet<String> commands = findCommandsByRegistryId(registryId);

            dogs.put(registryId, new Dog(height, weight, birthDate, name, breed, commands, isVaccinated, powerSenseSmell));
        }
        return dogs;
    }

    private HashMap<Integer, Hamster> getHamsters(ResultSet resultSet) throws SQLException, DataBaseException {
        var hamsters = new HashMap<Integer, Hamster>();
        while (resultSet.next()) {
            int registryId = resultSet.getInt("registry_id");
            int height = resultSet.getInt("height");
            int weight = resultSet.getInt("weight");

            Date date = resultSet.getDate("birthdate");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(date);

            String name = resultSet.getString("name");
            String breed = resultSet.getString("breed");
            Boolean isVaccinated = resultSet.getBoolean("isvaccinated");

            HashSet<String> commands = findCommandsByRegistryId(registryId);

            hamsters.put(registryId, new Hamster(height, weight, birthDate, name, breed, commands, isVaccinated));
        }
        return hamsters;
    }

    private HashMap<Integer, Camel> getCamels(ResultSet resultSet) throws SQLException, DataBaseException {
        var camels = new HashMap<Integer, Camel>();
        while (resultSet.next()) {
            int registryId = resultSet.getInt("registry_id");
            int height = resultSet.getInt("height");
            int weight = resultSet.getInt("weight");

            Date date = resultSet.getDate("birthdate");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(date);

            String name = resultSet.getString("name");
            String breed = resultSet.getString("breed");
            int loadCapacity = resultSet.getInt("loadcapacity");
            int milkValue = resultSet.getInt("milkvalue");

            HashSet<String> commands = findCommandsByRegistryId(registryId);

            camels.put(registryId, new Camel(height, weight, birthDate, name, breed, commands, loadCapacity, milkValue));
        }
        return camels;
    }

    private HashMap<Integer, Donkey> getDonkeys(ResultSet resultSet) throws SQLException, DataBaseException {
        var donkeys = new HashMap<Integer, Donkey>();
        while (resultSet.next()) {
            int registryId = resultSet.getInt("registry_id");
            int height = resultSet.getInt("height");
            int weight = resultSet.getInt("weight");

            Date date = resultSet.getDate("birthdate");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(date);

            String name = resultSet.getString("name");
            String breed = resultSet.getString("breed");
            int loadCapacity = resultSet.getInt("loadcapacity");
            int stubbornness = resultSet.getInt("stubbornness");

            HashSet<String> commands = findCommandsByRegistryId(registryId);

            donkeys.put(registryId, new Donkey(height, weight, birthDate, name, breed, commands, loadCapacity, stubbornness));
        }
        return donkeys;
    }

    private HashMap<Integer, Horse> getHorses(ResultSet resultSet) throws SQLException, DataBaseException {
        var horses = new HashMap<Integer, Horse>();
        while (resultSet.next()) {
            int registryId = resultSet.getInt("registry_id");
            int height = resultSet.getInt("height");
            int weight = resultSet.getInt("weight");

            Date date = resultSet.getDate("birthdate");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(date);

            String name = resultSet.getString("name");
            String breed = resultSet.getString("breed");
            int loadCapacity = resultSet.getInt("loadcapacity");
            int speed = resultSet.getInt("speed");

            HashSet<String> commands = findCommandsByRegistryId(registryId);

            horses.put(registryId, new Horse(height, weight, birthDate, name, breed, commands, loadCapacity, speed));
        }
        return horses;
    }


    @Override
    public HashSet<String> findCommandsByRegistryId(int registryId) throws DataBaseException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = String.format(getQuery(new File(SQL_PATH + "select_by_id.sql")), "command");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registryId);
            ResultSet resultSet = preparedStatement.executeQuery();

            var commands = new HashSet<String>();
            while (resultSet.next()) {
                String command = resultSet.getString("command");
                commands.add(command);
            }

            resultSet.close();
            preparedStatement.close();

            return commands;

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }

    @Override
    public int add(Animal animal, String note) throws DataBaseException {
        int id = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            connection.setAutoCommit(false);
            String sql = getQuery(new File(SQL_PATH + "insert_registry.sql"));
            PreparedStatement preparedStatementRegistry = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatementRegistry.setString(1, note);
            preparedStatementRegistry.executeUpdate();
            ResultSet resultSet = preparedStatementRegistry.getGeneratedKeys();
            id = resultSet.next() ? resultSet.getInt(1) : 0;

            PreparedStatement preparedStatementAnimal = getPreparedStatementAnimal(connection, animal, id);
            preparedStatementAnimal.executeUpdate();


            PreparedStatement preparedStatementCommand = null;
            for(String command: getCommands(animal)){
                sql = getQuery(new File(SQL_PATH + "insert_command.sql"));
                preparedStatementCommand = connection.prepareStatement(sql);
                preparedStatementCommand.setInt(1, id);
                preparedStatementCommand.setString(2, command);
                preparedStatementCommand.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);

            preparedStatementRegistry.close();
            preparedStatementAnimal.close();
            preparedStatementCommand.close();
        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }

        return id;
    }

    private HashSet<String> getCommands(Animal animal){
        if (animal instanceof Cat) {
            return ((Cat) animal).getCommands();
        } else if (animal instanceof Dog) {
            return ((Dog) animal).getCommands();
        } else if (animal instanceof Camel) {
            return ((Camel) animal).getCommands();
        } else if (animal instanceof Donkey) {
            return ((Donkey) animal).getCommands();
        } else if (animal instanceof Hamster) {
            return ((Hamster) animal).getCommands();
        } else if (animal instanceof Horse) {
            return ((Horse) animal).getCommands();
        }

        return null;
    }

    @Override
    public void addCommandsByRegistryId(int registryId, HashSet<String> commands) throws DataBaseException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = "";
            PreparedStatement preparedStatement = null;

            for(String command: commands){
                sql = getQuery(new File(SQL_PATH + "insert_command.sql"));
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, registryId);
                preparedStatement.setString(2, command);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }

    private PreparedStatement getPreparedStatementAnimal(Connection connection, Animal animal, int id) throws DataBaseException, SQLException {
        if (animal instanceof Cat) {
            return getPreparedStatementCat(connection, (Cat) animal, id);
        } else if (animal instanceof Dog) {
            return getPreparedStatementDog(connection, (Dog) animal, id);
        } else if (animal instanceof Hamster) {
            return getPreparedStatementHamster(connection, (Hamster) animal, id);
        } else if (animal instanceof Camel) {
            return getPreparedStatementCamel(connection, (Camel) animal, id);
        } else if (animal instanceof Donkey) {
            return getPreparedStatementDonkey(connection, (Donkey) animal, id);
        } else if (animal instanceof Horse) {
            return getPreparedStatementHorse(connection, (Horse) animal, id);
        }

        throw new DataBaseException("SQL Error");
    }

    private PreparedStatement getPreparedStatementCat(Connection connection, Cat cat, int id) throws DataBaseException, SQLException {
        DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String sql = getQuery(new File(SQL_PATH + "insert_cat.sql"));
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, cat.getHeight());
        preparedStatement.setInt(2, cat.getWeight());
        preparedStatement.setString(3, sdf.format(cat.getBirthDate().getTime()));
        preparedStatement.setString(4, cat.getName());
        preparedStatement.setString(5, cat.getBreed());
        preparedStatement.setBoolean(6, cat.isVaccinated());
        preparedStatement.setInt(7, cat.getMustacheLength());
        preparedStatement.setInt(8, id);

        return preparedStatement;
    }

    private PreparedStatement getPreparedStatementDog(Connection connection, Dog dog, int id) throws DataBaseException, SQLException {
        DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String sql = getQuery(new File(SQL_PATH + "insert_dog.sql"));
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, dog.getHeight());
        preparedStatement.setInt(2, dog.getWeight());
        preparedStatement.setString(3, sdf.format(dog.getBirthDate().getTime()));
        preparedStatement.setString(4, dog.getName());
        preparedStatement.setString(5, dog.getBreed());
        preparedStatement.setBoolean(6, dog.isVaccinated());
        preparedStatement.setInt(7, dog.getPowerSenseSmell());
        preparedStatement.setInt(8, id);

        return preparedStatement;
    }

    private PreparedStatement getPreparedStatementHamster(Connection connection, Hamster hamster, int id) throws DataBaseException, SQLException {
        DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String sql = getQuery(new File(SQL_PATH + "insert_hamster.sql"));
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, hamster.getHeight());
        preparedStatement.setInt(2, hamster.getWeight());
        preparedStatement.setString(3, sdf.format(hamster.getBirthDate().getTime()));
        preparedStatement.setString(4, hamster.getName());
        preparedStatement.setString(5, hamster.getBreed());
        preparedStatement.setBoolean(6, hamster.isVaccinated());
        preparedStatement.setInt(7, id);

        return preparedStatement;
    }

    private PreparedStatement getPreparedStatementCamel(Connection connection, Camel camel, int id) throws DataBaseException, SQLException {
        DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String sql = getQuery(new File(SQL_PATH + "insert_camel.sql"));
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, camel.getHeight());
        preparedStatement.setInt(2, camel.getWeight());
        preparedStatement.setString(3, sdf.format(camel.getBirthDate().getTime()));
        preparedStatement.setString(4, camel.getName());
        preparedStatement.setString(5, camel.getBreed());
        preparedStatement.setInt(6, camel.getLoadCapacity());
        preparedStatement.setInt(7, camel.getMilkValue());
        preparedStatement.setInt(8, id);

        return preparedStatement;
    }

    private PreparedStatement getPreparedStatementDonkey(Connection connection, Donkey donkey, int id) throws DataBaseException, SQLException {
        DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String sql = getQuery(new File(SQL_PATH + "insert_donkey.sql"));
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, donkey.getHeight());
        preparedStatement.setInt(2, donkey.getWeight());
        preparedStatement.setString(3, sdf.format(donkey.getBirthDate().getTime()));
        preparedStatement.setString(4, donkey.getName());
        preparedStatement.setString(5, donkey.getBreed());
        preparedStatement.setInt(6, donkey.getLoadCapacity());
        preparedStatement.setInt(7, donkey.getStubbornness());
        preparedStatement.setInt(8, id);

        return preparedStatement;
    }

    private PreparedStatement getPreparedStatementHorse(Connection connection, Horse horse, int id) throws DataBaseException, SQLException {
        DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String sql = getQuery(new File(SQL_PATH + "insert_horse.sql"));
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, horse.getHeight());
        preparedStatement.setInt(2, horse.getWeight());
        preparedStatement.setString(3, sdf.format(horse.getBirthDate().getTime()));
        preparedStatement.setString(4, horse.getName());
        preparedStatement.setString(5, horse.getBreed());
        preparedStatement.setInt(6, horse.getLoadCapacity());
        preparedStatement.setInt(7, horse.getSpeed());
        preparedStatement.setInt(8, id);

        return preparedStatement;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public HashMap<Integer, Registry> findAll() throws DataBaseException {
        var registry = new HashMap<Integer, Registry>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);) {
            String sql = String.format(getQuery(new File(SQL_PATH + "select_all.sql")), "registry");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");

                Date date = resultSet.getDate("create_date");
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Calendar createdDate = Calendar.getInstance();
                createdDate.setTime(date);

                String note = resultSet.getString("note");

                registry.put(id, new Registry(id, null, note, createdDate));
            }
            resultSet.close();
            preparedStatement.close();

            var cats = findCat("select_all.sql", Optional.empty());
            cats.entrySet().stream().
                    forEach(cat -> registry.replace(cat.getKey(), new Registry(cat.getKey(),
                            cat.getValue(), registry.get(cat.getKey()).note(), registry.get(cat.getKey()).createdDate())));

            var dogs = findDog("select_all.sql", Optional.empty());
            dogs.entrySet().stream().
                    forEach(dog -> registry.replace(dog.getKey(), new Registry(dog.getKey(),
                            dog.getValue(), registry.get(dog.getKey()).note(), registry.get(dog.getKey()).createdDate())));

            var hamsters = findHamster("select_all.sql", Optional.empty());
            hamsters.entrySet().stream().
                    forEach(hamster -> registry.replace(hamster.getKey(), new Registry(hamster.getKey(),
                            hamster.getValue(), registry.get(hamster.getKey()).note(), registry.get(hamster.getKey()).createdDate())));

            var camels = findCamel("select_all.sql", Optional.empty());
            camels.entrySet().stream().
                    forEach(camel -> registry.replace(camel.getKey(), new Registry(camel.getKey(),
                            camel.getValue(), registry.get(camel.getKey()).note(), registry.get(camel.getKey()).createdDate())));

            var donkeys = findDonkey("select_all.sql", Optional.empty());
            donkeys.entrySet().stream().
                    forEach(donkey -> registry.replace(donkey.getKey(), new Registry(donkey.getKey(),
                            donkey.getValue(), registry.get(donkey.getKey()).note(), registry.get(donkey.getKey()).createdDate())));

            var horses = findHorse("select_all.sql", Optional.empty());
            horses.entrySet().stream().
                    forEach(horse -> registry.replace(horse.getKey(), new Registry(horse.getKey(),
                            horse.getValue(), registry.get(horse.getKey()).note(), registry.get(horse.getKey()).createdDate())));

            return registry;

        } catch (SQLException ex) {
            throw new DataBaseException("SQL Error");
        }
    }

    private static String getQuery(File file) throws DataBaseException {
        var data = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line)
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
            throw new DataBaseException("Failed to get request");
        }

        return data.toString();
    }
}