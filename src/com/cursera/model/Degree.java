package com.cursera.model;

import java.time.LocalDate;
import java.util.List;

public class Degree {
    private LocalDate date;
    private String courseName;
    private String courseDuration;
    private String trainerName;
    private String trainerSurname;
    private int firm;
    public List<Degree> allDegrees;


    public Degree(Course course, User user) {
        this.date = LocalDate.now();
        this.courseName = course.getName();
        this.courseDuration = course.getDuration();
        this.trainerName = user.getName();
        this.trainerSurname = user.getSurname();
        this.firm = user.getFirm();
        allDegrees.add(this);
    }

}
