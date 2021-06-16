package com.cursera.menus;

import com.cursera.model.Course;
import com.cursera.model.Student;
import com.cursera.model.User;
import com.cursera.repository.All;
import com.cursera.repository.list.CourseRepository;
import com.cursera.repository.list.UserRepository;
import com.cursera.util.State;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.cursera.data.ToFiles.jsonToMap;
import static com.cursera.data.ToFiles.writingFile;
import static com.cursera.menus.MainMenu.firstScreen;
import static com.cursera.repository.list.CourseRepository.*;
import static com.cursera.util.Resources.optionInput;

public class StudentMenu {
    private Student student = new Student();


    public static void studentOptionsList(){
        System.out.println("           STUDENT MENU           ");
        System.out.print("Please select an option: "+
                "    1- To see all available courses." +
                "    2- To start a new course." +
                "    3- To see your current courses." +
                "    4- To see your degrees." +
                "    5- To drop out of a course." +
                "    6- To edit your information." +
                "    7- Go to main menu."
                );
    }

    public static void studentMenu(User user, List users, List courses, List degrees){
        All<Course> repoCourse = new CourseRepository();
        List <Course> allCourses = courses;
        All<User> repoUser = new UserRepository();
        Scanner in = new Scanner(System.in);
        studentOptionsList();
        int option = optionInput(1, 6);
        switch(option){
            case 1:
               listofCourses = jsonToMap("courses");
               listofCourses.forEach((key, value) ->
                       System.out.println(" [ID Trainer] : " + key +
                               " [Course] :" + value));
                try {
                    // sleep program for a minute
                    Thread.sleep(6*10);
                } catch (Exception e) {
                    System.out.println(" Having issues ... try later \t |THANKS| ");
                }
                studentMenu(user, users, courses, degrees);
            case 2:
                System.out.println(" Course ID: ");
                enrollIntoAcourse(in.nextInt(), user, courses);
                courseState(user,in.nextInt(), State.IN_PROGRESS);
                studentMenu(user, users, courses, degrees);
                users.remove(user.getmId());
                users.add(user);
                writingFile("users",users);
            case 3:
                System.out.println(" ------------------- ");
                System.out.println(Arrays.toString(user.courses));
                try {
                    // sleep program for a minute
                    Thread.sleep(5*1000);
                } catch (Exception e) {
                    System.out.println(" Having issues ... try later \t |THANKS| ");
                }
                studentMenu(user, users, courses, degrees);
            case 4:
                System.out.println(" ------------------- ");
                System.out.println(Arrays.toString(user.degrees));
                try {
                    // sleep program for a minute
                    Thread.sleep(5*1000);
                } catch (Exception e) {
                    System.out.println(" Having issues ... try later \t |THANKS| ");
                }
                studentMenu(user, users, courses, degrees);
            case 5:
                System.out.println(" Course ID: ");
                dropOutCourse(in.nextInt(),user);
                studentMenu(user, users, courses, degrees);
                users.remove(user.getmId());
                users.add(user);
                writingFile("users",users);
            case 6:
               user = repoUser.edit(user.getmId());
               users.remove(user.getmId());
               users.add(user);
               writingFile("users",users);
                break;
            case 7:
                System.out.println("Going back to main menu...");
                firstScreen(users,courses, degrees);
                break;
        }
    }
}


