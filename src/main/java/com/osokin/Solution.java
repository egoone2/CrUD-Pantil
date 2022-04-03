package com.osokin;

import com.osokin.service.jmx.AdminPage;
import com.osokin.config.ApplicationSettings;

import java.io.*;
import java.text.ParseException;

import javax.management.*;

public class Solution {

    public static void main(String[] args) throws InterruptedException, NotCompliantMBeanException, InstanceAlreadyExistsException, MalformedObjectNameException, MBeanRegistrationException {
        RequestSender requestSender = new RequestSender();
        AdminPage.init();

        try (FileReader fileReader = new FileReader(ApplicationSettings.FILE_PATH);
             BufferedReader reader = new BufferedReader(fileReader)) {
            while (reader.ready()) {
                requestSender.sendRequest(reader.readLine());
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
        //TODO 1.Таймер запросов и показфвать среднее время в jmx(для каждого запроса)
        //TODO 2. Сделать тумблер для отключения фичи 1.
        //TODO 3. Сделать отправку через потоки.
    }

}
