package com.javarush.ava111.Service;

import com.javarush.ava111.Dto.*;
import com.javarush.ava111.Person;

import java.io.FileWriter;
import java.text.ParseException;
import java.util.HashMap;


public class PersonService {

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


    }

    public void updatePerson(UpdateDto dto) throws ParseException {
        Person person = repository.get(dto.getID());
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setPassport(dto.getPassportNumber(), dto.getPassportSeries(), dto.getPassportIssueDate());
        person.setCity(dto.getCity());

        repository.put(dto.getID(),person);

    }

    public void deletePerson(DeleteDto dto) {
        try {
        repository.remove(dto.getID()); }
        catch (Exception e) {
            System.out.println("Wrong person ID");
        }
    }

    public void readPerson(ReadDto readDto) {
        try(FileWriter fileWriter = new FileWriter(ApplicationSettings.OUTPUT_FILE_PATH)) {
            String line = repository.get(readDto.getID()).toString();
            fileWriter.write(line);
            System.out.println(line); }
        catch (Exception e) {
            System.out.println("Wrong person ID");
        }
    }

    public void printPersons() {
        repository.forEach((name, person) -> System.out.println(person));
    }
}
