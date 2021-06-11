package com.cursera.menus;

import com.cursera.model.Student;
import com.cursera.model.Trainer;
import com.cursera.model.User;
import com.cursera.repository.list.CourseRepository;
import com.cursera.repository.list.UserRepository;
import com.cursera.menus.StudentMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    User logged;
    UserRepository userRep;
    CourseRepository courseRep;
    Scanner scanner;

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
                }

            case 2:
                logged = userRep.registration();
        }
    }

    public void login(){
        String username;
        String password;
        System.out.print("Username: ");
        username = scanner.nextLine();
        this.logged = userRep.login(username);
    }

}
