package com.cursera.menus;

import com.cursera.repository.list.CourseRepository;
import com.cursera.repository.list.UserRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    UserRepository userRep;
    CourseRepository courseRep;
    Scanner scanner;

    public MainMenu(){
        userRep = new UserRepository();
        scanner = new Scanner(System.in);
    }

    public int optionInput(int i, int j){
        int option;
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

    public void login(){

    }
}
