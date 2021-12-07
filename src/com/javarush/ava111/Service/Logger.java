package com.javarush.ava111.Service;

public class Logger {

    private static Logger INSTANCE;

    private Logger() {}

    public static Logger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Logger();
        }
        return INSTANCE;
    }




}
