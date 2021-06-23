package com.cursera.model;

import java.util.Arrays;
import java.util.Scanner;
import static com.cursera.model.StudentNtrainer.MAX_SUBMIT;

public class Trainer extends User{

    // CONSTRUCTOR
    public Trainer(){}

    public Trainer(String name, String surname, String username, String psw, String DNI, String telephone,
                   String location, String provinc, String country, int firm) {
        super(name, surname, username, psw, DNI, telephone, location, provinc, country, firm);
        super.courses = new Course[MAX_SUBMIT]; // limit of courses can submit
    }

    public static Trainer getDataTrainer() {
        Trainer t = new Trainer();

        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        t.setName(sc.nextLine());
        System.out.println("Surname: ");
        t.setSurname(sc.nextLine());
        System.out.println("Username: ");
        t.setUsername(sc.nextLine());
        System.out.println("Choose Password: ");
        t.setPsw(sc.nextLine());
        System.out.println("DNI: ");
        t.setDNI(sc.nextLine());
        System.out.println("Telephone (CellPhone): ");
        t.setTelephone(sc.nextLine());
        System.out.println("Location: ");
        t.setLocation(sc.nextLine());
        System.out.println("Province: ");
        t.setProvince(sc.nextLine());
        System.out.println("Country: ");
        t.setCountry(sc.nextLine());
        System.out.println("Firm: ");
        t.setFirm(sc.nextInt());

        return t;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "courses=" + Arrays.toString(courses) +
                ", degrees=" + Arrays.toString(degrees) +
                '}';
    }
}
