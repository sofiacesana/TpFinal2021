package com.cursera.menus;

import com.cursera.model.User;

public class StudentMenu extends MainMenu {

    public StudentMenu(User logged){
        this.logged = logged;
    }

    private void studentOptionsList(){
        System.out.println("           STUDENT MENU           ");
        System.out.print("Insert: " +
                "    1- To see all available courses." +
                "    2- To start a new course." +
                "    3- To see the progress in your current courses." +
                "    4- To see your degrees." +
                "    5- To drop out of a course." +
                "    6- To edit your information." +
                "    7- To exit." +
                "Please select an option: ");
    }

    public void studentMainMenu(){
        studentOptionsList();
        int option = optionInput(1, 7);
        switch(option){
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:
                editInformation();
                break;
            case 7:
        }
    }
}


