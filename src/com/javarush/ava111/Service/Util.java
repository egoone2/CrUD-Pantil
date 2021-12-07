package com.javarush.ava111.Service;

import java.text.SimpleDateFormat;

import static com.javarush.ava111.Service.ApplicationSettings.DATE_PATTERN;

public class Util {
    public static final SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
}