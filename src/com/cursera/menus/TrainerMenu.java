package com.cursera.menus;

import com.cursera.model.Course;
import com.cursera.model.Degree;
import com.cursera.model.User;
import com.cursera.repository.All;
import com.cursera.repository.list.CourseRepository;
import com.cursera.repository.list.DegreeRepository;
import com.cursera.repository.list.UserRepository;
import com.cursera.util.State;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static com.cursera.data.ToFiles.writingFile;
import static com.cursera.menus.MainMenu.firstScreen;
import static com.cursera.repository.list.CourseRepository.*;
import static com.cursera.util.Resources.optionInput;

public class TrainerMenu {

    public static void trainerOptionsList() {
        System.out.println("           TRAINER MENU           ");
        System.out.println("Please select an option: " +
                "    1- See your uploaded courses." +
                "    2- Upload a new course." +
                "    3- Delete a course." +
                "    4- Edit the information on one of your courses." +
                "    5- Edit your information." +
                "    6- Edit a degree. " +
                "    7- Go to main menu."
        );
    }

    public static void trainerMenu(User user, List users, List courses, List degrees) {
        //Resources
        List<Course> course = courses;
        All<Course> repoCourse = new CourseRepository();
        All<User> repoUser = new UserRepository();
        All<Degree> repoDegree = new DegreeRepository();
        List <Degree> degrees1 = degrees;
        String courseName;
        String description;
        String duration;
        Scanner in = new Scanner(System.in);

        trainerOptionsList();
        int op = optionInput(1, 6);
        switch (op) {
            case 1:
                System.out.println(" ------------------- ");
                System.out.println(Arrays.toString(user.courses));
                try {
                    // sleep program for a minute
                    Thread.sleep(5*1000);
                } catch (Exception e) {
                    System.out.println(" Having issues ... try later \t |THANKS| ");
                }
                break;
            case 2:
                System.out.println(" Name: ");
                courseName = in.nextLine();
                System.out.println(" Description ");
                description = in.nextLine();
                System.out.println(" Duration ");
                duration = in.nextLine();
                Course newCourse = new Course(courseName, description,duration);
                listOfCourses(user.getmId(), newCourse);
                user.addCourse(newCourse);
                writingFile("users",users);
                break;
            case 3:
                System.out.println(" Course ID ");
                courseState(user, in.nextInt(), State.DELETED);
                listofCourses.remove(in.nextInt());
                break;
            case 4:
                System.out.println(" Course ID ");
                repoCourse.delete(in.nextInt());
                Course auxCourse = repoCourse.edit(in.nextInt());
                user.addCourse(auxCourse);
                writingFile("users",users);
                listOfCourses(user.getmId(), auxCourse);
                break;
            case 5:
                user = repoUser.edit(user.getmId());
                users.remove(user.getmId());
                users.add(user);
                writingFile("users",users);
                break;
            case 6:
                System.out.println(" Degree |ID| : ");
                repoDegree.delete(in.nextInt());
                repoDegree.edit(in.nextInt());
                writingFile("degrees", degrees);
                break;
            case 7:
                System.out.println("Going back to main menu...");
                firstScreen(users,courses, degrees);
                break;
        }
    }
}

