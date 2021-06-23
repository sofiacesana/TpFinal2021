package com.cursera.model;

import com.cursera.util.State;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Course {
    private static int courseId;
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

    // region CONSTRUCTORS

    public Course(){
        id = ++courseId;

    }
    // create a course
    public Course(String name, String description, String duration) {
        this.id = ++courseId;
        this.date = LocalDate.now();
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.students = new User[MAX_STUDENTS];
    }
    // endregion


    // region GETTERS & SETTERS

    public int getId() {
        return this.id;
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

    public void addStudent(User student){
        for(int i = 0; i < MAX_STUDENTS; i++){
            if(this.students[i] == null){
                this.students[i] = student;
            }
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
    // endregion
}