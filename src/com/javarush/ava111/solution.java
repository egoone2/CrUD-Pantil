package com.javarush.ava111;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import static com.javarush.ava111.Service.ApplicationSettings.*;
public class Solution {



    static SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);

    public static void main(String[] args)  {

        String line;
        RequestParser requestParser = new RequestParser();
        try(FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader reader = new BufferedReader(fileReader)) {
            while (reader.ready()) {
                requestParser.sendRequest(reader.readLine());
            }
        }
        catch (IOException | ParseException e ) {
            e.printStackTrace();
        }

//        PersonService.getInstance().printPersons();

    }

}
