package com.cursera.menus;

import com.cursera.model.Course;
import com.cursera.model.User;
import java.util.Arrays;
import java.util.Scanner;

import static com.cursera.menus.MainMenu.firstScreen;
import static com.cursera.util.Resources.optionInput;

public class TrainerMenu {

    public static void trainerOptionsList() {
        System.out.println("           TRAINER MENU           ");
        System.out.println("Please select an option: " +
                "    1- To see your uploaded courses." +
                "    2- To upload a new course." +
                "    3- To delete a course." +
                "    4- To edit the information on one of your courses." +
                "    5- To edit your information." +
                "    6- To exit."
                );
    }

    public static void trainerMenu(User user) {
        //Resources
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
                break;
            case 2:
                System.out.println(" Name: ");
                courseName = in.nextLine();
                System.out.println(" Description ");
                description = in.nextLine();
                System.out.println(" Duration ");
                duration = in.nextLine();
                Course newCourse = new Course(courseName, description,duration);


                break;
            case 3:

            case 4:

            case 5:

            case 6:
                System.out.println("Going back to main menu...");
                firstScreen();
                break;
        }
    }
}

