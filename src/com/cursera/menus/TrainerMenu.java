package com.cursera.menus;

import com.cursera.model.User;

import java.util.Scanner;

public class TrainerMenu extends MainMenu{

    public TrainerMenu(User logged){
        this.logged = logged;
    }

    private void trainerOptionsList(){
        System.out.println("           TRAINER MENU           ");
        System.out.println("Insert: ");
        System.out.println("    1- To see your uploaded courses.");
        System.out.println("    2- To upload a new course.");
        System.out.println("    3- To see your students' progress on your courses.");
        System.out.println("    4- To see the degrees students got in your courses.");
        System.out.println("    5- To delete a course.");
        System.out.println("    6- To edit the information on one of your courses.");
        System.out.println("    7- To edit your information.");
        System.out.println("    8- To exit.");
    }

    public void trainerMainMenu(){
        trainerOptionsList();
        int op = optionInput(1, 8);
        switch(op){
            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:
                editInformation();
            case 8:

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
                "   10- Firm.");
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
