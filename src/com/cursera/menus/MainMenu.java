package com.cursera.menus;

import com.cursera.model.Student;
import com.cursera.model.StudentNtrainer;
import com.cursera.model.Trainer;
import com.cursera.model.User;
import com.cursera.repository.list.CourseRepository;
import com.cursera.repository.list.UserRepository;
import com.cursera.menus.StudentMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    protected User logged;
    protected UserRepository userRep;
    protected CourseRepository courseRep;
    protected Scanner scanner;

    public MainMenu(){
        userRep = new UserRepository();
        scanner = new Scanner(System.in);
    }

    public int optionInput(int i, int j){
        int option = 0;
        System.out.print("Insert a number between " + i + " and " + j + ": ");
        try{
            option = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Wrong data type inserted");
        }
        while (option < i || option > j){
            scanner.reset();
            System.out.print("Please insert a valid number: ");
            try{
                option = scanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Wrong data type inserted");
            }
        }
        return option;
    }

    public void welcomeOptionsList(){
        System.out.println("--------------Welcome to cursera!--------------");
        System.out.println("Insert: ");
        System.out.println("    1- To log in. ");
        System.out.println("    2- To register.");
        System.out.println("    3- To exit.");
        System.out.print("Please select an option: ");
    }

    public void welcomeMenu(){
        welcomeOptionsList();
        int option = optionInput(1,3);
        switch(option){
            case 1:
                login();
                if(logged instanceof Student){
                    StudentMenu sm = new StudentMenu(logged);
                    sm.studentMainMenu();
                }else if(logged instanceof Trainer){
                    TrainerMenu tm = new TrainerMenu(logged);
                    tm.trainerMainMenu();
                }else{
                    StudentNTrainerMenu snt = new StudentNTrainerMenu(logged);
                    snt.studentNTrainerMenu();
                }
                break;
            case 2:
                logged = userRep.registration();
                break;
        }
    }

    public void login(){
        String username;
        System.out.print("Username: ");
        username = scanner.nextLine();
        this.logged = userRep.login(username);
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
                "   9- Country.");
        if(this.logged instanceof Student){
            System.out.println("   10- Interests.");
        }else if(this.logged instanceof Trainer){
            System.out.println("   10- Firm.");
        }else if(this.logged instanceof StudentNtrainer){
            System.out.println("   10- Firm." +
                    "   11- Interests.");
        }
        System.out.print("Please select an option: ");
    }


    public void editInformation (){
        Scanner scan = new Scanner(System.in);
        editInformationListing();
        int op;
        if(this.logged instanceof Trainer || this.logged instanceof Student){
            op = optionInput(1, 10);
        }else{
            op = optionInput(1, 11);
        }
        switch(op){
            case 1:
                System.out.print("Introduce your new name: ");
                logged.setName(scan.nextLine());
                break;
            case 2:
                System.out.print("Introduce your new surname: ");
                logged.setSurname(scan.nextLine());
                break;
            case 3:
                System.out.print("Introduce your new username: ");
                logged.setUsername(scan.next());
                break;
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
                break;
            case 5:
                System.out.print("Introduce your new DNI: ");
                logged.setDNI(scan.next());
                break;
            case 6:
                System.out.println("Introduce your new phone number: ");
                logged.setTelephone(scan.next());
                break;
            case 7:
                System.out.println("Introduce your new location: ");
                logged.setLocation(scan.nextLine());
                break;
            case 8:
                System.out.println("Introduce your new province: ");
                logged.setProvince(scan.nextLine());
                break;
            case 9:
                System.out.println("Introduce your new country: ");
                logged.setCountry(scan.nextLine());
                break;
            case 10:
                if(this.logged instanceof Student){
                    System.out.println("Introduce your new interests: ");
                    logged.setInterests(scan.nextLine());
                }else{
                    System.out.println("Introduce your new firm: ");
                    try{
                        logged.setFirm(scan.nextInt());
                    }
                    catch (InputMismatchException e){
                        System.out.println("Wrong data type inserted.");
                    }
                }
                break;
            case 11:
                System.out.println("Introduce your new interests: ");
                logged.setInterests(scan.nextLine());
                break;
        }
    }


}
