package com.javarush.ava111;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import static com.javarush.ava111.Uitl.*;

public class Person {



    private String name;
    private int age;
    private String passportNumber;
    private String passportSeries;
    private Date passportIssueDate;
    private String city;

    public Person() {

    }

    @Override
    public String toString() {
        return "Person " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", passportNumber=" + passportNumber +
                ", passportSeries='" + passportSeries + '\'' +
                ", passportIssueDate=" + formatter.format(passportIssueDate) +
                ", city='" + city + '\'';

    }

    public String getName() {
        return name;
    }

    public Date getPassportIssueDate() {
        return passportIssueDate;
    }

    public int getAge() {
        return age;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getCity() {
        return city;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportIssueDate(Date passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }
}
