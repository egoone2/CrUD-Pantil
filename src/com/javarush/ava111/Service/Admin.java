package com.javarush.ava111.Service;

import com.javarush.ava111.Person;
import com.javarush.ava111.RequestSender;

import java.lang.management.ManagementFactory;

import javax.management.*;

import java.text.ParseException;

public class Admin implements AdminMBean {

    public void init() throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name1 = new ObjectName("com.javarush.ava111.Service:type=Admin");
        StandardMBean mBean = new StandardMBean(new Admin(), AdminMBean.class);
        mbs.registerMBean(mBean, name1);
    }

    @Override
    public void sendRequest(String params) throws ParseException {
        RequestSender sender = new RequestSender();
        sender.sendRequest(params);
    }

    @Override
    public int personsAmount() {
        return PersonService.getInstance().personsAmount();
    }

    @Override
    public void printPersons() {
        PersonService.getInstance().printPersons();
    }
}
