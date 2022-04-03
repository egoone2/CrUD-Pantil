package com.osokin.service.jmx;

import com.osokin.service.PersonService;
import com.osokin.RequestSender;

import java.lang.management.ManagementFactory;

import javax.management.*;

import java.text.ParseException;

public class AdminPage implements AdminPageMBean {

    private PersonService personService = PersonService.getInstance();
    private RequestSender sender = new RequestSender();

    public static void init() throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name1 = new ObjectName("main.java.ava111.Service:type=AdminPage");
        StandardMBean mBean = new StandardMBean(new AdminPage(), AdminPageMBean.class);
        mbs.registerMBean(mBean, name1);
    }

    @Override
    public void sendRequest(String params) throws ParseException {
        sender.sendRequest(params);
    }

    @Override
    public int personsAmount() {
        return personService.personsAmount();
    }

    @Override
    public void printPersons() {
        personService.printPersons();
    }
}
