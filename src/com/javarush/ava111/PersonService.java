package com.javarush.ava111;

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

    public void createPerson(String[] paramsArr) throws ParseException {
        Person person = new Person();
        person.setName(paramsArr[1]);
        person.setAge(Integer.parseInt(paramsArr[2]));
        person.setPassportSeries(paramsArr[3]);
        person.setPassportNumber(paramsArr[4]);
        person.setPassportIssueDate(Person.formatter.parse(paramsArr[5]));
        person.setCity(paramsArr[6]);

        repository.put(person.getName(),person);


    }

    public void updatePerson(String[] paramsArr) throws ParseException {
        Person person = new Person();
        person.setName(paramsArr[1]);
        person.setAge(Integer.parseInt(paramsArr[2]));
        person.setPassportSeries(paramsArr[3]);
        person.setPassportNumber(paramsArr[4]);
        person.setPassportIssueDate(Person.formatter.parse(paramsArr[5]));
        person.setCity(paramsArr[6]);

        repository.remove(person.getName());
        repository.put(person.getName(),person);
    }

    public void deletePerson(String[] paramsArr) {
        for (String i : paramsArr) {
            if (!i.equals("delete"))
                repository.remove(i);
        }
    }

    public void readPerson(String[] paramsArr) {
        for (String i : paramsArr) {
            if (!i.equals("read"))
                System.out.println(repository.get(i));
        }
    }

    public void printPersons() {
        repository.forEach((name, person) -> System.out.println(person));
    }
}
