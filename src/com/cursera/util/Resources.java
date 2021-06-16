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
        while (option < i || option > j){
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
                "   2- Surname." +
                "   3- Username." +
                "   4- Password." +
                "   5- DNI." +
                "   6- Phone number." +
                "   7- Location." +
                "   8- Province." +
                "   9- Country.");
        if(user instanceof Student){
            System.out.println("   10- Interests.");
        }else if(user instanceof Trainer){
            System.out.println("   10- Firm.");
        }else if (user instanceof StudentNtrainer){
            System.out.println("   10- Firm." +
                    "   11- Interests.");
        }
        System.out.print("Please select an option: ");
    }

    public static void editInformationCourse(Course course) {
        System.out.println("Choose the field you want to edit: ");
        System.out.println("1- Course name" +
                "2- Course duration" +
                "3- Course description");
    }

    public static void editInformationDegree(Degree degree) {
        System.out.println("Choose the field you want to edit: ");
        System.out.println("1- Degree name" +
                "2- Course duration" +
                "3- Trainer name" +
                "4- Trainer surname" +
                "5- Firm");
    }

}
