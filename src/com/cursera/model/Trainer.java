package com.cursera.model;

import static com.cursera.model.StudentNtrainer.MAX_SUBMIT;

public class Trainer extends User{

    public Trainer(String name, String surname, String username, String psw, String DNI, String telephone,
                   String location, String provinc, String country, Byte firm) {
        super(name, surname, username, psw, DNI, telephone, location, provinc, country, firm);
        super.setCourseIndex(MAX_SUBMIT); // limit of courses can submit
    }
}
