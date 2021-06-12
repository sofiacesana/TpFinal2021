package com.cursera.menus;

import com.cursera.model.User;

public class TrainerMenu extends MainMenu {

    public TrainerMenu(User logged) {
        this.logged = logged;
    }

    private void trainerOptionsList() {
        System.out.println("           TRAINER MENU           ");
        System.out.println("Insert: " +
                "    1- To see your uploaded courses." +
                "    2- To upload a new course." +
                "    3- To see your students' progress on your courses." +
                "    4- To see the degrees students got in your courses." +
                "    5- To delete a course." +
                "    6- To edit the information on one of your courses." +
                "    7- To edit your information." +
                "    8- To exit." +
                "Please select an option: ");
    }

    public void trainerMainMenu() {
        trainerOptionsList();
        int op = optionInput(1, 8);
        switch (op) {
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:
                super.editInformation();
                break;
            case 8:

            default:
                System.out.println("Going back to main menu...");
        }
    }
}

