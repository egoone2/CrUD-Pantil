package com.osokin.service.jmx;

import java.text.ParseException;

public interface AdminPageMBean {
    public void sendRequest(String params) throws ParseException;

    public int personsAmount();

    public void printPersons();
}
