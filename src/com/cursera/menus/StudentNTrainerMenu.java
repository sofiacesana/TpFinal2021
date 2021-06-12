package com.cursera.menus;

import com.cursera.model.Trainer;
import com.cursera.model.User;

public class StudentNTrainerMenu extends MainMenu {
    private User logged;
    public StudentNTrainerMenu(User logged){
        this.logged = logged;
    }

    private void studentNTrainerOptionsList(){
        System.out.println("           STUDENT AND TRAINER MENU           ");
        System.out.print("Insert: " +
                "    1- To see the Student options." +
                "    2- To see the Trainer options." +
                "    3- To exit." +
                "Please select an option: ");
    }

    public void studentNTrainerMenu(){
        studentNTrainerOptionsList();
        int op = optionInput(1, 3);
        switch(op){
            case 1:
                StudentMenu sm = new StudentMenu(logged);
                sm.studentMainMenu();
                break;
            case 2:
                TrainerMenu tm = new TrainerMenu(logged);
                tm.trainerMainMenu();
                break;
        }
    }
}
