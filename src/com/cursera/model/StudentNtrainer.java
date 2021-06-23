package com.cursera.model;

import java.util.Arrays;
import java.util.Scanner;

public class StudentNtrainer extends User{
    public static final int MAX_SUBMIT = 20;
    public static final int MAX_ENROLL = 5;

    public StudentNtrainer(){}
    
    public StudentNtrainer(String name, String surname, String username, String psw, String DNI, String telephone,
                           String location, String provinc, String country, String interests, int firm) {
        super(name, surname, username, psw, DNI, telephone, location, provinc, country, interests, firm);
    }

    public static StudentNtrainer getDataStudentTrainer() {
        StudentNtrainer snt = new StudentNtrainer();

        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        snt.setName(sc.nextLine());
        System.out.println("Surname: ");
        snt.setSurname(sc.nextLine());
        System.out.println("Username: ");
        snt.setUsername(sc.nextLine());
        System.out.println("Choose Password: ");
        snt.setPsw(sc.nextLine());
        System.out.println("DNI: ");
        snt.setDNI(sc.nextLine());
        System.out.println("Telephone (CellPhone): ");
        snt.setTelephone(sc.nextLine());
        System.out.println("Location: ");
        snt.setLocation(sc.nextLine());
        System.out.println("Province: ");
        snt.setProvince(sc.nextLine());
        System.out.println("Country: ");
        snt.setCountry(sc.nextLine());
        System.out.println("Interest: ");
        snt.setInterests(sc.nextLine());
        System.out.println("Firm: ");
        snt.setFirm(sc.nextInt());

        return snt;
    }

    @Override
    public String toString() {
        return "StudentNtrainer{" +
                ", enrolled=" + Arrays.toString(enrolled) +
                ", courses=" + Arrays.toString(courses) +
                ", degrees=" + Arrays.toString(degrees) +
                '}';
    }
}
