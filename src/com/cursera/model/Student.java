package com.cursera.model;
import java.util.Scanner;
import static com.cursera.model.StudentNtrainer.*;

public class Student extends User{
    public Student(){}

    public Student(String name, String surname, String username, String psw, String DNI, String telephone,
                   String location, String provinc, String country, String interests) {
        super(name, surname, username, psw, DNI, telephone, location, provinc, country, interests);
        super.setCourseIndex(MAX_ENROLL); // limit of courses can enroll
    }

    public Student getDataStudent() {
        Student st = new Student();

        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        st.setName(sc.nextLine());
        System.out.println("Surname: ");
        st.setSurname(sc.nextLine());
        System.out.println("Username: ");
        st.setUsername(sc.nextLine());
        System.out.println("Choose Password: ");
        st.setPsw(sc.nextLine());
        System.out.println("DNI: ");
        st.setDNI(sc.nextLine());
        System.out.println("Telephone (CellPhone): ");
        st.setTelephone(sc.nextLine());
        System.out.println("Location: ");
        st.setLocation(sc.nextLine());
        System.out.println("Province: ");
        st.setProvince(sc.nextLine());
        System.out.println("Country: ");
        st.setCountry(sc.nextLine());
        System.out.println("Interest: ");
        st.setInterests(sc.nextLine());

        return st;
    }
}
