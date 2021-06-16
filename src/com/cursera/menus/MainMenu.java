package com.cursera.menus;

import com.cursera.model.*;
import com.cursera.repository.All;
import com.cursera.repository.list.UserRepository;
import java.util.List;
import java.util.Scanner;
import static com.cursera.data.ToFiles.writingFile;
import static com.cursera.data.ToJson.jsonFile;
import static com.cursera.menus.StudentMenu.studentMenu;
import static com.cursera.menus.StudentNTrainerMenu.studentNTrainerMenu;
import static com.cursera.menus.TrainerMenu.trainerMenu;
import static com.cursera.model.Student.getDataStudent;
import static com.cursera.model.StudentNtrainer.getDataStudentTrainer;
import static com.cursera.model.Trainer.getDataTrainer;
import static com.cursera.util.Resources.optionInput;

public class MainMenu {

        public static void firstScreen (List allUser, List allCourses, List degrees) {
            All<User> repoUser = new UserRepository();
            List <User> users = allUser;

            Scanner sc = new Scanner(System.in);
            User whatUser = new User();
            System.out.println("-------------- ¡Welcome to Cursera! --------------");
            System.out.print(" Please select an option ");
            System.out.println("    1- Log in. ");
            System.out.println("    2- Register.");
            System.out.println(" -------------------------------------------------");
            System.out.println("--------------        -JSON-        --------------");
            System.out.println("    3- List of USERS ");
            System.out.println("    4- List of COURSES ");
            System.out.println("    5- List of DEGREES ");
            System.out.println(" -------------------------------------------------");
            System.out.println("    6- Exit \n ");

            int option = optionInput(1, 2);
            switch (option) {
                case 1:
                    System.out.println(" Insert |USERNAME| ");
                    whatUser = login(sc.nextLine(), users);

                    if (whatUser == null) {
                        System.out.println(" User |NON-EXISTENT| ");
                        firstScreen(users, allCourses, degrees);
                    } else if (whatUser instanceof Student) {
                        studentMenu(whatUser, users, allCourses, degrees);
                    } else if (whatUser instanceof Trainer) {
                        trainerMenu(whatUser, users, allCourses, degrees);
                    } else {
                        studentNTrainerMenu(whatUser, users, allCourses, degrees);
                    }
                    break;
                case 2:
                    whatUser = registration(users, allCourses, degrees);
                    repoUser.create(whatUser);
                    writingFile("users", users);
                    firstScreen(users, allCourses, degrees);
                    break;
                case 3:
                    jsonFile(users);
                    break;
                case 4:
                    jsonFile(allCourses);
                    break;
                case 5:
                    jsonFile(degrees);
                    break;
                default:
                    System.out.println(" Thanks for join our learning... ");
                    break;
            }
        }


        public static User registration (List users, List courses, List degrees) {
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
                default:
                    firstScreen(users,courses, degrees);
            }
            return whatUser;
        }

    public static User login(String userName, List list){
        User exist = null;
        Scanner sc = new Scanner(System.in);
        List <User> users = list;

        for (User whatUser: users){
            if (whatUser.getUsername().equals(userName)){
                System.out.println(" Enter |PASSWORD| ");
                if (whatUser.getPsw().equals(sc.nextLine())){
                    exist = whatUser;
                    break;
                }
            }
            break;
        }
        return exist;
    }

    }

