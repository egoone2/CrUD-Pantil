package com.osokin.service;

import com.osokin.config.ApplicationSettings;

import java.text.SimpleDateFormat;

public class Util {
    public static final SimpleDateFormat formatter = new SimpleDateFormat(ApplicationSettings.DATE_PATTERN);
}