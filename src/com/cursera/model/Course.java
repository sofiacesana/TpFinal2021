package com.cursera.model;

import com.cursera.util.State;

import java.time.LocalDate;
import java.util.Date;

public class Course {
    private static Integer courseId;
    private int id;
    private String name;
    private String description;
    private String duration;
    private LocalDate date;
    private Date startDate;
    private Date finishDate;
    private State state;
    public User[] students;
    public static int maxStudentsPerCourse;
    public static final int MAX_STUDENTS = 50;

    // region GETTERS & SETTERS

    public Integer getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date setStartDate() {
        return this.startDate = new Date();
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public Date setFinishDate() {
        return this.finishDate = new Date();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // endregion

   // create a course
    public Course(String name, String description, String duration) {
        this.courseId = ++id;
        this.date = LocalDate.now();
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.students = new User[MAX_STUDENTS];
    }

}