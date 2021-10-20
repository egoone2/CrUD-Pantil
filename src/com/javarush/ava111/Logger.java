package com.javarush.ava111;

import java.util.function.LongFunction;

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
