package com.javarush.ava111;
import com.javarush.ava111.Service.PersonService;
import com.javarush.ava111.Service.PersonServiceMBean;
import com.javarush.ava111.Service.RequestParserMbean;

import java.io.*;
import java.text.ParseException;
import java.lang.management.ManagementFactory;

import javax.management.*;


import static com.javarush.ava111.Service.ApplicationSettings.*;

public class Solution {



    

    public static void main(String[] args)  throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException
    {
        String line;
        RequestParser requestParser = new RequestParser();

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.javarush.ava111:type=RequestParser");
        StandardMBean mbean = new StandardMBean(requestParser,RequestParserMbean.class);
        mbs.registerMBean(mbean, name);

        ObjectName name1 = new ObjectName("com.javarush.ava111:Type=PersonService");
        StandardMBean mBean1 = new StandardMBean(PersonService.getInstance(), PersonServiceMBean.class);
        mbs.registerMBean(mBean1,name1);


        try(FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader reader = new BufferedReader(fileReader)) {
            while (reader.ready()) {
                requestParser.sendRequest(reader.readLine());
            }
        }
        catch (IOException | ParseException e ) {
            e.printStackTrace();
        }

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
//        PersonService.getInstance().printPersons();

    }

}
