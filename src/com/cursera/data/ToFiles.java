package com.cursera.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ToFiles{


    public static void writingFile(String fileName, List elements) {

        try {
            BufferedWriter fileOut = new BufferedWriter(
                    new FileWriter(new File(fileName))
            );
            Path pathFile = Paths.get(fileName);

            Files.write(pathFile, elements);

            fileOut.close();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void readingFile(String fileName) {
        if(!new File(fileName).exists())
            return;

        BufferedReader fileIn = null;

        try{
            fileIn = new BufferedReader(
                    new FileReader(new File(fileName))
            );

            String line = null;

            while((line = fileIn.readLine()) != null) {
                System.out.println(line);
            }

        }catch(IOException e) {
            System.out.println(e.getMessage());

        } finally {

            if(fileIn != null) {
                try {
                    fileIn.close();
                }
                catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
