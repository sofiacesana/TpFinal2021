package com.cursera.menus;

import com.cursera.model.Course;
import com.cursera.model.Degree;
import com.cursera.model.Student;
import com.cursera.model.User;
import com.cursera.repository.All;
import com.cursera.repository.list.CourseRepository;
import com.cursera.repository.list.UserRepository;
import com.cursera.util.State;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.cursera.menus.MainMenu.firstScreen;
import static com.cursera.repository.list.CourseRepository.*;
import static com.cursera.util.Resources.optionInput;

public class StudentMenu {
    private Student student = new Student();


    public static void studentOptionsList(){
        System.out.println("           STUDENT MENU           ");
        System.out.print("Please select an option: "+
                "\n    1- To see all available courses." +
                "\n    2- To start a new course." +
                "\n    3- To see your current courses." +
                "\n    4- To see your degrees." +
                "\n    5- To drop out of a course." +
                "\n    6- To edit your information." +
                "\n    7- Go to main menu."
                );
    }

    public static void studentMenu(All<User> repoUser, All<Course> repoCourse, All<Degree> repoDegree, User user, List<User> users, List<Course> courses, List<Degree> degrees){

        List<Course> allCourses = repoCourse.list();

        Scanner in = new Scanner(System.in);

        studentOptionsList();

        int option = optionInput(1, 6);
        switch(option){
            case 1:
                listofCourses.forEach((key, value) ->
                        System.out.println(" [ID Trainer] : " + key +
                                " [Course] :" + value));
                try {
                    // sleep program for a minute
                    Thread.sleep(6*10);
                } catch (Exception e) {
                    System.out.println(" Having issues ... try later \t |THANKS| ");
                }

                studentMenu(repoUser, repoCourse, repoDegree, user, users, courses, degrees);

            case 2:
                System.out.println(" Course ID: ");
                enrollIntoAcourse(in.nextInt(), user, courses);
                courseState(user,in.nextInt(), State.IN_PROGRESS);
                studentMenu(repoUser, repoCourse, repoDegree, user, users, courses, degrees);
                users.remove(user.getmId());
                users.add(user);
                //writingFile("users.txt",users);
            case 3:
                System.out.println(" ------------------- ");
                System.out.println(Arrays.toString(user.courses));
                try {
                    // sleep program for a minute
                    Thread.sleep(5*1000);
                } catch (Exception e) {
                    System.out.println(" Having issues ... try later \t |THANKS| ");
                }
                studentMenu(repoUser, repoCourse, repoDegree, user, users, courses, degrees);
            case 4:
                System.out.println(" ------------------- ");
                System.out.println(Arrays.toString(user.degrees));
                try {
                    // sleep program for a minute
                    Thread.sleep(5*1000);
                } catch (Exception e) {
                    System.out.println(" Having issues ... try later \t |THANKS| ");
                }
                studentMenu(repoUser, repoCourse, repoDegree, user, users, courses, degrees);
            case 5:
                System.out.println(" Course ID: ");
                dropOutCourse(in.nextInt(),user);
                studentMenu(repoUser, repoCourse, repoDegree, user, users, courses, degrees);
                users.remove(user.getmId());
                users.add(user);
                //writingFile("users.txt",users);
            case 6:
               user = repoUser.edit(user.getmId());
               users.remove(user.getmId());
               users.add(user);
               //writingFile("users.txt", users);
                break;
            case 7:
                System.out.println("Going back to main menu...");
                firstScreen(repoUser, repoCourse, repoDegree, users,courses, degrees);
                break;
        }
    }
}


