package com.cursera.menus;

import com.cursera.model.*;
import com.cursera.repository.All;
import com.cursera.repository.list.UserRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.cursera.data.ToFiles.*;
import static com.cursera.data.ToJson.jsonFile;
import static com.cursera.menus.StudentMenu.studentMenu;
import static com.cursera.menus.StudentNTrainerMenu.studentNTrainerMenu;
import static com.cursera.menus.TrainerMenu.trainerMenu;
import static com.cursera.model.Student.getDataStudent;
import static com.cursera.model.StudentNtrainer.getDataStudentTrainer;
import static com.cursera.model.Trainer.getDataTrainer;
import static com.cursera.util.Resources.optionInput;

public class MainMenu {


        public static void firstScreen (All<User> repoUser, All<Course> repoCourse, All<Degree> repoDegree, List<User> allUser, List allCourses, List degrees) {

            List<User> users = allUser;

            Scanner sc = new Scanner(System.in);
            User whatUser = new User();

            System.out.println("-------------- ¡Welcome to Cursera! --------------");
            System.out.print(" Please select an option \n");
            System.out.println("    1- Log in. ");
            System.out.println("    2- Register.");
            System.out.println(" -------------------------------------------------");
            System.out.println("--------------        -JSON-        --------------");
            System.out.println("    3- List of USERS ");
            System.out.println("    4- List of COURSES ");
            System.out.println("    5- List of DEGREES ");
            System.out.println(" -------------------------------------------------");
            System.out.println("    6- Exit \n ");

            int option = optionInput(1, 6);
            switch (option) {
                case 1:
                    System.out.println(" Insert |USERNAME| ");
                    whatUser = login(sc.next(), users);

                    if (whatUser == null) {
                        System.out.println(" User |NON-EXISTENT| ");
                        firstScreen(repoUser, repoCourse, repoDegree, users, allCourses, degrees);
                    } else if (whatUser instanceof Student) {
                        studentMenu(repoUser, repoCourse, repoDegree, whatUser, users, allCourses, degrees);
                    } else if (whatUser instanceof Trainer) {
                        trainerMenu(repoUser, repoCourse, repoDegree, whatUser, users, allCourses, degrees);
                    } else {
                        studentNTrainerMenu(repoUser, repoCourse, repoDegree, whatUser, users, allCourses, degrees);
                    }
                    break;
                case 2:
                    whatUser = registration(repoUser, repoCourse, repoDegree, users, allCourses, degrees);
                    if(users.get(0) != null){
                        for(var user : users) {
                            repoUser.create(user);
                        }
                    }
                    repoUser.create(whatUser);
                    users = repoUser.list();
                    writeJsonUser("users.json", repoUser);
                    firstScreen(repoUser, repoCourse, repoDegree, users, allCourses, degrees);

                    firstScreen(repoUser, repoCourse, repoDegree, users, allCourses, degrees);
                    break;
                case 3:
                    //writeJsonList("users.json", repoUser);
                    //readJsonList("users.json");
                    break;
                case 4:
                    //jsonFile(allCourses);
                    //writeJsonList("allCourses.json", allCourses);
                    //readJsonList("allCourses.json");
                    break;
                case 5:
                    //jsonFile(degrees);
                    //writeJsonList("degrees.json", degrees);
                    //readJsonList("degrees.json");
                    break;
                default:
                    System.out.println(" Thanks for choosing us, see you later! ");
                    break;
            }
        }


        public static User registration (All<User> repoUser, All<Course> repoCourse, All<Degree> repoDegree, List users, List courses, List degrees) {
            User whatUser = new User();
            System.out.println(" Register like: ");
            System.out.println("    1- Student ");
            System.out.println("    2- Trainer");
            System.out.println("    3- Student and Trainer");
            System.out.println(" -0- Back menu ");

            int option = optionInput(1, 3);
            switch (option) {
                case 1:
                    whatUser = getDataStudent();
                    break;
                case 2:
                    whatUser = getDataTrainer();
                    break;
                case 3:
                    whatUser = getDataStudentTrainer();
                    break;
                case 0:
                    firstScreen(repoUser, repoCourse, repoDegree, users, courses, degrees);
            }
            return whatUser;
        }

    public static User login(String userName, List list){
        User exist = null;
        Scanner sc = new Scanner(System.in);
        List <User> users = list;

        for (User whatUser : users){
            if(exist == null){
                if (whatUser.getUsername().compareToIgnoreCase(userName) == 0){
                    System.out.println(" Enter |PASSWORD| ");
                    if (whatUser.getPsw().compareToIgnoreCase(sc.nextLine()) == 0){
                        exist = whatUser;
                    }else{
                        System.out.println("Incorrect password. Try again.");
                        exist = login(userName, list);
                    }
                }
            }
        }
        return exist;
    }

}

