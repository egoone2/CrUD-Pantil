package com.javarush.ava111;

import com.javarush.ava111.Service.Admin;
import com.javarush.ava111.Service.PersonService;

import java.io.*;
import java.text.ParseException;
import java.lang.management.ManagementFactory;

import javax.management.*;


import static com.javarush.ava111.Service.ApplicationSettings.*;

public class Solution {

    public static void main(String[] args) throws InterruptedException, NotCompliantMBeanException, InstanceAlreadyExistsException, MalformedObjectNameException, MBeanRegistrationException {
        String line;
        RequestSender requestSender = new RequestSender();

        Admin admin = new Admin();
        admin.init();

        try (FileReader fileReader = new FileReader(FILE_PATH);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while (reader.ready()) {
                requestSender.sendRequest(reader.readLine());
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);


    }

}
