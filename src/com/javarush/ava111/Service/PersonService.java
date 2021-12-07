package com.javarush.ava111.Service;

import com.javarush.ava111.Dto.CreateUpdateDto;
import com.javarush.ava111.Dto.DeleteDto;
import com.javarush.ava111.Dto.ReadDto;
import com.javarush.ava111.Person;

import java.text.ParseException;
import java.util.HashMap;


public class PersonService {

    private static PersonService INSTANCE;

    private HashMap<String, Person> repository = new HashMap<>();

    private PersonService() {

    }

    public static PersonService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersonService();
        }

        return INSTANCE;
    }

    public void createPerson(CreateUpdateDto dto) throws ParseException {
        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setPassportSeries(dto.getPassportSeries());
        person.setPassportNumber(dto.getPassportNumber());
        person.setPassportIssueDate(dto.getPassportIssueDate());
        person.setCity(dto.getCity());

        repository.put(person.getName(),person);


    }

    public void updatePerson(CreateUpdateDto dto) throws ParseException {
        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        person.setPassportSeries(dto.getPassportSeries());
        person.setPassportNumber(dto.getPassportNumber());
        person.setPassportIssueDate(dto.getPassportIssueDate());
        person.setCity(dto.getCity());

        repository.put(person.getName(),person);

    }

    public void deletePerson(DeleteDto dto) {
        repository.remove(dto.getName());
    }

    public void readPerson(ReadDto readDto) {
        System.out.println(repository.get(readDto.getName()));
    }

    public void printPersons() {
        repository.forEach((name, person) -> System.out.println(person));
    }
}
