package com.javarush.ava111;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import static com.javarush.ava111.ApplicationSettings.*;
public class Solution {



    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

    public static void main(String[] args) throws IOException, ParseException {
        FileReader fileReader;
        String line;
        try(BufferedReader reader = new BufferedReader(fileReader = new FileReader(FILE_PATH))) {
            while (reader.ready()) {
                RequestParser rp = new RequestParser(reader.readLine());
            }
        }

//        PersonService.getInstance().printPersons();
        fileReader.close();

    }

}
