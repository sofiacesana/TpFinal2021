package com.cursera;

import java.util.ArrayList;
import java.util.List;
import static com.cursera.data.ToFiles.fileToList;
import static com.cursera.menus.MainMenu.firstScreen;


public class Main {


    public static void main(String[] args) {
        List users = new ArrayList();
        users = fileToList("users");

        List courses = new ArrayList();
        courses = fileToList("courses");

        List degrees = new ArrayList();
        degrees = fileToList("degrees");


        firstScreen(users, courses, degrees);

    }



}
