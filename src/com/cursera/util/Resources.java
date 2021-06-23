package com.cursera.util;

import com.cursera.model.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Resources {

    public static int optionInput(int i, int j){
        Scanner in = new Scanner(System.in);
        int option = 0;
        System.out.print("Insert a number between " + i + " and " + j + ": ");
        try{
            option = in.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Wrong data type inserted");
        }
        if (option < i || option > j){
            in.reset();
            System.out.print("Please insert a valid number: ");
            try{
                option = in.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Wrong data type inserted");
            }
        }
        return option;
    }

    public static void editInformationListing(User user){
        System.out.println("Choose the field you want to edit: ");
        System.out.println("    1- Name." +
                "\n   2- Surname." +
                "\n   3- Username." +
                "\n   4- Password." +
                "\n   5- DNI." +
                "\n   6- Phone number." +
                "\n   7- Location." +
                "\n   8- Province." +
                "\n   9- Country.");
        System.out.println("user" + user.getClass());
        if(user instanceof Student){
            System.out.println("   10- Interests.");
        }else if(user instanceof Trainer){
            System.out.println("   10- Firm.");
        }else if (user instanceof StudentNtrainer){
            System.out.println("   10- Firm." +
                    "\n   11- Interests.");
        }
    }

    public static void editInformationCourse() {
        System.out.println("Choose the field you want to edit: ");
        System.out.println("1- Course name" +
                "\n2- Course duration" +
                "\n3- Course description");
    }

    public static void editInformationDegree() {
        System.out.println("Choose the field you want to edit: ");
        System.out.println("1- Degree name" +
                "\n2- Course duration" +
                "\n3- Trainer name" +
                "\n4- Trainer surname" +
                "\n5- Firm");
    }
}
