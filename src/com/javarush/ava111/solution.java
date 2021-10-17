package com.javarush.ava111;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class solution {
    public static Map<String,Person> list = new HashMap<>();



    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

    public static void addPerson(String[] line) throws ParseException {    // метод добавляет человека в коллекцию
        String name = line[0];
        int age = Integer.parseInt(line[1]);
        String passportSeries = line[2];
        int passportNumber = Integer.parseInt(line[3]);
        Date date = formatter.parse(line[4]);
        String city = line[5];
        list.put(name,new Person(name,age,passportNumber,passportSeries,date,city));
    }

    public static void updatePerson(String[] line) throws ParseException {  // обновление информации соответственно
        String name = line[0];
        int age = Integer.parseInt(line[1]);
        String passportSeries = line[2];
        int passportNumber = Integer.parseInt(line[3]);
        Date date = formatter.parse(line[4]);
        String city = line[5];
        list.put(name,new Person(name,age,passportNumber,passportSeries,date,city));

    }

    public static void deletePersons(String[] line) { // удаление персон
        for (String name : line) {
            list.remove(name);
        }
    }

    public static void readPersons(String[] line, String fileName) throws IOException { //вывод информации в отдельный файл
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        for (String name : line) {
            String infoString = list.get(name).toString() + "\n";
            bufferedWriter.write(infoString.toCharArray());
        }
        bufferedWriter.close();
    }



    public static void main(String[] args) throws IOException, ParseException {
        FileReader fileReader;
        String line;
        BufferedReader reader = new BufferedReader(fileReader = new FileReader("C:\\Users\\whale\\OneDrive\\Рабочий стол\\Флешка\\create.txt"));

        while ((line = reader.readLine()) != null) {   // добавление
            String[] arr = line.split("\t");
            addPerson(arr);
            }



        BufferedReader updateReader = new BufferedReader(new FileReader("C:\\Users\\whale\\OneDrive\\Рабочий стол\\Флешка\\update.txt"));
        while ((line = updateReader.readLine()) != null) {   // обновление
            String[] arr = line.split("\t");
            updatePerson(arr);
        }

        BufferedReader deleteReader = new BufferedReader(new FileReader("C:\\Users\\whale\\OneDrive\\Рабочий стол\\Флешка\\delete.txt"));
        while ((line = deleteReader.readLine()) != null) {   // удаление
            String[] arr = line.split(", ");
            deletePersons(arr);
        }

//        for (Person person : list.values()) {  // вывод оставшихся в листе
//            System.out.println(person);
//        }

        BufferedReader infoReader = new BufferedReader(new FileReader("C:\\Users\\whale\\OneDrive\\Рабочий стол\\Флешка\\read.txt"));
        String[] arr = infoReader.readLine().split(", ");

        readPersons(arr, "C:\\Users\\whale\\OneDrive\\Рабочий стол\\Флешка\\output.txt");



        fileReader.close();

    }
}
