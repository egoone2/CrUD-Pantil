package com.osokin;

import com.osokin.config.ApplicationSettings;
import com.osokin.service.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Person {

    private static int INC_ID = 0;
    private String name;
    private int age;
    private Passport passport;
    private String city;
    private final int ID;


    public Person() {
        this.ID = ++INC_ID;
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
        String person = "Person ID " +
                ID + ", name='" + name + '\'' +
                ", age=" + age +
                ", passportSeries=" + passport.passportSeries +
                ", passportNumber='" + passport.passportNumber + '\'' +
                ", passportIssueDate=" + Util.formatter.format(passport.passportIssueDate) +
                ", city='" + city + '\'';


        try (FileWriter fileWriter = new FileWriter(ApplicationSettings.OUTPUT_FILE_PATH);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }

    public int getID() {
        return ID;
    }

    public void setPassport(String number, String series, Date date) {
        this.passport = new Passport(number, series, date);
    }

    public String getPassport() {
        return passport.getPassportNumber() + passport.getPassportSeries();
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
