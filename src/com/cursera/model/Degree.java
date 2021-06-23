package com.cursera.model;

import java.time.LocalDate;

public class Degree {
    private static int degreeId;
    private int id;
    private LocalDate date;
    private String name;
    private String courseDuration;
    private String trainerName;
    private String trainerSurname;
    private int firm;

    // CONSTRUCTOR
    public Degree(){
        this.id = ++degreeId;

    }

    public Degree(Course course, User user) {
        this.id = ++degreeId;
        this.date = LocalDate.now();
        this.name = course.getName();
        this.courseDuration = course.getDuration();
        this.trainerName = user.getName();
        this.trainerSurname = user.getSurname();
        this.firm = user.getFirm();
    }

    // region GETTERS & SETTERS

    public static Integer getDegreeId() {
        return degreeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String courseName) {
        this.name = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerSurname() {
        return trainerSurname;
    }

    public void setTrainerSurname(String trainerSurname) {
        this.trainerSurname = trainerSurname;
    }

    public int getFirm() {
        return firm;
    }
    public void setFirm(int firm) {
        this.firm = firm;
    }

    // endregion



}
