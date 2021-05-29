package com.cursera.model;

import static com.cursera.model.studentNtrainer.*;

public class Student extends User{

    public Student(String name, String surname, String username, String psw, String DNI, String telephone,
                   String location, String provinc, String country, String interests) {
        super(name, surname, username, psw, DNI, telephone, location, provinc, country, interests);
        super.setCourseIndex(MAX_ENROLL); // limit of courses can enroll
    }

}
