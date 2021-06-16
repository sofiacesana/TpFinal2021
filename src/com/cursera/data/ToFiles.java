package com.cursera.data;

import com.cursera.model.Course;
import com.cursera.model.Degree;
import com.cursera.model.User;
import com.cursera.repository.All;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ToFiles {


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

    public static void writeJsonUser(String fileName, All<User> userRepo){
        BufferedWriter fOut = null;

        try{
            fOut = new BufferedWriter(new FileWriter(new File(fileName)));
            Writer writer = new FileWriter(fileName);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(userRepo.list(), writer);
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fOut != null) {
                try {
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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


    public static void writeJsonDegree(String fileName, All<Degree> degreeRepo){
        BufferedWriter fOut = null;

        try{
            fOut = new BufferedWriter(new FileWriter(new File(fileName)));
            Writer writer = new FileWriter(fileName);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(degreeRepo.list(), writer);
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fOut != null) {
                try {
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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

    public static void writeJsonCourses(String fileName, All<Course> courseRepo){
        BufferedWriter fOut = null;

        try{
            fOut = new BufferedWriter(new FileWriter(new File(fileName)));
            Writer writer = new FileWriter(fileName);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(courseRepo.list(), writer);
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fOut != null) {
                try {
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
