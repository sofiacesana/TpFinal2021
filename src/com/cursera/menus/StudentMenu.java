package com.cursera.menus;

import com.cursera.model.Student;
import com.cursera.model.User;
import java.util.Arrays;
import java.util.Scanner;
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
                "    7- Exit."
                );
    }

    public static void studentMenu(User user){
        Scanner in = new Scanner(System.in);
        studentOptionsList();
        int option = optionInput(1, 7);
        switch(option){
            case 1:

            case 2:
                System.out.println(" Course ID: ");
                enrollIntoAcourse(in.nextInt(), user);
            case 3:
                System.out.println(" ------------------- ");
                System.out.println(Arrays.toString(user.courses));
            case 4:
                System.out.println(" ------------------- ");
                System.out.println(Arrays.toString(user.degrees));
            case 5:
                System.out.println(" Course ID: ");
                dropOutCourse(in.nextInt(),user);
            case 6:

                break;
            case 7:
                System.out.println("Going back to main menu...");
                firstScreen();
                break;
        }
    }
}


