package com.cursera.menus;

import com.cursera.model.User;

import java.util.Scanner;

public class StudentMenu extends MainMenu {

    public StudentMenu(User logged){
        this.logged = logged;
    }

    private void studentOptionsList(){
        System.out.println("           STUDENT MENU           ");
        System.out.println("Insert: ");
        System.out.println("    1- To see all available courses.");
        System.out.println("    2- To start a new course.");
        System.out.println("    3- To see the progress in your current courses.");
        System.out.println("    4- To see your degrees.");
        System.out.println("    5- To drop out of a course.");
        System.out.println("    6- To edit your information.");
        System.out.println("    7- To exit.");
        System.out.print("Please select an option: ");
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
            case 7:
        }
    }

    private void editInformationListing(){
        System.out.println("Choose the field you want to edit: ");
        System.out.println("    1- Name." +
                "   2- Surname." +
                "   3- Username." +
                "   4- Password." +
                "   5- DNI." +
                "   6- Phone number." +
                "   7- Location." +
                "   8- Province." +
                "   9- Country." +
                "   10- Interests.");
        System.out.println("Please select an option: ");
    }

    private void editInformation (){
        Scanner scan = new Scanner(System.in);
        editInformationListing();
        int op = optionInput(1, 10);
        switch(op){
            case 1:
                System.out.print("Introduce your new name: ");
                logged.setName(scan.nextLine());
            case 2:
                System.out.print("Introduce your new surname: ");
                logged.setSurname(scan.nextLine());
            case 3:
                System.out.print("Introduce your new username: ");
                logged.setUsername(scan.next());
            case 4:
                int flag = 1;
                int i = 0;
                do{
                    System.out.print("Please introduce your old password: ");
                    String pw = scan.next();
                    if(pw != logged.getPsw()){
                        System.out.println("Incorrect password!");
                        flag = 0;
                        i++;
                    }else{
                        logged.setPsw(pw);
                    }
                }while(flag == 0 && i < 3);
            case 5:
                System.out.print("Introduce your new DNI: ");
                logged.setDNI(scan.next());
            case 6:
                System.out.println("Introduce your new phone number: ");
                logged.setTelephone(scan.next());
            case 7:
                System.out.println("Introduce your new location: ");
                logged.setLocation(scan.nextLine());
            case 8:
                System.out.println("Introduce your new province: ");
                logged.setProvince(scan.nextLine());
            case 9:
                System.out.println("Introduce your new country: ");
                logged.setCountry(scan.nextLine());
            case 10:
                System.out.println("Introduce your new interests: ");
                logged.setInterests(scan.nextLine());
        }
    }
}


