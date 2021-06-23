package com.cursera.menus;

import com.cursera.data.ToFiles;
import com.cursera.model.Course;
import com.cursera.model.Degree;
import com.cursera.model.User;
import com.cursera.repository.All;
import com.cursera.util.State;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static com.cursera.menus.MainMenu.firstScreen;
import static com.cursera.model.StudentNtrainer.MAX_SUBMIT;
import static com.cursera.repository.list.CourseRepository.*;
import static com.cursera.util.Resources.optionInput;

public class TrainerMenu {

    public static void trainerOptionsList() {
        System.out.println("           TRAINER MENU           ");
        System.out.println("Please select an option: " +
                "\n    1- See your uploaded courses." +
                "\n    2- Upload a new course." +
                "\n    3- Delete a course." +
                "\n    4- Edit the information on one of your courses." +
                "\n    5- Edit your information." +
                "\n    6- Edit a degree. " +
                "\n    7- Go to main menu."
        );
    }

    public static void trainerMenu(All<User> repoUser, All<Course> repoCourse, All<Degree> repoDegree, User user, List<User> users, List<Course> courses, List<Degree> degrees) {
        //Resources
        List <Degree> degrees1 = degrees;
        String courseName;
        String description;
        String duration;
        Scanner in = new Scanner(System.in);

        trainerOptionsList();
        int op = optionInput(1, 6);
        switch (op) {
            case 1:
                if(user.courses == null){
                    System.out.println("No courses uploaded");
                } else {
                    System.out.println(" ------------------- ");
                    System.out.println(Arrays.toString(user.courses));

                    try {
                        // sleep program for a minute
                        Thread.sleep(5*1000);
                    } catch (Exception e) {
                        System.out.println(" Having issues... try again later \t |THANKS| ");
                    }
                }
                break;
            case 2:

                System.out.println(" Name: ");
                courseName = in.nextLine();
                System.out.println(" Description ");
                description = in.nextLine();
                System.out.println(" Duration ");
                duration = in.nextLine();
                Course newCourse = new Course(courseName, description, duration);

                if(courses.get(0) != null){
                    for(var course1 : courses) {
                        repoCourse.create(course1);
                    }
                }

                if(user.courses == null){
                    user.courses[0] = newCourse;
                } else {
                    user.addCourse(newCourse);
                }
                courses = repoCourse.list();
                courses.add(newCourse);

                ToFiles<Course> coursesFile = new ToFiles<>();
                coursesFile.listToFile("courses.json", courses);

                ToFiles<User> usersFile = new ToFiles<>();
                usersFile.listToFile("users.json", users);

                break;
            case 3:
                Integer id = null;
                System.out.println(" Course ID ");

                id = in.nextInt();
                courseState(user, id, State.DELETED);

                repoCourse.delete(id);


                ToFiles<Course> coursesFile2 = new ToFiles<>();
                coursesFile2.listToFile("courses.json", courses);

                ToFiles<User> usersFile2 = new ToFiles<>();
                usersFile2.listToFile("users.json", users);
                break;
            case 4:
                System.out.println(" Course ID ");
                Course auxCourse = repoCourse.searchById(in.nextInt());
                auxCourse = repoCourse.edit(auxCourse);

                ToFiles<Course> coursesFile3 = new ToFiles<>();
                coursesFile3.listToFile("courses.json", courses);

                ToFiles<User> usersFile3 = new ToFiles<>();
                usersFile3.listToFile("users.json", users);

                break;
            case 5:
                user = repoUser.edit(user);
                /*for (int i = 0; i < repoUser.total()){
                    if(u.getId() == user.getId()){

                    }
                }*/

                ToFiles<User> userFiles3 = new ToFiles<>();
                userFiles3.listToFile("users.json", users);
                break;
            case 6:
                System.out.println(" Degree |ID|: ");
                Degree editDegree = repoDegree.searchById(in.nextInt());
                repoDegree.edit(editDegree);

                ToFiles<Degree> degreeFiles = new ToFiles<>();
                degreeFiles.listToFile("degrees.json", degrees1);
                break;
            default:
                System.out.println("Going back to main menu...");
                firstScreen(repoUser, repoCourse, repoDegree, users,courses, degrees);
                break;
        }
    }


}

