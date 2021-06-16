package com.cursera.data;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ToFiles {

// write a file with data of a list
    public static void writingFile(String fileName, List elements) {

        try {
            BufferedWriter fileOut = new BufferedWriter(
                    new FileWriter(new File(fileName))
            );
            Path pathFile = Paths.get(fileName);

            Files.write(pathFile, elements);

            fileOut.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // convert a file into a list and return it
    public static List fileToList(String fileName) {
        List list = new ArrayList();

        readingFileToList(fileName, list);

        return list;
    }

    public static void readingFileToList(String fileName, List list) {
        if (!new File(fileName).exists())
            return;

        BufferedReader fileIn = null;

        try {
            fileIn = new BufferedReader(
                    new FileReader(new File(fileName))
            );

            String line = null;

            while ((line = fileIn.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {

            if (fileIn != null) {
                try {
                    fileIn.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    // convert a map into a file with json
    public static void writeJson(String fileName, Map map){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutputStream);
            objectOutput.writeObject(map);

            objectOutput.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // read the json file
    public static void readJson(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Map map = (Map) objectInputStream.readObject();

            System.out.println(map);

        } catch(IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // file into a map and return it
    public static Map jsonToMap(String fileName) {
        Map map = new HashMap();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            map = (Map) objectInputStream.readObject();

        } catch(IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }


}
