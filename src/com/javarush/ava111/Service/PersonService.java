package com.javarush.ava111.Service;

import com.javarush.ava111.Dto.*;
import com.javarush.ava111.Person;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonService implements PersonServiceMBean{

    private static Logger logger = Logger.getLogger(PersonService.class.getName());
    private static PersonService INSTANCE;

    private HashMap<Integer, Person> repository = new HashMap<>();

    private PersonService() {

    }

    public static PersonService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersonService();
        }

        return INSTANCE;
    }

    public void createPerson(CreateDto dto) throws ParseException {
        Person person = new Person(dto.getID());
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setPassport(dto.getPassportNumber(), dto.getPassportSeries(), dto.getPassportIssueDate());
        person.setCity(dto.getCity());

        repository.put(person.getID(),person);

        logger.info("created person " + person);
    }

    public void updatePerson(UpdateDto dto) throws ParseException {
        Person person = repository.get(dto.getID());
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setPassport(dto.getPassportNumber(), dto.getPassportSeries(), dto.getPassportIssueDate());
        person.setCity(dto.getCity());

        repository.put(dto.getID(),person);

        logger.info("updated person " + person);
    }

    public void deletePerson(DeleteDto dto) {
            Person person = repository.get(dto.getID());
            if (person != null) {
                repository.remove(dto.getID());
                logger.info("deleted person " + person);
            }
            else logger.log(Level.OFF,"invalid person ID");



    }

    public void readPerson(ReadDto readDto) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(ApplicationSettings.OUTPUT_FILE_PATH))) {
            String line = repository.get(readDto.getID()).toString();
            writer.write(line);
            writer.flush();
            System.out.println(line); }
        catch (Exception e) {
            System.out.println("Wrong person ID");
        }
    }

    @Override
    public void printPersons() {
        repository.forEach((name, person) -> System.out.println(person));
    }
    @Override
    public int personsAmount() {
        return repository.size();
    }

}
