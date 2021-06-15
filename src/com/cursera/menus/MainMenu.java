package com.cursera.menus;

import com.cursera.model.*;
import java.util.Scanner;

import static com.cursera.menus.StudentMenu.studentMenu;
import static com.cursera.menus.StudentNTrainerMenu.studentNTrainerMenu;
import static com.cursera.menus.TrainerMenu.trainerMenu;
import static com.cursera.model.Student.getDataStudent;
import static com.cursera.model.StudentNtrainer.getDataStudentTrainer;
import static com.cursera.model.Trainer.getDataTrainer;
import static com.cursera.util.Resources.optionInput;

public class MainMenu {

        public static void firstScreen () {
            Scanner sc = new Scanner(System.in);
            User whatUser = new User();
            System.out.println("-------------- ¡Welcome to Cursera! --------------");
            System.out.print(" Please select an option ");
            System.out.println("    1- Log in. ");
            System.out.println("    2- Register.");
            System.out.println("    3- Exit.");

            int option = optionInput(1, 3);
            switch (option) {
                case 1:
                    System.out.println(" Insert |USERNAME| ");
                    whatUser = login(sc.nextLine());

                    if (whatUser == null) {
                        System.out.println(" User |NON-EXISTENT| ");
                        firstScreen();
                    } else if (whatUser instanceof Student) {
                        studentMenu(whatUser);
                    } else if (whatUser instanceof Trainer) {
                        trainerMenu(whatUser);
                    } else {
                        studentNTrainerMenu(whatUser);
                    }
                    break;
                case 2:
                    whatUser = registration();
                    break;
                case 3:
                    System.out.println(" Thanks for join our learning... ");
                    break;
            }
        }


        public static User registration () {
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
                    firstScreen();
            }
            return whatUser;
        }

    public static User login(String userName){
        User exist = null;
        Scanner sc = new Scanner(System.in);

        for (User whatUser: dataSource){
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

