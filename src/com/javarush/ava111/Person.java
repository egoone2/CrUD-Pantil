package com.javarush.ava111;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


import static com.javarush.ava111.Service.Util.*;
import static com.javarush.ava111.Service.ApplicationSettings.*;

public class Person {



    private String name;
    private int age;
    private Passport passport;
    private String city;
    private final int ID;


    public Person(int id) {
        this.ID = id;
    }

    public class Passport {
        private String passportNumber;
        private String passportSeries;
        private Date passportIssueDate;

        public Passport(String number, String series, Date date) {
            this.passportNumber = number;
            this.passportSeries = series;
            this.passportIssueDate = date;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
        }

        public String getPassportSeries() {
            return passportSeries;
        }

        public void setPassportSeries(String passportSeries) {
            this.passportSeries = passportSeries;
        }

        public Date getPassportIssueDate() {
            return passportIssueDate;
        }

        public void setPassportIssueDate(Date passportIssueDate) {
            this.passportIssueDate = passportIssueDate;
        }
    }

    @Override
    public String toString() {
        String person =  "Person ID " +
               ID + ", name='" + name + '\'' +
                ", age=" + age +
                ", passportSeries=" + passport.passportSeries +
                ", passportNumber='" + passport.passportNumber + '\'' +
                ", passportIssueDate=" + formatter.format(passport.passportIssueDate) +
                ", city='" + city + '\'';


        try(FileWriter fileWriter = new FileWriter(OUTPUT_FILE_PATH);
            BufferedWriter writer = new BufferedWriter(fileWriter) ) {
            writer.write(person);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }

    public int getID() {
        return ID;
    }

    public void setPassport(String number, String series, Date date) {
        this.passport = new Passport(number,series,date);
    }

    public String getPassport() {
        return passport.getPassportNumber()+passport.getPassportSeries();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
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


}
