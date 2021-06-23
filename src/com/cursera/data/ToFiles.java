package com.cursera.data;

import com.cursera.model.Course;
import com.cursera.model.Degree;
import com.cursera.model.User;
import com.cursera.repository.All;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ToFiles <T> {

    private List<T> elements = new ArrayList<>();

    public ToFiles(){}

    public boolean addElements(T element){
        if(elements.size() > 100 ) {
            elements.add(element);
            return true;
        }
        return false;
    }

    public void listToFile(String fileName, List<T> elements){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter fOut = null;

        try{
            fOut = new BufferedWriter(new FileWriter(new File(fileName)));
            String json = gson.toJson(elements, elements.getClass());
            fOut.write(json);

        } catch (IOException e){
            e.printStackTrace();

        } finally {
            if (fOut != null){
                try {
                    fOut.close();

                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<User> readJsonUser(String fileName) {
        String content = null;
        File f = new File(fileName);
        if(f.exists()) {
            try {
                content = Files.readString(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List <User> users = new Gson().fromJson(content, new TypeToken<List<User>>() {}.getType());
        return users;
    }

    public static List<Degree> readJsonDegree(String fileName) {
        String content = null;
        File f = new File(fileName);
        if(f.exists()) {
            try {
                content = Files.readString(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List <Degree> degrees = new Gson().fromJson(content, new TypeToken<List<Degree>>() {}.getType());
        return degrees;
    }

    public static List<Course> readJsonCourse(String fileName) {
        String content = null;
        File f = new File(fileName);
        if(f.exists()){
            try {
                content = Files.readString(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List <Course> courses = new Gson().fromJson(content, new TypeToken<List<Course>>() {}.getType());
        return courses;
    }




    public List<Course> fileCourseToList(String fileName){
        List<Course> list = new ArrayList<>();
        list = null;

        File fIn = new File(fileName);

        if (!(fIn).exists()) {
            System.out.println("\nThere aren't courses in file\n");
            return list;
        }

        try{
            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(fIn));

            Object aux = objInputStream.readObject();

            while (aux != null){
                Course newCourse = new Course();
                newCourse = (Course) aux;
                list.add(newCourse);

                aux = objInputStream.readObject();
            }
        }
        catch (IOException e){
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error loading file...");
        }
        return list;
    }

    public List<Degree> fileDegreeToList(String fileName){
        List<Degree> list = new ArrayList<>();

        File fIn = new File(fileName);

        if (!(fIn).exists()) {
            System.out.println("\nThere aren't courses in file\n");
            return null;
        }

        try{
            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream(fIn));

            Object aux = objInputStream.readObject();

            while (aux != null){
                Degree degree = new Degree();
                degree = (Degree) aux;
                list.add(degree);

                aux = objInputStream.readObject();
            }
        }
        catch (IOException e){
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error loading file...");
        }
        return list;
    }

}
