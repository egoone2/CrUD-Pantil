package com.javarush.ava111.Service;

import java.text.ParseException;

public interface AdminMBean {
    public void sendRequest(String params) throws ParseException;

    public int personsAmount();

    public void printPersons();
}
