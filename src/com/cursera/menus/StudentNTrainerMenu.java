package com.cursera.menus;

import com.cursera.model.Course;
import com.cursera.model.Degree;
import com.cursera.model.User;
import com.cursera.repository.All;

import java.util.List;

import static com.cursera.menus.StudentMenu.studentMenu;
import static com.cursera.menus.TrainerMenu.trainerMenu;
import static com.cursera.util.Resources.optionInput;

public class StudentNTrainerMenu {
    private User logged;

    public StudentNTrainerMenu(User logged){
        this.logged = logged;
    }

    public static void studentNTrainerOptionsList(){
        System.out.println("           STUDENT AND TRAINER MENU           ");
        System.out.print("Insert: " +
                "\n    1- To see the Student options." +
                "\n    2- To see the Trainer options." +
                "\n    3- To exit." +
                "Please select an option: ");
    }

    public static void studentNTrainerMenu(All<User> repoUser, All<Course> repoCourse, All<Degree> repoDegree, User user, List users, List courses, List degrees){
        studentNTrainerOptionsList();
        int op = optionInput(1, 3);
        switch(op){
            case 1:
              studentMenu(repoUser, repoCourse, repoDegree, user, users, courses, degrees);
                break;
            case 2:
                trainerMenu(repoUser, repoCourse, repoDegree, user, users, courses, degrees);
                break;
        }
    }
}
