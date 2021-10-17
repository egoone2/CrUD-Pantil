package com.javarush.ava111;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {

    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

    private String name;
    private int age;
    private int passportNumber;
    private String passportSeries;
    private Date passportIssueDate;
    private String city;

    public Person(String name, int age, int passportNumber, String passportSeries, Date passportIssueDate, String city) throws ParseException {
        this.age = age;
        this.city = city;
        this.name = name;
        this.passportNumber = passportNumber;
        this.passportSeries = passportSeries;

        this.passportIssueDate = passportIssueDate;
    }

    @Override
    public String toString() {
        String line = "";
        line += this.name + " ";
        line += this.age + " ";
        line += this.passportNumber + " ";
        line += this.passportSeries + " ";
        line += formatter.format(this.passportIssueDate) + " ";
        line += this.city;
        return line;
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

    public int getPassportNumber() {
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

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }
}
