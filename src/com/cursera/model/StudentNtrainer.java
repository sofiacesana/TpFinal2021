package com.cursera.model;

public class StudentNtrainer extends User{
    public static final int MAX_SUBMIT = 20;
    public static final int MAX_ENROLL = 5;
    private Course[] enrolled;

    public StudentNtrainer(String name, String surname, String username, String psw, String DNI, String telephone,
                           String location, String provinc, String country, String interests, int firm) {
        super(name, surname, username, psw, DNI, telephone, location, provinc, country, interests, firm);
        super.setCourseIndex(MAX_SUBMIT); // limit of coursers can submit
        this.enrolled = new Course[MAX_ENROLL]; // limit of courses can enroll
    }
}
